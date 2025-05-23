package uh3;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zplan.event.impl.report.reportMsg.ZPlanReportMsgCacheHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Luh3/e;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "", "l", "e", "d", "f", "Luh3/a;", "j", "k", "", "connected", "onNetChangeEvent", "", "J", "mPollingDelay", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mPollingTask", "Ljava/util/concurrent/CopyOnWriteArrayList;", tl.h.F, "Ljava/util/concurrent/CopyOnWriteArrayList;", "mListenerPool", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e implements INetEventHandler {

    /* renamed from: d, reason: collision with root package name */
    public static final e f438965d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long mPollingDelay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Runnable mPollingTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<a> mListenerPool;

    static {
        e eVar = new e();
        f438965d = eVar;
        mPollingDelay = 30000L;
        mPollingTask = new Runnable() { // from class: uh3.b
            @Override // java.lang.Runnable
            public final void run() {
                e.g();
            }
        };
        mListenerPool = new CopyOnWriteArrayList<>();
        AppNetConnInfo.registerNetChangeReceiver(BaseApplication.context, eVar);
        eVar.e();
    }

    e() {
    }

    private final void d() {
        boolean z16;
        QLog.i("ZPlanCacheLoopGenerator_", 1, "handleCacheEvent ");
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.e("ZPlanCacheLoopGenerator_", 1, "handleCacheEvent net unavailable!");
            return;
        }
        loop0: while (true) {
            for (a aVar : mListenerPool) {
                boolean a16 = aVar.a();
                QLog.i("ZPlanCacheLoopGenerator_", 1, "handleCacheEvent handleResult:" + a16 + ", l:" + aVar);
                z16 = z16 || a16;
            }
        }
        if (z16) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(mPollingTask);
        QLog.w("ZPlanCacheLoopGenerator_", 1, "handleCacheEvent empty!");
    }

    private final void e() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable = mPollingTask;
        uIHandlerV2.removeCallbacks(runnable);
        ThreadManagerV2.getUIHandlerV2().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        f438965d.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        f438965d.e();
    }

    private final void l() {
        int M1 = ZPlanFeatureSwitch.f369852a.M1();
        QLog.i("ZPlanCacheLoopGenerator_", 1, "gapFromConfig : " + M1);
        if (M1 < 5) {
            M1 = 5;
        }
        mPollingDelay = M1 * 1000;
    }

    public final void j(a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        mListenerPool.add(l3);
    }

    public final synchronized void k() {
        l();
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable = mPollingTask;
        uIHandlerV2.removeCallbacks(runnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, mPollingDelay);
        QLog.i("ZPlanCacheLoopGenerator_", 1, "scheduleNextTask mPollingDelay:" + mPollingDelay);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean connected) {
        QLog.i("ZPlanCacheLoopGenerator_", 1, "onNetChangeEvent connected:" + connected);
        if (connected) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: uh3.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.i();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        QLog.i("ZPlanCacheLoopGenerator_", 1, "running mPollingTask");
        f438965d.k();
        ThreadManagerV2.excute(new Runnable() { // from class: uh3.c
            @Override // java.lang.Runnable
            public final void run() {
                e.h();
            }
        }, 32, null, false);
    }

    public final void f() {
        QLog.i("ZPlanCacheLoopGenerator_", 1, "inited!");
        j(f.f438969a);
        j(new ZPlanReportMsgCacheHandler());
    }
}
