package com.example.trabalho;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> pessoas = new ArrayList<String>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        som();
        textViewPrint();
        pais();


        Button btn_china =  findViewById(R.id.button3);

        btn_china.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
}
    public void som() {
        ToggleButton musicaPlay = findViewById(R.id.toggleButton3);
        musicaPlay.setOnClickListener(view -> {
            if (musicaPlay.isChecked()){
                MediaPlayer meuSom;
                meuSom = MediaPlayer.create(this, R.raw.floresta);
                meuSom.start();
            }
        });
    }


    public void textViewPrint(){
        Button btn_Cadastrar = findViewById(R.id.cadastrar_btn);
        btn_Cadastrar.setOnClickListener(view -> {
            EditText nome = findViewById(R.id.editTextTextPersonName2);
            EditText senha = findViewById(R.id.editTextTextPassword);
            EditText email = findViewById(R.id.editTextTextEmailAddress);
            RadioButton homem = findViewById(R.id.radioButton_homem);
            RadioButton mulher = findViewById(R.id.radioButton_mulher);
            TextView conteudo = findViewById(R.id.conteudo);
            TextView conteudo2 = findViewById(R.id.conteudo2);
            TextView conteudo3 = findViewById(R.id.conteudo3);
            TextView conteudo4 = findViewById(R.id.conteudo4);


            pessoas.add(nome.getText().toString());
            TextView textnomes = findViewById(R.id.nomes);
            for (int i=0 ; i < pessoas.size() ; i++){
                Log.d(TAG, "Criado: " + pessoas.get(i));
                textnomes.setText(pessoas.get(i).toString());
            }


            if (homem.isChecked()){
                conteudo.setText(nome.getText().toString());
                conteudo2.setText(senha.getText().toString());
                conteudo3.setText(email.getText().toString());
                conteudo4.setText("homem");

            }else if (mulher.isChecked()){
                conteudo.setText(nome.getText().toString());
                conteudo2.setText(senha.getText().toString());
                conteudo3.setText(email.getText().toString());
                conteudo4.setText("mulher");
            }
        });
    }




    public void pais(){
        Spinner spnr;

        String[] paises = {
                "Brasil",
                "USA",
                "Argentina"
        };

        spnr = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, paises);

        spnr.setAdapter(adapter);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        int position = spnr.getSelectedItemPosition();
                        Toast.makeText(getApplicationContext(),"Você selecionou "+paises[+position],Toast.LENGTH_LONG).show();
                        TextView conteudo5 = findViewById(R.id.conteudo5);
                        conteudo5.setText(paises[+position].toString());
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );
    }
}