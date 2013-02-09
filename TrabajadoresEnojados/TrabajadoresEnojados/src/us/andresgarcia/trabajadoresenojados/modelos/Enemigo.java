package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.math.Vector2;

public abstract class Enemigo extends EntidadMovible{

	public Enemigo(float ACELERACION, float rotacion, float ancho, float alto, Vector2 posicion) {
		super(ACELERACION, rotacion, ancho, alto, posicion);
	}
	
	public abstract void avanzar(float delta, Nave carga);

}
