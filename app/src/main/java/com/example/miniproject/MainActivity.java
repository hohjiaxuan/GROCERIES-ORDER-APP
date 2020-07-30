package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Spinner spinner;
    Button btnsignup;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editText6);
        password = findViewById(R.id.editText7);
        btnsignup = findViewById(R.id.button3);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item= spinner.getSelectedItem().toString();
                String email1 =email.getText().toString();
                String pwd=password.getText().toString();
                if (email1.isEmpty())
                {
                    email.setError("Please enter email id");
                    email.requestFocus();
                }
                else if (pwd.isEmpty())
                {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (email1.isEmpty() && pwd.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Fields are empty!",Toast.LENGTH_SHORT).show();
                }
                else if (!email1.isEmpty() && !pwd.isEmpty())
                {
                    if(email.getText().toString().equals("admin")&& password.getText().toString().equals("admin")&&item.equals("Admin"))
                    {
                        Intent intent = new Intent (MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }
                    else if (email.getText().toString().equals("user")&& password.getText().toString().equals("user")&&item.equals("User"))
                    {
                        Intent intent = new Intent (MainActivity.this,MainActivity3.class);
                        startActivity(intent);
                    }
                    else
                        {
                            Toast.makeText(MainActivity.this,"Error Occur!!",Toast.LENGTH_SHORT).show();
                        }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Error Occur!!",Toast.LENGTH_SHORT).show();
                }

            }
        });
       /* int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton1=findViewById(radioId);
        Toast.makeText(this, "Selected Radio Button :"+radioButton1.getText(), Toast.LENGTH_SHORT).show();
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                String email =emailId.getText().toString();
                String pwd=password.getText().toString();
                if(email.isEmpty())
                {
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else if (pwd.isEmpty())
                {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pwd.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Fields are empty!",Toast.LENGTH_SHORT).show();
                }
                else if (!email.isEmpty() && !pwd.isEmpty())
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.this,"Signup Unsuccessful,PLease Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                startActivity(new Intent(MainActivity.this,MainActivity3.class));
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Error Occur!!",Toast.LENGTH_SHORT).show();
                }
            }

        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }*/
    }
}