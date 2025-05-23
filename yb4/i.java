package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J$\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u001c\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\bJ\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\b\u00a8\u0006\u001b"}, d2 = {"Lyb4/i;", "", "", "f", "Lgv4/d;", "netRsp", "Lcom/tencent/sqshow/zootopia/data/q;", "d", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "Lcom/tencent/common/app/AppInterface;", "e", "", "", "reddotIds", "", "g", "templateId", "Lvu4/b;", "b", "dataType", "", "res", "c", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/i$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<vu4.b> f450084a;

        b(com.tencent.mobileqq.zootopia.api.e<vu4.b> eVar) {
            this.f450084a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaReddotService", 1, "clearReddot -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450084a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                vu4.b rsp = vu4.b.c(data);
                com.tencent.mobileqq.zootopia.api.e<vu4.b> eVar = this.f450084a;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                eVar.onResultSuccess(rsp);
            } catch (Exception e16) {
                QLog.e("ZootopiaReddotService", 1, "clearReddot throw e:" + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"yb4/i$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lgv4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<gv4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Boolean> f450085d;

        c(com.tencent.mobileqq.zootopia.api.e<Boolean> eVar) {
            this.f450085d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(gv4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f450085d.onResultSuccess(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f450085d.onResultFailure(error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/i$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<q> f450086a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f450087b;

        d(com.tencent.mobileqq.zootopia.api.e<q> eVar, i iVar) {
            this.f450086a = eVar;
            this.f450087b = iVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaReddotService", 1, "loadRedDot -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450086a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                gv4.d rsp = gv4.d.c(data);
                com.tencent.mobileqq.zootopia.api.e<q> eVar = this.f450086a;
                i iVar = this.f450087b;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                eVar.onResultSuccess(iVar.d(rsp));
            } catch (Exception e16) {
                QLog.e("ZootopiaReddotService", 1, "loadRedDot throw e:" + e16.getMessage(), e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q d(gv4.d netRsp) {
        gv4.e[] eVarArr = netRsp.f403423a;
        Intrinsics.checkNotNullExpressionValue(eVarArr, "netRsp.redDotDataList");
        ArrayList arrayList = new ArrayList(eVarArr.length);
        for (gv4.e eVar : eVarArr) {
            arrayList.add(eVar);
        }
        return new q(arrayList);
    }

    private final AppInterface e(com.tencent.mobileqq.zootopia.api.e<?> callback) {
        AppInterface appInterface = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getAppInterface();
        if (appInterface == null) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
        }
        return appInterface;
    }

    private final long f() {
        Long longOrNull;
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount == null) {
            return 0L;
        }
        String uin = firstSimpleAccount.getUin();
        Intrinsics.checkNotNullExpressionValue(uin, "simpleAccount.uin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public final void b(long templateId, com.tencent.mobileqq.zootopia.api.e<vu4.b> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface e16 = e(callback);
        if (e16 == null) {
            return;
        }
        vu4.a aVar = new vu4.a();
        ArrayList arrayList = new ArrayList();
        vu4.c cVar = new vu4.c();
        arrayList.add(cVar);
        ArrayList arrayList2 = new ArrayList();
        new vu4.d();
        vu4.d dVar = new vu4.d();
        dVar.f443568a = "tab";
        dVar.f443569b = String.valueOf(templateId);
        arrayList2.add(dVar);
        cVar.f443566l = "template_tab_redpoint_click";
        Object[] array = arrayList2.toArray(new vu4.d[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        cVar.f443565k = (vu4.d[]) array;
        cVar.f443555a = f();
        Object[] array2 = arrayList.toArray(new vu4.c[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        aVar.f443551a = (vu4.c[]) array2;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, e16, "trpc.metaverse.log_api_server.LogApiService", "ApiReport", byteArray, emptyMap, new b(callback), 0, 0, 192, null);
    }

    public final void c(int dataType, com.tencent.mobileqq.zootopia.api.e<Boolean> res) {
        Intrinsics.checkNotNullParameter(res, "res");
        gv4.a aVar = new gv4.a();
        aVar.f403421a = dataType;
        yb4.c.b(yb4.c.f450054a, aVar, new c(res), 0, 4, null);
    }

    public final void g(List<Integer> reddotIds, com.tencent.mobileqq.zootopia.api.e<q> callback) {
        int[] intArray;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface e16 = e(callback);
        if (e16 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (reddotIds != null) {
            arrayList.addAll(reddotIds);
        }
        gv4.c cVar = new gv4.c();
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        cVar.f403422a = intArray;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(cVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, e16, "trpc.metaverse.reddot_server.RedDotServer", "GetPortalRedDot", byteArray, emptyMap, new d(callback, this), 0, 0, 192, null);
    }
}
