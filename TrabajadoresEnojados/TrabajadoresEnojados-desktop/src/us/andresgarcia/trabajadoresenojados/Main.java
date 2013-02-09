package us.andresgarcia.trabajadoresenojados;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "TrabajadoresEnojados" + TrabajadoresEnojados.VERSION;
		cfg.useGL20 = true;
		cfg.width = 800;
		cfg.height = 600;
		//cfg.vSyncEnabled = false;
		
		new LwjglApplication(new TrabajadoresEnojados(), cfg);
	}
}
