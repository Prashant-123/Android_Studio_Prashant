package com.pankaj.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pankaj.helloworld.helper.SQLiteHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteTest extends MainActivity {

    private Button btnAdd;
    private Button btnUpdate;
    private Button btnDelete;
    private EditText inputName;
    private EditText inputEmail;
    private TextView dataRetrieved;
    private SQLiteHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_test);

        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnUpdate = (Button)findViewById(R.id.buttonUpdate);
        btnDelete = (Button)findViewById(R.id.buttonDelete);
        inputName = (EditText)findViewById(R.id.editTextName);
        inputEmail = (EditText)findViewById(R.id.editTextEmail);
        dataRetrieved = (TextView)findViewById(R.id.dataRetreived);
        db = new SQLiteHandler(getApplicationContext());

    }

    public void onAdd(View view){
        boolean res = db.addUser(inputName.getText().toString(), inputEmail.getText().toString());
        retrievedData(view);
        if(res){
            Toast.makeText(getApplicationContext(), "User added to database!",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "User cannot be added. Please check logs.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onUpdate(View view){
        boolean res = db.updateUser(inputName.getText().toString().trim(), inputEmail.getText().toString().trim());
        retrievedData(view);
        if(res){
            Toast.makeText(getApplicationContext(), "Email updated in the database!",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Email cannot be updated. Please check logs.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void onDelete(View view){
        boolean res = db.deleteUser(inputName.getText().toString().trim());
        retrievedData(view);
        if(res){
            Toast.makeText(getApplicationContext(), "User deleted from database!",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "User cannot be deleted. Please check logs.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void onDrop(View view){
        boolean res = db.deleteUsers();
        retrievedData(view);
        if(res){
            Toast.makeText(getApplicationContext(), "Users table deleted from database!",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Users table cannot be deleted. Please check logs.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void retrievedData(View view){
        dataRetrieved.setText(" ");
        ArrayList<HashMap<String, String>> list = db.getUserDetails();
        for (int itr=0; itr<list.size(); itr++){
            HashMap<String, String> user = list.get(itr);
            dataRetrieved.append(user.toString() + " \n");
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
