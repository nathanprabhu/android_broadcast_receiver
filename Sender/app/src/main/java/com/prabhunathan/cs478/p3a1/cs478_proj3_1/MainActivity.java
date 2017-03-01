package com.prabhunathan.cs478.p3a1.cs478_proj3_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private static final String TOAST_INTENT_HR = "com.prabhunathan.cs478.p3a1.cs478_proj3_1.hr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.setAction(TOAST_INTENT_HR);
                intent1.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                intent1.putExtra("type", "Hotels");
                sendOrderedBroadcast(intent1, null);
            }

        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setAction(TOAST_INTENT_HR);
                intent2.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                intent2.putExtra("type", "Restaurants");
                sendOrderedBroadcast(intent2, null);
            }

        });
    }
}
