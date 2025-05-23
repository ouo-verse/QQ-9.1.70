package t33;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import s33.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements s33.a {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f435358a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable.Callback f435359b;

    public a(Drawable drawable) {
        this.f435358a = drawable;
    }

    private void d(boolean z16) {
        Drawable drawable = this.f435358a;
        if (drawable instanceof ApngDrawable) {
            if (z16) {
                ((ApngDrawable) drawable).resume();
            } else {
                ((ApngDrawable) drawable).pause();
            }
        }
    }

    @Override // s33.a
    public void a(a.InterfaceC11202a interfaceC11202a) {
        C11272a c11272a = new C11272a(interfaceC11202a);
        this.f435359b = c11272a;
        Drawable drawable = this.f435358a;
        if (drawable != null) {
            drawable.setCallback(c11272a);
        }
    }

    @Override // s33.a
    public void b() {
        if (this.f435358a != null) {
            d(false);
            this.f435358a.setVisible(false, false);
        }
    }

    @Override // s33.a
    public void c() {
        if (this.f435358a != null) {
            d(true);
            this.f435358a.setVisible(true, false);
            this.f435358a.invalidateSelf();
        }
    }

    /* compiled from: P */
    /* renamed from: t33.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C11272a implements Drawable.Callback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC11202a f435360d;

        C11272a(a.InterfaceC11202a interfaceC11202a) {
            this.f435360d = interfaceC11202a;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            a.InterfaceC11202a interfaceC11202a = this.f435360d;
            if (interfaceC11202a != null) {
                interfaceC11202a.invalidateDrawable(drawable);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        }
    }
}
