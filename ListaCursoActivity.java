package com.example.lucassouza.myprojectapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.lucassouza.myprojectapp.Model.Curso;
import com.example.lucassouza.myprojectapp.Model.CursoAdapter;
import com.example.lucassouza.myprojectapp.Model.CursoRequester;

import java.util.ArrayList;

public class ListaCursoActivity extends AppCompatActivity {

    public static final String NOME = "nome";
    public static final String DATA_INI = "dataIni";
    public static final String DATA_TER = "dataTer";
    public static final String HORARIO = "horario";
    public static final String VALOR = "valor";
    public static final String NUM_VAGAS = "vagas";

    Activity atividade;
    ArrayList<Curso> lista;
    CursoRequester requester = new CursoRequester();
    String chave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_curso);
        atividade = this;
        Intent intent = getIntent();
        lista = (ArrayList<Curso>)intent.getSerializableExtra(MainActivity.LISTA);
        BaseAdapter adapter = new CursoAdapter(this, lista.toArray(new Curso[0]));
        ListView listView = (ListView) findViewById(R.id.lista_curso);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheCursoActivity.class);
                intent.putExtra(NOME, lista.get(position).getNome());
                intent.putExtra(VALOR, lista.get(position).getValor());
                intent.putExtra(NUM_VAGAS, lista.get(position).getNumeroVagas());
                intent.putExtra(DATA_INI, lista.get(position).getDataIni());
                intent.putExtra(DATA_TER, lista.get(position).getDataTer());
                intent.putExtra(HORARIO, lista.get(position).getHorario());

                startActivity(intent);

            }

        });

    }


}
