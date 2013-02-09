package us.andresgarcia.trabajadoresenojados.vistas;

import us.andresgarcia.trabajadoresenojados.modelos.Nave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RenderizarMundo {
	
	Mundo mundo;
	SpriteBatch superficieDibujo;
	Nave nave;
	Camera camara;
	Texture texturaNave;
	
	public RenderizarMundo(Mundo mundo){
		this.mundo = mundo;
		superficieDibujo = new SpriteBatch();
		camara = new OrthographicCamera();
		texturaNave = new Texture("data/nave.png");
	}
	
	public void render(){
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		nave = mundo.getNave();
		superficieDibujo.begin();
		superficieDibujo.draw(texturaNave, nave.getPosicion().x, nave.getPosicion().y);
		superficieDibujo.end();
	}
	
	public void dispose(){
		superficieDibujo.dispose();
		texturaNave.dispose();
	}

}
