package com.michell.demo07_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MICHELL on 25/05/2017.
 */

public class SecondActivity extends AppCompatActivity {

    Button btSecondRegistrar, btSecondActualizar, btSecondEliminar;
    EditText etSecondNombre, etSecondApellido, etSecondDocument, etSecondEdad;

    private final View.OnClickListener btSecondEliminarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(SecondActivity.this, "Eliminar", Toast.LENGTH_SHORT).show();
        }
    };

    private final View.OnClickListener btSecondActualizarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(SecondActivity.this, "Actualizar", Toast.LENGTH_SHORT).show();
            
        }
    };

    private final View.OnClickListener btSecondRegistrarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent();
            intent.putExtra("nombre", etSecondNombre.getText().toString());
            intent.putExtra("apellido",etSecondApellido.getText().toString());
            intent.putExtra("document", etSecondDocument.getText().toString());
            intent.putExtra("edad", etSecondEdad.getText().toString());

            setResult(RESULT_OK, intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        etSecondNombre = (EditText) findViewById(R.id.etSecondNombre);
        etSecondApellido = (EditText) findViewById(R.id.etSecondApellido);
        etSecondDocument = (EditText) findViewById(R.id.etSecondDocument);
        etSecondEdad = (EditText) findViewById(R.id.etSecondEdad);

        Intent intent = getIntent();

        etSecondNombre.setText(intent.getStringExtra("nombre"));
        etSecondApellido.setText(intent.getStringExtra("apellido"));
        etSecondDocument.setText(intent.getStringExtra("document"));
        etSecondEdad.setText(intent.getStringExtra("edad"));

        btSecondRegistrar = (Button) findViewById(R.id.btSecondRegistrar);
        btSecondActualizar = (Button) findViewById(R.id.btSecondActualizar);
        btSecondEliminar = (Button) findViewById(R.id.btSecondEliminar);

        btSecondRegistrar.setOnClickListener(btSecondRegistrarOnClickListener);
        btSecondActualizar.setOnClickListener(btSecondActualizarOnClickListener);
        btSecondEliminar.setOnClickListener(btSecondEliminarOnClickListener);

    }
}
