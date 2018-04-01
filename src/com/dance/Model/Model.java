package com.dance.Model;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.*;

public class Model{
	//默认动画必须不为空
	private Animation<TextureRegion>upStopAnim;
	private Animation<TextureRegion> downStopAnim;
	private Animation<TextureRegion> leftStopAnim;
	private Animation<TextureRegion> rightStopAnim;
	private Animation<TextureRegion> leftAnim;
	private Animation<TextureRegion> rightAnim;
	private Animation<TextureRegion> upAnim;
	private Animation<TextureRegion> downAnim;
	//动画持续时间
	//每次切换均需置零
	private float delta;
	private Animation<TextureRegion> current;
	private float x;
	private float y;
	private float width;
	private float height;
	private float speed;
	public void draw(SpriteBatch sb){
		delta+=Gdx.graphics.getDeltaTime();
		current.getAnimationDuration();
		TextureRegion tex=current.getKeyFrame(delta);
		sb.begin();
		sb.draw(tex,x,y,width,height);
		sb.end();
	}
	public void left(){
		
	}
}
