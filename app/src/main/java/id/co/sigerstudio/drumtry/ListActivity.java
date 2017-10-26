package id.co.sigerstudio.drumtry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Intent intent;
    String[] listAlatMusik = {"Gamelan", "Gong", "Rebana", "Try This Only"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.list_item1);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listAlatMusik);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("soundA", R.raw.crash);
                intent.putExtra("soundB", R.raw.crash);
                intent.putExtra("soundC", R.raw.crash);
                intent.putExtra("soundD", R.raw.crash);
                intent.putExtra("soundE", R.raw.crash);
                intent.putExtra("soundF", R.raw.crash);
                intent.putExtra("soundG", R.raw.crash);
                intent.putExtra("soundH", R.raw.crash);
                intent.putExtra("soundI", R.raw.crash);
                intent.putExtra("soundJ", R.raw.crash);
                intent.putExtra("soundK", R.raw.crash);
                intent.putExtra("soundL", R.raw.crash);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("soundA", R.raw.destroy);
                intent.putExtra("soundB", R.raw.destroy);
                intent.putExtra("soundC", R.raw.destroy);
                intent.putExtra("soundD", R.raw.destroy);
                intent.putExtra("soundE", R.raw.destroy);
                intent.putExtra("soundF", R.raw.destroy);
                intent.putExtra("soundG", R.raw.destroy);
                intent.putExtra("soundH", R.raw.destroy);
                intent.putExtra("soundI", R.raw.destroy);
                intent.putExtra("soundJ", R.raw.destroy);
                intent.putExtra("soundK", R.raw.destroy);
                intent.putExtra("soundL", R.raw.destroy);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("soundA", R.raw.snare);
                intent.putExtra("soundB", R.raw.snare);
                intent.putExtra("soundC", R.raw.snare);
                intent.putExtra("soundD", R.raw.snare);
                intent.putExtra("soundE", R.raw.snare);
                intent.putExtra("soundF", R.raw.snare);
                intent.putExtra("soundG", R.raw.snare);
                intent.putExtra("soundH", R.raw.snare);
                intent.putExtra("soundI", R.raw.snare);
                intent.putExtra("soundJ", R.raw.snare);
                intent.putExtra("soundK", R.raw.snare);
                intent.putExtra("soundL", R.raw.snare);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("soundA", R.raw.destroy);
                intent.putExtra("soundB", R.raw.gun);
                intent.putExtra("soundC", R.raw.snare);
                intent.putExtra("soundD", R.raw.gun);
                intent.putExtra("soundE", R.raw.hihat);
                intent.putExtra("soundF", R.raw.kick);
                intent.putExtra("soundG", R.raw.ride);
                intent.putExtra("soundH", R.raw.snare);
                intent.putExtra("soundI", R.raw.ride);
                intent.putExtra("soundJ", R.raw.tom1);
                intent.putExtra("soundK", R.raw.tom2);
                intent.putExtra("soundL", R.raw.tom3);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
