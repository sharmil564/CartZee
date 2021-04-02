package com.syed.cartzee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.syed.cartzee.FBase.UserHelperClass;
public class Register_page extends AppCompatActivity {

    EditText fname,lname,addr,mob,mail,dob,pwd,pwd1;
    CheckBox cb;
    ImageView mshow,mshow1;
    RadioGroup rg;
    Button bsubmit;
    String fn,ln,ad,mb,db,pd,pd1,ml;
    String ged,uid;
    FirebaseAuth fAuth;
    FirebaseDatabase fBase;
    DatabaseReference dRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        bsubmit =findViewById(R.id.signup);
        mshow=findViewById(R.id.dset3);
        mshow1=findViewById(R.id.dset4);
        bsubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validate1();

            }
        });

        TextView tx = (TextView) findViewById(R.id.back);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_page.this, LoginPage.class);
                startActivity(intent);
                // finish();
            }
        });
        //eye in password
        mshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd = findViewById(R.id.pass1);

                if (v.getId() == R.id.dset3) {

                    if (pwd.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                        mshow.setImageResource(R.drawable.ic_eye_open_24);

                        //Show Password
                        pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        pwd.setSelection(pwd.getText().length());

                    } else {
                        ((ImageView) (v)).setImageResource(R.drawable.ic_eye_hide);

                        //Hide Password
                        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        pwd.setSelection(pwd.getText().length());
                    }
                }
            }

        });
        mshow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd1 = findViewById(R.id.pass2);

                if (v.getId() == R.id.dset4) {

                    if (pwd1.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                        mshow1.setImageResource(R.drawable.ic_eye_open_24);

                        //Show Password
                        pwd1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        pwd1.setSelection(pwd1.getText().length());

                    } else {
                        ((ImageView) (v)).setImageResource(R.drawable.ic_eye_hide);

                        //Hide Password
                        pwd1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        pwd1.setSelection(pwd1.getText().length());
                    }
                }
            }

        });
        //ends eye password
    }

    public void validate1()
    {
        fAuth=FirebaseAuth.getInstance();
        fBase=FirebaseDatabase.getInstance();
        fname =findViewById(R.id.n1);
        lname =findViewById(R.id.l1);
        addr =findViewById(R.id.a1);
        mob =findViewById(R.id.num1);
        mail =findViewById(R.id.mal1);
        dob =findViewById(R.id.d1);
        pwd =findViewById(R.id.pass1);
        pwd1 =findViewById(R.id.pass2);
        cb = findViewById(R.id.checkBox);


        fn = fname.getText().toString();
        ln = lname.getText().toString();
        ad = addr.getText().toString();
        mb = mob.getText().toString();
        db = dob.getText().toString();
        pd = pwd.getText().toString();
        ml = mail.getText().toString();
        pd1 = pwd1.getText().toString();
        rg = (RadioGroup) findViewById(R.id.radioGrp);

        int check = rg.getCheckedRadioButtonId();

        int num = 0;

        if (check == -1) {
            num=1;
            Toast.makeText(Register_page.this, "Please select gender", Toast.LENGTH_LONG).show();

        }
        else
        {
            ged=((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        }
        if (fn.isEmpty()) {
            num=1;
            fname.setError("This field can't be empty");

        }
        if (ln.isEmpty()) {
            num=1;
            lname.setError("This field can't be empty");

        }
        if (ad.isEmpty()) {
            num=1;
            addr.setError("Specify your address");

        }
        if (mb.isEmpty()) {
            num=1;
            mob.setError("Field is Empty");

        } else if (mb.length() != 10) {
            num=1;
            mob.setError("Enter a valid number");

        }
        if (ml.isEmpty()) {
            num=1;
            mail.setError("Field is Empty");

        } else if (!ml.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            num=1;
            mail.setError("Enter a valid mail id");

        }
        if (!cb.isChecked()) {
            num=1;
            Toast.makeText(Register_page.this, "Please agree our terms", Toast.LENGTH_LONG).show();

        }
        if (db.isEmpty()) {
            num = 1;
            dob.setError("Enter your DOB");

        }
        if (pd.isEmpty()) {
            num=1;
            pwd.setError("Enter a password");

        }
        if (pd1.isEmpty()) {
            num=1;
            pwd1.setError("Enter a password");

        }
        if (!pd1.matches(pd)) {
            num=1;
            pwd1.setError("Please give corect password");

        }

        if(num==0) {
            fAuth.createUserWithEmailAndPassword(ml, pd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Register_page.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                        crAcc();
                        Intent ss = new Intent(Register_page.this, HomePage.class);
                        startActivity(ss);
                        finish();
                    } else {
                        Toast.makeText(Register_page.this, "Failed to create user !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void crAcc() {
        dRef=fBase.getReference().child("Users");
        uid=FirebaseAuth.getInstance().getUid();
        UserHelperClass helperClass=new UserHelperClass(fn,ln,ged,db,ad,mb,ml,pd);
        dRef.child(uid).child("Details").setValue(helperClass);
    }
}