package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Nave extends EntidadMovible{

	public Nave(Vector2 posicion, float ancho, float alto, float rotacion, float ACELERACION) {
		super(ACELERACION, rotacion, ancho, alto, posicion);
	}

	@Override
	public void update() {
		
		posicion.add(velocidad.tmp().mul(Gdx.graphics.getDeltaTime() * ACELERACION));
		
		if(velocidad.x != 0 || velocidad.y != 0)
			rotacion = velocidad.angle() - 90;
	}

}
