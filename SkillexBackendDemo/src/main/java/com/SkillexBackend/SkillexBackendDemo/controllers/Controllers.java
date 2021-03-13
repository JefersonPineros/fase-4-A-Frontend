package com.SkillexBackend.SkillexBackendDemo.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import org.springframework.web.multipart.MultipartFile;

public class Controllers {
	
	public String convertirImagen(String imagen, String nombre, Integer tipo) {
		String url;
		//Path pathImagenes = Paths.get("images");
		String urlFinalImagenes = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/ROOT/images";
		//Path pathEventos = Paths.get("images/eventos");
		String urlFinalEventos = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/ROOT/images/eventos";
		//Path pathAlbumes = Paths.get("images/albumes");
		String urlFinalAlbumes = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/ROOT/images/albumes";
		String nombres = nombre;
		try { 
			String base64String = imagen.split(",")[1];
			String tipoImagen = imagen.split(",")[0];
			String tipoImagen2 = tipoImagen.split("/")[1];
			String tipoImagen3 = tipoImagen2.split(";")[0];
			byte[] imagesBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64String);
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imagesBytes));
			
			if ( tipo == 1) {
				ImageIO.write( img, tipoImagen3.toLowerCase(), new File(urlFinalImagenes + "/" + nombres));
				//http://localhost:8080/images/
				url = "http://52.15.221.156:8080/images/" + nombres;
				return url;
			} else if (tipo == 2) {
				ImageIO.write( img, tipoImagen3.toLowerCase(), new File(urlFinalEventos + "/" + nombres));
				//http://localhost:8080/images/eventos/
				url = "http://52.15.221.156:8080/images/eventos/" + nombres;
				return url;
			} else if (tipo == 3) {
				ImageIO.write( img, tipoImagen3.toLowerCase(), new File(urlFinalAlbumes + "/" + nombres));
				//http://localhost:8080/images/albumes/
				url = "http://52.15.221.156:8080/images/albumes/" + nombres;
				return url;
			} else {
				return "";
			}
			
		} catch (Exception e) {
			System.out.println("A ocurrido un error al guardar la imagen");
			return null;
		}
	}
}
