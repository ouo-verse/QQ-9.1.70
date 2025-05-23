package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardTitleData;
import com.tencent.sqshow.zootopia.data.ZootopiaTabConfigData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pv4.r;
import r84.ZootopiaBrandMallListData;
import uv4.o;
import uv4.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lyb4/k;", "", "", "needHeaderCards", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/p;", "callback", "", "a", "", "I", "getSource", "()I", "source", "<init>", "(I)V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lyb4/k$a;", "", "Luv4/p;", "netRsp", "Lr84/b;", "a", "", "ERROR_CODE_APP_ERROR", "I", "", "METHOD_GET_BRAND_MALL", "Ljava/lang/String;", "NO_ERROR_CODE", "REQ_SERVICE", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yb4.k$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaBrandMallListData a(p netRsp) {
            List list;
            Intrinsics.checkNotNullParameter(netRsp, "netRsp");
            ArrayList arrayList = new ArrayList();
            int length = netRsp.f440435a.length;
            for (int i3 = 0; i3 < length; i3++) {
                ZootopiaCardData.Companion companion = ZootopiaCardData.INSTANCE;
                r rVar = netRsp.f440435a[i3];
                Intrinsics.checkNotNullExpressionValue(rVar, "netRsp.moduleList[originalIndex]");
                String str = netRsp.f440436b;
                Intrinsics.checkNotNullExpressionValue(str, "netRsp.tabConfig");
                arrayList.add(ZootopiaCardData.Companion.b(companion, rVar, new ZootopiaTabConfigData(str), i3, 0, null, 24, null));
            }
            String str2 = netRsp.f440436b;
            Intrinsics.checkNotNullExpressionValue(str2, "netRsp.tabConfig");
            ZootopiaTabConfigData zootopiaTabConfigData = new ZootopiaTabConfigData(str2);
            uv4.d dVar = netRsp.f440437c;
            ZootopiaCardTitleData zootopiaCardTitleData = new ZootopiaCardTitleData(dVar.f440399a, dVar.f440400b);
            pu4.b[] bVarArr = netRsp.f440437c.f440401c;
            Intrinsics.checkNotNullExpressionValue(bVarArr, "netRsp.storeInfo.list");
            list = ArraysKt___ArraysKt.toList(bVarArr);
            return new ZootopiaBrandMallListData(arrayList, zootopiaTabConfigData, zootopiaCardTitleData, list);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/k$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<p> f450091a;

        b(com.tencent.mobileqq.zootopia.api.e<p> eVar) {
            this.f450091a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaStoreService", 1, "getBrandMallInfoList -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450091a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                p rsp = p.c(data);
                QLog.i("ZootopiaStoreService", 1, "getBrandMallInfoList rsp callback");
                com.tencent.mobileqq.zootopia.api.e<p> eVar = this.f450091a;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                eVar.onResultSuccess(rsp);
            } catch (Exception e16) {
                QLog.e("ZootopiaStoreService", 1, "getBrandMallInfoList throw e:" + e16.getMessage(), e16);
            }
        }
    }

    public k(int i3) {
        this.source = i3;
    }

    public final void a(boolean needHeaderCards, com.tencent.mobileqq.zootopia.api.e<p> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppInterface appInterface = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getAppInterface();
        if (appInterface == null) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
            return;
        }
        o oVar = new o();
        oVar.f440434a = needHeaderCards;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(oVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.store_conf_svr.StoreConfSvr", "GetBrandMallInfo", byteArray, emptyMap, new b(callback), this.source, 0, 128, null);
    }
}
