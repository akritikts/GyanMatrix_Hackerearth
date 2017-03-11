package in.silive.hackerearthgyanmatrix.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import in.silive.hackerearthgyanmatrix.R;
import in.silive.hackerearthgyanmatrix.utils.Batsmen;

/**
 * Created by akriti on 11/3/17.
 */

public class BatsmenListAdapter extends BaseAdapter {
    public class Holder{
        ImageView player_img;
        TextView player_name;
        CheckBox player_fav;
    }
    Context context;
    LayoutInflater inflater;
    public ArrayList<String> list_names;
    public ArrayList<String> list_images;
    List<Batsmen> batsmenList;

    public BatsmenListAdapter(Context context, ArrayList<String> list_images, ArrayList<String> list_names) {
        this.context = context;
        this.list_images = list_images;
        this.list_names = list_names;
    }
    public BatsmenListAdapter(List<Batsmen> l){
        this.batsmenList = l;
    }

    @Override
    public int getCount() {
        return list_names.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int j, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.batsmen_list_adapter,null);
        Holder holder = new Holder();
        holder.player_img = (ImageView)view.findViewById(R.id.player_img);
        holder.player_name = (TextView)view.findViewById(R.id.player_name);
        holder.player_fav = (CheckBox)view.findViewById(R.id.player_fav);
        for(int i=0;i<batsmenList.size();i++){
            /*holder.player_img.setImageBitmap(getBitmapFromURL(list_images.get(i)));*/
            holder.player_img.setImageResource(R.drawable.bat);
            holder.player_name.setText(list_names.get(i));
        }

        return view;
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }
}
