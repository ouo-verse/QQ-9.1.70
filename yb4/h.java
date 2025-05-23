package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qv4.bl;
import qv4.bm;
import qv4.bn;
import qv4.bo;
import qv4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J.\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJ,\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002J&\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002\u00a8\u0006\u0017"}, d2 = {"Lyb4/h;", "", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "Lcom/tencent/common/app/AppInterface;", "a", "", "source", "", "Lpv4/f;", "", "groupIdList", "", "b", "id", "stepNum", "", "c", "skipAll", "Lqv4/bo;", "d", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/h$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<List<pv4.f>> f450080a;

        b(com.tencent.mobileqq.zootopia.api.e<List<pv4.f>> eVar) {
            this.f450080a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaGuideService", 1, "getGuideStatus -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450080a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        
            r4 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r4);
         */
        @Override // td3.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(byte[] data) {
            List<pv4.f> emptyList;
            try {
                n c16 = n.c(data);
                com.tencent.mobileqq.zootopia.api.e<List<pv4.f>> eVar = this.f450080a;
                pv4.f[] fVarArr = c16.f430187a;
                if (fVarArr == null || emptyList == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                eVar.onResultSuccess(emptyList);
            } catch (Exception e16) {
                QLog.e("ZootopiaGuideService", 1, "loadParadiseRecommendList throw e:" + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/h$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Boolean> f450081a;

        c(com.tencent.mobileqq.zootopia.api.e<Boolean> eVar) {
            this.f450081a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaGuideService", 1, "getGuideStatus -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450081a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                this.f450081a.onResultSuccess(Boolean.valueOf(bm.c(data) != null));
            } catch (Exception e16) {
                QLog.e("ZootopiaGuideService", 1, "loadParadiseRecommendList throw e:" + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/h$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bo> f450082a;

        d(com.tencent.mobileqq.zootopia.api.e<bo> eVar) {
            this.f450082a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaGuideService", 1, "skipGuide -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450082a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                bo rsp = bo.c(data);
                com.tencent.mobileqq.zootopia.api.e<bo> eVar = this.f450082a;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                eVar.onResultSuccess(rsp);
            } catch (Exception e16) {
                QLog.e("ZootopiaGuideService", 1, "skipGuide throw e:" + e16.getMessage(), e16);
            }
        }
    }

    private final AppInterface a(com.tencent.mobileqq.zootopia.api.e<?> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38 " + peekAppRuntime);
        }
        if (z16) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    public final void b(int source, com.tencent.mobileqq.zootopia.api.e<List<pv4.f>> callback, int[] groupIdList) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface a16 = a(callback);
        if (a16 == null) {
            return;
        }
        qv4.m mVar = new qv4.m();
        mVar.f430186a = groupIdList;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(mVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, a16, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetGuideStatus", byteArray, emptyMap, new b(callback), source, 0, 128, null);
    }

    public final void d(int[] groupIdList, boolean skipAll, com.tencent.mobileqq.zootopia.api.e<bo> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(groupIdList, "groupIdList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface a16 = a(callback);
        if (a16 == null) {
            return;
        }
        bn bnVar = new bn();
        bnVar.f430089a = groupIdList;
        bnVar.f430090b = skipAll;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(bnVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, a16, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "SkipGuide", byteArray, emptyMap, new d(callback), 0, 0, 192, null);
    }

    public final void c(int source, int id5, int stepNum, com.tencent.mobileqq.zootopia.api.e<Boolean> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface a16 = a(callback);
        if (a16 == null) {
            return;
        }
        bl blVar = new bl();
        blVar.f430087b = id5;
        blVar.f430088c = stepNum;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(blVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, a16, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "SetGuideStatus", byteArray, emptyMap, new c(callback), source, 0, 128, null);
    }
}
