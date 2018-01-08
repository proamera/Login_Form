package me.dvit.project;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText password;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        textView = (TextView) findViewById(R.id.textview);
        password= (EditText) findViewById(R.id.password);

        if (password.getText().toString().length() < 8 && !isValidPassword(password.getText().toString())) {
            textView.setText(R.string.invalidpass);

        } else {

            textView.setText("");
            Toast.makeText(this, "Valid Password", Toast.LENGTH_LONG).show();
        }
    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public void showpassword(View view) {
        imageView = (ImageView)findViewById(R.id.imageView1);
        password= (EditText) findViewById(R.id.password);
        password.setInputType(InputType.TYPE_CLASS_TEXT);
    }
}