package us.andresgarcia.trabajadoresenojados.vistas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AdministradorSonidos {
	
	private AdministradorSonidos(){}
	
	public static Music cancion = Gdx.audio.newMusic(Gdx.files.internal("data/melodia.mp3"));
	public static Sound disparo = Gdx.audio.newSound(Gdx.files.internal("data/disparo.wav"));
    public static Sound explosion = Gdx.audio.newSound(Gdx.files.internal("data/bomba.wav"));
	
	
	public static void iniciarMusica(boolean repetir){
		cancion.setLooping(repetir);
		cancion.play();
	}
	
	public static void pararMusica(){
		cancion.stop();
	}
	
	
	public static void disparo(){
		disparo.play();
	}
	
	public static void explosion(){
		explosion.play();
	}
	
	public static void dispose(){
		disparo.dispose();
		cancion.dispose();
		explosion.dispose();
	}
	
	
}
