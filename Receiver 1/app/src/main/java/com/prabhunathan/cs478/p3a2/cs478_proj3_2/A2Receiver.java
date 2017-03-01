package com.prabhunathan.cs478.p3a2.cs478_proj3_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Prabhunathan Gnanasekaran on 10/28/2016.
 */
public class A2Receiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle extras = intent.getExtras();
        String type = extras.getString("type");
        Toast.makeText(context, "Expensive "+type+ " in Chicago Coming Up!!!", Toast.LENGTH_LONG).show();
    }
}
