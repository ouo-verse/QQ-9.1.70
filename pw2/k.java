package pw2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static String f427761a = "QAdClickEffectReporterHelper";

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, ArrayList<ew2.e>> f427762b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static volatile k f427763c;

    public static k a() {
        if (f427763c == null) {
            synchronized (k.class) {
                if (f427763c == null) {
                    f427763c = new k();
                }
            }
        }
        return f427763c;
    }

    public synchronized void b(String str, int i3) {
        if (f427762b.containsKey(Integer.valueOf(i3))) {
            Iterator<ew2.e> it = f427762b.get(Integer.valueOf(i3)).iterator();
            while (it.hasNext()) {
                ew2.e next = it.next();
                n.e(f427761a, "reportDelayEffect \u5ef6\u8fdf\u4e0a\u62a5\u4e00\u6b21 clickId=" + str + ", localClickId=" + i3);
                next.K(str);
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e.c(next, false, null);
            }
            f427762b.remove(Integer.valueOf(i3));
        } else {
            n.e(f427761a, "reportDelayEffect \u6ca1\u6709\u5ef6\u8fdf\u7684\u6548\u679c\u4e0a\u62a5");
        }
    }

    public synchronized void c(ew2.e eVar, int i3) {
        if (eVar != null) {
            if (TextUtils.isEmpty(eVar.I())) {
                if (f427762b.containsKey(Integer.valueOf(i3))) {
                    f427762b.get(Integer.valueOf(i3)).add(eVar);
                } else {
                    ArrayList<ew2.e> arrayList = new ArrayList<>();
                    arrayList.add(eVar);
                    f427762b.put(Integer.valueOf(i3), arrayList);
                }
                n.e(f427761a, "reportEffect \u672a\u53d6\u5f97clickID\u9700\u8981\u5ef6\u8fdf\u4e0a\u62a5 localClickId=" + i3);
            } else {
                n.e(f427761a, "reportEffect \u5df2\u53d6\u5f97clickID\u65e0\u9700\u5ef6\u8fdf\u4e0a\u62a5 clickID=" + eVar.I());
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e.c(eVar, false, null);
            }
        }
    }
}
