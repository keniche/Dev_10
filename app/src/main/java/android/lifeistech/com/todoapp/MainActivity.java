package android.lifeistech.com.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);
        //TODO:この引数の意味
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
                String item = (String)adapter.getItem(position);
                adapter.remove(item);
                adapter.add(item);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
                String item = (String)adapter.getItem(position);
                adapter.remove(item);

                Toast.makeText(getApplicationContext(), item + "を削除しました", Toast.LENGTH_SHORT).show();
                    //TODO:なぜ、thisでは無理？
                return false;
            }
        });
    }

    public void add(View v) {
        String text;
        text = editText.getText().toString();
        Toast.makeText(this, text + "を追加しました", Toast.LENGTH_SHORT).show();

        adapter.add(text);

        //この辺で、textかeditTextを初期化したいor "" で更新したい
        //text = "1"; とかがなんでダメ？
    }
}

//TODO:全体的にもっと見直す必要あり
//TODO: