package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonRegister;
    TextView mTextViewLogin ;
    TextView mTextCnfPassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword= (EditText) findViewById(R.id.edittext_password);
        mTextPassword= (EditText) findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText) findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){

                    long val = db.addUser(user,pwd);
                    if(val > 0){

                        Toast.makeText( Main2Activity.this," you have registered successfully",Toast.LENGTH_SHORT).show();
                        Intent movetomain =  new Intent(Main2Activity.this,MainActivity.class);
                        startActivity(movetomain);

                    }

                    else {

                        Toast.makeText( Main2Activity.this," Registration ERROR",Toast.LENGTH_SHORT).show();
                    }



                }
                else{

                    Toast.makeText( Main2Activity.this," Password Is Not Matching",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
