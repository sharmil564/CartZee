package com.syed.cartzee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    EditText ml,pd;
    ImageView mShowHide;
    TextView rst;
    TextView t1;
    String mail,passwd;
    CheckBox Rem;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Button st=findViewById(R.id.logout);
        mShowHide=findViewById(R.id.show_hide_button);
        mAuth = FirebaseAuth.getInstance();
        t1=findViewById(R.id.textView9);
        rst=findViewById(R.id.fpass);


        mShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = findViewById(R.id.password1);

                if (v.getId() == R.id.show_hide_button) {

                    if (pd.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                        mShowHide.setImageResource(R.drawable.ic_eye_open_24);

                        //Show Password
                        pd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        pd.setSelection(pd.getText().length());

                    } else {
                        ((ImageView) (v)).setImageResource(R.drawable.ic_eye_hide);

                        //Hide Password
                        pd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        pd.setSelection(pd.getText().length());
                    }
                }
            }

        });


        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText rstm=new EditText(v.getContext());
                AlertDialog.Builder psdrst=new AlertDialog.Builder(v.getContext());
                psdrst.setTitle("Reset Password !");
                psdrst.setMessage("Enter your mail to send reset link");
                psdrst.setView(rstm);
                psdrst.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String resmail=rstm.getText().toString();
                        mAuth.sendPasswordResetEmail(resmail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LoginPage.this,"Reset link has been sent !",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginPage.this,"Error in sending reset link !"+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                psdrst.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //go back screen
                    }
                });
                psdrst.create().show();
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginPage.this,Register_page.class);
                startActivity(intent);

                //finish();
            }
        });
    }

    public void validate()
    {
        ml=findViewById(R.id.name1);
        pd=findViewById(R.id.password1);
        mail=ml.getText().toString().trim();
        passwd=pd.getText().toString().trim();

        if(!mail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
        {
            //Toast.makeText(LoginPage.this,"Enter a valid mail",Toast.LENGTH_SHORT).show();
            ml.setError("This field cant be empty");
            return;
        }
        if(passwd.isEmpty())
        {
            //Toast.makeText(LoginPage.this,"Enter the password",Toast.LENGTH_SHORT).show();
            pd.setError("Field can't be empty");
            return;
        }

        mAuth.signInWithEmailAndPassword(mail,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(LoginPage.this, "Login Successull",Toast.LENGTH_SHORT).show();
                    Intent main=new Intent(LoginPage.this,HomePage.class);
                    startActivity(main);
                    finish();

                }
                else
                {
                    Toast.makeText(LoginPage.this,"Incorrect User name and Password or \n User not registered !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}