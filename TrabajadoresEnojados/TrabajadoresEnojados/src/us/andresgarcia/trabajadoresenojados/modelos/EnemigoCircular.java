package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.math.Vector2;

public class EnemigoCircular extends Enemigo {

	float VELOCIDAD_ROTACION = 500;
	
	
	public EnemigoCircular(float ACELERACION, float rotacion, float ancho, float alto,
			Vector2 posicion) {
		super(ACELERACION, rotacion, ancho, alto, posicion);
		
	}

	@Override
	public void avanzar(float delta, Nave nave) {
		
		posicion.lerp(nave.getPosicion(), delta);
		
		rotacion += delta * VELOCIDAD_ROTACION;
		
		if(rotacion >360)
			rotacion -= 360;
		
		super.update(nave);
		
	}

}
