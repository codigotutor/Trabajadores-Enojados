package us.andresgarcia.trabajadoresenojados.vistas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import us.andresgarcia.trabajadoresenojados.TrabajadoresEnojados;
import us.andresgarcia.trabajadoresenojados.modelos.Carga;

public class Mundo {
	
	TrabajadoresEnojados juego;
	Carga carga;
	
	public Mundo(TrabajadoresEnojados juego){
		this.juego = juego;
		carga = new Carga(new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2),1,1,0,5f);
	}
	
	public Carga getCarga(){
		return carga;
	}
	


}
