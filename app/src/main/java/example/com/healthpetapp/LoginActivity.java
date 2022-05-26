package example.com.healthpetapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import example.com.healthpetapp.db.SQLiteHelper;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView register;
    EditText Email, Password;

    /*String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempUser = "NOT_FOUND" ;
    public static final String UserEmail = "";

    SharedPreferences sharedpreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.emailInput);
        Password = (EditText) findViewById(R.id.passwordInput);

        /*sharedpreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String email = sharedpreferences.getString(KEY_EMAIL, null);
        String user = sharedpreferences.getString(KEY_PASSWORD, null);
        if(email!=null){
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);
        }

        sqLiteHelper = new SQLiteHelper(this);
        */

        login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* // Calling EditText is empty or no method.
                CheckEditTextStatus();
                // Calling login method.
                LoginFunction();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(KEY_EMAIL, Email.getText().toString());
                editor.putString(KEY_PASSWORD, Password.getText().toString());
                editor.apply();*/
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    @SuppressLint("Range")
    private void LoginFunction() {
        if (EditTextEmptyHolder) {
            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
            // Adding search email query to cursor.
           // cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);
            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    cursor.moveToFirst();
                    // Storing Password associated with entered email.
                  //  TempUser = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Password));
                    // Closing cursor.
                    cursor.close();
                }
            }
            // Calling method to check final result ..
            CheckFinalResult();
        } else {
            //If any of login EditText empty then this block will be executed.
            Toast.makeText(LoginActivity.this,"Please Enter UserName or Email.",Toast.LENGTH_LONG).show();
        }
    }

    private void CheckFinalResult() {
        if(TempUser.equalsIgnoreCase(PasswordHolder))
        {
            Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
            // Going to Dashboard activity after login success message.
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(UserEmail, PasswordHolder);
            startActivity(intent);
        }
        else {
            Toast.makeText(LoginActivity.this,"UserName or Email is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();
        }
        TempUser = "NOT_FOUND" ;
    }

    private void CheckEditTextStatus() {
        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();
        // Checking EditText is empty or no using TextUtils.
        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){
            EditTextEmptyHolder = false ;
        }
        else {
            EditTextEmptyHolder = true ;
        }
    }
    */

}