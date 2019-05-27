package com.kaansonmezoz.blm3520.notebook.Activities.AddNoteActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kaansonmezoz.blm3520.notebook.Activities.AddNoteActivity.AlertBox.FileAttachmentsAlertDialog;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteAttachment;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteInfo;
import com.kaansonmezoz.blm3520.notebook.R;

import java.util.ArrayList;

public class AddNoteActivity extends AppCompatActivity {
    private Button saveButton;
    private EditText noteText;
    private Toolbar mTopToolbar;
    private EditText noteTitle;
    private ArrayList<String> attachmentPaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        //TODO: burası aslinda aynı aktivite olacak eger ki bundle icerisinden ya da intent ile iste bize bir obje gelmemisse
        //TODO: bu demek olacak ki yeni bir not yaratılıyor degil ise yeni bir not degil bu

        attachmentPaths = new ArrayList<String>();

        saveButton = findViewById(R.id.saveButton);
        noteText = findViewById(R.id.noteText);
        noteTitle = findViewById(R.id.note_title);

        mTopToolbar = (Toolbar) findViewById(R.id.add_note_toolbar);
        setSupportActionBar(mTopToolbar);
        /*
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //TODO: surada bir alertbox yaparız orada elemana priority sectiririz
                String title = noteTitle.getText().toString();

                Note note;
                NoteInfo noteInfo = new NoteInfo();

                NoteAttachment attachment = null;

                note = new Note(title, );

                if(attachmentPaths.size() != 0){ //TODO: ancak bu zaman dosya eklenmis demek db'ye o sekilde eklenecek

                }
            }
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_note_menu, menu);


        for(int i = 0; i < menu.size(); i++){   // bunu ayrıca color degistirmek icin de kullanmamiz gerekecek
            MenuItem item = menu.getItem(i);
            if(item.getTitle().toString().equals("Note Color")){
                Drawable drawable = item.getIcon();
                if(drawable != null) {
                    drawable.mutate();
                    drawable.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);
                }
            }

        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.attachment) {

            FileAttachmentsAlertDialog dialog = new FileAttachmentsAlertDialog(attachmentPaths);
            dialog.showDialog(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
