package com.example.manisaiprasad.letssecure;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manisaiprasad.letssecure.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity2 extends AppCompatActivity {

    Button button;
    EditText email;
    EditText password;

    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this,"Already Loged In",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mAuth = FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);

    }

    public void onRegister(View view){
        final String MyEmail=email.getText().toString();
        final String MyPass=password.getText().toString();

        mAuth.createUserWithEmailAndPassword(MyEmail, MyPass)
                .addOnCompleteListener(LoginActivity2.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            Toast.makeText(LoginActivity2.this,"registered",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity2.this, Main2Activity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity2.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}
