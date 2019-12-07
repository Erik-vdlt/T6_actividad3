package e.root.bd_sqlite_basico_2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirActivities(View view){

        switch (view.getId()){
            case R.id.btn_agregar_altas:
                Intent i = new Intent(this, ActivityAltas.class);
                startActivity(i);
                break;
            case R.id.btn_eliminar:
                Intent i1 = new Intent(this, ActivityBajas.class);
                startActivity(i1);
                break;
            case R.id.btn_buscar:
                Intent i2 = new Intent(this, ActivityConsultas.class);
                startActivity(i2);
                break;
            case R.id.btn_modificar:
                Intent i3 = new Intent(this, ActivityCambios.class);
                startActivity(i3);
                break;
        }
    }
}
