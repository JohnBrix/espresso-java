package com.ui.espresso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ui.espresso.view.Dashboard;

public class MainActivity extends AppCompatActivity {
    EditText
            editTxFName,
            editTxLName,
            editTxMName;
    TextView
            txView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTxFName = findViewById(R.id.edfName);
        editTxLName = findViewById(R.id.edlName);
        editTxMName = findViewById(R.id.edMname);
        btn = findViewById(R.id.btn);
        txView = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fname = editTxFName.getText().toString();
                String lname = editTxLName.getText().toString();
                String mname = editTxMName.getText().toString();
                Boolean intent = true; /*can be true*/

                if (fname.contains("open") && lname.contains("the") && mname.contains("intent")) {
                    Intent i = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(i);
                } else {
                    txView.setText(editTxFName.getText() + " " + editTxLName.getText() + " " + editTxMName.getText());
                }

            }
        });
    }
}