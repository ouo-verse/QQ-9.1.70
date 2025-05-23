package um0;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.report;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J@\u0010\u000f\u001a\u00020\u0006\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\u001c\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004J\u001c\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00152\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u00a8\u0006\u0019"}, d2 = {"Lum0/c;", "", "Ltencent/gdt/report$UserActionReportRsp;", "reportRsp", "Lsm0/b;", "callback", "", "e", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errCode", "", "errMsg", "", "d", "c", "Ltencent/gdt/access$AdGetReq;", Const.BUNDLE_KEY_REQUEST, "Ltencent/gdt/access$AdGetRsp;", "g", "Ltencent/gdt/report$UserActionReportReq;", "f", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f439206a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"um0/c$a", "Lsm0/c;", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "", "errMsg", "", "e", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements sm0.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sm0.b<report.UserActionReportRsp> f439207a;

        a(sm0.b<report.UserActionReportRsp> bVar) {
            this.f439207a = bVar;
        }

        @Override // sm0.c
        public void a(@NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            c.f439206a.d(this.f439207a, VasAdvServiceCode.REQUEST_CMD_ERROR, "report ad onError: " + errMsg, e16);
        }

        @Override // sm0.c
        public void b(@NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                report.UserActionReportRsp userActionReportRsp = new report.UserActionReportRsp();
                userActionReportRsp.mergeFrom(rspBytes);
                c.f439206a.e(userActionReportRsp, this.f439207a);
            } catch (Exception e16) {
                c.f439206a.d(this.f439207a, VasAdvServiceCode.REQUEST_RSP_PARSE_ERR, "parse rsp exception: " + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"um0/c$b", "Lsm0/c;", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "", "errMsg", "", "e", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements sm0.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sm0.b<access.AdGetRsp> f439208a;

        b(sm0.b<access.AdGetRsp> bVar) {
            this.f439208a = bVar;
        }

        @Override // sm0.c
        public void a(@NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            c.f439206a.d(this.f439208a, VasAdvServiceCode.REQUEST_CMD_ERROR, "request ad onError: " + errMsg, e16);
        }

        @Override // sm0.c
        public void b(@NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                access.AdGetRsp adGetRsp = new access.AdGetRsp();
                adGetRsp.mergeFrom(rspBytes);
                boolean has = adGetRsp.qq_ad_get_rsp.has();
                if (has) {
                    this.f439208a.a(adGetRsp);
                } else if (!has) {
                    sm0.b<access.AdGetRsp> bVar = this.f439208a;
                    VasAdvServiceCode vasAdvServiceCode = VasAdvServiceCode.REQUEST_RSP_FAIL;
                    String str = adGetRsp.ret_msg.err_msg.get();
                    Intrinsics.checkNotNullExpressionValue(str, "gdtAdRsp.ret_msg.err_msg.get()");
                    bVar.b(vasAdvServiceCode, str, null);
                }
            } catch (Exception e16) {
                c.f439206a.d(this.f439208a, VasAdvServiceCode.REQUEST_RSP_PARSE_ERR, "parse rsp exception: " + e16.getMessage(), e16);
            }
        }
    }

    c() {
    }

    private final String c() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends MessageMicro<T>> void d(sm0.b<T> callback, VasAdvServiceCode errCode, String errMsg, Throwable e16) {
        callback.b(errCode, errMsg, e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(report.UserActionReportRsp reportRsp, sm0.b<report.UserActionReportRsp> callback) {
        boolean has = reportRsp.has();
        if (has) {
            callback.a(reportRsp);
        } else if (!has) {
            VasAdvServiceCode vasAdvServiceCode = VasAdvServiceCode.REQUEST_RSP_FAIL;
            String str = reportRsp.ret_msg.err_msg.get();
            Intrinsics.checkNotNullExpressionValue(str, "reportRsp.ret_msg.err_msg.get()");
            callback.b(vasAdvServiceCode, str, null);
        }
    }

    public final void f(@NotNull report.UserActionReportReq request, @NotNull sm0.b<report.UserActionReportRsp> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = request.toByteArray();
            vm0.a.INSTANCE.a("trpc.commercial.dataworks.UserActionReport_sso.SsoReport", c(), byteArray, new a(callback));
        } catch (Throwable th5) {
            d(callback, VasAdvServiceCode.CREATE_REQUEST_ERR, "create ad report error, abort report ad", th5);
            QLog.e("GdtAdvService", 1, "create ad report error, abort report ad", th5);
        }
    }

    public final void g(@NotNull access.AdGetReq request, @NotNull sm0.b<access.AdGetRsp> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = request.toByteArray();
            vm0.a.INSTANCE.a("trpc.commercial.access.access_sso.SsoAdGet", c(), byteArray, new b(callback));
        } catch (Throwable th5) {
            d(callback, VasAdvServiceCode.CREATE_REQUEST_ERR, "create request ad error, abort request ad", th5);
            QLog.e("GdtAdvService", 1, "create request ad error, abort request ad", th5);
        }
    }
}
