package com.himo.datosdecontacto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvNombreExtra, tvNacimientoExtra, tvTelefonoExtra, tvEmailExtra, tvDescripcionExtra;
    String dia, mes, anio;
    Button btnEditar;
    Bundle parametros;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvNombreExtra = findViewById(R.id.tvNombreExtra);
        tvNacimientoExtra = findViewById(R.id.tvNacimientoExtra);
        tvTelefonoExtra = findViewById(R.id.tvTelefonoExtra);
        tvEmailExtra = findViewById(R.id.tvEmailExtra);
        tvDescripcionExtra = findViewById(R.id.tvDescripcionExtra);
        btnEditar = findViewById(R.id.btnEditar);

        parametros = getIntent().getExtras();
        tvNombreExtra.setText(parametros.getString("pnombre"));
        dia = String.valueOf(parametros.getInt("pdia"));
        mes = String.valueOf(parametros.getInt("pmes") + 1);
        anio = String.valueOf(parametros.getInt("panio"));
        tvNacimientoExtra.setText(dia + "/" + mes + "/" + anio);
        tvTelefonoExtra.setText(parametros.getString("ptelefono"));
        tvEmailExtra.setText(parametros.getString("pemail"));
        tvDescripcionExtra.setText(parametros.getString("pdescripcion"));

        editarDatos();
    }

    private void editarDatos() {

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentoEditarDatos = new Intent(ConfirmarDatos.this, MainActivity.class);
//                intentoEditarDatos.putExtras(parametros);
                intentoEditarDatos.putExtra("pNombre", parametros.getString("pnombre"));
                intentoEditarDatos.putExtra("pDia", parametros.getInt("pdia"));
                intentoEditarDatos.putExtra("pMes", parametros.getInt("pmes"));
                intentoEditarDatos.putExtra("pAnio", parametros.getInt("panio"));
                intentoEditarDatos.putExtra("pTelefono", parametros.getString("ptelefono"));
                intentoEditarDatos.putExtra("pEmail", parametros.getString("pemail"));
                intentoEditarDatos.putExtra("pDescripcion", parametros.getString("pdescripcion"));
                startActivity(intentoEditarDatos);
                finish();
            }
        });
    }
}
