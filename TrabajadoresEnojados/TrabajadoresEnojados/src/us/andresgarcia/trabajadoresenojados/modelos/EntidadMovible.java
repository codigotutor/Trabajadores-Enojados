package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.math.Vector2;


public abstract class EntidadMovible extends Entidad {
	
	protected Vector2 velocidad;
	protected float ACELERACION;
	protected float rotacion;
	
	
	public EntidadMovible(float ACELERACION, float rotacion, float ancho, float alto, Vector2 posicion){
		super(posicion, ancho, alto);
		this.ACELERACION = ACELERACION;
		this.rotacion = rotacion;
		velocidad = new Vector2(0,0);
	}

	public Vector2 getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Vector2 velocidad) {
		this.velocidad = velocidad;
	}

	public float getRotacion() {
		return rotacion;
	}

	public void setRotacion(float rotacion) {
		this.rotacion = rotacion;
	}
	
	
	public abstract void update();

	
	
}
