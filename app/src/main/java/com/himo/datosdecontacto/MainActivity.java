package com.himo.datosdecontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_siguiente;
    EditText edtNombre, edtTelefono, edtEmail, edtDescripcion;
    Integer dia, mes, anio;
    DatePicker datNacimiento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityConfirmarDatos();
    }

    private void activityConfirmarDatos() {
        edtNombre = findViewById(R.id.edtNombre);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtEmail = findViewById(R.id.edtEmail);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        datNacimiento = findViewById(R.id.datNacimiento);
        btn_siguiente = findViewById(R.id.btnSiguiente);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            edtNombre.setText(parametros.getString("pNombre"));
            edtTelefono.setText(parametros.getString("pTelefono"));
            edtEmail.setText(parametros.getString("pEmail"));
            edtDescripcion.setText(parametros.getString("pDescripcion"));
            dia = parametros.getInt("pDia");
            mes = parametros.getInt("pMes");
            anio = parametros.getInt("pAnio");
            datNacimiento.updateDate(anio, mes, dia);
        }

        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentoConfirmarDatos = new Intent(MainActivity.this, ConfirmarDatos.class);
                intentoConfirmarDatos.putExtra("pnombre", edtNombre.getText().toString());
                intentoConfirmarDatos.putExtra("ptelefono", edtTelefono.getText().toString());
                intentoConfirmarDatos.putExtra("pemail", edtEmail.getText().toString());
                intentoConfirmarDatos.putExtra("pdescripcion", edtDescripcion.getText().toString());
                intentoConfirmarDatos.putExtra("pdia", datNacimiento.getDayOfMonth());
                intentoConfirmarDatos.putExtra("pmes", datNacimiento.getMonth());
                intentoConfirmarDatos.putExtra("panio", datNacimiento.getYear());
                startActivity(intentoConfirmarDatos);
                finish();
            }
        });
    }
}