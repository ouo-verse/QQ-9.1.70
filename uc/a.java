package uc;

import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private QZoneBlankStateView.a f438776a;

    /* renamed from: b, reason: collision with root package name */
    private QZoneBlankStateView.a f438777b;

    public QZoneBlankStateView.a a() {
        return this.f438776a;
    }

    public QZoneBlankStateView.a b() {
        return this.f438777b;
    }

    public a c(QZoneBlankStateView.a aVar) {
        this.f438776a = aVar;
        return this;
    }

    public a d(QUIEmptyState.Builder builder) {
        if (this.f438776a == null) {
            this.f438776a = new QZoneBlankStateView.a();
        }
        this.f438776a.b(builder);
        return this;
    }

    public a e(QZoneBlankStateView.a aVar) {
        this.f438777b = aVar;
        return this;
    }

    public a f(QUIEmptyState.Builder builder) {
        if (this.f438777b == null) {
            this.f438777b = new QZoneBlankStateView.a();
        }
        this.f438777b.b(builder);
        return this;
    }
}
