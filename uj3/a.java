package uj3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qv4.ac;
import qv4.ad;
import qv4.ax;
import qv4.ay;
import qv4.be;
import qv4.bf;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a8\u0006\u0016"}, d2 = {"Luj3/a;", "", "Lqv4/be;", "req", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bf;", "callback", "", "source", "", "g", "Lqv4/a;", "Lqv4/b;", "a", "Lqv4/ac;", "Lqv4/ad;", "c", "Lqv4/ax;", "Lqv4/ay;", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a */
    public static final a f439091a = new a();

    a() {
    }

    public final void a(qv4.a req, e<qv4.b> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "CancelReserve", byteArray, emptyMap, new C11355a(callback), source, 0, 128, null);
    }

    public final void c(ac req, e<ad> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetReserveList", byteArray, emptyMap, new b(callback), source, 0, 128, null);
    }

    public final void e(ax req, e<ay> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "ModifyReserveConfig", byteArray, emptyMap, new c(callback), source, 0, 128, null);
    }

    public final void g(be req, e<bf> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "Reserve", byteArray, emptyMap, new d(callback), source, 0, 128, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"uj3/a$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uj3.a$a */
    /* loaded from: classes36.dex */
    public static final class C11355a implements td3.a {

        /* renamed from: a */
        final /* synthetic */ e<qv4.b> f439092a;

        C11355a(e<qv4.b> eVar) {
            this.f439092a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f439092a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            qv4.b bVar;
            if (data == null) {
                this.f439092a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                bVar = qv4.b.c(data);
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
                this.f439092a.onResultFailure(-13, str);
            } else {
                this.f439092a.onResultSuccess(bVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"uj3/a$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a */
        final /* synthetic */ e<ad> f439093a;

        b(e<ad> eVar) {
            this.f439093a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f439093a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            ad adVar;
            if (data == null) {
                this.f439093a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                adVar = ad.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                adVar = null;
            }
            if (adVar == null) {
                this.f439093a.onResultFailure(-13, str);
            } else {
                this.f439093a.onResultSuccess(adVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"uj3/a$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements td3.a {

        /* renamed from: a */
        final /* synthetic */ e<ay> f439094a;

        c(e<ay> eVar) {
            this.f439094a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f439094a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            ay ayVar;
            if (data == null) {
                this.f439094a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                ayVar = ay.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                ayVar = null;
            }
            if (ayVar == null) {
                this.f439094a.onResultFailure(-13, str);
            } else {
                this.f439094a.onResultSuccess(ayVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"uj3/a$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements td3.a {

        /* renamed from: a */
        final /* synthetic */ e<bf> f439095a;

        d(e<bf> eVar) {
            this.f439095a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f439095a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            bf bfVar;
            if (data == null) {
                this.f439095a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                bfVar = bf.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                bfVar = null;
            }
            if (bfVar == null) {
                this.f439095a.onResultFailure(-13, str);
            } else {
                this.f439095a.onResultSuccess(bfVar);
            }
        }
    }

    public static /* synthetic */ void b(a aVar, qv4.a aVar2, e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.a(aVar2, eVar, i3);
    }

    public static /* synthetic */ void d(a aVar, ac acVar, e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.c(acVar, eVar, i3);
    }

    public static /* synthetic */ void f(a aVar, ax axVar, e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.e(axVar, eVar, i3);
    }

    public static /* synthetic */ void h(a aVar, be beVar, e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.g(beVar, eVar, i3);
    }
}
