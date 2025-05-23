package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.netprobe.EchoTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pv4.y;
import qv4.bs;
import qv4.u;
import qv4.v;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u00a8\u0006\u0014"}, d2 = {"Lyb4/m;", "", "Lqv4/v;", "rsp", "", "f", "e", "Lcom/tencent/common/app/AppInterface;", "app", "", "Lqv4/bs;", "userMapInfo", "", "source", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class m {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/m$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<v> f450122b;

        b(com.tencent.mobileqq.zootopia.api.e<v> eVar) {
            this.f450122b = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.i("ZootopiaVerStatusService", 1, "errCode" + errCode + "  " + errMsg);
            this.f450122b.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                v rsp = v.c(data);
                m mVar = m.this;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                mVar.f(rsp);
                m.this.e(rsp);
                this.f450122b.onResultSuccess(rsp);
                QLog.i("ZootopiaVerStatusService", 1, "getMapVerStatus success");
            } catch (Throwable th5) {
                QLog.e("ZootopiaVerStatusService", 1, "getShareArkInfo parse data error");
                this.f450122b.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(v rsp) {
        QRouteApi api = QRoute.api(IZPlanApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
        IZPlanApi iZPlanApi = (IZPlanApi) api;
        gw4.f[] fVarArr = rsp.f430206c;
        if (fVarArr != null) {
            for (gw4.f checkPhoneResult : fVarArr) {
                int i3 = checkPhoneResult.f403470a;
                if (i3 > 0) {
                    Intrinsics.checkNotNullExpressionValue(checkPhoneResult, "checkPhoneResult");
                    iZPlanApi.updateCheckResultCache(i3, checkPhoneResult);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(v rsp) {
        QLog.i("ZootopiaVerStatusService", 1, "updateMapStatus");
        y[] yVarArr = rsp.f430204a;
        if (yVarArr != null) {
            for (y verControlInfo : yVarArr) {
                QLog.i("ZootopiaVerStatusService", 1, "updateMapStatus verControlInfo:" + verControlInfo);
                ZootopiaMapStatusManager zootopiaMapStatusManager = ZootopiaMapStatusManager.f370743d;
                String valueOf = String.valueOf(verControlInfo.f427728a);
                Intrinsics.checkNotNullExpressionValue(verControlInfo, "verControlInfo");
                zootopiaMapStatusManager.e(valueOf, verControlInfo);
            }
        }
    }

    public final void c(AppInterface app, List<bs> userMapInfo, int source, com.tencent.mobileqq.zootopia.api.e<v> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(userMapInfo, "userMapInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        u uVar = new u();
        Object[] array = userMapInfo.toArray(new bs[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        uVar.f430203a = (bs[]) array;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(uVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, app, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetMapVerStatus", byteArray, emptyMap, new b(callback), source, 0, 128, null);
    }

    public static /* synthetic */ void d(m mVar, AppInterface appInterface, List list, int i3, com.tencent.mobileqq.zootopia.api.e eVar, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 1;
        }
        mVar.c(appInterface, list, i3, eVar);
    }
}
