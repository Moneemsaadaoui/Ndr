package com.michell.demo07_3;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by MICHELL on 25/05/2017.
 */

public class LVMainAdapter extends ArrayAdapter<Persona> {

    public LVMainAdapter(Context context) {

        super(context,0, new ArrayList<Persona>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_item, parent, false);

        TextView tvMainItemFullname, tvMainItemDocument, tvMainItemAge;

        tvMainItemFullname = (TextView) convertView.findViewById(R.id.tvMainItemFullName);
        tvMainItemDocument = (TextView) convertView.findViewById(R.id.tvMainItemDocument);
        tvMainItemAge = (TextView) convertView.findViewById(R.id.tvMainItemAge);

        //OBTENER LA POSICION DE LA PERSONA

        Persona persona = getItem(position);

        tvMainItemFullname.setText(persona.getNombre()+ ' '+persona.getApellido());
        tvMainItemDocument.setText(persona.getDocumento());
        tvMainItemAge.setText(String.valueOf(persona.getEdad()));

        return convertView;
    }
}
