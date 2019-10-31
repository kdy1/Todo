package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> list;
    private List<Item> checkedList;
    private CustomAdapter customAdapter;

    private ImageButton allCheckButton;
    private EditText editText;
    private ListView listView;
    private Button clearButton;
    private TextView itemLeftText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allCheckButton = findViewById(R.id.allCheckButton);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        clearButton = findViewById(R.id.clearButton);
        itemLeftText = findViewById(R.id.itemLeftText);

        list = new LinkedList<>();
        checkedList = new LinkedList<>();
        customAdapter = new CustomAdapter(this, R.layout.item, list);

        listView.setAdapter(customAdapter);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch(actionId) {
                    case EditorInfo.IME_ACTION_DONE:
                        if (!editText.getText().toString().equals("")) {
                            Item item = new Item(editText.getText().toString());

                            customAdapter.add(item);
                            renew();
                        }

                        editText.setText("");
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<Item> iterator = checkedList.iterator();

                while (iterator.hasNext()) {
                    customAdapter.remove(iterator.next());
                }

                checkedList.clear();
                renew();
            }
        });

        allCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean isAllChecked = false;
//                Iterator<Item> iterator = list.iterator();
//
//                if (list.size() == checkedList.size())
//                {
//                    isAllChecked = true;
//                }
//
//                Log.d("before : ", list.size() + ", " + checkedList.size() + ", " + isAllChecked);
//
//                while (iterator.hasNext()) {
//                    Item item = iterator.next();
//
//                    Log.d("before : ", item.getContent() + " : " + item.getCheckBox().isChecked());
//
//                    if (!isAllChecked) {
//                        if (!checkedList.contains(item)) {
//                            item.getCheckBox().setChecked(true);
//                        }
//                    } else {
//                        if (checkedList.contains(item)) {
//                            item.getCheckBox().setChecked(false);
//                        }
//                    }
//
//                    Log.d("after : ", item.getContent() + " : " + item.getCheckBox().isChecked());
//
//                }
//                Log.d("after : ", list.size() + ", " + checkedList.size() + ", " + isAllChecked);
//
//                renew();

            }
        });
    }

    public void renew() {
        if (list.size() > 0) {
            itemLeftText.setVisibility(View.VISIBLE);

            if ((list.size() - checkedList.size()) != 1) {
                itemLeftText.setText((list.size() - checkedList.size()) + " items left");
            } else {
                itemLeftText.setText((list.size() - checkedList.size()) + " item left");
            }
        } else {
            itemLeftText.setVisibility(View.INVISIBLE);
        }

        if (checkedList.size() > 0) {
            clearButton.setVisibility(View.VISIBLE);
        } else {
            clearButton.setVisibility(View.INVISIBLE);
        }
    }

    public List<Item> getCheckedList() {
        return checkedList;
    }
}
