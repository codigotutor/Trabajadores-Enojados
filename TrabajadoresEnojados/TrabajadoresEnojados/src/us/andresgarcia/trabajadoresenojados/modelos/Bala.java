package us.andresgarcia.trabajadoresenojados.modelos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Bala extends EntidadMovible {

	public static float VELOCIDAD = 15;
	
	public Bala(float ACELERACION, float rotacion, float ancho, float alto,
			Vector2 posicion, Vector2 velocidad) {
		super(ACELERACION, rotacion, ancho, alto, posicion);
		
		this.velocidad = velocidad;
	}
	
	
	@Override
	public void update(Nave nave){
		
		posicion.add(velocidad.tmp().mul(Gdx.graphics.getDeltaTime() * ACELERACION));
		rotacion = velocidad.angle() - 90;
		super.update(nave);
	}

}
