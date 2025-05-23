package ro0;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import java.util.Collection;
import qo0.e;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    protected final e f431783b;

    /* renamed from: c, reason: collision with root package name */
    protected int f431784c;

    /* renamed from: d, reason: collision with root package name */
    protected int f431785d;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f431782a = true;

    /* renamed from: e, reason: collision with root package name */
    protected final int[] f431786e = new int[2];

    /* renamed from: f, reason: collision with root package name */
    protected final Rect f431787f = new Rect();

    public c(e eVar) {
        this.f431783b = eVar;
    }

    public int a(@NonNull View view) {
        int height = view.getRootView().getHeight();
        view.getLocationInWindow(this.f431786e);
        if (this.f431786e[1] < (height * 3) / 4) {
            return 1;
        }
        return 2;
    }

    public int b(@NonNull View view) {
        if (!this.f431782a) {
            return this.f431785d;
        }
        int e16 = e(view);
        this.f431785d = e16;
        return e16;
    }

    public int c(boolean z16, Collection<oo0.a> collection) {
        if (!this.f431782a) {
            return this.f431784c;
        }
        if (!z16) {
            return -1;
        }
        this.f431784c = 0;
        for (oo0.a aVar : collection) {
            if (aVar.c().getVisibility() != 8) {
                this.f431784c += aVar.d();
            }
        }
        return this.f431784c;
    }

    public int d(boolean z16, int i3, int i16) {
        throw null;
    }

    public int e(@NonNull View view) {
        view.getLocationInWindow(this.f431786e);
        return this.f431786e[1];
    }

    @NonNull
    public Rect f(@NonNull View view) {
        view.getLocationInWindow(this.f431786e);
        int[] iArr = this.f431786e;
        int i3 = iArr[0];
        int i16 = iArr[1];
        if (AppSetting.t(view.getContext())) {
            this.f431787f.set(i3, 0, view.getWidth() + i3, i16);
        } else {
            this.f431787f.set(0, 0, view.getWidth(), i16);
        }
        return this.f431787f;
    }

    public void g(boolean z16) {
        this.f431782a = z16;
    }
}
