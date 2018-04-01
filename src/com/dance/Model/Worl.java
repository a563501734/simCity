package com.dance.Model;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.files.*;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.math.*;

/**
表示世界内的一块地
计算碰撞时只计算周围块上的物体
*/
public class Worl{
	World w;
	
	Worl(){
		Vector2 v=new Vector2(0,0);
		w=new World(v,true);
		
	}
}
