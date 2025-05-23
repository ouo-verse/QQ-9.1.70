package z62;

import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.leba.Leba;
import com.tencent.mobileqq.leba.zplan.widget.PullToZoomHeaderFrameLayout;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.IZPlanRefreshMoveListener;
import cooperation.qzone.api.OnRefreshStateListener;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements b72.a {

    /* renamed from: i, reason: collision with root package name */
    private static boolean f452038i = false;

    /* renamed from: a, reason: collision with root package name */
    private Leba f452039a;

    /* renamed from: b, reason: collision with root package name */
    private f f452040b;

    /* renamed from: d, reason: collision with root package name */
    private float f452042d;

    /* renamed from: h, reason: collision with root package name */
    public PullToZoomHeaderFrameLayout f452046h;

    /* renamed from: c, reason: collision with root package name */
    private String f452041c = "";

    /* renamed from: e, reason: collision with root package name */
    private boolean f452043e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f452044f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f452045g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Integer) {
                int intValue = ((Integer) animatedValue).intValue();
                if (b.this.f452040b != null) {
                    b.this.f452040b.V(intValue);
                }
                b.this.d(intValue);
            }
        }
    }

    public b(Leba leba, f fVar) {
        this.f452039a = leba;
        this.f452040b = fVar;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3) {
        if (f452038i) {
            QLog.i("LebaZplanControlManager", 4, "[callBackRefreshMoveListener] topHeight = " + i3);
        }
        ArrayList<IZPlanRefreshMoveListener> t16 = this.f452040b.t();
        if (t16 != null && t16.size() > 0) {
            Iterator<IZPlanRefreshMoveListener> it = t16.iterator();
            while (it.hasNext()) {
                it.next().onMove(i3);
            }
        }
    }

    private void e() {
        ArrayList<IZPlanRefreshMoveListener> t16 = this.f452040b.t();
        if (t16 != null && t16.size() > 0) {
            Iterator<IZPlanRefreshMoveListener> it = t16.iterator();
            while (it.hasNext()) {
                it.next().onRelease();
            }
        }
    }

    private void f(int i3) {
        if (f452038i) {
            QLog.i("LebaZplanControlManager", 4, "[callBackRefreshStateChangeListener] state=" + i3);
        }
        ArrayList<IZPlanRefreshMoveListener> t16 = this.f452040b.t();
        if (t16 != null && t16.size() > 0) {
            Iterator<IZPlanRefreshMoveListener> it = t16.iterator();
            while (it.hasNext()) {
                it.next().onStateChange(i3);
            }
        }
    }

    private void h() {
        this.f452041c = this.f452039a.getActivity().getAppRuntime().getCurrentUin();
        q(this.f452040b.s());
    }

    private boolean j() {
        View view;
        if (this.f452046h == null) {
            return false;
        }
        Rect rect = new Rect();
        PullToZoomHeaderFrameLayout pullToZoomHeaderFrameLayout = this.f452046h;
        if (pullToZoomHeaderFrameLayout != null) {
            view = pullToZoomHeaderFrameLayout.getChildAt(0);
        } else {
            view = null;
        }
        if (view == null) {
            return false;
        }
        view.getLocalVisibleRect(rect);
        if (rect.top != 0) {
            return false;
        }
        return true;
    }

    @Override // b72.a
    public boolean a(@NonNull MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        View childAt;
        if (!this.f452039a.checkZplanEnable()) {
            return false;
        }
        PullToZoomHeaderFrameLayout pullToZoomHeaderFrameLayout = this.f452046h;
        if (pullToZoomHeaderFrameLayout != null && (childAt = pullToZoomHeaderFrameLayout.getChildAt(0)) != null && childAt.canScrollVertically(-1)) {
            return false;
        }
        float rawY = motionEvent.getRawY();
        float f16 = this.f452042d;
        float f17 = (rawY - f16) / 2.0f;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f452042d = motionEvent.getRawY();
        if (f17 > 0.0f && !z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f452043e = z17;
        if (z16 || !i(z17)) {
            return false;
        }
        return true;
    }

    public void g(boolean z16) {
        if (!i(z16)) {
            return;
        }
        o(z16);
    }

    @Override // b72.a
    public boolean handleZPlanEvent(@NonNull MotionEvent motionEvent) {
        boolean z16;
        View childAt;
        if (!this.f452039a.checkZplanEnable()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked() & 255;
        if (actionMasked != 0) {
            boolean z17 = true;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    PullToZoomHeaderFrameLayout pullToZoomHeaderFrameLayout = this.f452046h;
                    if (pullToZoomHeaderFrameLayout != null && (childAt = pullToZoomHeaderFrameLayout.getChildAt(0)) != null && childAt.canScrollVertically(-1)) {
                        return false;
                    }
                    float rawY = motionEvent.getRawY();
                    float f16 = this.f452042d;
                    float f17 = (rawY - f16) / 2.0f;
                    if (f16 == 0.0f) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.f452042d = motionEvent.getRawY();
                    if (f17 <= 0.0f || z16) {
                        z17 = false;
                    }
                    this.f452043e = z17;
                    if (z16) {
                        return false;
                    }
                    return m(f17, z17);
                }
            } else {
                this.f452042d = 0.0f;
                g(this.f452043e);
            }
        } else {
            this.f452042d = motionEvent.getRawY();
        }
        return false;
    }

    public boolean i(boolean z16) {
        int i3 = this.f452045g;
        if (i3 == 17) {
            return false;
        }
        if (i3 == -1 && (!j() || !z16)) {
            return false;
        }
        return true;
    }

    public void k(Configuration configuration) {
        f fVar = this.f452040b;
        if (fVar != null) {
            fVar.J(configuration);
            q(this.f452040b.s());
        }
    }

    public boolean m(float f16, boolean z16) {
        if (!i(z16)) {
            return false;
        }
        int u16 = this.f452040b.u();
        int i3 = ((int) f16) + u16;
        int i16 = this.f452044f;
        if (i16 > 0 && i3 > i16) {
            i3 = i16;
        }
        this.f452040b.V(i3);
        d(i3);
        ni3.a aVar = ni3.a.f420201a;
        Integer d16 = aVar.d();
        if (d16 != null && u16 > d16.intValue()) {
            r(16);
            return true;
        }
        Integer f17 = aVar.f();
        if (f17 != null && u16 > f17.intValue()) {
            r(14);
            return true;
        }
        Integer e16 = aVar.e();
        if (e16 != null && u16 >= e16.intValue()) {
            r(13);
            return true;
        }
        Integer a16 = z62.a.a();
        if (a16 != null && u16 > a16.intValue()) {
            r(12);
            return true;
        }
        Integer b16 = z62.a.b();
        if (b16 != null && u16 > b16.intValue()) {
            r(11);
            return true;
        }
        if (u16 > z62.a.c()) {
            r(10);
            return true;
        }
        r(-1);
        return true;
    }

    public void o(boolean z16) {
        QLog.d("LebaZplanControlManager", 1, "[onRelease] mState:", Integer.valueOf(this.f452045g));
        switch (this.f452045g) {
            case 10:
                t();
                break;
            case 11:
                if (z16) {
                    u();
                    break;
                } else {
                    t();
                    break;
                }
            case 12:
            case 13:
            case 14:
                u();
                break;
            case 16:
                r(17);
                this.f452039a.dismissUserGuide();
                if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isZplanUnderMaintenance()) {
                    u();
                    break;
                }
                break;
        }
        if (this.f452040b != null) {
            e();
        }
    }

    public void p() {
        if (this.f452045g == 17) {
            u();
        }
        this.f452039a.refreshTitleBar();
    }

    public void q(int i3) {
        QLog.i("LebaZplanControlManager", 1, "setMaxVisibilityHeight:" + i3);
        this.f452044f = i3;
    }

    public void r(int i3) {
        f fVar;
        if (this.f452045g != i3) {
            QLog.i("LebaZplanControlManager", 1, "[setState] state = " + i3 + ", oldState = " + this.f452045g);
            this.f452045g = i3;
            f fVar2 = this.f452040b;
            if (fVar2 != null) {
                ArrayList<OnRefreshStateListener> w3 = fVar2.w();
                if (w3 != null && w3.size() > 0) {
                    Iterator<OnRefreshStateListener> it = w3.iterator();
                    while (it.hasNext()) {
                        it.next().onRefreshStateChange(this.f452045g, null);
                    }
                }
                f(i3);
            } else {
                QLog.e("LebaZplanControlManager", 1, "setState headerLayout is null");
            }
            this.f452039a.refreshTitleBar();
            if (this.f452045g == 17 && (fVar = this.f452040b) != null) {
                fVar.F(2);
                return;
            }
            return;
        }
        if (f452038i) {
            QLog.d("LebaZplanControlManager", 4, "[setState] state = " + i3);
        }
    }

    protected void s(int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f452040b.u(), i3);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new a());
        ofInt.start();
    }

    public void t() {
        QLog.d("LebaZplanControlManager", 1, "[smoothScrollToClose]");
        r(-1);
        int statusTitleBottom = this.f452039a.getStatusTitleBottom();
        if (statusTitleBottom > 0) {
            s(statusTitleBottom);
        } else {
            s(z62.a.c());
        }
    }

    public void u() {
        r(13);
        Integer e16 = ni3.a.f420201a.e();
        if (e16 == null) {
            QLog.e("LebaZplanControlManager", 1, "smoothScrollToInitHeight failed, initHeight null.");
        } else {
            s(e16.intValue());
        }
    }

    public void l() {
    }

    public void n() {
    }
}
