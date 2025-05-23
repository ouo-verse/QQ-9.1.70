package pw2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f427747a = "AdCoreSystemUtil";

    public static boolean a() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) qv2.b.a().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            n.d(f427747a, e16, "isNetworkAvailable");
            return false;
        }
    }
}
