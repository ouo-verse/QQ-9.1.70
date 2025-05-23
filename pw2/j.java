package pw2;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f427755a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f427756b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f427757c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f427758d = "";

    /* renamed from: e, reason: collision with root package name */
    private static volatile String f427759e = "";

    /* renamed from: f, reason: collision with root package name */
    private static volatile String f427760f = "";

    @NonNull
    public static String a() {
        if (!TextUtils.isEmpty(f427759e)) {
            return f427759e;
        }
        synchronized (f427756b) {
            if (!TextUtils.isEmpty(f427759e)) {
                return f427759e;
            }
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                f427759e = str;
            }
            return f427759e;
        }
    }

    @NonNull
    public static String b() {
        if (!TextUtils.isEmpty(f427758d)) {
            return f427758d;
        }
        synchronized (f427755a) {
            if (!TextUtils.isEmpty(f427758d)) {
                return f427758d;
            }
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                f427758d = str;
            }
            return f427758d;
        }
    }

    @NonNull
    public static String c() {
        if (!TextUtils.isEmpty(f427760f)) {
            return f427760f;
        }
        synchronized (f427757c) {
            if (!TextUtils.isEmpty(f427760f)) {
                return f427760f;
            }
            String model = DeviceInfoMonitor.getModel();
            if (!TextUtils.isEmpty(model)) {
                f427760f = model;
            }
            return f427760f;
        }
    }
}
