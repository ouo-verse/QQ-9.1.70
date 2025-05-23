package yo0;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public static int C = 0;
    public static boolean D = false;

    /* renamed from: e, reason: collision with root package name */
    private Activity f450719e;

    /* renamed from: f, reason: collision with root package name */
    private a f450720f;

    /* renamed from: m, reason: collision with root package name */
    private View f450723m;

    /* renamed from: d, reason: collision with root package name */
    private int f450718d = 1;

    /* renamed from: h, reason: collision with root package name */
    private int f450721h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f450722i = 0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void d(int i3, int i16, int i17);

        void e(int i3, int i16, int i17);
    }

    public b(Activity activity) {
        this.f450719e = activity;
    }

    public static int a(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public static int b(View view) {
        if (view == null || view.getRootView() == null) {
            return 1;
        }
        int[] iArr = new int[2];
        int height = view.getRootView().getHeight();
        view.getLocationInWindow(iArr);
        if (iArr[1] < (height * 3) / 4) {
            return 1;
        }
        return 2;
    }

    public static void d(Activity activity) {
        C = a(activity.getWindow().getDecorView());
        D = f(activity);
    }

    public static boolean f(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (QLog.isColorLevel()) {
            QLog.d("AtPanelStatus", 2, "onGlobalLayout, top=" + rect.top + " bottom=" + rect.bottom);
        }
        if (rect.top == 0) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f450718d;
    }

    @RequiresApi(api = 16)
    public void e() {
        this.f450719e.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f450718d = 1;
        this.f450720f = null;
        this.f450721h = 0;
    }

    public void g(View view) {
        this.f450723m = view;
    }

    public void h(a aVar) {
        if (aVar == this.f450720f) {
            return;
        }
        if (aVar != null) {
            this.f450719e.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
        this.f450718d = 1;
        this.f450720f = aVar;
        this.f450721h = 0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        a aVar;
        View decorView = this.f450719e.getWindow().getDecorView();
        if (decorView == null) {
            return;
        }
        int height = decorView.getHeight();
        int a16 = a(decorView);
        int i3 = height - a16;
        View view = this.f450723m;
        if (view != null) {
            int height2 = view.getHeight();
            int i16 = this.f450722i;
            if (height2 != i16 && (aVar = this.f450720f) != null) {
                aVar.d(this.f450718d, a16, i16);
            }
            this.f450722i = height2;
        }
        if (a16 == this.f450721h) {
            return;
        }
        if (i3 > height / 4) {
            this.f450718d = 1;
            a aVar2 = this.f450720f;
            if (aVar2 != null) {
                aVar2.e(1, a16, i3);
            }
        } else if (i3 < (height * 3) / 4) {
            this.f450718d = 2;
            a aVar3 = this.f450720f;
            if (aVar3 != null) {
                aVar3.e(2, a16, i3);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AtPanelStatus", 2, "onGlobalLayout, screenHeight=" + height + " visibleHeight=" + a16 + " differHeight=" + i3 + " mode=" + this.f450718d);
        }
        this.f450721h = a16;
    }
}
