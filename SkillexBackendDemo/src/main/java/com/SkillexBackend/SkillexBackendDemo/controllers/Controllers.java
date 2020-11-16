package com.SkillexBackend.SkillexBackendDemo.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;

public class Controllers {

	public void subirImagen() {
		
	}
	public BufferedImage convertirImagen(String imagen) {
		try {
			String base64String = imagen.split(",")[1];
			byte[] imagesBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64String);
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imagesBytes));
			return img;
		} catch (Exception e) {
			System.out.println("A ocurrido un error al guardar la imagen");
			return null;
		}
	}
}
