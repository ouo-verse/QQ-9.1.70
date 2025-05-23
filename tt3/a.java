package tt3;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.superplayer.tools.utils.d;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.ModuleUpdateInterface;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thumbplayer.api.common.ITPModuleLoader;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, String> f437460a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f437461b = "";

    /* renamed from: c, reason: collision with root package name */
    private static Context f437462c;

    /* renamed from: d, reason: collision with root package name */
    private static String f437463d;

    /* renamed from: e, reason: collision with root package name */
    private static ITPModuleLoader f437464e;

    /* renamed from: f, reason: collision with root package name */
    private static int f437465f;

    /* renamed from: g, reason: collision with root package name */
    private static SparseArray<com.tencent.qqlive.superplayer.vinfo.a> f437466g;

    /* renamed from: h, reason: collision with root package name */
    private static String f437467h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: tt3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C11309a implements BeaconInterface {
        C11309a() {
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface
        public String getQIMEI() {
            return a.f437463d;
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface
        public Properties getRequiredReportValue() {
            return null;
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface
        public boolean trackCustomKVEvent(String str, Map<String, String> map) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements ModuleUpdateInterface {
        b() {
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.ckey.ModuleUpdateInterface
        public boolean loadLibrary(String str) {
            if (a.f437464e != null) {
                try {
                    a.f437464e.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
        int d(String str, String str2);

        int e(String str, String str2);

        int i(String str, String str2);

        int v(String str, String str2);

        int w(String str, String str2);
    }

    public static Context c() {
        return f437462c;
    }

    public static String d() {
        return "1.0.0";
    }

    public static String e() {
        if (!TextUtils.isEmpty(f437467h)) {
            return f437467h;
        }
        String str = f437463d;
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
                StringBuilder sb5 = new StringBuilder();
                for (byte b16 : digest) {
                    String hexString = Integer.toHexString(b16 & 255);
                    if (hexString.length() == 1) {
                        hexString = '0' + hexString;
                    }
                    sb5.append(hexString.toUpperCase());
                }
                f437467h = sb5.toString();
            } catch (Throwable th5) {
                d.a("TVideoMgr", "init:" + th5.toString());
            }
        }
        if (TextUtils.isEmpty(f437467h)) {
            f437467h = "wtfguidisemptyhehehe";
        }
        return f437467h;
    }

    public static int f() {
        return f437465f;
    }

    public static String g() {
        return h(f437465f);
    }

    public static String h(int i3) {
        SparseArray<com.tencent.qqlive.superplayer.vinfo.a> sparseArray = f437466g;
        if (sparseArray != null && sparseArray.indexOfKey(i3) >= 0) {
            return f437466g.get(i3).c();
        }
        return null;
    }

    public static void i(Context context, int i3, String str) {
        f437462c = context.getApplicationContext();
        f437465f = i3;
        f437463d = str;
        CKeyFacade.setInterface("", "", new C11309a(), new b());
        CKeyFacade.instance().init(f437462c, null, e());
    }

    public static boolean j(com.tencent.qqlive.superplayer.vinfo.a aVar) {
        boolean z16 = false;
        if (aVar == null) {
            return false;
        }
        if (f437466g == null) {
            f437466g = new SparseArray<>();
        }
        if (f437466g.indexOfKey(aVar.b()) < 0 && (z16 = CKeyFacade.instance().addVsAppkey(f437462c, aVar.a()))) {
            f437466g.put(aVar.b(), aVar);
        }
        return z16;
    }

    public static void k(ITPModuleLoader iTPModuleLoader) {
        f437464e = iTPModuleLoader;
    }

    public static void l(c cVar) {
        d.g(cVar);
    }

    public static void m(int i3, boolean z16, int i16) {
        com.tencent.qqlive.superplayer.tools.utils.b.i(i3, z16, i16);
    }
}
