package com.deonico.prkesembilan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText isinya = findViewById(R.id.etInput);
        Button tambah = findViewById(R.id.btnAdd);
        final ListView arraylist = findViewById(R.id.lvArray);
        final Button lihat = findViewById(R.id.btnView);

        final ArrayList<String> addArray = new ArrayList<String>();

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getinput = isinya.getText().toString();

                if(addArray.contains(getinput)){
                    Toast.makeText(MainActivity.this, "Ditambah", Toast.LENGTH_SHORT).show();
                }
                else if(getinput == null || getinput.equals("")){
                    Toast.makeText(MainActivity.this, "Input yang bener", Toast.LENGTH_SHORT).show();
                }
                else{
                    addArray.add(getinput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addArray);
                    arraylist.setAdapter(adapter);
                    isinya.setText("");
                }
            }
        });



        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent newForm = new Intent(MainActivity.this,
                        ResultActivity.class);
                newForm.putExtra("array", addArray);
                startActivity(newForm);*/

                Bundle extra = new Bundle();
                extra.putSerializable("array", addArray);

                Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                intent.putExtra("extra", extra);
                startActivity(intent);

            }
        });

    }
}
