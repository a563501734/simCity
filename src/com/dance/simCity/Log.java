package com.dance.simCity;
import android.content.*;
import android.app.*;
import android.os.*;
import java.io.*;

public class Log extends Service{
	private static Context self;
	public static final String data_key="data";
	public static final String action="com.dance.simCity";
	public static void log(String data){
		if(self==null){return;}
		Intent i=new Intent(action);
		i.putExtra(data_key,data);
		self.sendBroadcast(i);
	}
	private static final String log_path="/sdcard/a.txt";
	public static void sdlog(Object o){
		try{
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(log_path,true)));
			bw.write(o+"\n");
			bw.flush();
			bw.close();
		}catch(Exception e){

		}
	}
	public Log(){
		self=this;
	}
	public IBinder onBind(Intent p1){
		
		return null;
	}

	@Override
	public void onCreate(){
		super.onCreate();
		//registerReceiver(sl,i);
		//log("one");
	}
	
}
