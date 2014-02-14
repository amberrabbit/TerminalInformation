package com.example.terminalinformation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView text1 , text2;
	
	String strVersion = null;
	String loadAvg = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//表示用IDの指定
		text1 = (TextView) findViewById(R.id.textView1);
		text2 = (TextView) findViewById(R.id.textView2);
		
		try {
			//bufferでバージョン情報を読む
			BufferedReader reader1 = new BufferedReader(new FileReader("/proc/version"),256);
			BufferedReader reader2 = new BufferedReader(new FileReader("/proc/loadavg"),256);
			
			//読み込んだものを入れる
			strVersion = reader1.readLine();
			loadAvg = reader2.readLine();
			
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	
		//表示
		text1.setText("カーネルのバージョン：" + strVersion);
		text2.setText("負荷情報：" + loadAvg);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
