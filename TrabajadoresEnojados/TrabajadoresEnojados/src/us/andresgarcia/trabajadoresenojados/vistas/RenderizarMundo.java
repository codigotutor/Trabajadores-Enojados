package us.andresgarcia.trabajadoresenojados.vistas;

import us.andresgarcia.trabajadoresenojados.modelos.Nave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RenderizarMundo {
	
	Mundo mundo;
	SpriteBatch superficieDibujo;
	Nave nave;
	OrthographicCamera camara;
	Texture texturaNave;
	float ancho, alto;
	
	public RenderizarMundo(Mundo mundo){
		this.mundo = mundo;
		
		ancho = Gdx.graphics.getWidth() / 40;
		alto = Gdx.graphics.getHeight() / 40;

		camara = new OrthographicCamera();
		camara.setToOrtho(false, ancho, alto);
		camara.update();
		
		superficieDibujo = new SpriteBatch();
		superficieDibujo.setProjectionMatrix(camara.combined);
		
		texturaNave = new Texture("data/nave.png");
		texturaNave.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		
	}
	
	public void render(){
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		nave = mundo.getNave();
		
		//mueve la camara
		camara.position.set(nave.getPosicion().x, nave.getPosicion().y, 0);
		camara.update();
		
		superficieDibujo.setProjectionMatrix(camara.combined);
		
		superficieDibujo.begin();
		//superficieDibujo.draw(texturaNave, nave.getPosicion().x, nave.getPosicion().y);
		
		
		superficieDibujo.draw(texturaNave, //texture the Texture 
							  nave.getPosicion().x, //x the x-coordinate in screen space
							  nave.getPosicion().y, //y the y-coordinate in screen space
							  0, //originX the x-coordinate of the scaling and rotation origin relative to the screen space coordinates
							  0, //originY the y-coordinate of the scaling and rotation origin relative to the screen space coordinates
							  nave.getAncho(), // width the width in pixels
							  nave.getAlto(),  // height the height in pixels
							  1, //scaleX the scale of the rectangle around originX/originY in x
							  1, //scaleY the scale of the rectangle around originX/originY in y
							  nave.getRotacion(), // rotation the angle of counter clockwise rotation of the rectangle around originX/originY
							  0, // srcX the x-coordinate in pixel space
							  0, // srcY the y-coordinate in pixel space
							  texturaNave.getWidth(), //srcWidth the source with in pixels
							  texturaNave.getHeight(), // srcHeight the source height in pixels
							  false, // flipX whether to flip the sprite horizontally
							  false); // flipY whether to flip the sprite vertically
		superficieDibujo.end();
		
		
	}
	
	public void dispose(){
		superficieDibujo.dispose();
		texturaNave.dispose();
	}

}
