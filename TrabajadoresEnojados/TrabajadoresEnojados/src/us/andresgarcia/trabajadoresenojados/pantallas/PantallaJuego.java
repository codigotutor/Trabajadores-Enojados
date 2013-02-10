package us.andresgarcia.trabajadoresenojados.pantallas;

import us.andresgarcia.trabajadoresenojados.TrabajadoresEnojados;
import us.andresgarcia.trabajadoresenojados.vistas.Mundo;
import us.andresgarcia.trabajadoresenojados.vistas.RenderizarMundo;

import com.badlogic.gdx.Screen;

public class PantallaJuego implements Screen {
	
	TrabajadoresEnojados juego;
	Mundo mundo;
	RenderizarMundo renderizar;
	
	
	public PantallaJuego(TrabajadoresEnojados juego){
		this.juego = juego;
		mundo = new Mundo(juego);
		renderizar = new RenderizarMundo(mundo);
	}
	

	@Override
	public void render(float delta) {
		mundo.update();
		renderizar.render();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		mundo.dispose();
		renderizar.dispose();
	}

}
