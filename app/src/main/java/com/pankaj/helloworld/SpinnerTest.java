package com.pankaj.helloworld;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerTest extends MainActivity {
    Spinner statespinner = null;
    Spinner cityspinner = null;
    TextView tv = null;
    ImageView iv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        statespinner = (Spinner)findViewById(R.id.spinner);
        cityspinner = (Spinner)findViewById(R.id.spinner2);

        tv = (TextView) findViewById(R.id.text1);
        iv =(ImageView) findViewById(R.id.imageView);

        Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.pathankot);
        iv.setImageBitmap(bImage);

        statespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String [] ker = getResources().getStringArray(R.array.kerala_cities);
                String [] har = getResources().getStringArray(R.array.haryana_cities);
                String [] pun = getResources().getStringArray(R.array.punjab_cities);
                ArrayAdapter<String> adapt = null;

                switch((String)statespinner.getSelectedItem()){
                    case "Kerala":
                        adapt = new ArrayAdapter <String>(getApplicationContext(), android.R.layout.simple_spinner_item, ker);
                        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        cityspinner.setAdapter(adapt);
                        adapt.notifyDataSetChanged();
                        break;

                    case "Haryana":
                        adapt = new ArrayAdapter <String>(getApplicationContext(), android.R.layout.simple_spinner_item, har);
                        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        cityspinner.setAdapter(adapt);
                        adapt.notifyDataSetChanged();
                        break;

                    case "Punjab":
                        adapt = new ArrayAdapter <String>(getApplicationContext(), android.R.layout.simple_spinner_item, pun);
                        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        cityspinner.setAdapter(adapt);
                        adapt.notifyDataSetChanged();
                        break;

                    default:
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cityspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv.setText((String)cityspinner.getSelectedItem() + " Selected");

                switch((String)cityspinner.getSelectedItem()){
                    case "Pathankot":
                        Bitmap bImage = BitmapFactory.decodeResource(getResources(), R.drawable.pathankot);
                        iv.setImageBitmap(bImage);
                        break;
                    case "Ludhiana":
                        Bitmap bImage2 = BitmapFactory.decodeResource(getResources(), R.drawable.ludhiana);
                        iv.setImageBitmap(bImage2);
                        break;
                    case "Jalandhar":
                        Bitmap bImage3 = BitmapFactory.decodeResource(getResources(), R.drawable.jalandhar);
                        iv.setImageBitmap(bImage3);
                        break;

                    default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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