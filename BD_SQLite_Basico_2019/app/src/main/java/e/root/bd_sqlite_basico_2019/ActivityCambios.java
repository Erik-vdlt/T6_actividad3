package e.root.bd_sqlite_basico_2019;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import controlador.AlumnoDAO;
import modelo.Alumno;

public class ActivityCambios extends Activity implements AdapterView.OnItemSelectedListener{
    EditText num,nom,pa,sa;
    Spinner ss,sc,se;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cambios);

        num = findViewById(R.id.edit_num_cambios);
        nom = findViewById(R.id.edit_nombre_cambios);
        pa = findViewById(R.id.edit_primer_cambios);
        sa = findViewById(R.id.edit_segundo_cambios);
        se = findViewById(R.id.spinner_edad);
        ss = findViewById(R.id.sp_semestre);
        sc = findViewById(R.id.sp_carrera);

        se.setOnItemSelectedListener(this);
        ss.setOnItemSelectedListener(this);
        sc.setOnItemSelectedListener(this);

        ArrayAdapter adaptador_c = ArrayAdapter.createFromResource(this,R.array.listaCarrera,android.R.layout.simple_spinner_item);
        ArrayAdapter adaptador_s = ArrayAdapter.createFromResource(this,R.array.listaSemestre,android.R.layout.simple_spinner_item);
        ArrayAdapter adaptador_e = ArrayAdapter.createFromResource(this,R.array.listaedad,android.R.layout.simple_spinner_item);

        sc.setAdapter(adaptador_c);
        ss.setAdapter(adaptador_s);
        se.setAdapter(adaptador_e);
    }

    public void cambios(View view){
        Alumno a = new Alumno();
        AlumnoDAO Adao = new AlumnoDAO(this);

        a.setNumContorl(String.valueOf(num.getText()));
        a.setNombre(String.valueOf(nom.getText()));
        a.setPrimerAp(String.valueOf(pa.getText()));
        a.setSegundoAp(String.valueOf(sa.getText()));
        a.setEdad(Byte.parseByte(String.valueOf(se.getSelectedItem())));
        a.setSemestre(Byte.parseByte(String.valueOf(ss.getSelectedItem())));
        a.setCarrera(String.valueOf(sc.getSelectedItem()));

        Adao.modificarAlumno(a);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
