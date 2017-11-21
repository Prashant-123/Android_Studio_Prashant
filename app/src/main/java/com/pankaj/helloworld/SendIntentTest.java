package com.pankaj.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SendIntentTest extends MainActivity {

    EditText SendIntentText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_intent_test);
    }

    public void SendIntentFn(View view){
        SendIntentText = (EditText)findViewById(R.id.SendIntentText);
        Intent send = new Intent(this, GetIntentTest.class);
        send.putExtra("INTENT_DATA", SendIntentText.getText().toString());
        startActivity(send);
    }

    public void SendImplicitIntentFn(View view){
        String url = "http://google.com";
        Intent sendImplicit = new Intent();
        sendImplicit.setAction(Intent.ACTION_VIEW);
        sendImplicit.setData(Uri.parse("http://google.com"));
        String title = getResources().getString(R.string.chooser_title);
        startActivity(sendImplicit);
// Create intent to show the chooser dialog
        Intent chooser = Intent.createChooser(sendImplicit, title);


// Verify that the intent will resolve to an activity
//        if (sendImplicit.resolveActivity(getPackageManager()) != null) {
//            Uri.parse("http://sscbs.du.ac.in/");
//            startActivity(chooser);
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        super.onOptionsItemSelected(item);
        //noinspection SimplifiableIfStatement
        switch(id){

            case R.id.HelloWorldMenu:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.spinnerMenu:
                Intent intent2 = new Intent(this, SpinnerTest.class);
                startActivity(intent2);
                return true;

            case R.id.loginMenu:
                Intent intent3 = new Intent(this, LoginActivity.class);
                startActivity(intent3);
                return true;

            case R.id.sendIntentMenu:
                Intent intent4 = new Intent(this, SendIntentTest.class);
                startActivity(intent4);
                return true;

            case R.id.colorButtonsMenu:
                Intent intent5 = new Intent(this, ColorButtons.class);
                startActivity(intent5);
                return true;

            case R.id.LifeCycle:
                Intent intent6 = new Intent(this, LifeCycle.class);
                startActivity(intent6);
                return true;

            case R.id.radioButtonMenu:
                Intent intent7 = new Intent(this, RadioButton.class);
                startActivity(intent7);
                return true;
            case R.id.Database:
                Intent intent8 = new Intent(this, SQLiteTest.class);
                startActivity(intent8);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
