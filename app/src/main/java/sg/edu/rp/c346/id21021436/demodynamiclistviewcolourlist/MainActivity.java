package sg.edu.rp.c346.id21021436.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    EditText etIndexElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveColour);
        btnUpdate = findViewById(R.id.buttonUpdateColour);
        lvColour = findViewById(R.id.listViewColour);


        ArrayList<String> alcolours = new ArrayList<String>();

        alcolours.add("Red");
        alcolours.add("Orange");

        ArrayAdapter<String> aaColour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alcolours);
        lvColour.setAdapter(aaColour);



            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String colour = etElement.getText().toString();
                    //  alcolours.add(colour);
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alcolours.add(pos, colour);
                    aaColour.notifyDataSetChanged();
                }
            });

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alcolours.remove(pos);
                    aaColour.notifyDataSetChanged();
                }
            });

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String colour = etElement.getText().toString();
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alcolours.set(pos, colour);
                    aaColour.notifyDataSetChanged();
                }
            });

            lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String colour = alcolours.get(position).toString();
                    Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();

                }
            });

        }


    }
