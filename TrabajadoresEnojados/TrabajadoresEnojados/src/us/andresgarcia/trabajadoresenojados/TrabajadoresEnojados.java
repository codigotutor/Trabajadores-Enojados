package us.andresgarcia.trabajadoresenojados;


import us.andresgarcia.trabajadoresenojados.pantallas.PantallaBienvenida;
import us.andresgarcia.trabajadoresenojados.vistas.AdministradorSonidos;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;


public class TrabajadoresEnojados extends Game {

	public static final String VERSION = "0.0.0.02 Pre-Alpha";
	public static final String LOG = "Trabajadores Enojados";
	public static final Boolean DEBUG = false;
	FPSLogger informacionPantallaFPS;
	
	@Override
	public void create() {		
		//setScreen(new PantallaBienvenida(this));
		//setScreen(new PantallaJuego(this));
		informacionPantallaFPS = new FPSLogger();
		AdministradorSonidos.iniciarMusica(true);
		setScreen(new PantallaBienvenida(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AdministradorSonidos.dispose();
	}

	@Override
	public void render() {		
		super.render();
		informacionPantallaFPS.log();
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
