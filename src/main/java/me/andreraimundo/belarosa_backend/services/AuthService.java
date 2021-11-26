package me.andreraimundo.belarosa_backend.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.services.emails.EmailService;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;
//classe de geraçao de nova senha aleatoria
@Service
public class AuthService {
    
    @Autowired
    RegistroRepository registroRepository;

    @Autowired
    private BCryptPasswordEncoder encoderPassword;

    @Autowired
    private EmailService emailService;

    private Random random = new Random();

    public void sendNewPassword (String email) {
        Registro registro  = registroRepository.findByEmail(email);
        if (registro == null) {
            throw new ObjectNotFoundException("Email não encontrado! .");
        }

        String newPassword = newPassword();
        registro.setPassword(encoderPassword.encode(newPassword));

        registroRepository.save(registro);
        emailService.sendNewPasswordHtmlEmail(registro, newPassword);
    }

    private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = random.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (random.nextInt(10) + 48);
		}
		else if (opt == 1) { // gera letra maiuscula
			return (char) (random.nextInt(26) + 65);
		}
		else { // gera letra minuscula
			return (char) (random.nextInt(26) + 97);
		}
    }
}
