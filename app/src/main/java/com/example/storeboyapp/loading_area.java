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

public class loading_area extends AppCompatActivity {
    TextView textView;
    ArrayList<String> arrayList;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_area);

        textView = findViewById(R.id.text_view);
        arrayList = new ArrayList<>();

        arrayList.add("Minipalais A1102");
        arrayList.add("Amayavs A1103");
        arrayList.add("AnjanapsA202");
        arrayList.add("kajol A3104");
        arrayList.add("praveen A4107");
        arrayList.add("nidhinA5110");
        arrayList.add("robertvinay A6112");
        arrayList.add("jamespj A7124");
        arrayList.add("edwingovind A7124");
        arrayList.add("jeswinpl A7124");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(loading_area.this);
                dialog.setContentView(R.layout.dialog_searchable_spinner);

                dialog.getWindow().setLayout(900, 950);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                dialog.show();
                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_item);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(loading_area.this, android.R.layout.simple_list_item_1, arrayList);
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
                        textView.setText(adapter.getItem(i));
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
