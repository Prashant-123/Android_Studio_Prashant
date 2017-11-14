package com.pankaj.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class LifeCycle extends AppCompatActivity {

    private static final String TAG= " tanyamessage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.i(TAG," on create");
        Toast.makeText(this , "Created" , Toast.LENGTH_SHORT).show() ;

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG," on Start");
        Toast.makeText(this , "Created" , Toast.LENGTH_SHORT).show() ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG," on Resume");
        Toast.makeText(this , "Resumed" , Toast.LENGTH_SHORT).show() ;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG," on pause");
        Toast.makeText(this , "Paused" , Toast.LENGTH_SHORT).show() ;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG," on stop");
        Toast.makeText(this , "Stopped" , Toast.LENGTH_SHORT).show() ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG," on destroy");
        Toast.makeText(this , "Destroyed" , Toast.LENGTH_SHORT).show() ;
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
