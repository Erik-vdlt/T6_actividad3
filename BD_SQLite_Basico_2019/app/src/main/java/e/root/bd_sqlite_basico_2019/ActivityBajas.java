package e.root.bd_sqlite_basico_2019;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import controlador.AlumnoDAO;
import modelo.Alumno;

public class ActivityBajas extends Activity {
    EditText num_control;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bajas);

        num_control = findViewById(R.id.edit_num_control_bajas);
    }

    public void eliminar(View view){
        Alumno a = new Alumno();
        AlumnoDAO alumnoDAO = new AlumnoDAO(this);

        alumnoDAO.eliminarAlumno(String.valueOf(num_control.getText()));
    }
}
