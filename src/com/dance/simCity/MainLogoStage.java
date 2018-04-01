package com.dance.simCity;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;

public class MainLogoStage extends Interface{
	private Camera cam;
	private Texture logos;
	private TextureRegion t[];
	private SpriteBatch sb;
	private Bezier<Vector2>anim;
	MainLogoStage(){
		cam=new OrthographicCamera();
		logos=new Texture("man.png");
		t=new TextureRegion[2];
		t[0]=new TextureRegion(logos,0,0,13,29);
		t[1]=new TextureRegion(logos,1,29,11,11);
		sb=new SpriteBatch();
		anim=new Bezier<>();
		anim.set(new Vector2[]{
			new Vector2(0,0),
			new Vector2(500,1.5f),
			new Vector2(6500,1.5f),
			new Vector2(7000,0),
		});
		Gdx.gl.glClearColor(1,1,1,1);
	}
	public Camera getCamera(){
		return cam;
	}
	long l;
	short index=-1;
	public void render(){
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		float f=(System.currentTimeMillis()-l)/7000f;
		Vector2 v=new Vector2();
		if(f>1){
			f=0;
			l=System.currentTimeMillis();
			index++;
			if(index>t.length-1){
				main.setStage(new Game());
				return;
			}
		}
		anim.valueAt(v,f);
		sb.setColor(1,1,1,v.y>1?1:v.y);
		float rate=t[index].getRegionHeight()*1f/t[index].getRegionWidth();
		sb.draw(t[index],-2,-2*rate,4,4*rate);
		sb.end();
	}
	public void dispose(){
		sb.dispose();
		logos.dispose();
	}
	public void resize(int width,int height){
		main.setStage(new Game());
		float rate=height*1f/width;
		cam.viewportWidth =8;
		cam.viewportHeight=rate*cam.viewportWidth;
		cam.update();
	}
}
