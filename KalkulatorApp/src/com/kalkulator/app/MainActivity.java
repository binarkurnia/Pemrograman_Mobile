package com.kalkulator.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button bTambah, bKurang, bKali, bBagi;
	EditText in1, in2, out;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		in1 = (EditText) findViewById(R.id.idSatu);
		in2 = (EditText) findViewById(R.id.idDua);
		out = (EditText) findViewById(R.id.idHasil);
		bTambah = (Button) findViewById(R.id.idBTambah);
		bKurang = (Button) findViewById(R.id.idBKurang);
		bKali = (Button) findViewById(R.id.idBKali);
		bBagi = (Button) findViewById(R.id.idBBagi);
		bTambah.setOnClickListener(this);
		bKurang.setOnClickListener(this);
		bKali.setOnClickListener(this);
		bBagi.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onClick(View v){
		switch (v.getId()){
		case R.id.idBTambah :
			String t1 = in1.getText().toString();
			String t2 = in2.getText().toString();
			if(!t1.equals("")|| !t2.equals("")){
				String hsl = penjumlahan(t1, t2);
				out.setText(hsl);
			}else{
				Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.idBKurang :
			String ku1 = in1.getText().toString();
			String ku2 = in2.getText().toString();
			if(!ku1.equals("") || !ku2.equals("")){
				String hsl = pengurangan(ku1,ku2);
				out.setText(hsl);
			} else {
				Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.id.idBKali :
			String ka1 = in1.getText().toString();
			String ka2 = in2.getText().toString();
			if(!ka1.equals("") || !ka2.equals("")){
				String hsl = pengurangan(ka1,ka2);
				out.setText(hsl);
			} else {
				Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.id.idBBagi :
			String b1 = in1.getText().toString();
			String b2 = in2.getText().toString();
			if(!b1.equals("") || !b2.equals("")){
				String hsl = pengurangan(b1,b2);
				out.setText(hsl);
			} else {
				Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
			}
			break;
		}
		
	}
	
	private String penjumlahan (String a, String b){
		Double d1 = Double.parseDouble(a);
		Double d2 = Double.parseDouble(b);
		Double dHasil = d1+d2;
		String taHasil = String.valueOf(dHasil);
		return taHasil;
	}
	
	private String pengurangan (String a, String b){
		Double d1 = Double.parseDouble(a);
		Double d2 = Double.parseDouble(b);
		Double dHasil = d1-d2;
		String taHasil = String.valueOf(dHasil);
		return taHasil;
	}
	
	private String perkalian (String a, String b){
		Double d1 = Double.parseDouble(a);
		Double d2 = Double.parseDouble(b);
		Double dHasil = d1*d2;
		String taHasil = String.valueOf(dHasil);
		return taHasil;
	}
	
	private String pembagian (String a, String b){
		Double d1 = Double.parseDouble(a);
		Double d2 = Double.parseDouble(b);
		Double dHasil = d1/d2;
		String taHasil = String.valueOf(dHasil);
		return taHasil;
	}
}