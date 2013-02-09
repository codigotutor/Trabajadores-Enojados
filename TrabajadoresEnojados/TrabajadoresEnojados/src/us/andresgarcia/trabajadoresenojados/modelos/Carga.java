package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.math.Vector2;

public class Carga extends EntidadMovible{

	public Carga(Vector2 posicion, float ancho, float alto, float rotacion, float ACELERACION) {
		super(ACELERACION, rotacion, ancho, alto, posicion);
	}

}
