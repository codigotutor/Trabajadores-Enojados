package us.andresgarcia.trabajadoresenojados.vistas;

import us.andresgarcia.trabajadoresenojados.modelos.Bala;
import us.andresgarcia.trabajadoresenojados.modelos.Nave;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class ManejadorEntrada implements InputProcessor{

	Mundo mundo;
	Nave nave;
	Vector3 toque = new Vector3();
	Vector2 vec2Toque = new Vector2();
	
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
		
		toque.set(screenX, screenY,0);
		mundo.getRenderizadorMundo().getCamara().unproject(toque);
		vec2Toque.set(toque.x, toque.y);
		nave = mundo.getNave();
		mundo.addBalas(new Bala(Bala.VELOCIDAD, 0, .1f, 8/20f, new Vector2(nave.getPosicion().x + nave.getAncho()/2, nave.getPosicion().y + nave.getAlto()/2), 
							new Vector2(vec2Toque.sub(nave.getPosicion()).nor())));
		return true;
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
