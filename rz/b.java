package rz;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class b implements a {

    /* renamed from: d, reason: collision with root package name */
    protected Activity f432974d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewStub f432975e;

    /* renamed from: f, reason: collision with root package name */
    protected View f432976f;

    public b(Activity activity, ViewStub viewStub) {
        this.f432974d = activity;
        this.f432975e = viewStub;
    }

    private void r(ViewStub viewStub) {
        viewStub.setLayoutResource(q());
        if (this.f432976f == null) {
            this.f432976f = viewStub.inflate();
        }
    }

    @Override // rz.a
    public void j() {
        r(this.f432975e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View m(int i3) {
        View view = this.f432976f;
        if (view != null) {
            return view.findViewById(i3);
        }
        return null;
    }

    public Context o() {
        return this.f432974d.getBaseContext();
    }

    protected abstract int q();

    @Override // rz.a
    public void e() {
    }

    @Override // rz.a
    public void h() {
    }

    @Override // rz.a
    public void k() {
    }

    @Override // rz.a
    public void onPageDestroy() {
    }

    @Override // rz.a
    public void onPagePause() {
    }
}
