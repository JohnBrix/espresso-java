package com.ui.espresso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        editTxFName = findViewById(R.id.edFname);
        editTxLName = findViewById(R.id.edLname);
        editTxMName = findViewById(R.id.edMname);
        btn = findViewById(R.id.btn);
        txView = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txView.setText(editTxFName.getText() + " " + editTxLName.getText() + " " + editTxMName.getText());
            }
        });
    }
}