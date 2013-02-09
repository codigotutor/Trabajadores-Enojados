package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.math.Vector2;

public class Nave extends EntidadMovible{

	public Nave(Vector2 posicion, float ancho, float alto, float rotacion, float ACELERACION) {
		super(ACELERACION, rotacion, ancho, alto, posicion);
	}

	@Override
	public void update() {
		
		
	}

}
