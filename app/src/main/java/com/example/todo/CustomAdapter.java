package com.example.todo;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {

    CustomAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        final Item item = getItem(position);

        final CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        ImageButton deleteButton = convertView.findViewById(R.id.deleteButton);
        checkBox.setChecked(item.getChecked());



        checkBox.setText(getItem(position).getContent());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                List<Item> checkedList = ((MainActivity)getContext()).getCheckedList();

                item.setChecked(isChecked);
                if (isChecked) {
                    checkedList.add(item);
                    buttonView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    buttonView.setTextColor(Color.parseColor("#888888"));
                } else {
                    checkedList.remove(item);
                    buttonView.setPaintFlags(0);
                    buttonView.setTextColor(Color.parseColor("#000000"));
                }

                ((MainActivity)getContext()).renew();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(item);
                ((MainActivity)getContext()).renew();
            }
        });

        return convertView;
    }
}
