package com.example.storeboyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class searchmenu extends AppCompatActivity {
    TextView textview;
    ArrayList<String> arrayList;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchmenu);
        textview = findViewById(R.id.txtview);
        arrayList = new ArrayList();
        arrayList.add("Minipalais A1102");
        arrayList.add("Minipalais A1103");
        arrayList.add("Minipalais A202");
        arrayList.add("Minipalais A3104");
        arrayList.add("Minipalais A4107");
        arrayList.add("Minipalais A5110");
        arrayList.add("Minipalais A6112");
        arrayList.add("Minipalais A7124");
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(searchmenu.this);
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(650, 800);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                EditText editText = dialog.findViewById(R.id.edittext);
                ListView listView = dialog.findViewById(R.id.listview);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(searchmenu.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(adapter);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textview.setText(adapter.getItem(i));
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
