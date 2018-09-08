package com.deonico.prkesembilan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extra = getIntent().getBundleExtra("extra");
        final ArrayList<String> datanya = (ArrayList<String>) extra.getSerializable("array");
        final ListView arraylist = findViewById(R.id.lvArray);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ResultActivity.this, android.R.layout.simple_list_item_1, datanya);
        arraylist.setAdapter(adapter);

        arraylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = datanya.get(i);
                datanya.remove(i);
                Toast.makeText(ResultActivity.this, "Dibusek", Toast.LENGTH_LONG).show();
                arraylist.setAdapter(adapter);
            }
        });

    }
}
