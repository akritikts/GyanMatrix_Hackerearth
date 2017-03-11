package in.silive.hackerearthgyanmatrix.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import in.silive.hackerearthgyanmatrix.R;
import in.silive.hackerearthgyanmatrix.adapters.BatsmenListAdapter;
import in.silive.hackerearthgyanmatrix.network.FetchData;

public class MainActivity extends AppCompatActivity {
    ListView batsmen_listview;
    public String list_names[];
    public Integer list_images[];
    ProgressDialog sprogressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batsmen_listview = (ListView)findViewById(R.id.lview);
        batsmen_listview.setAdapter(new BatsmenListAdapter(getApplicationContext(),list_images,list_names));
        sprogressDialog = new ProgressDialog(this);
        sprogressDialog.setMessage("Loading");
        sprogressDialog.show();
        new FetchData(this).execute();
        sprogressDialog.dismiss();
    }
}
