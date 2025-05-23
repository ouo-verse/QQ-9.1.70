package xv;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import vv.c;
import vv.d;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f448732a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f448733b = ProxyExecutors.newSingleThreadExecutor();

    /* renamed from: c, reason: collision with root package name */
    private static int f448734c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static int f448735d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f448736e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f448737f = false;

    /* renamed from: g, reason: collision with root package name */
    public static volatile boolean f448738g = false;

    /* renamed from: h, reason: collision with root package name */
    public static volatile boolean f448739h = false;

    private static Map<String, String> a(SessionInfo sessionInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", d.a(sessionInfo));
        return hashMap;
    }

    private static Map<String, String> b(VideoAppInterface videoAppInterface, SessionInfo sessionInfo) {
        HashMap hashMap = new HashMap();
        if (videoAppInterface.Y(2)) {
            if (((EffectPendantTools) videoAppInterface.B(2)).u() != null) {
                hashMap.put("open_widgets", String.valueOf(1));
            } else {
                hashMap.put("open_widgets", String.valueOf(0));
            }
        } else {
            hashMap.put("open_widgets", String.valueOf(0));
        }
        if (videoAppInterface.Y(1)) {
            fu.a aVar = (fu.a) videoAppInterface.B(1);
            if (aVar.u() != null && aVar.u().getFiltertype() != 0) {
                hashMap.put("open_filter", String.valueOf(1));
            } else {
                hashMap.put("open_filter", String.valueOf(0));
            }
        } else {
            hashMap.put("open_filter", String.valueOf(0));
        }
        hashMap.put("open_virtual_avatar", String.valueOf(0));
        return hashMap;
    }

    private static boolean c() {
        if (!f448739h || f448736e != 0) {
            return true;
        }
        return false;
    }

    private static boolean d() {
        if (!f448738g || f448734c != 0) {
            return true;
        }
        return false;
    }

    private static boolean e() {
        if (!f448737f || f448735d != 0) {
            return true;
        }
        return false;
    }

    public static void f(Runnable runnable) {
        f448733b.execute(runnable);
    }

    public static void g(int i3, int i16, Map<String, String> map) {
        j(i3, i16);
        if (map != null && map.size() > 0) {
            f448732a.putAll(map);
        }
        if (e() && d() && c()) {
            HashMap<String, String> hashMap = f448732a;
            if (hashMap.size() <= 0) {
                i();
                c.a("Empty Data , No-Report");
                return;
            }
            for (String str : hashMap.keySet()) {
                c.a("market-key:" + str + ", market-value:" + f448732a.get(str));
            }
            c.a("----- ----- ----- -----");
            QQBeaconReport.reportWithAppKey("0AND0U1I7C4PAMM0", "", "market_data", true, f448732a, true);
            i();
        }
    }

    public static void h(VideoAppInterface videoAppInterface, SessionInfo sessionInfo, Map<String, String> map) {
        map.putAll(a(sessionInfo));
        map.putAll(b(videoAppInterface, sessionInfo));
        for (String str : map.keySet()) {
            c.a("sample-key:" + str + ", sample-value:" + map.get(str));
        }
        c.a("----- ----- ----- -----");
        QQBeaconReport.reportWithAppKey("0AND0U1I7C4PAMM0", "", "sample_data", true, map, true);
    }

    private static void i() {
        f448732a.clear();
        f448737f = false;
        f448738g = false;
        f448739h = false;
        f448735d = 0;
        f448734c = 0;
        f448736e = 0;
    }

    private static void j(int i3, int i16) {
        if (i3 != 17) {
            if (i3 != 34) {
                if (i3 == 51) {
                    f448736e = i16;
                    return;
                }
                return;
            }
            f448735d = i16;
            return;
        }
        f448734c = i16;
    }
}
