package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class EnemigoCircular extends EntidadMovible {

	float VELOCIDAD_ROTACION = 500;
	
	
	public EnemigoCircular(float ACELERACION, float rotacion, float ancho, float alto,
			Vector2 posicion) {
		super(ACELERACION, rotacion, ancho, alto, posicion);
		
	}

	@Override
	public void update(Nave nave) {
		
		posicion.lerp(nave.getPosicion(), Gdx.graphics.getDeltaTime());
		
		rotacion += Gdx.graphics.getDeltaTime() * VELOCIDAD_ROTACION;
		
		if(rotacion >360)
			rotacion -= 360;
		
		super.update(nave);
	}

}
