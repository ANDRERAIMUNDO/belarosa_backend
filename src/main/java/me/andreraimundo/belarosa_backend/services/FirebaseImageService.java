package me.andreraimundo.belarosa_backend.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.repositories.ProdutoRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;
import me.andreraimundo.belarosa_backend.services.exception.AuthorizationException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

@Service
public class FirebaseImageService{
	
	private Logger log = LoggerFactory.getLogger(FirebaseImageService.class);
	
	@Value("${firebase.bucket-name}")
	private String bucketName;

    @Autowired
    private ImagesService imagesService;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
	@Value("${img.prefix.client.profile}")
	private String prefix;
	
	@Value("${img.prefix.produto.prod}")
	private String prefixProd;
	
	@Value("${img.profile.size}")
	private Integer size;

	@EventListener
    public void init(ApplicationReadyEvent event) {
		
        try {
            ClassPathResource serviceAccount = new ClassPathResource("serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
                    .setStorageBucket(bucketName)
                    .build();
            FirebaseApp.initializeApp(options);
            log.info("firebase, logado com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
            log.info("firebase, não foi possivel logar");
        }
    }
	
	
	public String saveProfiles(MultipartFile file) throws IOException{
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Você precisa está logado! ");
		}
		BufferedImage pngImage = imagesService.getJpgImageFromFile(file);
		pngImage = imagesService.cropSquare(pngImage);
		pngImage = imagesService.resize(pngImage, size);
		String filePath = "cp/";
		String fileName = prefix + user.getId() + ".png";
		
		 Bucket bucket = StorageClient.getInstance().bucket();
		 bucket.create(filePath + fileName	, file.getBytes(), file.getContentType());
	     log.info("name = " + fileName);
	     return "file: " + fileName + "extension:" + fileName;
	}
	
	public String saveProduts(MultipartFile file, Integer id) throws IOException  {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Você precisa está logado! ");
		}
		
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto == null ) {
			throw new ObjectNotFoundException("Produto ID: " + id + "não encontrado");
		}
		
		BufferedImage pngImage = imagesService.getJpgImageFromFile(file);
		pngImage = imagesService.cropSquare(pngImage);
		pngImage = imagesService.resize(pngImage, size);
		String filePath = "prod/";
		String fileName = prefixProd + produto.get().getId() + ".png";
		
		Bucket bucket = StorageClient.getInstance().bucket();
		bucket.create(filePath + fileName, file.getBytes(), file.getContentType());
	     return "file: " + fileName + "extension:" + fileName;
	}
}