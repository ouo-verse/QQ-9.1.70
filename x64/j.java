package x64;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    protected DisplayMetrics f447340a;

    /* renamed from: b, reason: collision with root package name */
    protected int f447341b;

    /* renamed from: c, reason: collision with root package name */
    protected final int[] f447342c = new int[2];

    /* renamed from: d, reason: collision with root package name */
    protected final Rect f447343d = new Rect();

    public j(DisplayMetrics displayMetrics) {
        this.f447340a = displayMetrics;
        this.f447341b = (int) y64.a.c(displayMetrics, 88);
    }

    public int a(@NonNull View view) {
        int height = view.getRootView().getHeight();
        view.getLocationInWindow(this.f447342c);
        if (this.f447342c[1] < (height * 3) / 4) {
            return 1;
        }
        return 2;
    }

    public int b(@NonNull View view) {
        return f(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(@NonNull ml3.b bVar, int i3, boolean z16) {
        return ((m) bVar.b(m.class)).Q(z16, 0, i3);
    }

    public int d(@NonNull ml3.b bVar, @NonNull Rect rect, boolean z16) {
        if (z16) {
            return ((m) bVar.b(m.class)).w0(true, 0, rect.height());
        }
        return -1;
    }

    public int e(@NonNull ml3.b bVar, @NonNull Rect rect, int i3, boolean z16) {
        if (z16) {
            return Math.max(rect.height() - c(bVar, rect.height(), true), g());
        }
        return g();
    }

    public int f(@NonNull View view) {
        view.getLocationInWindow(this.f447342c);
        return this.f447342c[1];
    }

    public int g() {
        return this.f447341b;
    }

    @NonNull
    public Rect h(@NonNull View view) {
        view.getLocationInWindow(this.f447342c);
        int[] iArr = this.f447342c;
        int i3 = iArr[0];
        this.f447343d.set(i3, 0, view.getWidth() + i3, iArr[1]);
        return this.f447343d;
    }
}
