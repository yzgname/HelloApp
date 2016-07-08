package com.domain.helloapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Ev1;
    String username = null;
    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeText = (TextView)findViewById(R.id.textView);

        Ev1 = (EditText)findViewById(R.id.editText1);
        Button Btn1 = (Button)findViewById(R.id.button1);//获取按钮资源
        Btn1.setOnClickListener(new Button.OnClickListener(){//创建监听
            public void onClick(View v) {
                String strTmp = username + "点击Button01";
                Ev1.setText(strTmp);
                //Ev1.getText().append("\r\n");
                //Ev1.getText().append(strTmp);
            }

        });
        Button Btn2 = (Button)findViewById(R.id.button2);//获取按钮资源
        Btn2.setOnClickListener(new Button.OnClickListener(){//创建监听
            public void onClick(View v) {
                String strTmp = username + "点击Button02";
                Ev1.setText(strTmp);
                //Ev1.getText().append("\r\n");
                //Ev1.getText().append(strTmp);
            }
        });

        Button okButton = (Button)findViewById(R.id.okbtn);
        okButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                TextView errorEditText = (TextView) findViewById(R.id.errormsg);
                username = ((EditText) findViewById(R.id.username)).getText().toString();
                if(null == username || username.equals("")) {
                    errorEditText.setText("Please input username!");
                    return;
                }

                String pwd = ((EditText) findViewById(R.id.password)).getText().toString();
                if(null == pwd || pwd.equals("")) {
                    errorEditText.setText("Please input password!");
                    return;
                }

                if(username.equals("yzg") && pwd.equals("peter")) {
                    FrameLayout frameLayout = (FrameLayout)findViewById(R.id.login);
                    frameLayout.setVisibility(View.GONE);
                    String temp = welcomeText.getText().toString();
                    welcomeText.setText(username + " " + temp);
                } else {
                    errorEditText.setText("Username or password is incorrect!");
                    return;
                }
            }
        });
    }
}
