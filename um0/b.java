package um0;

import com.tencent.gdtad.params.GdtSsoReportMiniParam;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.report;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lum0/b;", "", "", "isMiniAdReport", "Ljava/lang/Runnable;", "e", "Ltencent/gdt/report$UserActionReportReq;", "d", "c", "", "i", "j", "Lcom/tencent/gdtad/params/GdtSsoReportParam;", "param", "Lsm0/a;", "callback", h.F, "Lcom/tencent/gdtad/params/GdtSsoReportMiniParam;", "g", "b", "Lcom/tencent/gdtad/params/GdtSsoReportParam;", "mReportParams", "Lcom/tencent/gdtad/params/GdtSsoReportMiniParam;", "mReportMiniParams", "Ljava/util/HashSet;", "", "Ljava/util/HashSet;", "mReportedAdExposureSet", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f439202a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static GdtSsoReportParam mReportParams = new GdtSsoReportParam.Builder().build();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static GdtSsoReportMiniParam mReportMiniParams = new GdtSsoReportMiniParam.Builder().build();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashSet<String> mReportedAdExposureSet = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"um0/b$a", "Lsm0/b;", "Ltencent/gdt/report$UserActionReportRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements sm0.b<report.UserActionReportRsp> {
        a() {
        }

        @Override // sm0.b
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            b.b();
            if (QLog.isColorLevel()) {
                QLog.d("GdtAdReportService", 2, "onError errMsg:" + errMsg);
            }
        }

        @Override // sm0.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull report.UserActionReportRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            report.RetMsg retMsg = rsp.ret_msg.get();
            if (QLog.isColorLevel()) {
                QLog.d("GdtAdReportService", 2, "onSuccess code:" + retMsg.ret_code.get());
            }
            b.b();
        }
    }

    b() {
    }

    public static final /* synthetic */ sm0.a b() {
        return null;
    }

    private final report.UserActionReportReq c() {
        report.UserActionReportReq userActionReportReq = new report.UserActionReportReq();
        userActionReportReq.busi_type.set(mReportMiniParams.getBusiType());
        userActionReportReq.adid.set(mReportMiniParams.getAid());
        userActionReportReq.action_type.set(mReportMiniParams.getActionType());
        userActionReportReq.action_time.set(mReportMiniParams.getActionTime());
        userActionReportReq.os_type.set(mReportMiniParams.getOsType());
        userActionReportReq.qq_ver.set(mReportMiniParams.getQqVer());
        userActionReportReq.app_id.set(mReportMiniParams.getAppId());
        return userActionReportReq;
    }

    private final report.UserActionReportReq d() {
        report.UserActionReportReq userActionReportReq = new report.UserActionReportReq();
        userActionReportReq.busi_type.set(mReportParams.getBusiType());
        userActionReportReq.adid.set(mReportParams.getAid());
        userActionReportReq.adpos_type.set(mReportParams.getAdPosType());
        userActionReportReq.action_time.set(mReportParams.getActionTime());
        userActionReportReq.feeds_index.set(mReportParams.getFeedsIndex());
        userActionReportReq.experiment_id.set(mReportParams.getExperimentId());
        userActionReportReq.attachment.set(mReportParams.getAttachment());
        userActionReportReq.adpos_id.set(mReportParams.getAdPosId());
        userActionReportReq.trace_id.set(mReportParams.getTraceId());
        userActionReportReq.action_type.set(mReportParams.getActionType());
        userActionReportReq.os_type.set(mReportParams.getOsType());
        userActionReportReq.qq_ver.set(mReportParams.getQqVer());
        return userActionReportReq;
    }

    private final Runnable e(final boolean isMiniAdReport) {
        return new Runnable() { // from class: um0.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f(isMiniAdReport);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(boolean z16) {
        a aVar = new a();
        if (!z16) {
            c.f439206a.f(f439202a.d(), aVar);
        } else {
            c.f439206a.f(f439202a.c(), aVar);
        }
    }

    public final void g(@NotNull GdtSsoReportMiniParam param, @Nullable sm0.a callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.d("GdtAdReportService", 1, "initMiniParams");
        mReportMiniParams = param;
    }

    public final void h(@NotNull GdtSsoReportParam param, @Nullable sm0.a callback) {
        Intrinsics.checkNotNullParameter(param, "param");
        mReportParams = param;
    }

    public final void i() {
        d.b(d.f439209a, e(false), true, false, 4, null);
    }

    public final void j() {
        d.b(d.f439209a, e(true), true, false, 4, null);
    }
}
