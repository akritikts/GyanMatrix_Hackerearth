package in.silive.hackerearthgyanmatrix.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import in.silive.hackerearthgyanmatrix.R;
import in.silive.hackerearthgyanmatrix.adapters.BatsmenListAdapter;
import in.silive.hackerearthgyanmatrix.network.HttpHandler;
import in.silive.hackerearthgyanmatrix.utils.BatsmenList;
import in.silive.hackerearthgyanmatrix.utils.Config;

public class MainActivity extends AppCompatActivity {
    ListView batsmen_listview;
    ProgressDialog sprogressDialog;
    public static ArrayList<String> names_of_players = new ArrayList<>();
    public static ArrayList<String> desc_of_players = new ArrayList<>();
    public static ArrayList<String> img_of_players = new ArrayList<>();
    public static ArrayList<String> country_of_players = new ArrayList<>();
    public static ArrayList<Long> runs_of_players = new ArrayList<>();
    public static ArrayList<Integer> matches_of_players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "MainActivity created");
        batsmen_listview = (ListView)findViewById(R.id.lview);
        Log.d("TAG", "Listview initialized");


        Log.d("TAG", "adapter set");
        /*sprogressDialog = new ProgressDialog(this);
        sprogressDialog.setMessage("Loading");
        sprogressDialog.show();*/
        new FetchData(this).execute();
        //List<Batsmen > l = BatsmenList.getBatsmenList(this);
        Log.d("TAG","List of images : "+BatsmenList.img_of_players+"\n List of Players : "+BatsmenList.names_of_players);

        //sprogressDialog.dismiss();
    }
    public class FetchData extends AsyncTask<Void,Void,String> {
        public Context context;
        public URL H_url;
        public HttpURLConnection H_connection;
        public BufferedReader H_bufferedReader;
        public StringBuilder H_response;
        public ProgressDialog progressDialog;
        public String jsonStr;


        public FetchData(Context c) {
            context = c;
            this.progressDialog = new ProgressDialog(c);
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                H_url = new URL(Config.API_KEY);
                H_connection = (HttpURLConnection) H_url.openConnection();
                Log.d("TAG", "url : " + H_url);
                Log.d("TAG", "connection");
                H_connection.setRequestMethod("GET");
                H_connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                Log.d("TAG", "connection req property get");
                H_connection.connect();
                Log.d("TAG", "connection estb");
                H_bufferedReader = new BufferedReader(new InputStreamReader(H_connection.getInputStream()));
                Log.d("TAG", "buff readr");
                HttpHandler sh = new HttpHandler();
                jsonStr = sh.makeServiceCall(Config.API_KEY);
            } catch (Exception e) {
                Log.d("TAG", "NO connection");
                e.printStackTrace();
            }
            return jsonStr;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Fetching Data ");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s)

        {
            // super.onPostExecute(s);

            parsing_Batsmen(s);
            //notify data set changed;
            progressDialog.dismiss();
            Log.d("TAG", "dialog dismissed");
            batsmen_listview.setAdapter(new BatsmenListAdapter(getApplicationContext(), img_of_players, names_of_players));
            Log.d("TAG", "adapter applied");


        }

        public void parsing_Batsmen(String s) {
            try {
                Log.d("TAG", "try parsing");

                Log.d("TAG", "JSON data : "+s);
                //Log.d("TAG", "JSON obj created");
                /*JSONArray List_of_kings = King_object.getJSONArray();*/

                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONArray List_of_batsmen = jsonObject.getJSONArray("records");
                Log.d("TAG", "JSON array fetched : Length of array : "+List_of_batsmen.length()+" : "+List_of_batsmen);
                for (int i = 0; i < List_of_batsmen.length(); i++) {
                    Log.d("TAG", "for loop");
                    JSONObject batsm = List_of_batsmen.getJSONObject(i);
                    names_of_players.add(batsm.getString("name").toString());
                    desc_of_players.add(batsm.getString("description"));
                    country_of_players.add(batsm.getString("country"));
                    img_of_players.add(batsm.getString("image"));
                    matches_of_players.add(batsm.getInt("matches_played"));
                    runs_of_players.add(batsm.getLong("total_score"));
                    Log.d("TAG", "Item added");

                }
                Log.d("TAG", "Item added");
                //BatsmenList batsmen = new BatsmenList(country_of_players,desc_of_players,img_of_players,matches_of_players,names_of_players,runs_of_players);

            }

            catch (Exception e) {
                Log.d("TAG", "Printing stack trace : "+"\n\n");
                e.printStackTrace();
                Log.d("TAG", "Parsing not working");
            }

        }
    }

}
