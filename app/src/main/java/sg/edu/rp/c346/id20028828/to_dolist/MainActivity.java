package sg.edu.rp.c346.id20028828.to_dolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDesc, etDate;
    Button btnInsertTask, btnShowTasks;
    RadioGroup rgImportance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etDesc = findViewById(R.id.etDescription);
        etDate = findViewById(R.id.editTextDate);
        btnInsertTask = findViewById(R.id.btnInsertTask);
        btnShowTasks = findViewById(R.id.btnShowTasks);
        rgImportance = findViewById(R.id.rgImportance);


        btnInsertTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String description = etDesc.getText().toString().trim();
                String date = etDate.getText().toString().trim();
                if (name.length() == 0 || description.length() == 0 || date.length() == 0) {
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }
                int selectedId = rgImportance.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                int importance = Integer.parseInt(selectedRadioButton.getText().toString());

                DBHelper dbh = new DBHelper(MainActivity.this);

                dbh.insertTask(name, description, date, importance);
                dbh.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();

                etName.setText("");
                etDesc.setText("");
                etDate.setText("");
            }
        });

        btnShowTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}