package us.andresgarcia.trabajadoresenojados.vistas;

import java.io.IOException;
import java.util.Iterator;

import us.andresgarcia.trabajadoresenojados.TrabajadoresEnojados;
import us.andresgarcia.trabajadoresenojados.modelos.Bala;
import us.andresgarcia.trabajadoresenojados.modelos.Enemigo;
import us.andresgarcia.trabajadoresenojados.modelos.Nave;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;

public class RenderizarMundo {
	
	Mundo mundo;
	SpriteBatch superficieDibujo;
	Nave nave;
	OrthographicCamera camara;
	Texture texturaNave, texturaEnemigoCircular, texturaBala;
	float ancho, alto;
	ShapeRenderer renderizadorRectangulos;
	Array<Enemigo> enemigos;
	Array<Bala> balas;
	Iterator<Bala> iteradorBalas;
	Iterator<Enemigo> iteradorEnemigos;
	Bala bala;
	Enemigo enemigo;
	ParticleEmitter  particulaPunto;
	
	public RenderizarMundo(Mundo mundo){
		
		this.mundo = mundo;
		mundo.setRenderizadorMundo(this);
		
		ancho = Gdx.graphics.getWidth() / 40;
		alto = Gdx.graphics.getHeight() / 40;

		camara = new OrthographicCamera();
		camara.setToOrtho(false, ancho, alto);
		camara.update();
		
		superficieDibujo = new SpriteBatch();
		superficieDibujo.setProjectionMatrix(camara.combined);
		
		texturaNave = new Texture("data/nave.png");
		texturaNave.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		texturaEnemigoCircular = new Texture("data/enemigoCircular.png");
		texturaEnemigoCircular.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		
		texturaBala = new Texture("data/bala.png");
		texturaBala.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		
		particulaPunto = new ParticleEmitter();
		try {
			particulaPunto.load(Gdx.files.internal("data/efectoParticleEditor").reader(2024));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Texture texturaPelota = new Texture(Gdx.files.internal("data/particulaBlancaRedonda.png"));
		Sprite pelota = new Sprite(texturaPelota);
		particulaPunto.setSprite(pelota);
		particulaPunto.getScale().setHigh(0.3f);
		particulaPunto.start();

		renderizadorRectangulos = new ShapeRenderer();
	}
	
	public void render(){
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		nave = mundo.getNave();
		enemigos = mundo.getEnemigos();
		balas = mundo.getBalas();
		
		
		particulaPunto.setPosition(nave.getPosicion().x + nave.getAncho()/2, nave.getPosicion().y+ nave.getAncho()/2);
		setRotacionParticulaPunto();
		
		
		//mueve la camara
		camara.position.set(nave.getPosicion().x, nave.getPosicion().y, 0);
		camara.update();
		
		superficieDibujo.setProjectionMatrix(camara.combined);
		superficieDibujo.begin();
		
		particulaPunto.draw(superficieDibujo,Gdx.graphics.getDeltaTime());
		
		superficieDibujo.draw(texturaNave, //texture the Texture 
							  nave.getPosicion().x, //x the x-coordinate in screen space
							  nave.getPosicion().y, //y the y-coordinate in screen space
							  nave.getAncho()/2, //originX the x-coordinate of the scaling and rotation origin relative to the screen space coordinates
							  nave.getAlto()/2, //originY the y-coordinate of the scaling and rotation origin relative to the screen space coordinates
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
		
		
		iteradorEnemigos = enemigos.iterator();
		while(iteradorEnemigos.hasNext()){
			enemigo = iteradorEnemigos.next();
			
			superficieDibujo.draw(texturaEnemigoCircular, 
					enemigo.getPosicion().x, 
					enemigo.getPosicion().y, 
					enemigo.getAncho()/2, 
					enemigo.getAlto()/2, 
					enemigo.getAncho(), 
					enemigo.getAlto(), 
					1, 
					1, 
					enemigo.getRotacion(), 
					0, 
					0, 
					texturaEnemigoCircular.getWidth(), 
					texturaEnemigoCircular.getHeight(),
					false,
					false);	
		}
		
	
		
		iteradorBalas = balas.iterator();
		while(iteradorBalas.hasNext()){
			bala = iteradorBalas.next();
			
			superficieDibujo.draw(texturaBala, 
					bala.getPosicion().x, 
					bala.getPosicion().y, 
					bala.getAncho()/2, 
					bala.getAlto()/2, 
					bala.getAncho(), 
					bala.getAlto(), 
					1, 
					1, 
					bala.getRotacion(), 
					0, 
					0, 
					texturaBala.getWidth(), 
					texturaBala.getHeight(),
					false,
					false);
		}
		
		superficieDibujo.end();
		
		
		if(TrabajadoresEnojados.DEBUG){
			renderizadorRectangulos.setProjectionMatrix(camara.combined);
			renderizadorRectangulos.begin(ShapeType.Rectangle);
			renderizadorRectangulos.setColor(Color.CYAN);
			renderizadorRectangulos.rect(nave.getLimites().x, nave.getLimites().y, nave.getLimites().width, nave.getLimites().height);
			renderizadorRectangulos.setColor(Color.RED);
		
			iteradorEnemigos = enemigos.iterator();
			while(iteradorEnemigos.hasNext()){
				enemigo = iteradorEnemigos.next();
				renderizadorRectangulos.rect(enemigo.getLimites().x, enemigo.getLimites().y, enemigo.getLimites().width, enemigo.getLimites().height);
			}
		
			iteradorBalas = balas.iterator();
			while(iteradorBalas.hasNext()){
				bala = iteradorBalas.next();
				renderizadorRectangulos.rect(bala.getLimites().x, bala.getLimites().y, bala.getLimites().width, bala.getLimites().height);
			}
		
			renderizadorRectangulos.end();
		}
	}
	
	
	private void setRotacionParticulaPunto() {
		float angulo = nave.getRotacion();
		particulaPunto.getAngle().setLow(angulo + 270);		
		particulaPunto.getAngle().setHighMin(angulo+270-45);
		particulaPunto.getAngle().setHighMax(angulo+270+45);
		
	}

	public OrthographicCamera getCamara(){
		return camara;
	}
	
	
	
	public void dispose(){
		superficieDibujo.dispose();
		texturaNave.dispose();
		renderizadorRectangulos.dispose();
	}

}
