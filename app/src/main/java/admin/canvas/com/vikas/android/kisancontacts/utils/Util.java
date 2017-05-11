package admin.canvas.com.vikas.android.kisancontacts.utils;

import android.util.Log;

/**
 * Created by OFFICE on 5/10/2017.
 */

public class Util {

    public static String filterPhoneNumber(String phoneNo) {
        StringBuilder stringBuilder = new StringBuilder("+");
        stringBuilder.append(phoneNo.replace("(", "").replace(")","").replace(" ", "").replace("-", ""));
        return stringBuilder.toString();
    }
}
