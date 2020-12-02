package com.SkillexBackend.SkillexBackendDemo.controllers;

import java.awt.PageAttributes.MediaType;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;
import com.SkillexBackend.SkillexBackendDemo.utilidades.MultipartImage;

public class Controllers {
	
	public String convertirImagen(String imagen, String nombre) {
		String url;
		String nombres = nombre;
		try { 
			String base64String = imagen.split(",")[1];
			String tipoImagen = imagen.split(",")[0];
			String tipoImagen2 = tipoImagen.split("/")[1];
			String tipoImagen3 = tipoImagen2.split(";")[0];
			byte[] imagesBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64String);
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imagesBytes));
			
			
			ImageIO.write( img, tipoImagen3, new File("C:\\Users\\jefer\\Documents\\NetBeansProjects\\SkillexBackendDemo\\images\\" + nombres));
			url = "http://localhost:8080/images/" + nombres;
			return url;
		} catch (Exception e) {
			System.out.println("A ocurrido un error al guardar la imagen");
			return null;
		}
	}
}
