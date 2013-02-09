package us.andresgarcia.trabajadoresenojados.vistas;

import us.andresgarcia.trabajadoresenojados.modelos.Nave;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class ManejadorEntrada implements InputProcessor{

	Mundo mundo;
	Nave nave;
	
	public ManejadorEntrada(Mundo mundo){
		this.mundo = mundo;
	}
	
	@Override
	public boolean keyDown(int codigoTecla) {
		
		nave = mundo.getNave();
		
		switch(codigoTecla){
		case Keys.W:
			nave.getVelocidad().y = 1;
			break;
		case Keys.S:
			nave.getVelocidad().y = -1;
			break;
		case Keys.A:
			nave.getVelocidad().x = -1;
			break;
		case Keys.D:
			nave.getVelocidad().x = 1;
			break;
		default:
			break;
		}
		
		return true;
	}

	@Override
	public boolean keyUp(int codigoTecla) {
		
		nave = mundo.getNave();
		
		switch(codigoTecla){
		case Keys.W:
			if(nave.getVelocidad().y == 1) // para evitar que se quede pegado a veces, al darle muchas
				// veces a la misma tecla la deja uno apretado y ya no avanza para esa direccion.
				nave.getVelocidad().y = 0;
			break;
		case Keys.S:
			if(nave.getVelocidad().y == -1)// para evitar que se quede pegado a veces, al darle muchas
				// veces a la misma tecla la deja uno apretado y ya no avanza para esa direccion.
				nave.getVelocidad().y = 0;
			break;
		case Keys.A:
			if(nave.getVelocidad().x == -1)// para evitar que se quede pegado a veces, al darle muchas
				// veces a la misma tecla la deja uno apretado y ya no avanza para esa direccion.
				nave.getVelocidad().x = 0;
			break;
		case Keys.D:
			if(nave.getVelocidad().x == 1)// para evitar que se quede pegado a veces, al darle muchas
				// veces a la misma tecla la deja uno apretado y ya no avanza para esa direccion.
				nave.getVelocidad().x = 0;
			break;
		default:
			break;
		}
		
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
