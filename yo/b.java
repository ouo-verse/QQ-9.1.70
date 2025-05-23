package yo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.qzone.misc.network.report.ClickReport;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f450699a = 63;

    /* renamed from: b, reason: collision with root package name */
    public static int f450700b = 66;

    /* renamed from: c, reason: collision with root package name */
    public static int f450701c = 82;

    /* renamed from: d, reason: collision with root package name */
    public static int f450702d = 85;

    /* renamed from: e, reason: collision with root package name */
    public static int f450703e = 91;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(Context context, g gVar) {
        return gVar.k(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Context context, Uri uri, Map<Integer, Map<String, String>> map) {
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setPackage("com.qzone");
        a(intent);
        context.startActivity(intent);
        d(true, map);
    }

    public static boolean g(Context context, int i3) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Context context) {
        return g(context, f450699a);
    }

    public static final void a(Intent intent) {
        if (intent != null) {
            intent.putExtra("big_brother_source_key", "biz_src_jc_qzone");
        }
    }

    public static final void b(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("big_brother_source_key", "biz_src_jc_qzone");
        }
    }

    static void d(boolean z16, Map<Integer, Map<String, String>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        ClickReport.f(0, map.get(Integer.valueOf(z16 ? 1 : 2)));
    }

    public static void e(Context context) {
    }
}
