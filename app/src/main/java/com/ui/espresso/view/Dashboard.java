package com.ui.espresso.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ui.espresso.R;

public class Dashboard extends AppCompatActivity {

    EditText
            dash,
            msg,
            name;
    TextView
            txView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        dash = findViewById(R.id.dash);
        msg = findViewById(R.id.msg);
        name = findViewById(R.id.name);
        btn = findViewById(R.id.btn);
        txView = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(dash.getText() + " " + msg.getText() + " " + name.getText());
                txView.setText(dash.getText() + " " + msg.getText() + " " + name.getText());

            }
        });
    }
}