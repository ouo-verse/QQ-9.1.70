package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lyb4/c;", "", "Lgv4/a;", "req", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lgv4/b;", "callback", "", "source", "", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a */
    public static final c f450054a = new c();

    c() {
    }

    public final void a(gv4.a req, com.tencent.mobileqq.zootopia.api.e<gv4.b> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.reddot_server.RedDotServer", "ClearUserCenterReddotData", byteArray, emptyMap, new a(callback), source, 0, 128, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/c$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<gv4.b> f450055a;

        a(com.tencent.mobileqq.zootopia.api.e<gv4.b> eVar) {
            this.f450055a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f450055a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            gv4.b bVar;
            if (data == null) {
                this.f450055a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                bVar = gv4.b.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                bVar = null;
            }
            if (bVar == null) {
                this.f450055a.onResultFailure(-13, str);
            } else {
                this.f450055a.onResultSuccess(bVar);
            }
        }
    }

    public static /* synthetic */ void b(c cVar, gv4.a aVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        cVar.a(aVar, eVar, i3);
    }
}
