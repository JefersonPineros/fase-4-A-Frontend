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
		Path pathImagenes = Paths.get("images");
		String urlFinalImagenes = pathImagenes.toUri().getRawPath();
		Path pathEventos = Paths.get("images/eventos");
		String urlFinalEventos = pathEventos.toUri().getRawPath();
		Path pathAlbumes = Paths.get("images/albumes");
		String urlFinalAlbumes = pathAlbumes.toUri().getRawPath();
		String nombres = nombre;
		try { 
			String base64String = imagen.split(",")[1];
			String tipoImagen = imagen.split(",")[0];
			String tipoImagen2 = tipoImagen.split("/")[1];
			String tipoImagen3 = tipoImagen2.split(";")[0];
			byte[] imagesBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64String);
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imagesBytes));
			
			if ( tipo == 1) {
				ImageIO.write( img, tipoImagen3.toLowerCase(), new File(urlFinalImagenes + nombres));
				//http://localhost:8080/images/
				url = "https://power-riff-metal-bar.herokuapp.com/images/" + nombres;
				return url;
			} else if (tipo == 2) {
				ImageIO.write( img, tipoImagen3.toLowerCase(), new File(urlFinalEventos + nombres));
				//http://localhost:8080/images/eventos/
				url = "https://power-riff-metal-bar.herokuapp.com/images/eventos/" + nombres;
				return url;
			} else if (tipo == 3) {
				ImageIO.write( img, tipoImagen3.toLowerCase(), new File(urlFinalAlbumes + nombres));
				//http://localhost:8080/images/albumes/
				url = "https://power-riff-metal-bar.herokuapp.com/images/albumes/" + nombres;
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
