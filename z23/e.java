package z23;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.data.SmallHomeInfo;
import com.tencent.mobileqq.vas.data.SmallHomeStatus;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import e33.RspErrorData;
import e33.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zu4.m;
import zu4.n;
import zu4.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ6\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\nJ*\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0016J\"\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0016\u00a8\u0006\u001b"}, d2 = {"Lz23/e;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "id", "", "isTinyId", "", "source", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/vas/data/d;", "callback", "", "b", "Lcom/tencent/mobileqq/vas/data/f;", "e", "uin", "Lcom/tencent/mobileqq/vas/data/e;", "d", "", "url", "Lkotlin/Function1;", "g", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/e$b", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements e33.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f451806a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f451806a = function1;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanVasSmallHomeService", 1, "delSmallHomeBg error " + errCode + " " + errMsg);
            this.f451806a.invoke(Boolean.FALSE);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            this.f451806a.invoke(Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/e$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f451807a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<SmallHomeInfo> f451808b;

        c(long j3, com.tencent.mobileqq.zootopia.api.e<SmallHomeInfo> eVar) {
            this.f451807a = j3;
            this.f451808b = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanVasSmallHomeService", 1, "getSmallHomeInfo fail " + errCode + ", " + errMsg);
            this.f451808b.onResultFailure(errCode != null ? errCode.intValue() : -1, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                n c16 = n.c(data);
                SmallHomeInfo smallHomeInfo = new SmallHomeInfo(this.f451807a);
                smallHomeInfo.i(c16.f453453a);
                smallHomeInfo.h(c16.f453454b);
                smallHomeInfo.j(c16.f453455c);
                smallHomeInfo.k(c16.f453456d);
                smallHomeInfo.g(c16.f453457e);
                smallHomeInfo.f(c16.f453458f);
                smallHomeInfo.l(c16.f453459g);
                this.f451808b.onResultSuccess(smallHomeInfo);
            } catch (Throwable unused) {
                QLog.e("ZplanVasSmallHomeService", 1, "GetSmallhomeInfoRsp parse data error");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/e$d", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements e33.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<com.tencent.mobileqq.vas.data.e> f451809a;

        d(com.tencent.mobileqq.zootopia.api.e<com.tencent.mobileqq.vas.data.e> eVar) {
            this.f451809a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanVasSmallHomeService", 1, "getSmallHomePageInfo error " + errCode + " " + errMsg);
            this.f451809a.onResultFailure(errCode != null ? errCode.intValue() : -1, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            try {
                com.tencent.mobileqq.vas.utils.a aVar = com.tencent.mobileqq.vas.utils.a.f311243a;
                lw4.c c16 = lw4.c.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                this.f451809a.onResultSuccess(aVar.a(c16));
            } catch (Throwable unused) {
                QLog.e("ZplanVasSmallHomeService", 1, "getSmallHomePageInfo parse data error");
                this.f451809a.onResultFailure(-1, "parse rsp error");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/e$e", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z23.e$e, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11648e implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f451810a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<SmallHomeStatus> f451811b;

        C11648e(long j3, com.tencent.mobileqq.zootopia.api.e<SmallHomeStatus> eVar) {
            this.f451810a = j3;
            this.f451811b = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanVasSmallHomeService", 1, "getSmallHomeStatus fail " + errCode + ", " + errMsg);
            this.f451811b.onResultFailure(errCode != null ? errCode.intValue() : -1, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                o c16 = o.c(data);
                SmallHomeStatus smallHomeStatus = new SmallHomeStatus(this.f451810a);
                smallHomeStatus.c(c16.f453462a);
                smallHomeStatus.b(c16.f453463b);
                this.f451811b.onResultSuccess(smallHomeStatus);
            } catch (Throwable unused) {
                QLog.e("ZplanVasSmallHomeService", 1, "GetSmallhomeStatusRsp parse data error");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/e$f", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class f implements e33.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f451812a;

        /* JADX WARN: Multi-variable type inference failed */
        f(Function1<? super Boolean, Unit> function1) {
            this.f451812a = function1;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanVasSmallHomeService", 1, "setSmallHomeBg error " + errCode + " " + errMsg);
            this.f451812a.invoke(Boolean.FALSE);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            this.f451812a.invoke(Boolean.TRUE);
        }
    }

    public final void a(AppInterface app, Function1<? super Boolean, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QRouteApi api = QRoute.api(IZplanVasProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanVasProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(new lw4.a());
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(DelWoBackgroundReq())");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZplanVasProxyServlet.a.a((IZplanVasProxyServlet) api, app, "trpc.qmeta.wo_transit_page_svr.WoTransitPageSvr", "DelWoBackground", byteArray, emptyMap, new b(callback), 0, 64, null);
    }

    public final void d(AppInterface app, long uin, com.tencent.mobileqq.zootopia.api.e<com.tencent.mobileqq.vas.data.e> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        lw4.b bVar = new lw4.b();
        bVar.f415697a = uin;
        QRouteApi api = QRoute.api(IZplanVasProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanVasProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZplanVasProxyServlet.a.a((IZplanVasProxyServlet) api, app, "trpc.qmeta.wo_transit_page_svr.WoTransitPageSvr", "GetPageInfo", byteArray, emptyMap, new d(callback), 0, 64, null);
    }

    public final void g(AppInterface app, String url, Function1<? super Boolean, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        lw4.d dVar = new lw4.d();
        dVar.f415704a = url;
        QRouteApi api = QRoute.api(IZplanVasProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanVasProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(dVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZplanVasProxyServlet.a.a((IZplanVasProxyServlet) api, app, "trpc.qmeta.wo_transit_page_svr.WoTransitPageSvr", "SetWoBackground", byteArray, emptyMap, new f(callback), 0, 64, null);
    }

    public final void b(AppInterface app, long id5, boolean isTinyId, int source, com.tencent.mobileqq.zootopia.api.e<SmallHomeInfo> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        m mVar = new m();
        if (isTinyId) {
            mVar.f453450b = id5;
        } else {
            mVar.f453449a = id5;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(mVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, app, "trpc.metaverse.mod_info_svr.ModInfoSvr", "GetSmallhomeInfo", byteArray, emptyMap, new c(id5, callback), source, 0, 128, null);
    }

    public final void e(AppInterface app, long id5, boolean isTinyId, int source, com.tencent.mobileqq.zootopia.api.e<SmallHomeStatus> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        m mVar = new m();
        if (isTinyId) {
            mVar.f453450b = id5;
        } else {
            mVar.f453449a = id5;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(mVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, app, "trpc.metaverse.mod_info_svr.ModInfoSvr", "GetSmallhomeStatus", byteArray, emptyMap, new C11648e(id5, callback), source, 0, 128, null);
    }

    public static /* synthetic */ void c(e eVar, AppInterface appInterface, long j3, boolean z16, int i3, com.tencent.mobileqq.zootopia.api.e eVar2, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            i3 = 1;
        }
        eVar.b(appInterface, j3, z16, i3, eVar2);
    }

    public static /* synthetic */ void f(e eVar, AppInterface appInterface, long j3, boolean z16, int i3, com.tencent.mobileqq.zootopia.api.e eVar2, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            i3 = 1;
        }
        eVar.e(appInterface, j3, z16, i3, eVar2);
    }
}
