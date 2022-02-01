package me.andreraimundo.belarosa_backend.services.emails;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPayment;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
//simple email
    @Override
    public void sendOrderConfirmationPedido (Pedido obj) {
        SimpleMailMessage sm =  prepareSimpleMailMessageFromPedido(obj);
        sendEmail(sm);     
    }

	protected  SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getRegistro().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Recebemos seu pedido");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Sr(a) " + obj.getRegistro().getCliente().getName() + ", " + "seu pedido esta sendo processado, em breve recebera um email de confirmação.");
		return sm;
	}
//html email
	protected String htmlFromTemplatePedido(Pedido obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		return templateEngine.process("recebemoSeuPedido", context);
	}

	@Override
	public void sendOrderConfirmationHtmlPedido (Pedido obj) {
	try {
		MimeMessage mm = prepareMimeMessageFromPedido(obj);
		sendHtmlEmail(mm);
	}
	catch (MessagingException e) {
		sendOrderConfirmationPedido(obj);
		}
	}

	protected MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws MessagingException {
	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
	mmh.setTo(obj.getRegistro().getEmail());
	mmh.setFrom(sender);
	mmh.setSubject("sr(a) " + obj.getCliente().getName() + " recebemos seu pedido. ");
	mmh.setSentDate(new Date(System.currentTimeMillis()));
	mmh.setText(htmlFromTemplatePedido(obj), true);
	return mimeMessage;
	}
//simple email
	@Override
		public void sendNewPasswordEmail(Registro obj, String newPassword) {
			SimpleMailMessage sm = prepareNewPasswordEmail(obj, newPassword);
			sendEmail(sm);
		}	

	protected SimpleMailMessage prepareNewPasswordEmail(Registro obj, String newPassword) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Sua senha nova é: " + newPassword);
		sm.setText("Solicitação de senha, recomendados altera-la ao usar na primeira vez. ");
		return sm;
	}
//html email
@Override
public void sendNewPasswordHtmlEmail (Registro obj, String newPassword) {
 try {
	 MimeMessage mm = prepareMimeMessageFromsendNewPasswordHtmlEmail(obj, newPassword);
	 sendHtmlEmail(mm);
 }
 catch (MessagingException e) {
	sendNewPasswordEmail(obj, newPassword);
 }
}

protected String htmlFromTemplatesendNewPasswordHtmlEmail(Registro obj, String newPassword) {
	Context context = new Context();
		context.setVariable("registro",  obj);
		context.setVariable("password",  newPassword);
		return templateEngine.process("novaSenha", context);
   }
   
   protected MimeMessage prepareMimeMessageFromsendNewPasswordHtmlEmail(Registro obj, String newPassword) throws MessagingException {
	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
	mmh.setTo(obj.getEmail());
	mmh.setFrom(sender);
	mmh.setSubject("sr(a) " + obj.getCliente().getName() + " sua confirmação de validação de segurança ");
	mmh.setSentDate(new Date(System.currentTimeMillis()));
	mmh.setText(htmlFromTemplatesendNewPasswordHtmlEmail(obj, newPassword), true);
	return mimeMessage;
}
//simple email
    @Override
	public void sendNoticationChangerRegistro(Registro obj) {
		SimpleMailMessage sm = prepareNoticationChangerRegistro(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNoticationChangerRegistro(Registro obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Alteração de dados");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Seus dados foram atualizados");
		return sm;
	}
//email html
	protected String htmlFromTemplateSendNoticationChangerHtmlRegistro(Registro obj) {
		Context context = new Context();
			context.setVariable("registro", obj);
			return templateEngine.process("registroAtualizado", context);
	   }

	@Override
	public void sendNoticationChangerHtmlRegistro (Registro obj) {
	 try {
		 MimeMessage mm = prepareSendNoticationChangerHtmlRegistro (obj);
		 sendHtmlEmail(mm);
	 }
	 catch (MessagingException e) {
		prepareNoticationChangerRegistro(obj);
	 }
	}
	
	protected MimeMessage prepareSendNoticationChangerHtmlRegistro (Registro obj) throws MessagingException {
	 MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	 MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
	 mmh.setTo(obj.getEmail());
	 mmh.setFrom(sender);
	 mmh.setSubject("sr(a) " + obj.getCliente().getName() + "Seus dados foram atualizados.");
	 mmh.setSentDate(new Date(System.currentTimeMillis()));
	 mmh.setText(htmlFromTemplateSendNoticationChangerHtmlRegistro(obj), true);
	 return mimeMessage;
 }
//simple email
    @Override
	public void newAccount(Registro registro) {
		SimpleMailMessage sm = preparenewAccount(registro);
		sendEmail(sm);
	}

	protected SimpleMailMessage preparenewAccount(Registro registro) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(registro.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Bem vindo(a) ao BelaRosa");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Seu cadastro foi feito com sucessso. ");
		return sm;
	}
//email html
	protected String htmlFromTemplatenewAccountHtml(Registro obj) {
		Context context = new Context();
			context.setVariable("registro", obj);
			return templateEngine.process("novaConta", context);
	}

	@Override
	public void newAccountHtml (Registro obj) {
	try {
		MimeMessage mm = preparenewAccountHtml (obj);
		sendHtmlEmail(mm);
	}
	catch (MessagingException e) {
		preparenewAccount(obj);
		}
	}

	protected MimeMessage preparenewAccountHtml (Registro obj) throws MessagingException {
	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
	mmh.setTo(obj.getEmail());
	mmh.setFrom(sender);
	mmh.setSubject("sr(a) " + obj.getCliente().getName() + "Bem vindo(a) ao BelaRosa");
	mmh.setSentDate(new Date(System.currentTimeMillis()));
	mmh.setText(htmlFromTemplatenewAccountHtml(obj), true);
	return mimeMessage;
	}
//pix simple email
    @Override
    public void sendPixCode (PixPayment px) {
        SimpleMailMessage sm =  SimpleMailMessageFromPixPayment(px);
        sendEmail(sm);     
    }

	protected  SimpleMailMessage SimpleMailMessageFromPixPayment(PixPayment px) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(px.getRegistro().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de email");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Sr(a) " + px.getRegistro().getCliente().getName() + ", " + "Você solicitou email com codigo de pagamento.");
		return sm;
	}
//pix html email
	protected String htmlFromTemplatePixPayment(PixPayment px) {
		Context context = new Context();
		context.setVariable("pixPayment", px);
		return templateEngine.process("chavePix", context);
	}

	protected MimeMessage prepareMimeMessageFromPixPayment(PixPayment px) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(px.getRegistro().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("sr(a) " + px.getRegistro().getCliente().getName() + ", " + " Enviamos sua solicitação de pagamento");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePixPayment(px), true);
		return mimeMessage;
		}

	@Override
	public void sendPixCodeHtml (PixPayment px) {
	try {
		MimeMessage mm = prepareMimeMessageFromPixPayment(px);
		sendHtmlEmail(mm);
	}
	catch (MessagingException e) {
		SimpleMailMessageFromPixPayment(px);
		}
	}

}   
