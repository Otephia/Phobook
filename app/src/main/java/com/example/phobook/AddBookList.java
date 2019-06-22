package com.example.phobook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddBookList extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editTextBookName;
    private EditText editTextArtist;
    private EditText editTextNot;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_list);

        mAuth = FirebaseAuth.getInstance();


        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Kitap Ekle");

        editTextBookName = findViewById(R.id.edit_text_bookName);
        editTextArtist = findViewById(R.id.edit_text_artist);
        editTextNot = findViewById(R.id.edit_text_note);
        numberPickerPriority = findViewById(R.id.number_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.book_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_book:
                saveBook();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void saveBook(){

        String bookName = editTextBookName.getText().toString();
        String artist = editTextArtist.getText().toString();
        String note = editTextNot.getText().toString();
        int priority = numberPickerPriority.getValue();

        if (bookName.trim().isEmpty() || artist.trim().isEmpty()){

            Toast.makeText(this, "Lütfen kitap adını veya yazarı boş bırakmayın!", Toast.LENGTH_SHORT).show();
            return;
        }


        /** String user_id = mAuth.getCurrentUser().getUid();

        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

        Map newAdd = new HashMap();
        newAdd.put("book", bookName);
        newAdd.put("artist", artist);
        newAdd.put("note", note);
        newAdd.put("priority", priority);

        current_user_db.setValue(newAdd); **/

        CollectionReference notebookRef = FirebaseFirestore.getInstance()
                .collection("BookList");
        notebookRef.add(new Book(bookName,artist,note,priority));
        Toast.makeText(this,"Kitap Eklendi!", Toast.LENGTH_SHORT).show();
        finish();


    }
}
