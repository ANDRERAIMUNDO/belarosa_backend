package me.andreraimundo.belarosa_backend.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.andreraimundo.belarosa_backend.services.exception.FileException;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3Service {
    private Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 amazonS3Conect;

	@Value("${s3.bucket}")
	private String bucketName;

	@Value("${s3.bucket.prod}")
	private String bucketNameProd;

	public URI uploadFile(MultipartFile multipartFile) {
		try {

			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();
			return uploadFile(is, fileName, contentType);

		} catch (IOException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
	}

	public URI uploadFile(InputStream is, String fileName, String contentType) {
		try {

			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("Iniciando upload");
			amazonS3Conect.putObject(bucketName, fileName, is, meta);
			LOG.info("Upload finalizado");

			return amazonS3Conect.getUrl(bucketName, fileName).toURI();

		} catch (URISyntaxException e) {
			throw new FileException("Erro de conversão URL para URI");
		}
	}

		public URI uploadFileProdutc(InputStream is, String fileName, String contentType) {
			try {
	
				ObjectMetadata meta = new ObjectMetadata();
				meta.setContentType(contentType);
				LOG.info("Iniciando upload");
				amazonS3Conect.putObject(bucketNameProd, fileName, is, meta);
				LOG.info("Upload finalizado");
	
				return amazonS3Conect.getUrl(bucketNameProd, fileName).toURI();
	
			} catch (URISyntaxException e) {
				throw new FileException("Erro de conversão URL para URI");
			}
	}
}

