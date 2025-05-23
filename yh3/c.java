package yh3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import t74.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0003J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010!\u00a8\u0006%"}, d2 = {"Lyh3/c;", "", "Lyh3/d;", "", "i", "Lji3/d;", "listener", h.F, "l", "Lji3/c;", "g", "k", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "d", "", "params", "e", "b", "f", "Lai3/b;", "cb", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mStatusListeners", "mProgressListeners", "Lai3/a;", "mLoadingErrorListeners", "", "Z", "mIsHotPatching", "Lyh3/e;", "Lyh3/e;", "mVersionInfo", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsHotPatching;

    /* renamed from: a, reason: collision with root package name */
    public static final c f450357a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArraySet<ji3.d> mStatusListeners = new CopyOnWriteArraySet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArraySet<ji3.c> mProgressListeners = new CopyOnWriteArraySet<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArraySet<ai3.a> mLoadingErrorListeners = new CopyOnWriteArraySet<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static ZPlanHotPatchVersionInfo mVersionInfo = new ZPlanHotPatchVersionInfo();

    c() {
    }

    private final void i(final ZPlanHotPatchResult zPlanHotPatchResult) {
        ThreadManagerV2.excute(new Runnable() { // from class: yh3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.j(ZPlanHotPatchResult.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZPlanHotPatchResult this_report) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this_report, "$this_report");
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("ViewType", String.valueOf(this_report.getMViewType()));
        pairArr[1] = TuplesKt.to("ErrorCode", String.valueOf(this_report.getMErrorCode()));
        pairArr[2] = TuplesKt.to("Version", this_report.getMVersion());
        AppRuntime d16 = bb.f335811a.d();
        String currentUin = d16 != null ? d16.getCurrentUin() : null;
        if (currentUin == null) {
            currentUin = "";
        }
        pairArr[3] = TuplesKt.to("UserId", currentUin);
        pairArr[4] = TuplesKt.to("TimeMs", String.valueOf(System.currentTimeMillis()));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        r.e(null, "zplan_hot_patch_result", mapOf, 1, null);
    }

    public final synchronized void b(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ZPlanHotPatchResult result = (ZPlanHotPatchResult) DataConvertUtil.f329546a.a().fromJson(params, ZPlanHotPatchResult.class);
        mIsHotPatching = false;
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("key_hot_patch_version", result.getMVersion());
        QLog.i("ZPlanHotPatchPublisherBridge", 1, "dispatchHotPatchResult :: version == " + result.getMVersion());
        Iterator<T> it = mStatusListeners.iterator();
        while (it.hasNext()) {
            ((ji3.d) it.next()).b(result.getMErrorCode());
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        i(result);
    }

    public final void c(String params, ai3.b cb5) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i("ZPlanHotPatchPublisherBridge", 1, "dispatchLoadingError params:" + params);
        ZPlanLoadingErrorInfo info = (ZPlanLoadingErrorInfo) DataConvertUtil.f329546a.a().fromJson(params, ZPlanLoadingErrorInfo.class);
        CopyOnWriteArraySet<ai3.a> copyOnWriteArraySet = mLoadingErrorListeners;
        QLog.i("ZPlanHotPatchPublisherBridge", 1, "dispatchLoadingError info:" + info + ", listenerSize= " + copyOnWriteArraySet.size());
        for (ai3.a aVar : copyOnWriteArraySet) {
            Intrinsics.checkNotNullExpressionValue(info, "info");
            aVar.a(info, cb5);
        }
    }

    public final void d(CommonLoadingData loadingData) {
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        Iterator<T> it = mProgressListeners.iterator();
        while (it.hasNext()) {
            ((ji3.c) it.next()).onProgress(loadingData.getProgress(), loadingData.getCurrentMode(), loadingData.getTotalMode());
        }
    }

    public final synchronized void e(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ZPlanHotPatchVersionInfo versionInfo = (ZPlanHotPatchVersionInfo) DataConvertUtil.f329546a.a().fromJson(params, ZPlanHotPatchVersionInfo.class);
        if (versionInfo.getMNeedUpdate()) {
            mIsHotPatching = true;
            Intrinsics.checkNotNullExpressionValue(versionInfo, "this");
            mVersionInfo = versionInfo;
            for (ji3.d dVar : mStatusListeners) {
                Intrinsics.checkNotNullExpressionValue(versionInfo, "versionInfo");
                dVar.a(versionInfo);
            }
        }
    }

    public final void g(ji3.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("ZPlanHotPatchPublisherBridge", 1, "register progress listener.");
        mProgressListeners.add(listener);
    }

    public final synchronized void h(ji3.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("ZPlanHotPatchPublisherBridge", 1, "register status listener.");
        mStatusListeners.add(listener);
        if (mIsHotPatching) {
            listener.a(mVersionInfo);
        }
    }

    public final void k(ji3.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("ZPlanHotPatchPublisherBridge", 1, "unregister progress listener.");
        mProgressListeners.remove(listener);
    }

    public final void l(ji3.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("ZPlanHotPatchPublisherBridge", 1, "unregister status listener.");
        mStatusListeners.remove(listener);
    }

    public final void f() {
        QLog.w("ZPlanHotPatchPublisherBridge", 1, "interruptHotPatching");
        mIsHotPatching = false;
    }
}
