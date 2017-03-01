package com.prabhunathan.cs478.p3a2.cs478_proj3_3;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Prabhunathan Gnanasekaran on 10/30/16.
 */
public class ChicagoRestaurantImageFragment extends Fragment {

    private ImageView restaurantImage = null;
    private int currentIndex = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    // Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        restaurantImage = (ImageView) getActivity().findViewById(R.id.hotelImage);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }


    int getShownIndex() {
        return currentIndex;
    }

    // Show the image of the restaurant selected
    void showImage(int index) {
        if (index < 0 || index >= ChicagoHotelActivity.namesArray.length)
            return;
        currentIndex = index;
        restaurantImage.setImageResource(ChicagoHotelActivity.imagesArray[currentIndex]);
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
