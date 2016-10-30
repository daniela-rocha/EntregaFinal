package com.example.lucassouza.myprojectapp.Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.lucassouza.myprojectapp.R;

import java.util.Hashtable;

public class CursoAdapter extends BaseAdapter implements SectionIndexer
{
    Activity context;
    Curso[] curso;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public CursoAdapter(Activity context, Curso[] curso){
        this.context = context;
        this.curso = curso;
        sectionHeaders = SectionIndexBuilder.BuildSectionHeaders(this.curso);
        positionForSectionMap = SectionIndexBuilder.BuildPositionForSectionMap(this.curso);
        sectionForPositionMap = SectionIndexBuilder.BuildSectionForPositionMap(this.curso);

    }
    @Override
    public int getCount() {
        return curso.length;
    }

    @Override
    public Object getItem(int position) {
        if(position >= 0 && position < curso.length)
            return curso[position];
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //o list view recicla os layouts para melhor performance
        //o layout reciclado vem no parametro convert view
        View view = convertView;
        //se nao recebeu um layout para reutilizar deve inflar um
        if(view == null) {
            //um inflater transforma um layout em uma view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_curso, parent, false);

            TextView nomeCurso = (TextView)view.findViewById(R.id.nome_curso);
            TextView detalheCurso = (TextView)view.findViewById(R.id.detalhe_curso);
            //faz cache dos widgets instanciados na tag da view para reusar quando houver reciclagem
            view.setTag(new ViewHolder(nomeCurso, detalheCurso));
        }
        //usa os widgets cacheados na view reciclada
        ViewHolder holder = (ViewHolder)view.getTag();
        //carrega os novos valores

        holder.getNomeCliente().setText(curso[position].getNome());
        holder.getDetalheCliente().setText(String.format("%s - %s", curso[position].getNumeroVagas(),
                curso[position].getValor()));

        return view;
    }
//metodos da interface SectionIndexer


    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}
