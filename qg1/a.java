package qg1;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.widget.tip.QUICustomBubbleView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends com.tencent.mobileqq.widget.tip.a {
    private int V;
    private int W;
    private float X;

    /* compiled from: P */
    /* renamed from: qg1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class ViewTreeObserverOnGlobalLayoutListenerC11075a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f428903d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QUICustomBubbleView f428904e;

        ViewTreeObserverOnGlobalLayoutListenerC11075a(FrameLayout frameLayout, QUICustomBubbleView qUICustomBubbleView) {
            this.f428903d = frameLayout;
            this.f428904e = qUICustomBubbleView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] iArr = new int[2];
            this.f428903d.getLocationOnScreen(iArr);
            this.f428904e.setArrowOffsetX(((a.this.V - iArr[0]) - (this.f428904e.g() / 2)) - this.f428903d.getPaddingLeft());
            this.f428903d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public a(Context context) {
        super(context);
        this.V = 0;
        this.W = 0;
    }

    public static a B0(Context context) {
        Context D0 = D0(context);
        if (D0 == null) {
            return null;
        }
        return new a(D0);
    }

    private static Activity C0(Context context) {
        if (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return C0(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static Context D0(Context context) {
        Activity C0 = C0(context);
        if (C0 != null && C0.getWindow() != null) {
            return C0;
        }
        QLog.d("QUIBubbleTip", 1, "requestPermissions error with null activity");
        return null;
    }

    public void E0(float f16) {
        this.X = f16;
    }

    public com.tencent.mobileqq.widget.tip.a F0(int i3, int i16) {
        this.f317524h = i3;
        this.f317525i = i16;
        return this;
    }

    public void G0(int i3, int i16) {
        this.V = i3;
        this.W = i16;
    }

    public void H0(int i3, int i16) {
        this.Q.update(i3, i16, -1, -1);
    }

    @Override // com.tencent.mobileqq.widget.tip.a
    protected int[] N(@NonNull View view, int i3, int i16, @NonNull FrameLayout frameLayout, @NonNull QUICustomBubbleView qUICustomBubbleView) {
        if (this.V != 0) {
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC11075a(frameLayout, qUICustomBubbleView));
        }
        float f16 = this.X;
        if (f16 != 0.0f) {
            qUICustomBubbleView.setCornerRadius(f16);
        }
        return new int[]{this.f317524h, this.f317525i};
    }

    @Override // com.tencent.mobileqq.widget.tip.a
    protected void v0(View view, View view2, int[] iArr) {
        if (!I()) {
            QLog.d("QUIBubbleTip", 1, "isActivityAlive: false");
        } else {
            this.Q.setContentView(view);
            this.Q.showAtLocation(view2, 0, iArr[0], iArr[1]);
        }
    }
}
