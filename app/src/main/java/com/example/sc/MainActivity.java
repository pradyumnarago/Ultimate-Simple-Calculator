package com.example.sc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,b,bp,bm,bd,bmu,bmo,bans,bclr,bclra,bob,bcb,bdot;
    EditText e1;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String[] text = new String[1];
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.one);
        b2=(Button) findViewById(R.id.two);
        b3=(Button) findViewById(R.id.three);
        b4=(Button) findViewById(R.id.four);
        b5=(Button) findViewById(R.id.five);
        b6=(Button) findViewById(R.id.six);
        b7=(Button) findViewById(R.id.seven);
        b8=(Button) findViewById(R.id.eight);
        b9=(Button) findViewById(R.id.nine);
        b0=(Button) findViewById(R.id.zero);
        b=(Button) findViewById(R.id.power);
        bp=(Button) findViewById(R.id.plus);
        bm=(Button) findViewById(R.id.minus);
        bd=(Button) findViewById(R.id.divide);
        bmu=(Button) findViewById(R.id.multiply);
        bmo=(Button) findViewById(R.id.modulo);
        bans=(Button) findViewById(R.id.ans);
        bob=(Button) findViewById(R.id.ob);
        bcb=(Button) findViewById(R.id.cb);
        bclr=(Button) findViewById(R.id.clear);
        bclra=(Button) findViewById(R.id.clearall);
        bdot=(Button) findViewById(R.id.dot);
        e1=(EditText) findViewById(R.id.editTextText);
        t=(TextView) findViewById(R.id.textView);
        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                e1.setText(s1.substring(0, s1.length() - 1));
            }
        });
        bclra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString() + ".";
                e1.setText(text);
            }
        });
        bob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString() + "(";
                e1.setText(text);
            }
        });
        bcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+")";
                e1.setText(text);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"1";
                e1.setText(text);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"2";
                e1.setText(text);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"3";
                e1.setText(text);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"4";
                e1.setText(text);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"5";
                e1.setText(text);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"6";
                e1.setText(text);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"7";
                e1.setText(text);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"8";
                e1.setText(text);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"9";
                e1.setText(text);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"0";
                e1.setText(text);
            }
        });
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"+";
                e1.setText(text);
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"-";
                e1.setText(text);
            }
        });
        bmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"*";
                e1.setText(text);
            }
        });
        bmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"%";
                e1.setText(text);
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"/";
                e1.setText(text);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = e1.getText().toString()+"^";
                e1.setText(text);
            }
        });
        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression exp = new Expression(e1.getText().toString());
                try{
                    exp.infix_to_postfix();
                    exp.evaluate();
                    String text=e1.getText().toString() + " = " + exp.getVal();
                    t.setText(text);
                }catch(Exception w){
                    String text1="Invalid Expression. Enter a valid Expression.";
                    t.setText(text1);
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Created by Pradyumna Ragothaman", Toast.LENGTH_SHORT).show();
    }
}