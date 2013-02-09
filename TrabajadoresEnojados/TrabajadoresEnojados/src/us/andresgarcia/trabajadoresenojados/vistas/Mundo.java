package us.andresgarcia.trabajadoresenojados.vistas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import us.andresgarcia.trabajadoresenojados.TrabajadoresEnojados;
import us.andresgarcia.trabajadoresenojados.modelos.Nave;

public class Mundo {
	
	TrabajadoresEnojados juego;
	Nave nave;
	
	public Mundo(TrabajadoresEnojados juego){
		this.juego = juego;
		nave = new Nave(new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2),1,1,0,5f);
	}
	
	public Nave getNave(){
		return nave;
	}
	
	
	public void update(){
		nave.update();
	}
	
	public void dispose(){
		
	}
	


}
