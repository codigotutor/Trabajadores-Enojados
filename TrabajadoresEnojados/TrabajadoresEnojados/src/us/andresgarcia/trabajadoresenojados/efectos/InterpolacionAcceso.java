package us.andresgarcia.trabajadoresenojados.efectos;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

public class InterpolacionAcceso implements TweenAccessor<Sprite>{

	public static final int ALPHA = 1;
	
	@Override
	public int getValues(Sprite objetivo, int tipo, float[] valoresRetorno) {
		
		switch(tipo){
		case ALPHA: valoresRetorno[0] = objetivo.getColor().a;
			return 1;
		
		default: return 0;	
			
		}
	}

	@Override
	public void setValues(Sprite objetivo, int tipo, float[] nuevosValores) {	
		
		switch(tipo){
		case ALPHA: 
			objetivo.setColor(1, 1, 1, nuevosValores[0]);
			break;
		}	
	}
}
