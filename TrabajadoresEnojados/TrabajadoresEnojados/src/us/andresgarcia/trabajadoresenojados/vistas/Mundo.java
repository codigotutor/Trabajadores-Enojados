package us.andresgarcia.trabajadoresenojados.vistas;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import us.andresgarcia.trabajadoresenojados.TrabajadoresEnojados;
import us.andresgarcia.trabajadoresenojados.modelos.Nave;
import us.andresgarcia.trabajadoresenojados.modelos.EnemigoCircular;

public class Mundo {
	
	TrabajadoresEnojados juego;
	Nave nave;
	EnemigoCircular enemigoCircular;
	
	public Mundo(TrabajadoresEnojados juego){
		this.juego = juego;
		
		nave = new Nave(new Vector2(5, 5),1,1,0,5f);
		enemigoCircular = new EnemigoCircular(5f,0,1,1,new Vector2(10, 10));
		
		Gdx.input.setInputProcessor(new ManejadorEntrada(this));
	}
	
	public Nave getNave(){
		return nave;
	}
	
	
	public EnemigoCircular getEnemigoCircular(){
		return enemigoCircular;
	}
	
	
	public void update(){
		nave.update();
		enemigoCircular.update(nave);
		
		//if(nave.getLimites().overlaps(enemigoCircular.getLimites()))
			//Gdx.app.log("ddd", "FFFFFFFF");
		
	}
	
	public void dispose(){
		
	}
	


}
