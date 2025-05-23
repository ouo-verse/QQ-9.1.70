package vd3;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUETechReportParams;
import com.tencent.mobileqq.zplan.mod.impl.helper.ModDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\b%\u0010&J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0000J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rJ\u001a\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0018\u001a\u00020\rH&R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\"\u0010$\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lvd3/a;", "Lvd3/b;", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "enterJson", "Lvd3/c;", "callback", "", "a", "preparer", "i", "f", "", "msg", h.F, "error", "g", "", "needDownloadCommonMod", "", "stepCost", "Lcom/tencent/mobileqq/zootopia/ueloading/report/c;", "b", "e", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "loaderController", "Lvd3/a;", "mNextPreparer", "c", "J", "d", "()J", "setStepStartTime", "(J)V", "stepStartTime", "<init>", "(Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZPlanUELoaderControllerV2 loaderController;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private a mNextPreparer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long stepStartTime;

    public a(ZPlanUELoaderControllerV2 loaderController) {
        Intrinsics.checkNotNullParameter(loaderController, "loaderController");
        this.loaderController = loaderController;
    }

    @Override // vd3.b
    public void a(ZootopiaEnterParams enterParams, JSONObject enterJson, c callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long currentTimeMillis = System.currentTimeMillis();
        this.stepStartTime = currentTimeMillis;
        h("prepare start stepStartTime = " + currentTimeMillis);
    }

    /* renamed from: d, reason: from getter */
    public final long getStepStartTime() {
        return this.stepStartTime;
    }

    public abstract String e();

    public void f(ZootopiaEnterParams enterParams, JSONObject enterJson, c callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        h("prepare end cost = " + (System.currentTimeMillis() - this.stepStartTime));
        a aVar = this.mNextPreparer;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            aVar.a(enterParams, enterJson, callback);
        } else {
            callback.a(new PrepareResult(enterParams, enterJson, null, null, 12, null));
            h("prepare completed");
        }
    }

    public final void g(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        QLog.e("Preparer_" + e(), 1, e() + MsgSummary.STR_COLON + error);
    }

    public final void h(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i("Preparer_" + e(), 1, e() + MsgSummary.STR_COLON + msg2);
    }

    public final void i(a preparer) {
        Intrinsics.checkNotNullParameter(preparer, "preparer");
        this.mNextPreparer = preparer;
    }

    public final ZPlanUETechReportParams b(boolean needDownloadCommonMod, long stepCost) {
        Boolean isDownloaded;
        ZootopiaEnterParams enterParams = this.loaderController.getEnterParams();
        int mapId = enterParams != null ? enterParams.getMapId() : 0;
        long currentTimeMillis = System.currentTimeMillis();
        ZootopiaEnterParams enterParams2 = this.loaderController.getEnterParams();
        long startTime = currentTimeMillis - (enterParams2 != null ? enterParams2.getStartTime() : 0L);
        boolean useV2Loading = this.loaderController.getUseV2Loading();
        boolean isBackLoad = this.loaderController.getIsBackLoad();
        String enterSource = this.loaderController.getEnterSource();
        ZootopiaEnterParams enterParams3 = this.loaderController.getEnterParams();
        boolean booleanValue = (enterParams3 == null || (isDownloaded = enterParams3.getIsDownloaded()) == null) ? true : isDownloaded.booleanValue();
        ModDownloadHelper modDownloadHelper = ModDownloadHelper.f334765a;
        ZootopiaEnterParams enterParams4 = this.loaderController.getEnterParams();
        return new ZPlanUETechReportParams(mapId, startTime, stepCost, useV2Loading, isBackLoad, enterSource, booleanValue, needDownloadCommonMod, modDownloadHelper.g(enterParams4 != null ? enterParams4.getMapId() : 0));
    }

    public static /* synthetic */ ZPlanUETechReportParams c(a aVar, boolean z16, long j3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            return aVar.b(z16, j3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildReportParams");
    }
}
