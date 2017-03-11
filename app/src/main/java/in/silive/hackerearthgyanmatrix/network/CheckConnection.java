package in.silive.hackerearthgyanmatrix.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by akriti on 11/3/17.
 */

public class CheckConnection {
    public Context context;

    public CheckConnection(Context context) {
        this.context = context;
    }

    public boolean check_connection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info == null) {
            return false;
        } else {
            return true;
        }


    }

}
