package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entidad {
	protected Vector2 posicion;
	protected float ancho;
	protected float alto;
	protected Rectangle limites;
	
	
	public Entidad(Vector2 posicion, float ancho, float alto){
		this.posicion = posicion;
		this.ancho = ancho;
		this.alto = alto;
		
		limites = new Rectangle(posicion.x, posicion.y, ancho, alto);
	} 
	
	
	public Vector2 getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Vector2 posicion) {
		this.posicion = posicion;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public Rectangle getLimites() {
		return limites;
	}
	public void setLimites(Rectangle limites) {
		this.limites = limites;
	}	
}
