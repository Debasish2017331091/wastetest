package com.example.wastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity implements View.OnClickListener {
   private Button forget,login,signup;
    private FirebaseAuth mAuth;
   EditText username,password;
   Toast toast;
    String user,pass;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("user");

   private AlertDialog.Builder n;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forget=findViewById(R.id.forget);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        forget.setOnClickListener(this);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        username.getText().toString().trim();
        password.getText().toString().trim();
        mAuth = FirebaseAuth.getInstance();




    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.forget)
        {

        }
        else if (v.getId()==R.id.login)
        {



            user= username.getText().toString().trim();
            pass=password.getText().toString().trim();


            mAuth.signInWithEmailAndPassword(user,pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                               toast.makeText(getApplicationContext(),"fukc",Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                toast.makeText(getApplicationContext(),"fuck you boy ",Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });



        }
        else if (v.getId()==R.id.signup)
        {
            Intent i= new Intent (login.this,signup.class);
            startActivity(i);
        }
    }




    void show(String title, String dialog)
    {
        n=new AlertDialog.Builder(this);
        n.setTitle(title);
        n.setMessage(dialog);
        n.setCancelable(true);

        n.show();


    }

}
