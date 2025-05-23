package uq3;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static volatile l f439814a;

    /* renamed from: b, reason: collision with root package name */
    private static Set<Long> f439815b;

    l() {
        String[] split = c().split(",");
        f439815b = new HashSet(split.length);
        for (String str : split) {
            try {
                f439815b.add(Long.valueOf(Long.parseLong(str)));
            } catch (Exception unused) {
                RFWLog.w("QFSServerShowToastErrorCodeManager", RFWLog.USR, "parseLong error, str=" + str);
            }
        }
    }

    public static l b() {
        if (f439814a == null) {
            synchronized (l.class) {
                if (f439814a == null) {
                    f439814a = new l();
                }
            }
        }
        return f439814a;
    }

    private static String c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105459", "-1,-100001,-100002,1410015,10015,10055,110024,110045,40301,40302,10063,10066,10067,10014");
    }

    public boolean a(long j3) {
        return f439815b.contains(Long.valueOf(j3));
    }
}
