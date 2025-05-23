package qc3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.util.List;
import java.util.Map;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import xu4.c;
import xu4.d;
import xu4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J,\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002J*\u0010\u0012\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002\u00a8\u0006\u0015"}, d2 = {"Lqc3/a;", "", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "Lcom/tencent/common/app/AppInterface;", "a", "", "factType", "duration", "Lkc3/a;", "params", "Lxu4/c;", "", "b", "", "Lxu4/f;", "reportInfoList", "Lxu4/e;", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f428847a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"qc3/a$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qc3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11071a implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<c> f428848a;

        C11071a(e<c> eVar) {
            this.f428848a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("MinorsReqUtils_", 1, "judgeLogin errCode:" + errCode + ", errMsg:" + errMsg);
            this.f428848a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f428848a.onResultFailure(-10, "rsp is null");
                QLog.e("MinorsReqUtils_", 1, "judgeLogin error! data is null!");
                return;
            }
            try {
                e<c> eVar = this.f428848a;
                c c16 = c.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Exception e16) {
                QLog.e("MinorsReqUtils_", 1, "judgeLogin throw e:" + e16.getMessage(), e16);
                this.f428848a.onResultFailure(-13, e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"qc3/a$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<xu4.e> f428849a;

        b(e<xu4.e> eVar) {
            this.f428849a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("MinorsReqUtils_", 1, "reportInsExeBatch errCode:" + errCode + ", errMsg:" + errMsg);
            this.f428849a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f428849a.onResultFailure(-10, "rsp is null");
                QLog.e("MinorsReqUtils_", 1, "reportInsExeBatch error! data is null!");
                return;
            }
            try {
                e<xu4.e> eVar = this.f428849a;
                xu4.e c16 = xu4.e.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Exception e16) {
                QLog.e("MinorsReqUtils_", 1, "reportInsExeBatch throw e:" + e16.getMessage(), e16);
                this.f428849a.onResultFailure(-13, e16.getMessage());
            }
        }
    }

    a() {
    }

    private final AppInterface a(e<?> callback) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        boolean z16 = waitAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        if (z16) {
            return (AppInterface) waitAppRuntime;
        }
        return null;
    }

    public final void c(List<f> reportInfoList, GameJudgeParams params, e<xu4.e> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(reportInfoList, "reportInfoList");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface a16 = a(callback);
        if (a16 == null) {
            return;
        }
        d dVar = new d();
        int i3 = 0;
        Object[] array = reportInfoList.toArray(new f[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        f[] fVarArr = (f[]) array;
        dVar.f448724a = fVarArr;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "req.reportList");
        int length = fVarArr.length;
        int i16 = 0;
        while (i3 < length) {
            f reportInfo = fVarArr[i3];
            Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
            QLog.i("MinorsReqUtils_", 1, "reportInsExeBatch " + i16 + " " + mc3.b.c(reportInfo));
            i3++;
            i16++;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(dVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, a16, "trpc.metaverse.minors_protection_svr.MinorsProtectionSvr", "ReportExecuteBatch", byteArray, emptyMap, new b(callback), params.getSource(), 0, 128, null);
    }

    public final void b(int factType, int duration, GameJudgeParams params, e<c> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface a16 = a(callback);
        if (a16 == null) {
            return;
        }
        xu4.b bVar = new xu4.b();
        bVar.f448713a = params.getOpenId();
        bVar.f448714b = params.getAccessToken();
        bVar.f448715c = "";
        String qimei = QQDeviceInfo.getQIMEI();
        bVar.f448716d = qimei;
        bVar.f448717e = factType;
        bVar.f448718f = duration;
        QLog.i("MinorsReqUtils_", 1, "judgeTiming factType:" + factType + ", duration:" + duration + ", openid:" + bVar.f448713a + ", deviceid:" + bVar.f448715c + ", qimei:" + qimei);
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, a16, "trpc.metaverse.minors_protection_svr.MinorsProtectionSvr", "JudgeTiming", byteArray, emptyMap, new C11071a(callback), params.getSource(), 0, 128, null);
    }
}
