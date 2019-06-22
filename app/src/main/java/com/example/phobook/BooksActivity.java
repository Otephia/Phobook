package com.example.phobook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.phobook.Books.NietzscheBoyleBuyurduActivity;
import com.example.phobook.Books.StefanSatrancActivity;
import org.jetbrains.annotations.Nullable;

public class BooksActivity extends AppCompatActivity {

    ListView list;
    String kitapadi[] = {"Böyle Buyurdu Zerdüşt","Dönüşüm","Satranç","Olasılıksız","Savaş ve Barış","Hobbit","Nutuk Makinesi"};
    String aciklama[] = {"Friedrich Nietzsche","Franz Kafka","Stefan Zweig","Adam Fawer","Tolstoy","J.R.R Tolkien","Aziz Nesin"};
    int kapakresim [] = {R.drawable.boylebuyurduzerdust, R.drawable.donusum, R.drawable.satranc, R.drawable.olasiliksiz,
            R.drawable.savasvebaris, R.drawable.hobbit, R.drawable.nutukmakinesi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        list = findViewById(R.id.list);

        MyAdapter adapter = new MyAdapter(this, kitapadi,kapakresim,aciklama);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){

                    Intent intent = new Intent(BooksActivity.this, NietzscheBoyleBuyurduActivity.class);
                    startActivity(intent);

                    Toast.makeText(BooksActivity.this,"Böyle Buyurdu Zerdüşt", Toast.LENGTH_SHORT).show();

            }
                if (position == 1){


                    Toast.makeText(BooksActivity.this,"Hazır Değil!", Toast.LENGTH_SHORT).show();
                }

                if (position == 2){

                    Intent intent = new Intent(BooksActivity.this, StefanSatrancActivity.class);
                    startActivity(intent);

                    Toast.makeText(BooksActivity.this,"Satranç", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String bKitapadi[];
        String bAciklama[];
        int[] kapakresim;

        MyAdapter(Context c, String[] kitapadi, int[] kapakresim, String[] aciklama){
            super(c, R.layout.row, R.id.kitapadi1, kitapadi);
            this.context=c;
            this.kapakresim=kapakresim;
            this.bAciklama=aciklama;
            this.bKitapadi=kitapadi;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.logo);
            TextView kitapadi = row.findViewById(R.id.kitapadi1);
            TextView aciklama = row.findViewById(R.id.aciklama1);
            images.setImageResource(kapakresim[position]);
            kitapadi.setText(bKitapadi[position]);
            aciklama.setText(bAciklama[position]);


            return row;
        }
    }


}
