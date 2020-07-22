package com.example.views.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =
            "com.example.views.ui.Activities.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.example.views.ui.Activities.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "com.example.views.ui.Activities.EXTRA_PRIORITY";

    private TextInputEditText mEdtTitle,mEdtDescription;
    private NumberPicker mNumberPickerPriority;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        //Toolbar configuration
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //EditText
        mEdtTitle = findViewById(R.id.edt_title);
        mEdtDescription = findViewById(R.id.edt_description);
        mNumberPickerPriority = findViewById(R.id.number_picker_priority);

        mNumberPickerPriority.setMinValue(1);
        mNumberPickerPriority.setMaxValue(10);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                SaveNote();
                return  true;
            case android.R.id.home:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Save Note Methode
    private void SaveNote(){
        String title = mEdtTitle.getText().toString();
        String description = mEdtDescription.getText().toString();
        int priority = mNumberPickerPriority.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please complete Title and Description", Toast.LENGTH_SHORT).show();
        }else{

            Intent data = new Intent();
            data.putExtra(EXTRA_TITLE,title);
            data.putExtra(EXTRA_DESCRIPTION,description);
            data.putExtra(EXTRA_PRIORITY,priority);

            setResult(RESULT_OK,data);
            finish();
        }
    }
}
