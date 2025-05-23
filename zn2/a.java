package zn2;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.view.FitIMEInsetLayout;
import com.tencent.mobileqq.search.util.az;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements FitIMEInsetLayout.a {

    /* renamed from: g, reason: collision with root package name */
    private static final int f452797g = ViewUtils.dip2px(150.0f);

    /* renamed from: a, reason: collision with root package name */
    private final FitIMEInsetLayout f452798a;

    /* renamed from: b, reason: collision with root package name */
    private View f452799b;

    /* renamed from: c, reason: collision with root package name */
    private String f452800c;

    /* renamed from: d, reason: collision with root package name */
    private final b f452801d;

    /* renamed from: e, reason: collision with root package name */
    private final C11702a f452802e;

    /* renamed from: f, reason: collision with root package name */
    private BaseQQAppInterface f452803f;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(String str);
    }

    public a(FitIMEInsetLayout fitIMEInsetLayout, b bVar) {
        this.f452798a = fitIMEInsetLayout;
        this.f452801d = bVar;
        fitIMEInsetLayout.setVisibility(4);
        fitIMEInsetLayout.setPaddingBottomChangedListener(this);
        this.f452802e = new C11702a(fitIMEInsetLayout);
    }

    private static boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100371", true);
    }

    private void c() {
        this.f452801d.a(this.f452800c);
    }

    @Override // com.tencent.mobileqq.search.base.view.FitIMEInsetLayout.a
    public void a(int i3) {
        if (i3 > f452797g) {
            this.f452798a.setVisibility(0);
            View view = this.f452799b;
            if (view != null && view.isShown()) {
                this.f452802e.a(false);
                return;
            }
            return;
        }
        this.f452798a.setVisibility(4);
        this.f452802e.a(true);
    }

    public void d(BaseQQAppInterface baseQQAppInterface) {
        this.f452803f = baseQQAppInterface;
    }

    public void e(String str) {
        if (!b()) {
            QLog.d("QCircleSearchFloatIMEBar", 2, "#setKeyword: switch is off");
            return;
        }
        if (TextUtils.equals(this.f452800c, str)) {
            return;
        }
        this.f452800c = str;
        View view = this.f452799b;
        if (view != null) {
            view.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str)) {
            c();
        }
    }

    /* compiled from: P */
    /* renamed from: zn2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private static class C11702a {

        /* renamed from: a, reason: collision with root package name */
        private final View f452804a;

        /* renamed from: b, reason: collision with root package name */
        private final TopGestureLayout.InterceptTouchEventListener f452805b = new C11703a();

        C11702a(View view) {
            this.f452804a = view;
        }

        void a(boolean z16) {
            if (z16) {
                az.f(this.f452804a, this.f452805b);
            } else {
                az.d(this.f452804a, this.f452805b);
            }
        }

        /* compiled from: P */
        /* renamed from: zn2.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        private static class C11703a implements TopGestureLayout.InterceptTouchEventListener {
            C11703a() {
            }

            @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
            public boolean OnInterceptTouchEvent(MotionEvent motionEvent) {
                return false;
            }

            @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
            public void OnDispatchTouchEvent(MotionEvent motionEvent) {
            }
        }
    }
}
