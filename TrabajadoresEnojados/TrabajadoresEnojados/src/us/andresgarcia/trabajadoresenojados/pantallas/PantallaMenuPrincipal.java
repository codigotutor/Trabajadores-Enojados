package us.andresgarcia.trabajadoresenojados.pantallas;

import us.andresgarcia.trabajadoresenojados.TrabajadoresEnojados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class PantallaMenuPrincipal implements Screen{

	
	TrabajadoresEnojados juego;
	Stage escena;
	BitmapFont fuenteBlanca;
	BitmapFont fuenteNegra;
	TextureAtlas atlas;
	Skin piel;
	SpriteBatch superficieDibujo;
	TextButton boton;
	Label etiqueta;
	
	
	public PantallaMenuPrincipal(TrabajadoresEnojados juego){
		this.juego = juego;
	}
	
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		escena.act(delta);
		
		superficieDibujo.begin();
		escena.draw();
		superficieDibujo.end();
	}

	@Override
	public void resize(int ancho, int alto) {
		if(escena == null)
			escena = new Stage(ancho,alto,true);
		
		escena.clear();
		
		Gdx.input.setInputProcessor(escena);
		
		TextButtonStyle estiloBoton = new TextButtonStyle();
		estiloBoton.up = piel.getDrawable("botonNormal");
		estiloBoton.down = piel.getDrawable("botonPresionado");
		estiloBoton.font = fuenteNegra;
		
		boton = new TextButton("JUGAR", estiloBoton);
		boton.setWidth(400);
		boton.setHeight(100);
		boton.setX(Gdx.graphics.getWidth()/2 - boton.getWidth()/2);
		boton.setY(Gdx.graphics.getHeight()/2 - boton.getHeight()/2);
		
		
		boton.addListener(new InputListener(){
			public boolean touchDown(InputEvent evento, float x, float y, int apuntador, int boton ){
				return true;
			}
			
			public void touchUp(InputEvent evento, float x, float y, int apuntador, int boton ){
				juego.setScreen(new PantallaJuego(juego));
			}
			
			
		});
		
		
		LabelStyle estiloEtiqueta = new LabelStyle(fuenteBlanca, Color.WHITE);
		etiqueta = new Label("Trabajadores Enojados", estiloEtiqueta);
		etiqueta.setX(0);
		etiqueta.setY(Gdx.graphics.getHeight()/2 + 100);
		etiqueta.setWidth(ancho);
		etiqueta.setAlignment(Align.center);
		
		escena.addActor(boton);
		escena.addActor(etiqueta);
	}

	@Override
	public void show() {
		superficieDibujo = new SpriteBatch();
		piel = new Skin();
		
		atlas = new TextureAtlas("data/boton.pack");
		
		piel.addRegions(atlas);
		
		fuenteNegra = new BitmapFont(Gdx.files.internal("data/fuenteNegra.fnt"), false);
		fuenteBlanca =	new BitmapFont(Gdx.files.internal("data/fuenteBlanca.fnt"), false);	
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
		superficieDibujo.dispose();
		piel.dispose();
		atlas.dispose();
		fuenteBlanca.dispose();
		fuenteNegra.dispose();
		escena.dispose();
	}

}
