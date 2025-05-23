package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import iw4.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001c\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006J$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u001d"}, d2 = {"Lyb4/f;", "Lyb4/d;", "", "workId", "feedId", "uin", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/h;", "callback", "", "e", "", "pageInfo", "f", "id", "Liw4/l;", tl.h.F, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "Liw4/j;", "g", "method", "c", "data", "", "a", "source", "<init>", "(I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends yb4.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450063a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450064b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450065c;

        public b(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450063a = dVar;
            this.f450064b = str;
            this.f450065c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450065c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ZootopiaDetailFeedsListData zootopiaDetailFeedsListData;
            try {
                Object a16 = this.f450063a.a(this.f450064b, data);
                if (!(a16 instanceof ZootopiaDetailFeedsListData)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    zootopiaDetailFeedsListData = null;
                } else if (a16 != null) {
                    zootopiaDetailFeedsListData = (ZootopiaDetailFeedsListData) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData");
                }
                if (zootopiaDetailFeedsListData != null) {
                    this.f450065c.onResultSuccess(zootopiaDetailFeedsListData);
                } else {
                    this.f450065c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450065c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450066a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450067b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450068c;

        public c(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450066a = dVar;
            this.f450067b = str;
            this.f450068c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450068c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ZootopiaDetailFeedsListData zootopiaDetailFeedsListData;
            try {
                Object a16 = this.f450066a.a(this.f450067b, data);
                if (!(a16 instanceof ZootopiaDetailFeedsListData)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    zootopiaDetailFeedsListData = null;
                } else if (a16 != null) {
                    zootopiaDetailFeedsListData = (ZootopiaDetailFeedsListData) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData");
                }
                if (zootopiaDetailFeedsListData != null) {
                    this.f450068c.onResultSuccess(zootopiaDetailFeedsListData);
                } else {
                    this.f450068c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450068c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450069a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450070b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450071c;

        public d(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450069a = dVar;
            this.f450070b = str;
            this.f450071c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450071c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            iw4.j jVar;
            try {
                Object a16 = this.f450069a.a(this.f450070b, data);
                if (!(a16 instanceof iw4.j)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    jVar = null;
                } else if (a16 != null) {
                    jVar = (iw4.j) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.wear_square.nano.OutfitWorksChangeShowTypeRsp");
                }
                if (jVar != null) {
                    this.f450071c.onResultSuccess(jVar);
                } else {
                    this.f450071c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450071c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class e implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450072a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450073b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450074c;

        public e(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450072a = dVar;
            this.f450073b = str;
            this.f450074c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450074c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            iw4.l lVar;
            try {
                Object a16 = this.f450072a.a(this.f450073b, data);
                if (!(a16 instanceof iw4.l)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    lVar = null;
                } else if (a16 != null) {
                    lVar = (iw4.l) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.wear_square.nano.OutfitWorksDeleteRsp");
                }
                if (lVar != null) {
                    this.f450074c.onResultSuccess(lVar);
                } else {
                    this.f450074c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450074c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    public f(int i3) {
        super(i3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // yb4.d
    public Object a(String method, byte[] data) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("ZootopiaDressDetailService", 4, "convertData, method:" + method + ", data" + data);
        switch (method.hashCode()) {
            case -1613302618:
                if (method.equals("OutfitWorksChangeShowType")) {
                    iw4.j c16 = iw4.j.c(data);
                    Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                    return c16;
                }
                return "";
            case 481565968:
                if (method.equals("GetWearSquareList")) {
                    ZootopiaDetailFeedsListData.Companion companion = ZootopiaDetailFeedsListData.INSTANCE;
                    iw4.h c17 = iw4.h.c(data);
                    Intrinsics.checkNotNullExpressionValue(c17, "parseFrom(data)");
                    return companion.d(c17);
                }
                return "";
            case 593080951:
                if (method.equals("GetOutfitWorksInfo")) {
                    ZootopiaDetailFeedsListData.Companion companion2 = ZootopiaDetailFeedsListData.INSTANCE;
                    iw4.b c18 = iw4.b.c(data);
                    Intrinsics.checkNotNullExpressionValue(c18, "parseFrom(data)");
                    return companion2.b(c18);
                }
                return "";
            case 914164138:
                if (method.equals("OutfitWorksDelete")) {
                    iw4.l c19 = iw4.l.c(data);
                    Intrinsics.checkNotNullExpressionValue(c19, "parseFrom(data)");
                    return c19;
                }
                return "";
            case 1269395835:
                if (method.equals("OutfitWorksPraise")) {
                    n c26 = n.c(data);
                    Intrinsics.checkNotNullExpressionValue(c26, "parseFrom(data)");
                    return c26;
                }
                return "";
            default:
                return "";
        }
    }

    @Override // yb4.d
    public String c(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "GetWearSquareList")) {
            return "trpc.metaverse.wear_square_list.WearSquareList";
        }
        return "trpc.metaverse.wear_square_detail.WearSquareDetail";
    }

    public final void f(byte[] pageInfo, com.tencent.mobileqq.zootopia.api.e<ZootopiaDetailFeedsListData> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        iw4.g gVar = new iw4.g();
        gVar.f408887a = 2;
        gVar.f408888b = pageInfo;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:GetWearSquareList");
        byte[] byteArray = MessageNano.toByteArray(gVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("GetWearSquareList");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "GetWearSquareList", byteArray, emptyMap, new c(this, "GetWearSquareList", callback), source, 0, 128, null);
    }

    public final void g(String id5, int showType, com.tencent.mobileqq.zootopia.api.e<iw4.j> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        iw4.i iVar = new iw4.i();
        iVar.f408898a = id5;
        iVar.f408899b = showType;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:OutfitWorksChangeShowType");
        byte[] byteArray = MessageNano.toByteArray(iVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("OutfitWorksChangeShowType");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "OutfitWorksChangeShowType", byteArray, emptyMap, new d(this, "OutfitWorksChangeShowType", callback), source, 0, 128, null);
    }

    public final void h(String id5, com.tencent.mobileqq.zootopia.api.e<iw4.l> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        iw4.k kVar = new iw4.k();
        kVar.f408901a = id5;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:OutfitWorksDelete");
        byte[] byteArray = MessageNano.toByteArray(kVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("OutfitWorksDelete");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "OutfitWorksDelete", byteArray, emptyMap, new e(this, "OutfitWorksDelete", callback), source, 0, 128, null);
    }

    public final void e(String workId, String feedId, String uin, com.tencent.mobileqq.zootopia.api.e<ZootopiaDetailFeedsListData> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(workId, "workId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        iw4.a aVar = new iw4.a();
        aVar.f408868a = workId;
        aVar.f408869b = feedId;
        if (uin.length() > 0) {
            try {
                aVar.f408872e = Long.parseLong(uin);
                aVar.f408870c = 3;
            } catch (NumberFormatException e16) {
                aVar.f408872e = 0L;
                aVar.f408870c = 2;
                QLog.i("ZootopiaDressDetailService", 1, "format queryUin NumberFormatException: " + e16 + ", use listType=2");
            }
        } else {
            aVar.f408872e = 0L;
            aVar.f408870c = 2;
        }
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:GetOutfitWorksInfo");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("GetOutfitWorksInfo");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "GetOutfitWorksInfo", byteArray, emptyMap, new b(this, "GetOutfitWorksInfo", callback), source, 0, 128, null);
    }
}
