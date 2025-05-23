package z23;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.banner.VasZplanBannerHelper;
import com.tencent.mobileqq.vas.banner.VasZplanUserCallbackTabInfo;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.qphone.base.util.QLog;
import e33.RspErrorData;
import e33.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\r"}, d2 = {"Lz23/f;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "source", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/vas/banner/d;", "callback", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"z23/f$b", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements e33.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<VasZplanUserCallbackTabInfo> f451814a;

        b(com.tencent.mobileqq.zootopia.api.e<VasZplanUserCallbackTabInfo> eVar) {
            this.f451814a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanVasUserCallbackService", 1, "getSmallHomeTabInfo fail " + errCode + ", " + errMsg);
            this.f451814a.onResultFailure(errCode != null ? errCode.intValue() : -1, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            try {
                mw4.b c16 = mw4.b.c(data);
                VasZplanUserCallbackTabInfo vasZplanUserCallbackTabInfo = new VasZplanUserCallbackTabInfo(c16.f417718g);
                vasZplanUserCallbackTabInfo.l(c16.f417712a);
                vasZplanUserCallbackTabInfo.k(c16.f417713b);
                String str = c16.f417714c;
                Intrinsics.checkNotNullExpressionValue(str, "rsp.icon");
                vasZplanUserCallbackTabInfo.n(str);
                String str2 = c16.f417715d;
                Intrinsics.checkNotNullExpressionValue(str2, "rsp.text");
                vasZplanUserCallbackTabInfo.t(str2);
                String str3 = c16.f417716e;
                Intrinsics.checkNotNullExpressionValue(str3, "rsp.jumpUrl");
                vasZplanUserCallbackTabInfo.o(str3);
                String str4 = c16.f417717f;
                Intrinsics.checkNotNullExpressionValue(str4, "rsp.moduleCode");
                vasZplanUserCallbackTabInfo.p(str4);
                vasZplanUserCallbackTabInfo.q(c16.f417719h);
                String str5 = c16.f417720i;
                Intrinsics.checkNotNullExpressionValue(str5, "rsp.groupKey");
                vasZplanUserCallbackTabInfo.m(str5);
                String str6 = c16.f417721j;
                Intrinsics.checkNotNullExpressionValue(str6, "rsp.expKey");
                vasZplanUserCallbackTabInfo.j(str6);
                String str7 = c16.f417722k;
                Intrinsics.checkNotNullExpressionValue(str7, "rsp.silenceText");
                vasZplanUserCallbackTabInfo.s(str7);
                vasZplanUserCallbackTabInfo.r(c16.f417723l);
                this.f451814a.onResultSuccess(vasZplanUserCallbackTabInfo);
            } catch (Throwable unused) {
                QLog.e("ZplanVasUserCallbackService", 1, "getSmallHomeTabInfo parse data error");
            }
        }
    }

    public final void a(AppInterface app, int source, com.tencent.mobileqq.zootopia.api.e<VasZplanUserCallbackTabInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        mw4.a aVar = new mw4.a();
        aVar.f417711a = VasZplanBannerHelper.f308822d.d();
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.wo_user_callback_svr.WoUserCallbackSvr", "GetTabInfos", byteArray, emptyMap, new b(callback), source);
    }
}
