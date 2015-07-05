package com.android.kamus.app;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{
	DatabaseManager dm;
	EditText input;
	ImageButton bcari;
	Button bTambah;
	TextView output;
	ArrayList<EntitasKamus> isikamus = new ArrayList<EntitasKamus>();
	EntitasKamus komponenkamus;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dm = new DatabaseManager(this);
        //mencocokkan komponen objek yang sesuai dg id nya
        bTambah = (Button) findViewById(R.id.btTambah);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        bcari = (ImageButton) findViewById(R.id.bSearch);
        
        //method supaya button berfungsi
        bTambah.setOnClickListener(this);
        bcari.setOnClickListener(this);
    }
    protected void fungsiterjemah(){
    	ArrayList<Object> baris;
    	baris = dm.terjemahkan(input.getText().toString());
    	if(baris.size()>0){
    		output.setText((String) baris.get(2));
    		input.setText("");
    	}else{
    		output.setText("tidak ditemukan");
    	}
    }


    @Override
    public void onClick(View v){
    	switch(v.getId()){
    	case R.id.bSearch:
    		fungsiterjemah();
    		break;
    	case R.id.btTambah:
    		Intent i = new Intent(MainActivity.this, TambahActivity.class);
    		startActivity(i);
    		break;
    	}
    }
}
