package pw2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdMarketDownloadVRReport;
import java.util.HashMap;
import pw2.l;

/* compiled from: P */
/* loaded from: classes19.dex */
public class o implements l.c {

    /* renamed from: a, reason: collision with root package name */
    final HashMap<String, Pair<String, Integer>> f427774a;

    /* renamed from: b, reason: collision with root package name */
    final Object f427775b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static o f427776a = new o();
    }

    @NonNull
    public static o d() {
        return b.f427776a;
    }

    @Nullable
    private Pair<String, Integer> e(@NonNull String str) {
        Pair<String, Integer> pair;
        synchronized (this.f427775b) {
            pair = this.f427774a.get(str);
        }
        return pair;
    }

    private void f(@NonNull String str, @NonNull Pair<String, Integer> pair) {
        synchronized (this.f427775b) {
            this.f427774a.put(str, pair);
        }
    }

    private void g(@NonNull String str) {
        synchronized (this.f427775b) {
            this.f427774a.remove(str);
        }
    }

    @Override // pw2.l.c
    public void a(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str) && this.f427774a.containsKey(str)) {
            Pair<String, Integer> e16 = e(str);
            if (e16 != null && e16.first != null && (num = e16.second) != null) {
                if (num.intValue() != 0 && e16.second.intValue() != 1) {
                    g(str);
                    return;
                } else {
                    QAdMarketDownloadVRReport.b(e16.first, e16.second.intValue());
                    g(str);
                    return;
                }
            }
            g(str);
        }
    }

    public void c(@Nullable String str, @Nullable String str2, int i3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (i3 != 0 && i3 != 1) {
                return;
            }
            f(str, new Pair<>(str2, Integer.valueOf(i3)));
        }
    }

    o() {
        this.f427774a = new HashMap<>();
        this.f427775b = new Object();
        l.c().f(this);
    }

    @Override // pw2.l.c
    public void b(String str) {
    }
}
