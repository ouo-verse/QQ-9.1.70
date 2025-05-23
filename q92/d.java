package q92;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static d f428743b = new d();

    /* renamed from: c, reason: collision with root package name */
    static boolean f428744c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f428745a;

    public static boolean a(String str, boolean z16) {
        try {
            return f428743b.f428745a.getBoolean(str, z16);
        } catch (ClassCastException unused) {
            return z16;
        }
    }

    public static float b(String str, float f16) {
        try {
            return f428743b.f428745a.getFloat(str, f16);
        } catch (ClassCastException unused) {
            return f16;
        }
    }

    public static int c(String str, int i3) {
        try {
            return f428743b.f428745a.getInt(str, i3);
        } catch (ClassCastException unused) {
            return i3;
        }
    }

    public static long d(String str, long j3) {
        try {
            return f428743b.f428745a.getLong(str, j3);
        } catch (ClassCastException unused) {
            return j3;
        }
    }

    public static String e(String str, String str2) {
        try {
            return f428743b.f428745a.getString(str, str2);
        } catch (ClassCastException unused) {
            return str2;
        }
    }

    public static void f(Context context, String str) {
        f428743b.f428745a = SharedPreferencesProxyManager.getInstance().getProxy(str, 0);
        f428744c = true;
    }

    public static void g(String str, boolean z16) {
        SharedPreferences.Editor edit = f428743b.f428745a.edit();
        edit.putBoolean(str, z16);
        edit.commit();
    }

    public static void h(String str, float f16) {
        SharedPreferences.Editor edit = f428743b.f428745a.edit();
        edit.putFloat(str, f16);
        edit.commit();
    }

    public static void i(String str, int i3) {
        SharedPreferences.Editor edit = f428743b.f428745a.edit();
        edit.putInt(str, i3);
        edit.commit();
    }

    public static void j(String str, long j3) {
        SharedPreferences.Editor edit = f428743b.f428745a.edit();
        edit.putLong(str, j3);
        edit.commit();
    }

    public static void k(String str, String str2) {
        SharedPreferences.Editor edit = f428743b.f428745a.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static void l(String str) {
        synchronized (f428743b) {
            SharedPreferences.Editor edit = f428743b.f428745a.edit();
            edit.remove(str);
            edit.commit();
        }
    }
}
