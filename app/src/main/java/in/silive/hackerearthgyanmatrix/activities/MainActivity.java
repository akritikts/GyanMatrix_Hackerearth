package in.silive.hackerearthgyanmatrix.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import in.silive.hackerearthgyanmatrix.R;
import in.silive.hackerearthgyanmatrix.adapters.BatsmenListAdapter;
import in.silive.hackerearthgyanmatrix.network.FetchData;
import in.silive.hackerearthgyanmatrix.utils.Batsmen;
import in.silive.hackerearthgyanmatrix.utils.BatsmenList;

public class MainActivity extends AppCompatActivity {
    ListView batsmen_listview;
    ProgressDialog sprogressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "MainActivity created");
        batsmen_listview = (ListView)findViewById(R.id.lview);
        Log.d("TAG", "Listview initialized");


        Log.d("TAG", "adapter set");
        sprogressDialog = new ProgressDialog(this);
        sprogressDialog.setMessage("Loading");
        sprogressDialog.show();
        new FetchData(this).execute();
        List<Batsmen > l = BatsmenList.getBatsmenList(this);
        Log.d("TAG","List of images : "+BatsmenList.img_of_players+"\n List of Players : "+BatsmenList.names_of_players);
        batsmen_listview.setAdapter(new BatsmenListAdapter(getApplicationContext(), BatsmenList.img_of_players, BatsmenList.names_of_players));
        sprogressDialog.dismiss();
    }
}
