package com.example.estructuracontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv1=(TextView)findViewById(R.id.textView1);
		boolean condicion = true;
		// condicionales if, awitch
		if(condicion){
			tv1.setText("El valor es verdadero");
		}else{
			tv1.setText("El valor es Falso");	
		}
		
		int numero = 7;
		switch(numero){
		case 0:
			break;
		case 5:
			break;
		default: 
			String recuperando = tv1.getText().toString();
			tv1.setText(recuperando+"\ny el numero"+ numero+"no corresponde ala condicion");
			break;
		}
		
		//2 repetivas
		int suma = 0;
		for(int i=0;i<10;i++){
			suma = i + suma;
		}
		tv1.setText("suma "+suma);
		
		int b = 0, suma2 = 0;
		while(b <= 5){
			suma2++;
			b++;
		}
		String recuperando = tv1.getText().toString();
		tv1.setText(recuperando+"\nsuma2"+suma2);
			
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
