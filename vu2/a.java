package vu2;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel.QAdVideoFunnelUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kt3.j;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private j f443536a;

    /* renamed from: b, reason: collision with root package name */
    private String f443537b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<ViewGroup> f443538c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Object> f443539d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Object> f443540e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private int f443541f;

    public a() {
    }

    @SuppressLint({"ThreadSafeCheck"})
    public void a(String str, Object obj) {
        this.f443540e.put(str, obj);
    }

    public int b() {
        return this.f443541f;
    }

    public Map<String, Object> c() {
        return this.f443540e;
    }

    public j d() {
        return this.f443536a;
    }

    public String e() {
        return this.f443537b;
    }

    public Map<String, Object> f() {
        ViewGroup viewGroup;
        WeakReference<ViewGroup> weakReference = this.f443538c;
        if (weakReference == null) {
            viewGroup = null;
        } else {
            viewGroup = weakReference.get();
        }
        Map<String, Object> j3 = QAdVideoFunnelUtil.j(viewGroup);
        if (!y.i(j3)) {
            this.f443539d = j3;
        }
        return this.f443539d;
    }

    public WeakReference<ViewGroup> g() {
        return this.f443538c;
    }

    public void h(j jVar) {
        this.f443536a = jVar;
    }

    public void i(String str) {
        this.f443537b = str;
    }

    public void j(Map<String, Object> map) {
        this.f443539d = map;
    }

    public void k(WeakReference<ViewGroup> weakReference) {
        this.f443538c = weakReference;
    }

    public a(int i3) {
        this.f443541f = i3;
    }
}
