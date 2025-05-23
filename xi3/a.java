package xi3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nw4.c;
import nw4.d;
import nw4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a8\u0006\u000f"}, d2 = {"Lxi3/a;", "", "", "mapId", "", "mapVersion", "Lnw4/g;", "a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lnw4/d;", "callback", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f448031a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"xi3/a$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xi3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11550a implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<d> f448032a;

        C11550a(e<d> eVar) {
            this.f448032a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("GetBaseModInfoRequest", 1, "GetBaseModInfoRequest error " + errCode + ", " + errMsg);
            e<d> eVar = this.f448032a;
            if (eVar != null) {
                eVar.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
            }
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                QLog.e("GetBaseModInfoRequest", 1, "GetBaseModInfoRequest error, data is null");
                e<d> eVar = this.f448032a;
                if (eVar != null) {
                    eVar.onResultFailure(-1, "CheckPhoneRequest error, data is null");
                    return;
                }
                return;
            }
            d rsp = d.c(data);
            e<d> eVar2 = this.f448032a;
            if (eVar2 != null) {
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                eVar2.onResultSuccess(rsp);
            }
            QLog.i("GetBaseModInfoRequest", 1, "GetBaseModInfoRequest success, data size is " + rsp.f421467c.length);
        }
    }

    a() {
    }

    private final g a(int mapId, String mapVersion) {
        g gVar = new g();
        gVar.f421479a = mapId;
        gVar.f421480b = mapVersion;
        return gVar;
    }

    public final void b(int mapId, String mapVersion, e<d> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(mapVersion, "mapVersion");
        QLog.i("GetBaseModInfoRequest", 1, "GetBaseModInfoRequest :: start request mapId == " + mapId + " , mapVersion == " + mapVersion);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        c cVar = new c();
        cVar.f421464a = new g[]{a(mapId, mapVersion)};
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(cVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(request)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.wuji_data_proxy.WujiDataProxy", "GetPlatFormBaseSourceConf", byteArray, emptyMap, new C11550a(callback), 0, 0, 192, null);
    }
}
