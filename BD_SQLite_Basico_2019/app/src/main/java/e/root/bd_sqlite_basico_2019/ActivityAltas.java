package e.root.bd_sqlite_basico_2019;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import controlador.AlumnoDAO;
import modelo.Alumno;

public class ActivityAltas extends Activity implements AdapterView.OnItemSelectedListener{
    EditText ed_num,ed_nombre,ed_primer,ed_segundo;
    Spinner spinner_carrera,spinner_semestre,spinner_edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_altas);

        ed_num = findViewById(R.id.edit_num_control);
        ed_nombre = findViewById(R.id.edit_nombre);
        ed_primer = findViewById(R.id.edit_primer);
        ed_segundo = findViewById(R.id.edit_segundo);
        spinner_semestre = findViewById(R.id.sp_semestre);
        spinner_carrera = findViewById(R.id.sp_carrera);
        spinner_edad = findViewById(R.id.spinner_edad);

        spinner_carrera.setOnItemSelectedListener(this);
        spinner_semestre.setOnItemSelectedListener(this);
        spinner_edad.setOnItemSelectedListener(this);

        ArrayAdapter adaptador_c = ArrayAdapter.createFromResource(this,R.array.listaCarrera,android.R.layout.simple_spinner_item);
        ArrayAdapter adaptador_s = ArrayAdapter.createFromResource(this,R.array.listaSemestre,android.R.layout.simple_spinner_item);
        ArrayAdapter adaptador_e = ArrayAdapter.createFromResource(this,R.array.listaedad,android.R.layout.simple_spinner_item);
        //ArrayAdapter adaptador_e  = new ArrayAdapter(this,android.R.layout.simple_spinner_item,edad());
        spinner_carrera.setAdapter(adaptador_c);
        spinner_semestre.setAdapter(adaptador_s);
        spinner_edad.setAdapter(adaptador_e);
    }


    public void agregar(View view){
        Alumno a = new Alumno();
        AlumnoDAO Adao = new AlumnoDAO(this);

        a.setNumContorl(String.valueOf(ed_num.getText()));
        a.setNombre(String.valueOf(ed_nombre.getText()));
        a.setPrimerAp(String.valueOf(ed_primer.getText()));
        a.setSegundoAp(String.valueOf(ed_segundo.getText()));
        a.setEdad(Byte.parseByte(String.valueOf(spinner_edad.getSelectedItem())));
        a.setSemestre(Byte.parseByte(String.valueOf(spinner_semestre.getSelectedItem())));
        a.setCarrera(String.valueOf(spinner_carrera.getSelectedItem()));

        Toast t = Toast.makeText(getApplicationContext(),"alumno "+a.toString(),Toast.LENGTH_LONG);
        t.show();
        Adao.agregarAlumno(a);
    }

    public String[] edad(){
        String listaEdad[] = new String[100];
        for (int i = 1;i<100;i++){
            listaEdad[i]= String.valueOf(i);
        }
        return listaEdad;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
