package org.danielcastelao.otorradomiguez.pmdm_ejercicio01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView cuadroTexto;
    int i=1;
    Date horaInicial;
    Date horaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.w("Mi Log","Mensaje desde onCreate()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        cuadroTexto = (TextView)findViewById(R.id.miTexto);
        cuadroTexto.setText(R.string.onPause);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Metodo usado con el onClick (en el XML) del boton send de content_main.xml
    public void miMetodo(View v){
        if(i==1) {
            horaInicial=Calendar.getInstance().getTime();
            cuadroTexto = (TextView) findViewById(R.id.miTexto);
            cuadroTexto.setText(R.string.miMensaje);
        }else if(i<5){
            Toast.makeText(this, "Es la "+i+"ª vez que pulsas el boton", Toast.LENGTH_SHORT).show();
        }else{
            horaFinal=Calendar.getInstance().getTime();
            long dif=(horaFinal.getTime()-horaInicial.getTime())/1000;
            Toast.makeText(this, "¿Tu te aburres no? Dejalo ya llevas "+dif+"s", Toast.LENGTH_SHORT).show();
        }
        i++;
    }
}
