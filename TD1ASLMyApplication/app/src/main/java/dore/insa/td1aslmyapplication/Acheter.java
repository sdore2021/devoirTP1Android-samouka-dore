package dore.insa.td1aslmyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Acheter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acheter);

        /*TextView textView = (TextView) findViewById(R.id.achatId);
        String login = getIntent().getExtras().getString("login");
        textView.setText(login);*/

        TextView textView = (TextView) findViewById(R.id.achatId);
        String login = getIntent().getExtras().getString("achat");
        String item = getIntent().getExtras().getString("item");
        if(login.equals("achat")){
            textView.setText("Voulez vous acheter ... ?\n"+item);
        }
    }
}