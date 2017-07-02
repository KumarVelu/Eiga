package vale.velu.com.eiga.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by kumar_velu on 04-01-2017.
 */
public class Utils {

    public static boolean isInternetOn(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    @SuppressLint("SimpleDateFormat")
    public static String formatReleaseDate(String date) {

        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat releaseDateFormat = new SimpleDateFormat("MMM dd, yyyy");

        String formattedStr = "";
        try {
            formattedStr = releaseDateFormat.format(fromUser.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formattedStr;
    }
}
