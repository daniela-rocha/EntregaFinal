package com.example.lucassouza.myprojectapp.Model;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private TextView nomeCurso, detalheCurso;

    public ViewHolder(TextView nomeCurso, TextView detalheCurso) {
        this.nomeCurso = nomeCurso;
        this.detalheCurso = detalheCurso;
    }

    public TextView getNomeCliente() {
        return nomeCurso;
    }

    public void setNomeCliente(TextView nomeCliente) {
        this.nomeCurso = nomeCliente;
    }

    public TextView getDetalheCliente() {
        return detalheCurso;
    }

    public void setDetalheCliente(TextView detalheCliente) {
        this.detalheCurso = detalheCliente;
    }
}

