package com.dance.simCity;
import com.badlogic.gdx.graphics.*;

public abstract class Interface{
	static Main main;
	public Interface(){
	}
	public abstract void render();
	public abstract Camera getCamera();
	public abstract void dispose();
	public abstract void resize(int width,int height);
}
