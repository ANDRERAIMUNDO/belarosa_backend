package me.andreraimundo.belarosa_backend.services;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.andreraimundo.belarosa_backend.services.exception.FileException;

@Service
public class ImagesService {
//permitindo somente arquivo PNG ou JPG no Bucket
    public BufferedImage getJpgImageFromFile(MultipartFile uplodaFile) {

		String extensao = FilenameUtils.getExtension(uplodaFile.getOriginalFilename());

		if (!"png".equals(extensao) && !"jpg".equals(extensao)) {
			throw new FileException("Permitido somente imagem em formato PNG ou JPG. ");
		}
		try {
			BufferedImage img = ImageIO.read(uplodaFile.getInputStream());
			if ("jpg".equals(extensao)) {
				img = JpgToPng(img);
			}
			return img;
		} catch (IOException e) {
			throw new FileException("Imagem em formato não aceito no sitema!. User PNG ou JPG");
		}

	}
//Converte png para jpg
	public BufferedImage pngToJpg(BufferedImage img) {
		BufferedImage jpgImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		jpgImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
		return jpgImage;
	}

//Converte png para jpg
	public BufferedImage JpgToPng(BufferedImage img) {
		BufferedImage pngImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		pngImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
		return pngImage;
	}
//entrada de imagem padrao arquivo + extensao
	public InputStream getInputStream(BufferedImage img, String extension) {
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(img, extension, os);
			return new ByteArrayInputStream(os.toByteArray());
		} catch (IOException e) {
			throw new FileException("Erro ao ler arquivo");
		}
	}

// redimensionar imagem
	public BufferedImage cropSquare(BufferedImage sourceImg) {
		int min = (sourceImg.getHeight() <= sourceImg.getWidth()) ? sourceImg.getHeight() : sourceImg.getWidth();
		return Scalr.crop(sourceImg, (sourceImg.getWidth() / 2) - (min / 2), (sourceImg.getHeight() / 2) - (min / 2),
				min, min);
	}	
//opcional melhorando a quaide
	public BufferedImage resize(BufferedImage sourceImg, int size) {
		return Scalr.resize(sourceImg, Scalr.Method.ULTRA_QUALITY, size);
	}
}

//osb: por padrão o sistema suporte PNG E JPG, nesta classe está padrão PNG. 24/08/2021 