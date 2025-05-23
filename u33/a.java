package u33;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import s33.a;
import s33.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private s33.a f438193a;

    /* renamed from: b, reason: collision with root package name */
    private b f438194b;

    /* compiled from: P */
    /* renamed from: u33.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C11320a implements a.InterfaceC11202a {
        C11320a() {
        }

        @Override // s33.a.InterfaceC11202a
        public void invalidateDrawable(Drawable drawable) {
            QLog.i("VipWallpaper", 1, "mView#draw");
            a.this.f438194b.b(drawable);
        }
    }

    public a(s33.a aVar, b bVar) {
        this.f438193a = aVar;
        this.f438194b = bVar;
    }

    public void b(int i3, int i16) {
        this.f438194b.setBounds(new Rect(0, 0, i3, i16));
    }

    public void c() {
        this.f438193a.b();
    }

    public void d() {
        this.f438193a.a(null);
        this.f438194b.reset();
    }

    public void e() {
        this.f438193a.c();
    }

    public void f() {
        this.f438193a.a(new C11320a());
        e();
    }
}
