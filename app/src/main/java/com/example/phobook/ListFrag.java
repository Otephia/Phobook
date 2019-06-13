package com.example.phobook;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    public GondorListener gondorListener;


    public ListFrag() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.city)));

        gondorListener.onCitySelected(0);
    }

    public interface GondorListener{

        public void onCitySelected(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try
        {
            gondorListener = (GondorListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "icerik cagırmalıyız" + "Gondor Cagırıcı!");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        gondorListener.onCitySelected(position);
    }
}
