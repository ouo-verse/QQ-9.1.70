package tw2;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b implements a {

    /* renamed from: g, reason: collision with root package name */
    protected static final AtomicInteger f437864g = new AtomicInteger();

    /* renamed from: a, reason: collision with root package name */
    protected Context f437865a;

    /* renamed from: b, reason: collision with root package name */
    protected AdFeedInfo f437866b;

    /* renamed from: d, reason: collision with root package name */
    protected View f437868d;

    /* renamed from: c, reason: collision with root package name */
    protected final QAdCardExtraData f437867c = new QAdCardExtraData();

    /* renamed from: f, reason: collision with root package name */
    protected vw2.a f437870f = j();

    /* renamed from: e, reason: collision with root package name */
    protected int f437869e = f437864g.getAndIncrement();

    public b(Context context) {
        this.f437865a = context;
    }

    @Override // tw2.a
    public void a(xw2.a aVar) {
        if (this.f437870f.e() == null) {
            return;
        }
        this.f437870f.e().a(aVar);
    }

    @Override // ww2.c
    public void b() {
        if (this.f437870f.f() == null) {
            return;
        }
        this.f437870f.f().k().b();
    }

    @Override // ww2.c
    public void c() {
        if (this.f437870f.f() == null) {
            return;
        }
        this.f437870f.f().k().c();
    }

    @Override // tw2.a
    @CallSuper
    public void e(QAdCardExtraData qAdCardExtraData) {
        this.f437867c.c(qAdCardExtraData);
    }

    @Override // tw2.a
    @CallSuper
    public void g(AdFeedInfo adFeedInfo) {
        this.f437866b = adFeedInfo;
    }

    @Override // ww2.c
    public void i(boolean z16) {
        if (this.f437870f.f() == null) {
            return;
        }
        this.f437870f.f().k().i(z16);
    }

    @NonNull
    protected abstract vw2.a j();

    public xw2.a k() {
        if (this.f437870f.e() == null) {
            return null;
        }
        return this.f437870f.e().getPlayer();
    }
}
