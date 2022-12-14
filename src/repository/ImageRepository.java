package repository;

import java.util.UUID;

import domain.Image;
import utils.JpaRespository;


public class ImageRepository extends JpaRespository<Image, UUID>{

	public ImageRepository() {
		super(Image.class);
	}
	
}