package com.michell.demo07_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lvMain;
    private Button btMain;
    private LVMainAdapter mLVMainAdapter;
    private  int REQUEST_CODE  = 1;

    private final View.OnClickListener btMainOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    };

    private final AdapterView.OnItemClickListener lvMainOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Persona persona = mLVMainAdapter.getItem(position);

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("nombre", persona.getNombre().toString());
            intent.putExtra("apellido", persona.getApellido().toString());
            intent.putExtra("document", persona.getDocumento().toString());
            intent.putExtra("edad", String.valueOf(persona.getEdad()));
            startActivityForResult(intent, REQUEST_CODE);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        btMain = (Button) findViewById(R.id.btMain);

        btMain.setOnClickListener(btMainOnClickListener);
        lvMain.setOnItemClickListener(lvMainOnItemClickListener);

        mLVMainAdapter = new LVMainAdapter(MainActivity.this);
        lvMain.setAdapter(mLVMainAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {

                Persona persona = new Persona();
                persona.setId(java.util.UUID.randomUUID().toString());
                persona.setNombre(data.getStringExtra("nombre"));
                persona.setApellido(data.getStringExtra("apellido"));
                persona.setDocumento(data.getStringExtra("document"));
                persona.setEdad(Integer.valueOf(data.getStringExtra("edad")));

                mLVMainAdapter.add(persona);
            }
        }
    }
}
