package y60;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.h;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class c implements a {
    private WeakReference<x60.a> C;
    private final Gson D = new Gson();

    /* renamed from: d, reason: collision with root package name */
    protected FeedCloudMeta$StFeed f449511d;

    /* renamed from: e, reason: collision with root package name */
    protected int f449512e;

    /* renamed from: f, reason: collision with root package name */
    private ViewStub f449513f;

    /* renamed from: h, reason: collision with root package name */
    private View f449514h;

    /* renamed from: i, reason: collision with root package name */
    private View f449515i;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<x60.b> f449516m;

    private x60.a i() {
        WeakReference<x60.a> weakReference = this.C;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private x60.b j() {
        WeakReference<x60.b> weakReference = this.f449516m;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // y60.a
    public void V() {
        String str;
        if (this.f449513f == null) {
            QLog.e("BGV-QFSAbsFeedBottomGuideHolder", 1, "[showGuideView] bottom guide view stub should not is null.");
            return;
        }
        int h16 = h();
        try {
            if (this.f449514h == null) {
                this.f449514h = this.f449513f.inflate().findViewById(h16);
            }
        } catch (Throwable unused) {
            this.f449514h = this.f449515i.findViewById(h16);
        }
        View view = this.f449514h;
        if (view == null) {
            QLog.d("BGV-QFSAbsFeedBottomGuideHolder", 1, "[showGuideView] bottom guide root layout should not be null.");
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            QLog.e("BGV-QFSAbsFeedBottomGuideHolder", 1, "[showGuideView] context should not be null.");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f449511d;
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        QLog.d("BGV-QFSAbsFeedBottomGuideHolder", 1, "[showGuideView] current show comment guide view feedId: " + str + " | this: " + toString());
        q(0);
        m(context, this.f449514h);
    }

    @Override // y60.a
    public void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f449511d = feedCloudMeta$StFeed;
        this.f449512e = i3;
    }

    @Override // y60.a
    public void b(x60.b bVar) {
        this.f449516m = new WeakReference<>(bVar);
    }

    @Override // y60.a
    public boolean c() {
        View view = this.f449514h;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // y60.a
    public void d(x60.a aVar) {
        this.C = new WeakReference<>(aVar);
    }

    @Override // y60.a
    public void e(@NonNull View view) {
        this.f449515i = view;
        this.f449513f = (ViewStub) view.findViewById(l());
    }

    @Override // y60.a
    public void f(boolean z16) {
        String str;
        try {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f449511d;
            if (feedCloudMeta$StFeed == null) {
                str = "null";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            QLog.d("BGV-QFSAbsFeedBottomGuideHolder", 1, "[goneGuideView] current gone comment guide view feedId: " + str + " | isForceFlag: " + z16 + " | this: " + toString());
            q(8);
        } catch (Throwable th5) {
            QLog.e("BGV-QFSAbsFeedBottomGuideHolder", 1, "[goneGuideView] error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleExtraTypeInfo g() {
        x60.a i3 = i();
        if (i3 == null) {
            return null;
        }
        return i3.f();
    }

    protected abstract int h();

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleReportBean k() {
        x60.a i3 = i();
        if (i3 == null) {
            return null;
        }
        return i3.A();
    }

    protected abstract int l();

    protected abstract void m(@NonNull Context context, @NonNull View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T n(String str, Class<T> cls) {
        try {
            return (T) this.D.fromJson(str, (Class) cls);
        } catch (Throwable th5) {
            QLog.e("BGV-QFSAbsFeedBottomGuideHolder", 1, "[parseJson] error: ", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(String str, Object... objArr) {
        x60.b j3 = j();
        if (j3 == null) {
            QLog.e("BGV-QFSAbsFeedBottomGuideHolder", 1, "[sendIocMessage] callback should not be null.");
        } else {
            j3.i(str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(h hVar) {
        x60.b j3 = j();
        if (j3 == null) {
            QLog.e("BGV-QFSAbsFeedBottomGuideHolder", 1, "[sendPresenterEvent] callback should not be null.");
        } else {
            j3.g(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(int i3) {
        View view = this.f449514h;
        if (view != null && i3 == view.getVisibility()) {
            return;
        }
        r(this.f449514h, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(View view, int i3) {
        if (view == null) {
            QLog.e("BGV-QFSAbsFeedBottomGuideHolder", 1, "[setViewVisible] view should not be null.");
        } else {
            if (view.getVisibility() == i3) {
                return;
            }
            view.setVisibility(i3);
        }
    }

    @Override // y60.a
    public void release() {
    }
}
