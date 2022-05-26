package example.com.healthpetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button register;
    EditText Username, Email, Password, Phone;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        Username = (EditText) findViewById(R.id.username);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        Phone = (EditText) findViewById(R.id.phone);

        register = (Button) findViewById(R.id.btnRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, TwoStepVerification.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        registerUser();
    }

    private void registerUser(){
        String username = Username.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String phone = Phone.getText().toString().trim();

        if(username.isEmpty()){
            Username.setError("Username is required");
            Username.requestFocus();
            return;
        }

        if(email.isEmpty()){
            Email.setError("Email is required");
            Email.requestFocus();
            return;
        }

        if(password.isEmpty()){
            Password.setError("Password is required");
            Password.requestFocus();
            return;
        }

        if(phone.isEmpty()){
            Phone.setError("Phone is required");
            Phone.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(username, email, password, phone);
                    FirebaseDatabase.getInstance().getReference("users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "User has been registered succesfull", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Failed to register try again", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }  else {
                    Toast.makeText(RegisterActivity.this, "Failed to register", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}