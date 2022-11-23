package repository;

import java.util.UUID;

import domain.Color;
import utils.JpaRespository;



public class ColorRepository extends JpaRespository<Color, UUID>{

	public ColorRepository() {
		super(Color.class);
	}
	
}