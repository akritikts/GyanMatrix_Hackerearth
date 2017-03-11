package in.silive.hackerearthgyanmatrix.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import in.silive.hackerearthgyanmatrix.R;

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
    public String list_names[];
    public Integer list_images[];

    public BatsmenListAdapter(Context context, LayoutInflater inflater, Integer[] list_images, String[] list_names) {
        this.context = context;
        this.inflater = inflater;
        this.list_images = list_images;
        this.list_names = list_names;
    }

    @Override
    public int getCount() {
        return 0;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.batsmen_list_adapter,null);
        Holder holder = new Holder();
        holder.player_img = (ImageView)view.findViewById(R.id.player_img);
        holder.player_name = (TextView)view.findViewById(R.id.player_name);
        holder.player_fav = (CheckBox)view.findViewById(R.id.player_fav);
        holder.player_img.setImageResource(list_images[i]);
        holder.player_name.setText(list_names[i]);
        return view;
    }
}
