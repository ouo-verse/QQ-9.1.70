package t74;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz2.VasRewardAdReportParams;
import uz2.VasRewardAdReqParams;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u0000 .2\u00020\u0001:\u0002\u0017\u001aB\u0007\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bJ \u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nJ.\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0004R\u0016\u0010\u0019\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010(\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lt74/o;", "", "Lt74/o$b;", "listener", "", "o", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "rewardType", "", "rewardItem", GetAdInfoRequest.SOURCE_FROM, "l", "", "adSequence", "rewardText", "p", "", "isFinished", "actionValue", "k", DomainData.DOMAIN_NAME, "a", "J", "curAdSequence", "b", "Z", "curIsFinished", "c", "I", "curElapsedTime", "d", "curRewardType", "e", "Ljava/lang/String;", "curRewardItem", "f", "curRewardText", "g", "BIZ_SRC", tl.h.F, "Lt74/o$b;", "stateListener", "<init>", "()V", "i", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long curAdSequence;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean curIsFinished;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int curElapsedTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curRewardType = 29;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String curRewardItem = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String curRewardText = "\u83b7\u5f97\u6709\u6548\u5956\u52b1";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String BIZ_SRC = "biz_src_test";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b stateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lt74/o$b;", "", "", "success", "", "b", "profitable", "c", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface b {
        void a(boolean success);

        void b(boolean success);

        void c(boolean profitable);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"t74/o$c", "Ltz2/b;", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "retCode", "", "errMsg", "", "busiBuffer", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements tz2.b {
        c() {
        }

        @Override // tz2.b
        public void a(VasAdvServiceCode code, int retCode, String errMsg, byte[] busiBuffer) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            b bVar = o.this.stateListener;
            if (bVar != null) {
                bVar.a(code == VasAdvServiceCode.SUCCEED);
            }
            if (code == VasAdvServiceCode.SUCCEED) {
                QLog.i("ZPlanAdHelper", 1, "reportRewardAd onResult succeed");
                return;
            }
            QLog.e("ZPlanAdHelper", 1, "reportRewardAd onResult failed, code: " + code + ", errMsg: " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"t74/o$d", "Ltz2/c;", "", "adSequence", "", "a", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements tz2.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f435577b;

        d(Activity activity) {
            this.f435577b = activity;
        }

        @Override // tz2.c
        public void a(long adSequence) {
            QLog.i("ZPlanAdHelper", 1, "requestAd onSucceed adSequence: " + adSequence);
            b bVar = o.this.stateListener;
            if (bVar != null) {
                bVar.b(true);
            }
            o.this.curAdSequence = adSequence;
            o oVar = o.this;
            oVar.p(this.f435577b, oVar.curAdSequence, o.this.curRewardText);
        }

        @Override // tz2.c
        public void b(VasAdvServiceCode code, String errMsg) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("ZPlanAdHelper", 1, "requestAd onError code: " + code + ", errMsg: " + errMsg);
            b bVar = o.this.stateListener;
            if (bVar != null) {
                bVar.b(false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"t74/o$e", "Ltz2/d;", "", "code", "", "profitable", "elapsedTime", "totalTime", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class e implements tz2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<b> f435578a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f435579b;

        e(WeakReference<b> weakReference, o oVar) {
            this.f435578a = weakReference;
            this.f435579b = oVar;
        }

        @Override // tz2.d
        public void a(int code, boolean profitable, int elapsedTime, int totalTime) {
            QLog.i("ZPlanAdHelper", 1, "showRewardAd onResult code: " + code + ", profitable: " + profitable + ", elapsedTime: " + elapsedTime + ", totalTime: " + totalTime);
            b bVar = this.f435578a.get();
            if (bVar != null) {
                bVar.c(profitable);
            }
            this.f435579b.curIsFinished = profitable;
            this.f435579b.curElapsedTime = elapsedTime;
            if (profitable) {
                this.f435579b.curElapsedTime = elapsedTime;
                o oVar = this.f435579b;
                oVar.k(oVar.curAdSequence, this.f435579b.curIsFinished, this.f435579b.curRewardType, this.f435579b.curRewardItem, this.f435579b.curElapsedTime);
            }
        }
    }

    public final void k(long adSequence, boolean isFinished, int rewardType, String rewardItem, int actionValue) {
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        VasRewardAdReportParams.C11382a c11382a = new VasRewardAdReportParams.C11382a();
        c11382a.d(adSequence);
        c11382a.e(isFinished);
        c11382a.h(rewardType);
        c11382a.f(rewardItem);
        c11382a.b(actionValue);
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).reportRewardAd(c11382a.a(), new c());
        n();
    }

    public final void l(Activity activity, int rewardType, String rewardItem, int sourceFrom) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        this.curRewardType = rewardType;
        this.curRewardItem = rewardItem;
        VasRewardAdReqParams.a aVar = new VasRewardAdReqParams.a();
        aVar.d(rewardType);
        aVar.c(rewardItem);
        aVar.e(sourceFrom);
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).requestAd(aVar.a(), new d(activity));
    }

    public final void o(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateListener = listener;
    }

    public final void p(Activity activity, long adSequence, String rewardText) {
        Intrinsics.checkNotNullParameter(rewardText, "rewardText");
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).showRewardAd(activity, adSequence, rewardText, this.BIZ_SRC, new e(new WeakReference(this.stateListener), this));
    }

    public final void n() {
        this.curAdSequence = 0L;
        this.curIsFinished = false;
        this.curElapsedTime = 0;
        this.curRewardType = 29;
        this.curRewardItem = "";
        this.curRewardText = "\u83b7\u5f97\u6709\u6548\u5956\u52b1";
    }

    public static /* synthetic */ void m(o oVar, Activity activity, int i3, String str, int i16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        oVar.l(activity, i3, str, i16);
    }
}
