package va4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import uv4.bo;
import uv4.bp;
import uv4.bu;
import uv4.bv;
import uv4.m;
import uv4.n;
import uv4.x;
import uv4.y;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00172\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u001a2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a8\u0006\u001f"}, d2 = {"Lva4/a;", "", "Luv4/f;", "req", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/g;", "callback", "", "source", "", "e", "Luv4/b;", "Luv4/c;", "a", "Luv4/bo;", "Luv4/bp;", "k", "Luv4/x;", "Luv4/y;", "i", "Luv4/bu;", "Luv4/bv;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Luv4/m;", "Luv4/n;", "g", "Lbw4/a;", "Lbw4/c;", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a */
    public static final a f441274a = new a();

    a() {
    }

    public final void a(uv4.b req, com.tencent.mobileqq.zootopia.api.e<uv4.c> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.store_conf_svr.StoreConfSvr", "BatchGetStoreItem", byteArray, emptyMap, new C11406a(callback), source, 0, 128, null);
    }

    public final void c(bw4.a req, com.tencent.mobileqq.zootopia.api.e<bw4.c> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.zplan.unified_store.UnifiedStore", "Buy", byteArray, emptyMap, new b(callback), source, 0, 128, null);
    }

    public final void e(uv4.f req, com.tencent.mobileqq.zootopia.api.e<uv4.g> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.store_conf_svr.StoreConfSvr", "BuyStoreItem", byteArray, emptyMap, new c(callback), source, 0, 128, null);
    }

    public final void g(m req, com.tencent.mobileqq.zootopia.api.e<n> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.store_conf_svr.StoreConfSvr", "DressAvatar", byteArray, emptyMap, new d(callback), source, 0, 128, null);
    }

    public final void i(x req, com.tencent.mobileqq.zootopia.api.e<y> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.store_conf_svr.StoreConfSvr", "GetStoreColorCfg", byteArray, emptyMap, new e(callback), source, 0, 128, null);
    }

    public final void k(bo req, com.tencent.mobileqq.zootopia.api.e<bp> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.store_conf_svr.StoreConfSvr", "UpdateAvatarCharacter", byteArray, emptyMap, new f(callback), source, 0, 128, null);
    }

    public final void m(bu req, com.tencent.mobileqq.zootopia.api.e<bv> callback, int i3) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.store_conf_svr.StoreConfSvr", "UseExperienceCard", byteArray, emptyMap, new g(callback), i3, 0, 128, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"va4/a$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: va4.a$a */
    /* loaded from: classes36.dex */
    public static final class C11406a implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<uv4.c> f441275a;

        C11406a(com.tencent.mobileqq.zootopia.api.e<uv4.c> eVar) {
            this.f441275a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f441275a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            uv4.c cVar;
            if (data == null) {
                this.f441275a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                cVar = uv4.c.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                cVar = null;
            }
            if (cVar == null) {
                this.f441275a.onResultFailure(-13, str);
            } else {
                this.f441275a.onResultSuccess(cVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"va4/a$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bw4.c> f441276a;

        b(com.tencent.mobileqq.zootopia.api.e<bw4.c> eVar) {
            this.f441276a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f441276a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            bw4.c cVar;
            if (data == null) {
                this.f441276a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                cVar = bw4.c.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                cVar = null;
            }
            if (cVar == null) {
                this.f441276a.onResultFailure(-13, str);
            } else {
                this.f441276a.onResultSuccess(cVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"va4/a$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<uv4.g> f441277a;

        c(com.tencent.mobileqq.zootopia.api.e<uv4.g> eVar) {
            this.f441277a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f441277a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            uv4.g gVar;
            if (data == null) {
                this.f441277a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                gVar = uv4.g.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                gVar = null;
            }
            if (gVar == null) {
                this.f441277a.onResultFailure(-13, str);
            } else {
                this.f441277a.onResultSuccess(gVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"va4/a$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<n> f441278a;

        d(com.tencent.mobileqq.zootopia.api.e<n> eVar) {
            this.f441278a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f441278a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            n nVar;
            if (data == null) {
                this.f441278a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                nVar = n.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                nVar = null;
            }
            if (nVar == null) {
                this.f441278a.onResultFailure(-13, str);
            } else {
                this.f441278a.onResultSuccess(nVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"va4/a$e", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class e implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<y> f441279a;

        e(com.tencent.mobileqq.zootopia.api.e<y> eVar) {
            this.f441279a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f441279a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            y yVar;
            if (data == null) {
                this.f441279a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                yVar = y.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                yVar = null;
            }
            if (yVar == null) {
                this.f441279a.onResultFailure(-13, str);
            } else {
                this.f441279a.onResultSuccess(yVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"va4/a$f", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class f implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bp> f441280a;

        f(com.tencent.mobileqq.zootopia.api.e<bp> eVar) {
            this.f441280a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f441280a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            bp bpVar;
            if (data == null) {
                this.f441280a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                bpVar = bp.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                bpVar = null;
            }
            if (bpVar == null) {
                this.f441280a.onResultFailure(-13, str);
            } else {
                this.f441280a.onResultSuccess(bpVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"va4/a$g", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class g implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bv> f441281a;

        g(com.tencent.mobileqq.zootopia.api.e<bv> eVar) {
            this.f441281a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f441281a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            bv bvVar;
            if (data == null) {
                this.f441281a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                bvVar = bv.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                bvVar = null;
            }
            if (bvVar == null) {
                this.f441281a.onResultFailure(-13, str);
            } else {
                this.f441281a.onResultSuccess(bvVar);
            }
        }
    }

    public static /* synthetic */ void b(a aVar, uv4.b bVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.a(bVar, eVar, i3);
    }

    public static /* synthetic */ void d(a aVar, bw4.a aVar2, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.c(aVar2, eVar, i3);
    }

    public static /* synthetic */ void f(a aVar, uv4.f fVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.e(fVar, eVar, i3);
    }

    public static /* synthetic */ void h(a aVar, m mVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.g(mVar, eVar, i3);
    }

    public static /* synthetic */ void j(a aVar, x xVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.i(xVar, eVar, i3);
    }

    public static /* synthetic */ void l(a aVar, bo boVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.k(boVar, eVar, i3);
    }

    public static /* synthetic */ void n(a aVar, bu buVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.m(buVar, eVar, i3);
    }
}
