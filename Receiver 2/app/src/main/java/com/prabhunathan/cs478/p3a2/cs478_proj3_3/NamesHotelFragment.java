package com.prabhunathan.cs478.p3a2.cs478_proj3_3;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Prabhunathan Gnanasekaran on 10/29/2016.
 */

// List fragment - Hotel activity
public class NamesHotelFragment extends ListFragment {
    private ListSelectionListener myListener = null;

    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {

        getListView().setItemChecked(pos, true);
        myListener.onListSelection(pos);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myListener = (ListSelectionListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //Invoked on activity creation
    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.names_fragment, ChicagoHotelActivity.namesArray));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setSelector(android.R.color.holo_green_light);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}