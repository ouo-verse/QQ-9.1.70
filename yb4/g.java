package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004J\u0014\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lyb4/g;", "", "", "activityId", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "", "a", "b", "", "I", "getSource", "()I", "source", "<init>", "(I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/g$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Object> f450077a;

        b(com.tencent.mobileqq.zootopia.api.e<Object> eVar) {
            this.f450077a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaFaceAdService", 1, "notifyFaceAdHasShown -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450077a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                nw4.k rsp = nw4.k.c(data);
                com.tencent.mobileqq.zootopia.api.e<Object> eVar = this.f450077a;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                eVar.onResultSuccess(rsp);
            } catch (Exception e16) {
                QLog.e("ZootopiaFaceAdService", 1, "notifyFaceAdHasShown throw e:" + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/g$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Object> f450078a;

        c(com.tencent.mobileqq.zootopia.api.e<Object> eVar) {
            this.f450078a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaFaceAdService", 1, "notifyFaceAdTodayNotShown -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450078a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                nw4.m rsp = nw4.m.c(data);
                com.tencent.mobileqq.zootopia.api.e<Object> eVar = this.f450078a;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                eVar.onResultSuccess(rsp);
            } catch (Exception e16) {
                QLog.e("ZootopiaFaceAdService", 1, "notifyFaceAdTodayNotShown throw e:" + e16.getMessage(), e16);
            }
        }
    }

    public g(int i3) {
        this.source = i3;
    }

    public final void a(String activityId, com.tencent.mobileqq.zootopia.api.e<Object> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface appInterface = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getAppInterface();
        if (appInterface == null) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
            return;
        }
        nw4.j jVar = new nw4.j();
        jVar.f421502b = activityId;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(jVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.wuji_data_proxy.WujiDataProxy", "SlapFaceActivityPopupFinish", byteArray, emptyMap, new b(callback), this.source, 0, 128, null);
    }

    public final void b(com.tencent.mobileqq.zootopia.api.e<Object> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface appInterface = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getAppInterface();
        if (appInterface == null) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
            return;
        }
        nw4.l lVar = new nw4.l();
        lVar.f421503a = 1;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(lVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.wuji_data_proxy.WujiDataProxy", "TodayNotShowSlapFacePopup", byteArray, emptyMap, new c(callback), this.source, 0, 128, null);
    }
}
