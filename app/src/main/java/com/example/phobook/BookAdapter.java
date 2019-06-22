package com.example.phobook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class BookAdapter extends FirestoreRecyclerAdapter<Book, BookAdapter.BookHolder> {



    public BookAdapter(@NonNull FirestoreRecyclerOptions<Book> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BookHolder holder, int position, @NonNull Book model) {

        holder.textViewName.setText(model.getBookName());
        holder.textViewArtist.setText(model.getArtist());
        holder.textViewPriority.setText(String.valueOf(model.getPriority()));

    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent , false);
        return new BookHolder(v);
    }

    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();

    }

    class BookHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView textViewArtist;
        TextView textViewPriority;

        public BookHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_title);
            textViewArtist = itemView.findViewById(R.id.textView_description);
            textViewPriority = itemView.findViewById(R.id.textView_priority);
        }
    }
}
