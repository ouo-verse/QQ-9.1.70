package z43;

import android.content.Context;
import android.widget.Scroller;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends Scroller {

    /* renamed from: a, reason: collision with root package name */
    private int f451886a;

    public a(Context context) {
        super(context, new b());
        this.f451886a = 150;
    }

    public void a(int i3) {
        this.f451886a = i3;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        super.startScroll(i3, i16, i17, i18, this.f451886a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i3, int i16, int i17, int i18) {
        super.startScroll(i3, i16, i17, i18, this.f451886a);
    }
}
