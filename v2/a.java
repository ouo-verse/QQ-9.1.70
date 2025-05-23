package v2;

import android.os.RemoteException;
import android.util.Log;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f440771c = "ApiLevelManager";

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f440772d;

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f440773e;

    /* renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Integer> f440774f;

    /* renamed from: a, reason: collision with root package name */
    public int f440775a = -1;

    /* renamed from: b, reason: collision with root package name */
    public w1.b f440776b;

    static {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        f440773e = concurrentHashMap;
        ConcurrentHashMap<Integer, Integer> concurrentHashMap2 = new ConcurrentHashMap<>();
        f440774f = concurrentHashMap2;
        concurrentHashMap.put("insertData", 1);
        concurrentHashMap.put("deleteData", 1);
        concurrentHashMap.put("updateData", 1);
        concurrentHashMap.put("queryData", 1);
        concurrentHashMap.put("getCount", 1);
        concurrentHashMap.put("clearData", 1);
        concurrentHashMap.put("registerRealTimeListener", 1);
        concurrentHashMap.put("unregisterRealTimeListener", 1);
        concurrentHashMap.put("subscribe", 1);
        concurrentHashMap.put("unsubscribe", 1);
        concurrentHashMap2.put(6, 1);
        concurrentHashMap2.put(7, 1);
        concurrentHashMap2.put(8, 1);
        concurrentHashMap2.put(9, 1);
        concurrentHashMap2.put(11, 1);
        concurrentHashMap2.put(4, 1);
        concurrentHashMap2.put(5, 1);
        concurrentHashMap2.put(10, 1);
        concurrentHashMap2.put(14, 1);
        concurrentHashMap2.put(15, 1);
        concurrentHashMap2.put(16, 1);
        concurrentHashMap2.put(17, 1);
        concurrentHashMap2.put(202, 1);
        concurrentHashMap2.put(203, 1);
        concurrentHashMap2.put(204, 1);
        concurrentHashMap2.put(205, 1);
        concurrentHashMap2.put(206, 1);
        concurrentHashMap2.put(207, 1);
        concurrentHashMap2.put(208, 1);
        concurrentHashMap2.put(209, 1);
        concurrentHashMap2.put(210, 1);
        concurrentHashMap2.put(211, 1);
        concurrentHashMap2.put(3, 1);
        concurrentHashMap2.put(18, 1);
        concurrentHashMap2.put(19, 1);
        concurrentHashMap2.put(402, 1);
        concurrentHashMap2.put(Integer.valueOf(PlayerResources.ViewId.TITLE_BAR), 1);
        concurrentHashMap2.put(552, 1);
        concurrentHashMap2.put(Integer.valueOf(PlayerResources.ViewId.LOADING), 1);
        concurrentHashMap2.put(Integer.valueOf(PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON), 1);
        concurrentHashMap2.put(Integer.valueOf(PlayerResources.ViewId.PLAYER_DURATION), 1);
        concurrentHashMap2.put(502, 1);
        concurrentHashMap2.put(503, 1);
        concurrentHashMap2.put(501, 1);
        concurrentHashMap2.put(13, 1);
        concurrentHashMap2.put(21, 1);
        concurrentHashMap2.put(23, 1);
        concurrentHashMap2.put(26, 1);
        concurrentHashMap2.put(10001, 1);
        concurrentHashMap2.put(10002, 1);
    }

    public a() {
        a();
    }

    public static a d() {
        if (f440772d == null) {
            synchronized (a.class) {
                if (f440772d == null) {
                    f440772d = new a();
                }
            }
        }
        return f440772d;
    }

    public final int a() {
        int intValue = ((Integer) Collections.max(new ArrayList(f440773e.values()))).intValue();
        if (intValue < 1) {
            return 1;
        }
        return intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(w1.b bVar) {
        String a16;
        int parseInt;
        this.f440776b = bVar;
        if (bVar != null) {
            try {
                a16 = bVar.a();
            } catch (RemoteException | NumberFormatException unused) {
                Log.e(f440771c, "get serverVersionCode failed version");
            }
            if (a16 != null) {
                parseInt = Integer.parseInt(a16);
                this.f440775a = parseInt;
                if (this.f440776b != null) {
                    Log.w(f440771c, "null health data service");
                    return;
                }
                return;
            }
        }
        parseInt = -1;
        this.f440775a = parseInt;
        if (this.f440776b != null) {
        }
    }

    public boolean c(String str, int i3) {
        if (str != null) {
            ConcurrentHashMap<String, Integer> concurrentHashMap = f440773e;
            if (concurrentHashMap.get(str) != null) {
                ConcurrentHashMap<Integer, Integer> concurrentHashMap2 = f440774f;
                if (concurrentHashMap2.get(Integer.valueOf(i3)) != null) {
                    if (this.f440775a >= concurrentHashMap.get(str).intValue() && this.f440775a >= concurrentHashMap2.get(Integer.valueOf(i3)).intValue()) {
                        return true;
                    }
                    Log.e(f440771c, "isSupported failed as health version is low");
                    return false;
                }
            }
        }
        Log.e(f440771c, "isSupported failed as apiName is null");
        return false;
    }
}
