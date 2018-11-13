package com.example.nam.travel.views.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nam.travel.R;
import com.example.nam.travel.models.Note.Note;
import com.example.nam.travel.presenters.note.INotePresenter;
import com.example.nam.travel.presenters.note.NotePresenter;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener, INoteActivity{
    private Long idLocation;
    private Toolbar toolbar;
    private Button btnSave;
    private EditText edtNote;
    private INotePresenter notePresenter;
    private boolean isUpdate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        initCollapsingToolbar();
        Intent intent = getIntent();
        idLocation = intent.getLongExtra("idLocation", 1L);
        mapped();
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                String txtNote = edtNote.getText().toString();
                Note note = new Note(idLocation, txtNote);
                if(isUpdate) {
                    notePresenter.editNoteLocation(note);
                } else {
                    notePresenter.noteLocation(note);
                }

                break;
        }
    }

    private void initCollapsingToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Ghi chú");


        //Display back home button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void mapped() {
        btnSave = findViewById(R.id.btn_save);
        edtNote = findViewById(R.id.edt_note);
        notePresenter = new NotePresenter(this);
        notePresenter.getNoteLocation(idLocation);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void noteLocationFailure() {
        Toast.makeText(getBaseContext(), "note Location Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noteLocationSuccess() {
        onBackPressed();
    }


    public void getNoteLocationSuccess(String content) {
        if(content != null) {
            isUpdate = true;
            edtNote.setText(content);
            btnSave.setText("Cập nhật");
        }
    }

    public void getNoteLocationFailure() {
        Toast.makeText(getBaseContext(), "get note Location Failure", Toast.LENGTH_SHORT).show();
    }


    public void editNoteLocationSuccess() {
        onBackPressed();
    }

    public void editNoteLocationFailure(){
        Toast.makeText(getBaseContext(), "edit note Location Failure", Toast.LENGTH_SHORT).show();
    }
}
