package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002J\u001a\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ&\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lyb4/e;", "", "", "params", "", "i", "Lru4/b;", "rsp", "Lcom/tencent/sqshow/zootopia/data/f;", "c", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "Lcom/tencent/common/app/AppInterface;", "d", "", "source", "", "e", "f", "", "b", "J", "lastLoadCurrencyTimeStamp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f450058a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastLoadCurrencyTimeStamp = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isLoading = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"yb4/e$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(com.tencent.sqshow.zootopia.data.f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            gb4.a.f401894a.b().postValue(result);
            QLog.i("ZootopiaCurrencyService", 1, "updateCurrency onResultSuccess " + result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("ZootopiaCurrencyService", 1, "updateCurrency onResultFailure error:" + error + ", message:" + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"yb4/e$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> f450061a;

        b(com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> eVar) {
            this.f450061a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            e.isLoading.set(false);
            QLog.e("ZootopiaCurrencyService", 1, "getBrandMallInfoList -- errCode:" + errCode + ", errMsg:" + errMsg);
            this.f450061a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                e.isLoading.set(false);
                ru4.b rsp = ru4.b.c(data);
                com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> eVar = this.f450061a;
                e eVar2 = e.f450058a;
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                eVar.onResultSuccess(eVar2.c(rsp));
            } catch (Exception e16) {
                QLog.e("ZootopiaCurrencyService", 1, "getBrandMallInfoList throw e:" + e16.getMessage(), e16);
            }
        }
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.sqshow.zootopia.data.f c(ru4.b rsp) {
        return new com.tencent.sqshow.zootopia.data.f(rsp.f432520c, rsp.f432521d, rsp.f432518a, rsp.f432519b);
    }

    private final AppInterface d(com.tencent.mobileqq.zootopia.api.e<?> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
        }
        if (z16) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    private final boolean i(String params) {
        long currentTimeMillis = System.currentTimeMillis();
        if (isLoading.get()) {
            QLog.d("ZootopiaCurrencyService", 1, "skip loadCurrency as loading ");
            return true;
        }
        if (!Intrinsics.areEqual(params, "request_lazy")) {
            return false;
        }
        long j3 = lastLoadCurrencyTimeStamp;
        long j16 = currentTimeMillis - j3;
        if (j3 > 0 && j16 < 3000) {
            QLog.d("ZootopiaCurrencyService", 1, "skip loadCurrency during 3s ");
            return true;
        }
        lastLoadCurrencyTimeStamp = currentTimeMillis;
        return false;
    }

    public final void e(String params, int source) {
        Intrinsics.checkNotNullParameter(params, "params");
        f(params, new a(), source);
    }

    public static /* synthetic */ void g(e eVar, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = "request_lazy";
        }
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        eVar.e(str, i3);
    }

    public final void f(String params, com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("ZootopiaCurrencyService", 1, "loadCurrencyInfo " + params);
        AppInterface d16 = d(callback);
        if (d16 == null || i(params)) {
            return;
        }
        isLoading.set(true);
        ru4.a aVar = new ru4.a();
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(reqInfo)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, d16, "trpc.metaverse.currency_info.CurrencyInfo", "QueryCurrency", byteArray, emptyMap, new b(callback), source, 0, 128, null);
    }

    public static /* synthetic */ void h(e eVar, String str, com.tencent.mobileqq.zootopia.api.e eVar2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        eVar.f(str, eVar2, i3);
    }
}
