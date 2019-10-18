package com.example.wastemanagement;
import com.example.wastemanagement.profile;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

public class signup extends AppCompatActivity implements View.OnClickListener {
    public EditText gmail,name,number,password,address;
   private Button pushbutton;
    private FirebaseAuth mAuth;
    String a,b;
    String num,nam,ad;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("user");



    Toast toast;
private AlertDialog.Builder n;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_form);
        gmail=findViewById(R.id.editText4);
        name=findViewById(R.id.editText3);
        number=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        address=findViewById(R.id.editText5);
        pushbutton=findViewById(R.id.push_button);
        mAuth = FirebaseAuth.getInstance();
        pushbutton.setOnClickListener(this);

        show ("value of a " ,"it has been fucking me"+a);

        // Sign in success, update UI th the signed-in user's information









    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.push_button)
        {
            num=number.getText().toString().trim();
            nam=name.getText().toString().trim();

            ad=address.getText().toString().trim();
    a=gmail.getText().toString();
            b=password.getText().toString().trim();


            show ("value of a " ,"it has been fucking me"+a+" "+b+ "fu" +nam);





try {
     show("value",""+a +"  "+b);
    createaccount(a, b);
}
catch (Exception e)
{
    show("fuck by",""+e);
}


        }
    }


    void createaccount(String gmai,String pass)
    {
        mAuth.createUserWithEmailAndPassword(gmai, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {





                              try {
                                  Toast.makeText(getApplicationContext(), "" + nam + " " + num + " " + " " + a, Toast.LENGTH_LONG).show();
                                  profile profil;
                                  profil = new profile(nam, a, num, b, ad);
                                  myRef.child("" + nam).setValue(profil);
                              }
                              catch (Exception e){
                                  show("hwll",""+e);

                            }



                            toast.makeText(getApplicationContext(),"i got no no fuck,",Toast.LENGTH_LONG).show();
                            Intent i = new Intent (signup.this,Comolain.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
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
