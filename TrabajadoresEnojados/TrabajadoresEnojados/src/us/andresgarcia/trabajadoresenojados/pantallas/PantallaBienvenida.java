package us.andresgarcia.trabajadoresenojados.pantallas;

import us.andresgarcia.trabajadoresenojados.TrabajadoresEnojados;
import us.andresgarcia.trabajadoresenojados.efectos.InterpolacionAcceso;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PantallaBienvenida implements Screen {

	
	Texture imagenBienvenida;
	Sprite objetoBienvenida;
	SpriteBatch superficieDibujo;
	TrabajadoresEnojados juego;
	TweenManager administradorInterpolacion;
	
	
	public PantallaBienvenida(TrabajadoresEnojados juego){
		this.juego = juego;
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//Gdx.app.log(TrabajadoresEnojados.LOG, "pintando pantalla de bienvenida...");
		administradorInterpolacion.update(delta);
		
		superficieDibujo.begin();
		objetoBienvenida.draw(superficieDibujo);
		superficieDibujo.end();
		
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		imagenBienvenida = new Texture("data/pantallaBienvenida.png");
		imagenBienvenida.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		objetoBienvenida = new Sprite(imagenBienvenida);
		objetoBienvenida.setColor(1, 1, 1, 0);
		
		objetoBienvenida.setX(Gdx.graphics.getWidth()/2 - (objetoBienvenida.getWidth() /2));
		objetoBienvenida.setY(Gdx.graphics.getHeight()/2 - (objetoBienvenida.getHeight() /2));
		//objetoBienvenida.setOrigin(objetoBienvenida.getWidth()/2, objetoBienvenida.getHeight()/2);
		//objetoBienvenida.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		
		superficieDibujo = new SpriteBatch();
		
		Tween.registerAccessor(Sprite.class, new InterpolacionAcceso());
		
		administradorInterpolacion = new TweenManager();
		
		TweenCallback observadorInterpolacion = new TweenCallback() {
			
			@Override
			public void onEvent(int tipo, BaseTween<?> fuente) {
				interpolacionCompletada();
				
			}
		};
		
	
		Tween.to(objetoBienvenida, InterpolacionAcceso.ALPHA, 2f).
		target(1).
		ease(TweenEquations.easeInQuad).
		repeatYoyo(1, 2.5f).
		setCallback(observadorInterpolacion).
		setCallbackTriggers(TweenCallback.COMPLETE).
		start(administradorInterpolacion);
	}
	
	
	private void interpolacionCompletada() {
		juego.setScreen(new PantallaMenuPrincipal(juego));
		
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {
	
	}

	@Override
	public void dispose() {
		
	}

}
