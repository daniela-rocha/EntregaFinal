package com.example.lucassouza.myprojectapp.Model;

import java.io.Serializable;

/**
 * Created by asbonato on 9/18/16.
 */
public class Curso implements Comparable, Serializable {
    private int id;
    private String nome;
    private String dataIni;
    private String dataTer;
    private String horario;
    private Double valor;
    private int numeroVagas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataTer() {
        return dataTer;
    }

    public void setDataTer(String dataTer) {
        this.dataTer = dataTer;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public Curso() {

    }

    public Curso(int id, String nome, String dataIni, String dataTer, String horario, Double valor, int numeroVagas) {
        this.id = id;
        this.nome = nome;
        this.dataIni = dataIni;
        this.dataTer = dataTer;
        this.horario = horario;
        this.valor = valor;
        this.numeroVagas = numeroVagas;
    }


    public String getIniciais() {
        String iniciais = nome.substring(0, 1);
        iniciais += nome.substring(nome.lastIndexOf(' ') + 1, nome.lastIndexOf(' ') + 2);
        return iniciais;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (dataIni == null) {
            if (other.dataIni != null)
                return false;
        } else if (!dataIni.equals(other.dataIni))
            return false;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return getNome().compareTo(((Curso) o).getNome());
    }
}
