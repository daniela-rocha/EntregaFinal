package com.example.lucassouza.myprojectapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lucassouza.myprojectapp.Model.Curso;
import com.example.lucassouza.myprojectapp.Model.CursoRequester;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Curso> lista;
    CursoRequester requester;
    Intent intent;
    String chave;
    public static final String SERVIDOR = "http://192.168.1.18";
    public static final String APLICACAO = "/Curso";
    private final String RECURSO = "/curso";
    public static final String LISTA = "lista";

    private GoogleApiClient client;
    String nome;
    Button consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = ((EditText) findViewById(R.id.et_matricula)).getText().toString();
        consultar = (Button) findViewById(R.id.btn_consultar);

    }

    public void abrirActivitConsultarCurso(View v){
        chave = nome;
        requester = new CursoRequester();
        intent = new Intent(this, ListaCursoActivity.class);
        if(requester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lista = requester.get(SERVIDOR + APLICACAO + RECURSO, chave);
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run(){
                                intent.putExtra(LISTA, lista);
                                startActivity(intent);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponível", Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
