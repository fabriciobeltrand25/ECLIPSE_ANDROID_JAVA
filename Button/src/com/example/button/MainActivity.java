package com.example.button;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public abstract class MainActivity extends Activity implements OnClickListener, OnLongClickListener {
	
	EditText etNombre;
	Button btnEnviarRapido;
	Button  btnEnviarLento;
	TextView tvMs ;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etNombre= (EditText) findViewById(R.id.etNombre);
		btnEnviarRapido=(Button) findViewById(R.id.btnEnviarRapido);
		btnEnviarLento=(Button) findViewById(R.id.btnEnviarLento);
		tvMs=(TextView)findViewById(R.id.tvMs);
		
		btnEnviarRapido.setOnClickListener((android.view.View.OnClickListener) this);
		btnEnviarLento.setOnLongClickListener(this);
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

	public boolean onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.btnEnviarRapido:
		String nombreInvitado = etNombre.getText().toString();
		tvMs.setText("Tarjeta enviada a "+nombreInvitado);

		break;
		}
		
		return false;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
