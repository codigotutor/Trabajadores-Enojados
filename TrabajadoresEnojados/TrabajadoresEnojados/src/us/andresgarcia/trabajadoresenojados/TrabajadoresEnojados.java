package us.andresgarcia.trabajadoresenojados;


//import us.andresgarcia.trabajadoresenojados.pantallas.PantallaBienvenida;
import us.andresgarcia.trabajadoresenojados.pantallas.PantallaJuego;

import com.badlogic.gdx.Game;


public class TrabajadoresEnojados extends Game {

	public static final String VERSION = "0.0.0.02 Pre-Alpha";
	public static final String LOG = "Trabajadores Enojados";
	
	@Override
	public void create() {		
		//setScreen(new PantallaBienvenida(this));
		setScreen(new PantallaJuego(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
