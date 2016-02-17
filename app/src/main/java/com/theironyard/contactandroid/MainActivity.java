package com.theironyard.contactandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<Contact> items;

    ListView list;
    EditText name;
    EditText phoneNumber;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.name);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        addButton = (Button) findViewById(R.id.addButton);

        items = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!name.getText().toString().isEmpty() && !phoneNumber.getText().toString().isEmpty()){
            Contact item = new Contact(name.getText().toString(), phoneNumber.getText().toString());
            items.add(item);
            name.setText("");
            phoneNumber.setText("");
        }


    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Contact item = items.getItem(position);
        items.remove(item);
        return true;
    }
}
