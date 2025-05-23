package sz2;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 .2\u00020\u0001:\u0002%(B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0002J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH$J\b\u0010\u0011\u001a\u00020\u0007H\u0004J\b\u0010\u0013\u001a\u00020\u0012H$J\b\u0010\u0014\u001a\u00020\u0012H$J\b\u0010\u0015\u001a\u00020\u0012H$J\b\u0010\u0017\u001a\u00020\u0016H$J\b\u0010\u0019\u001a\u00020\u0018H$J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H$J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH$J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH$J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0004R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&\u00a8\u0006/"}, d2 = {"Lsz2/d;", "", "Ljava/lang/Runnable;", DomainData.DOMAIN_NAME, "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "callback", "", "w", "l", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "u", "v", HippyTKDListViewAdapter.X, "Lsz2/d$b;", "showAdCallback", ReportConstant.COSTREPORT_PREFIX, "t", "", "g", tl.h.F, "f", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", "j", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "i", "rsp", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "serviceCode", "", "errMsg", "p", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRequestingAd", "b", "isShowingAd", "c", "isReportingAd", "<init>", "()V", "d", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile AtomicBoolean isRequestingAd = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile AtomicBoolean isShowingAd = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile AtomicBoolean isReportingAd = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lsz2/d$b;", "", "", "success", "", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(boolean success);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"sz2/d$c", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements bz2.a<adv_report.MobileAdvReportRsp> {
        c() {
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            d.this.p(code, errMsg);
            d.this.isReportingAd.set(false);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull adv_report.MobileAdvReportRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            d.this.q(rsp);
            d.this.isReportingAd.set(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"sz2/d$d", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sz2.d$d, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C11263d implements bz2.a<vac_adv_get.VacAdvRsp> {
        C11263d() {
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            d.this.p(code, errMsg);
            d.this.isRequestingAd.set(false);
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull vac_adv_get.VacAdvRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            d.this.r(rsp);
            d.this.isRequestingAd.set(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"sz2/d$e", "Lsz2/d$b;", "", "success", "", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements b {
        e() {
        }

        @Override // sz2.d.b
        public void a(boolean success) {
            d.this.isShowingAd.set(false);
            if (QLog.isColorLevel()) {
                QLog.d("VasRewardAdBaseService", 2, "show ad result: " + success);
            }
        }
    }

    private final Runnable l() {
        return new Runnable() { // from class: sz2.c
            @Override // java.lang.Runnable
            public final void run() {
                d.m(d.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isReportingAd.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("VasRewardAdBaseService", 2, "repeating report ad, discard");
            }
        } else {
            if (!this$0.f()) {
                this$0.isReportingAd.set(false);
                if (QLog.isColorLevel()) {
                    QLog.d("VasRewardAdBaseService", 2, "reportAd: early return, beforeReportAd failed");
                    return;
                }
                return;
            }
            this$0.u(new c());
        }
    }

    private final Runnable n() {
        return new Runnable() { // from class: sz2.b
            @Override // java.lang.Runnable
            public final void run() {
                d.o(d.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isRequestingAd.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("VasRewardAdBaseService", 2, "repeating request ad, discard");
            }
        } else {
            if (!this$0.g()) {
                this$0.isRequestingAd.set(false);
                if (QLog.isColorLevel()) {
                    QLog.d("VasRewardAdBaseService", 2, "requestAd: early return, beforeRequestAd failed");
                    return;
                }
                return;
            }
            this$0.w(new C11263d());
        }
    }

    private final void u(bz2.a<adv_report.MobileAdvReportRsp> callback) {
        com.tencent.mobileqq.vas.adv.base.service.e.f307985a.r(i(), callback);
    }

    private final void w(bz2.a<vac_adv_get.VacAdvRsp> callback) {
        com.tencent.mobileqq.vas.adv.base.service.e.f307985a.u(j(), callback);
    }

    protected abstract boolean f();

    protected abstract boolean g();

    protected abstract boolean h();

    @NotNull
    protected abstract adv_report.MobileAdvReportReq i();

    @NotNull
    protected abstract vac_adv_get.VacAdvReq j();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final qq_ad_get.QQAdGet.DeviceInfo k() {
        return VasAdvSupport.INSTANCE.a().getDeviceInfo();
    }

    protected abstract void p(@NotNull VasAdvServiceCode serviceCode, @NotNull String errMsg);

    protected abstract void q(@NotNull adv_report.MobileAdvReportRsp rsp);

    protected abstract void r(@NotNull vac_adv_get.VacAdvRsp rsp);

    protected abstract void s(@NotNull b showAdCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t() {
        c.a.a(VasAdvSupport.INSTANCE.a(), l(), true, false, 4, null);
    }

    public final void v() {
        c.a.a(VasAdvSupport.INSTANCE.a(), n(), true, false, 4, null);
    }

    public final void x() {
        if (!this.isShowingAd.compareAndSet(false, true)) {
            if (QLog.isColorLevel()) {
                QLog.d("VasRewardAdBaseService", 2, "repeating show ad, discard");
            }
        } else {
            if (!h()) {
                this.isShowingAd.set(false);
                if (QLog.isColorLevel()) {
                    QLog.d("VasRewardAdBaseService", 2, "showAd: early return, beforeShowAd failed");
                    return;
                }
                return;
            }
            s(new e());
        }
    }
}
