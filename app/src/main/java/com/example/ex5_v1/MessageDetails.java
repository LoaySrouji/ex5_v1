package com.example.ex5_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MessageDetails extends AppCompatActivity {
    public static final String INTENT__KEY_MESSAGE_CONTENT = "content";
    public static final String INTENT__KEY_MESSAGE_ID = "id";
    public static final String INTENT__KEY_MESSAGE_DEVICE = "device";
    public static final String INTENT__KEY_MESSAGE_TIMESTAMP = "timestamp";
    TextView message, device, id, timestamp;
    Button deleteButton;
    int pos;
    String username_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_details);
        message = (TextView) findViewById(R.id.textView_MessageContent);
        device = (TextView) findViewById(R.id.textView_DeviceInfo);
        id = (TextView) findViewById(R.id.textView_messageKey);
        timestamp = (TextView) findViewById(R.id.textView_Timestamp);
        deleteButton = (Button) findViewById(R.id.button_DeleteMessage);

        Bundle extras = getIntent().getExtras();
        message.setText("Message Content: " + extras.getString(INTENT__KEY_MESSAGE_CONTENT));
        device.setText("Sent From: " + extras.getString(INTENT__KEY_MESSAGE_DEVICE));
        id.setText("Message Key: " + extras.getString(INTENT__KEY_MESSAGE_ID));
        timestamp.setText("Message TimeStamp: " + extras.getString(INTENT__KEY_MESSAGE_TIMESTAMP));
        pos = extras.getInt(MainActivity.DELETE_MESSAGE_CODE);
        username_v = extras.getString(MainActivity.USERNAME);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageDetails.this, MainActivity.class);
                intent.putExtra(MainActivity.NAVIGATION_CODE, MainActivity.DELETE);
                intent.putExtra(MainActivity.DELETE_MESSAGE_CODE, pos);
                intent.putExtra(MainActivity.USERNAME, username_v);
                startActivity(intent);
                finishAffinity();
            }
        });
    }
}
