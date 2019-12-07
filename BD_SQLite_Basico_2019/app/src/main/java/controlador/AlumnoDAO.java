package controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import modelo.Alumno;

public class AlumnoDAO extends SQLiteOpenHelper {

    private static final int VERSION_BD = 1;
    private static final String NOMBRE_BD = "Escuela";
    private static final String TABLA_ALUMNOS = "Alumnos";
    private static final String CAMPO_NUM_CONTROL = "Num_Control";
    private static final String CAMPO_NOMBRE = "Nombre";
    private static final String CAMPO_PRIMER_AP = "Primer_Ap";
    private static final String CAMPO_SEGUNDO_AP = "Segundo_Ap";
    private static final String CAMPO_EDAD = "Edad";
    private static final String CAMPO_SEMESTRE = "Semestre";
    private static final String CAMPO_CARRERA = "Carrera";
    private static final String CREAR_TABLA_ALUMNOS = "CREATE TABLE "+TABLA_ALUMNOS
            +"("+CAMPO_NUM_CONTROL+" TEXT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_PRIMER_AP+" TEXT, "
            +CAMPO_SEGUNDO_AP+" TEXT, "+CAMPO_EDAD+" INTEGER, "+CAMPO_SEMESTRE+" INTEGER,"
            +CAMPO_CARRERA+" TEXT)";




    public AlumnoDAO(Context context/*, String name, SQLiteDatabase.CursorFactory factory, int version*/) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }



    public void agregarAlumno(){

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_ALUMNOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean agregarAlumno(Alumno a){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NUM_CONTROL,a.getNumContorl());
        cv.put(CAMPO_NOMBRE,a.getNombre());
        cv.put(CAMPO_PRIMER_AP,a.getPrimerAp());
        cv.put(CAMPO_SEGUNDO_AP,a.getSegundoAp());
        cv.put(CAMPO_EDAD,a.getEdad());
        cv.put(CAMPO_CARRERA,a.getCarrera());
        cv.put(CAMPO_SEMESTRE,a.getSemestre());

        long res = db.insert(TABLA_ALUMNOS,null,cv);

        return (res == -1) ? false : true;
    }

    public boolean eliminarAlumno(String nc){
        SQLiteDatabase db = this.getWritableDatabase();
        //String sql = "DELETE FROM "+TABLA_ALUMNOS+" WHERE "+CAMPO_NUM_CONTROL+" = "+nc;

        int res = db.delete(TABLA_ALUMNOS,CAMPO_NUM_CONTROL+" = "+nc,null);

        return (res == -1) ? false : true;
    }

    public boolean modificarAlumno(Alumno a){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NUM_CONTROL,a.getNumContorl());
        cv.put(CAMPO_NOMBRE,a.getNombre());
        cv.put(CAMPO_PRIMER_AP,a.getPrimerAp());
        cv.put(CAMPO_SEGUNDO_AP,a.getSegundoAp());
        cv.put(CAMPO_EDAD,a.getEdad());
        cv.put(CAMPO_CARRERA,a.getCarrera());
        cv.put(CAMPO_SEMESTRE,a.getSemestre());

        int res = db.update(TABLA_ALUMNOS,cv, CAMPO_NUM_CONTROL+" = "+a.getNumContorl(),null);
        return (res == -1) ? false : true;
    }

    public ArrayList<Alumno> obtenerTodosLosAlumnos(String filtro){
        ArrayList<Alumno> listaAlumnos = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM "+TABLA_ALUMNOS;

        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do {
                listaAlumnos.add(new Alumno(cursor.getString(0),cursor.getString(1),cursor.getString(2)
                        ,cursor.getString(3),(byte)cursor.getInt(4),(byte)cursor.getInt(5)
                        ,cursor.getString(6)));


            }while (cursor.moveToNext());
        }


        return  listaAlumnos;
    }


}
