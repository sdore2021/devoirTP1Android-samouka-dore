package dore.insa.td1aslmyapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        TextView textView = (TextView) findViewById(R.id.text1Id);
        String login = getIntent().getExtras().getString("login");
        textView.setText(login);

        // definir la list des course
        String shoppingList[] = {"Du pain", "Du fromage", "Du coca", "Du beurre"};
        ListView simpleList = (ListView)findViewById(R.id.listViewCourseId);
        ArrayAdapter<String> tableau = new ArrayAdapter<String>(this, R.layout.activity_mon_text, R.id.monTextId,shoppingList);
        simpleList.setAdapter(tableau);
        simpleList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = simpleList.getCheckedItemPosition();
                String item = simpleList.getItemAtPosition(pos).toString();
                //Toast.makeText(ListeActivity.this, "" + obj, Toast.LENGTH_SHORT).show();

                // send to Acheter activity
                Intent intent = new Intent(getApplicationContext(), Acheter.class);
                intent.putExtra("item",item);
                intent.putExtra("achat","achat"); // pour preciser pour l'activité suivant
                startActivity(intent);

            }
        });
    }

}
