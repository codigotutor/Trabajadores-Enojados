package us.andresgarcia.trabajadoresenojados.vistas;


import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import us.andresgarcia.trabajadoresenojados.TrabajadoresEnojados;
import us.andresgarcia.trabajadoresenojados.modelos.Enemigo;
import us.andresgarcia.trabajadoresenojados.modelos.Nave;
import us.andresgarcia.trabajadoresenojados.modelos.Bala;
import us.andresgarcia.trabajadoresenojados.modelos.EnemigoCircular;

public class Mundo {
	
	TrabajadoresEnojados juego;
	Nave nave;
	Array<Bala> balas = new Array<Bala>();
	Array<Enemigo> enemigos = new Array<Enemigo>();
	Iterator<Bala> iteradorBalas;
	Iterator<Enemigo> iteradorEnemigos;
	RenderizarMundo renderizadorMundo;
	Bala bala;
	Enemigo enemigo;
	
	public Mundo(TrabajadoresEnojados juego){
		this.juego = juego;
		nave = new Nave(new Vector2(5, 5),1,1,0,5f);
		enemigos.add(new EnemigoCircular(5f,0,1,1,new Vector2(10, 10)));
		Gdx.input.setInputProcessor(new ManejadorEntrada(this));
	}
	
	public Nave getNave(){
		return nave;
	}
	
	
	public Array<Enemigo> getEnemigos(){
		return enemigos;
	}
	
	
	public void update(){
		nave.update();
		
		iteradorBalas = balas.iterator();
		while(iteradorBalas.hasNext()){
			bala = iteradorBalas.next();
			bala.update(nave);
			
			iteradorEnemigos = enemigos.iterator();
			
			while(iteradorEnemigos.hasNext()){
				enemigo = iteradorEnemigos.next();
				enemigo.avanzar(Gdx.graphics.getDeltaTime(), nave);
				
				
				if(nave.getLimites().overlaps(enemigo.getLimites()))
					Gdx.app.log(TrabajadoresEnojados.LOG, "contacto!!!!");
				
				
				if(enemigo.getLimites().overlaps(bala.getLimites())){
					Gdx.app.log(TrabajadoresEnojados.LOG, "enemigo cogido");
					iteradorEnemigos.remove();
					iteradorBalas.remove();					
				}
			}
		}
	}
	
	
	public void addBalas(Bala bala){
		balas.add(bala);
	}
	
	
	public Array<Bala> getBalas(){
		return balas;
	}
	
	
	public RenderizarMundo getRenderizadorMundo(){
		return renderizadorMundo;
	}
	
	
	public void setRenderizadorMundo(RenderizarMundo renderizadorMundo){
		this.renderizadorMundo = renderizadorMundo;
	}
	
	public void dispose(){
		
	}
	


}
