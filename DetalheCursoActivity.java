package com.example.lucassouza.myprojectapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucassouza.myprojectapp.Model.Curso;
import com.example.lucassouza.myprojectapp.Model.CursoRequester;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class DetalheCursoActivity extends AppCompatActivity {
    Curso cliente;
    CursoRequester requester;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_curso);
        Intent intent = getIntent();
        cliente = new Curso(1, intent.getStringExtra(ListaCursoActivity.NOME),
                intent.getStringExtra(ListaCursoActivity.DATA_INI),
                intent.getStringExtra(ListaCursoActivity.DATA_TER),
                intent.getStringExtra(ListaCursoActivity.HORARIO),
                Double.parseDouble(intent.getStringExtra(ListaCursoActivity.VALOR)),
                Integer.parseInt(intent.getStringExtra(ListaCursoActivity.NUM_VAGAS)));

        requester = new CursoRequester();
        if (requester.isConnected(this)) {

        } else {
            Toast toast = Toast.makeText(this, "Rede indisponivel", Toast.LENGTH_LONG);
            toast.show();
        }
        TextView nome = (TextView) findViewById(R.id.txt_curso_nome);
        TextView dataIni = (TextView) findViewById(R.id.txt_curso_dataIni);
        TextView dataTerm = (TextView) findViewById(R.id.txt_curso_dataTer);
        TextView horario = (TextView) findViewById(R.id.txt_curso_horario);
        TextView valor = (TextView) findViewById(R.id.txt_curso_valor);
        TextView numVagas = (TextView) findViewById(R.id.txt_curso_vaga);

        nome.setText(cliente.getNome());
        dataIni.setText(cliente.getDataIni());
        dataTerm.setText(cliente.getDataTer());
        horario.setText(cliente.getHorario());
        valor.setText(cliente.getValor().shortValue());
        numVagas.setText(cliente.getNumeroVagas());
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DetalheCurso Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.lucassouza.myprojectapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "DetalheCurso Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.lucassouza.myprojectapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}


