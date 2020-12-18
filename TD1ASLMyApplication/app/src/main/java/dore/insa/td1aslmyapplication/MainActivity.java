package dore.insa.td1aslmyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText contenu = (EditText)findViewById(R.id.editId);

        TimePicker time = (TimePicker)findViewById(R.id.timeId);
        time.setIs24HourView(true);

        Button bouton1 = (Button)findViewById(R.id.button1Id);
        bouton1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textviewId);
                textView.setText(contenu.getText());
                int hour;
                int munites;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    hour = time.getHour();
                    munites =  time.getMinute();
                }
                else{
                    hour = time.getCurrentHour();
                    munites = time.getCurrentMinute();
                }
                String _temps = " doit faire les courses à "+hour+":"+munites;
                textView.append(_temps);
            }
        });
        Button quitter = (Button)findViewById(R.id.quiteId);
        quitter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                System.exit(0);
            }
        });

        Button mycourses = (Button)findViewById(R.id.courseId);
        mycourses.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent faireCourses = new Intent(getApplicationContext(), ListeActivity.class);
                String loginInfo = contenu.getText().toString();
                faireCourses.putExtra("login",loginInfo);
                startActivity(faireCourses);
            }
        });

     }
}