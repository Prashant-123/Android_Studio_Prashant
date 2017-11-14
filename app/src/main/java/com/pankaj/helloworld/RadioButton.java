package com.pankaj.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class RadioButton extends AppCompatActivity {

     TextView final_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        final_result=(TextView)findViewById(R.id.result_text);
        final_result.setEnabled(false);
    }

    public void selectcourse(View view)
    {
        boolean checked=((android.widget.RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.course_comp_sc:
                if(checked)
                {
                    final_result.setText("Dr Vandana Gupta ");
                    final_result.setEnabled(true);
                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;

            case R.id.course_phy_hons:
                if(checked)
                {
                    final_result.setText("Dr Rachna Kumar ");
                    final_result.setEnabled(true);
                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;

            case R.id.course_eng_hons:
                if(checked)
                {
                    final_result.setText("Mrs Monica Zutshi ");
                    final_result.setEnabled(true);
                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;

            case R.id.course_economics_hons:
                if(checked)
                {
                    final_result.setText("Dr Anjali Bansal ");
                    final_result.setEnabled(true);
                }
                else
                {
                    final_result.setEnabled(false);
                }
                break;

        }
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
