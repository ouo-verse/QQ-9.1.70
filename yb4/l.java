package yb4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskCommonRewardData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskSystemMainData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import xv4.n;
import xv4.o;
import xv4.p;
import xv4.q;
import xv4.r;
import xv4.s;
import xv4.t;
import xv4.x;
import xv4.y;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010%\u001a\u00020\f\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u001c\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\bJ\u0014\u0010\u0012\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ\u0014\u0010\u0016\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00150\bJ\u001c\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00180\bJ\u0014\u0010\u001b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001a0\bJ\u001c\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001c0\bJ\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016\u00a8\u0006("}, d2 = {"Lyb4/l;", "Lyb4/d;", "Lxv4/p;", "leYuanTaskRsp", "Lcom/tencent/sqshow/zootopia/data/y;", "f", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "index", "Lcom/tencent/sqshow/zootopia/data/t;", tl.h.F, "Lxv4/t;", "l", "g", "questId", "i", "Lcom/tencent/sqshow/zootopia/data/s;", "j", "rewardType", "Lxv4/y;", DomainData.DOMAIN_NAME, "Lxv4/c;", "e", "Lxv4/r;", "k", "", "method", "c", "", "data", "", "a", "source", "<init>", "(I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l extends yb4.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450093a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450094b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450095c;

        public b(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450093a = dVar;
            this.f450094b = str;
            this.f450095c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450095c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            xv4.c cVar;
            try {
                Object a16 = this.f450093a.a(this.f450094b, data);
                if (!(a16 instanceof xv4.c)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    cVar = null;
                } else if (a16 != null) {
                    cVar = (xv4.c) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.task_engine_svr.nano.ClearLeYuanTaskRsp");
                }
                if (cVar != null) {
                    this.f450095c.onResultSuccess(cVar);
                } else {
                    this.f450095c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450095c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450096a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450097b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450098c;

        public c(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450096a = dVar;
            this.f450097b = str;
            this.f450098c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450098c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ZootopiaTaskCommonRewardData zootopiaTaskCommonRewardData;
            try {
                Object a16 = this.f450096a.a(this.f450097b, data);
                if (!(a16 instanceof ZootopiaTaskCommonRewardData)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    zootopiaTaskCommonRewardData = null;
                } else if (a16 != null) {
                    zootopiaTaskCommonRewardData = (ZootopiaTaskCommonRewardData) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.sqshow.zootopia.data.ZootopiaTaskCommonRewardData");
                }
                if (zootopiaTaskCommonRewardData != null) {
                    this.f450098c.onResultSuccess(zootopiaTaskCommonRewardData);
                } else {
                    this.f450098c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450098c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450099a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450100b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450101c;

        public d(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450099a = dVar;
            this.f450100b = str;
            this.f450101c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450101c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ZootopiaTaskCommonRewardData zootopiaTaskCommonRewardData;
            try {
                Object a16 = this.f450099a.a(this.f450100b, data);
                if (!(a16 instanceof ZootopiaTaskCommonRewardData)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    zootopiaTaskCommonRewardData = null;
                } else if (a16 != null) {
                    zootopiaTaskCommonRewardData = (ZootopiaTaskCommonRewardData) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.sqshow.zootopia.data.ZootopiaTaskCommonRewardData");
                }
                if (zootopiaTaskCommonRewardData != null) {
                    this.f450101c.onResultSuccess(zootopiaTaskCommonRewardData);
                } else {
                    this.f450101c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450101c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class e implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450102a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450103b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450104c;

        public e(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450102a = dVar;
            this.f450103b = str;
            this.f450104c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450104c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ZootopiaTaskCommonRewardData zootopiaTaskCommonRewardData;
            try {
                Object a16 = this.f450102a.a(this.f450103b, data);
                if (!(a16 instanceof ZootopiaTaskCommonRewardData)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    zootopiaTaskCommonRewardData = null;
                } else if (a16 != null) {
                    zootopiaTaskCommonRewardData = (ZootopiaTaskCommonRewardData) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.sqshow.zootopia.data.ZootopiaTaskCommonRewardData");
                }
                if (zootopiaTaskCommonRewardData != null) {
                    this.f450104c.onResultSuccess(zootopiaTaskCommonRewardData);
                } else {
                    this.f450104c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450104c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class f implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450105a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450106b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450107c;

        public f(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450105a = dVar;
            this.f450106b = str;
            this.f450107c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450107c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ZootopiaTaskBlindBoxData zootopiaTaskBlindBoxData;
            try {
                Object a16 = this.f450105a.a(this.f450106b, data);
                if (!(a16 instanceof ZootopiaTaskBlindBoxData)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    zootopiaTaskBlindBoxData = null;
                } else if (a16 != null) {
                    zootopiaTaskBlindBoxData = (ZootopiaTaskBlindBoxData) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData");
                }
                if (zootopiaTaskBlindBoxData != null) {
                    this.f450107c.onResultSuccess(zootopiaTaskBlindBoxData);
                } else {
                    this.f450107c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450107c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class g implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450108a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450109b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450110c;

        public g(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450108a = dVar;
            this.f450109b = str;
            this.f450110c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450110c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            r rVar;
            try {
                Object a16 = this.f450108a.a(this.f450109b, data);
                if (!(a16 instanceof r)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    rVar = null;
                } else if (a16 != null) {
                    rVar = (r) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.task_engine_svr.nano.GetTaskRedPointRsp");
                }
                if (rVar != null) {
                    this.f450110c.onResultSuccess(rVar);
                } else {
                    this.f450110c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450110c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class h implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450111a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450112b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450113c;

        public h(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450111a = dVar;
            this.f450112b = str;
            this.f450113c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450113c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            t tVar;
            try {
                Object a16 = this.f450111a.a(this.f450112b, data);
                if (!(a16 instanceof t)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    tVar = null;
                } else if (a16 != null) {
                    tVar = (t) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.task_engine_svr.nano.GuidePopupsRsp");
                }
                if (tVar != null) {
                    this.f450113c.onResultSuccess(tVar);
                } else {
                    this.f450113c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450113c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class i implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450115b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450116c;

        public i(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450114a = dVar;
            this.f450115b = str;
            this.f450116c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450116c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ZootopiaTaskSystemMainData zootopiaTaskSystemMainData;
            try {
                Object a16 = this.f450114a.a(this.f450115b, data);
                if (!(a16 instanceof ZootopiaTaskSystemMainData)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    zootopiaTaskSystemMainData = null;
                } else if (a16 != null) {
                    zootopiaTaskSystemMainData = (ZootopiaTaskSystemMainData) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.sqshow.zootopia.data.ZootopiaTaskSystemMainData");
                }
                if (zootopiaTaskSystemMainData != null) {
                    this.f450116c.onResultSuccess(zootopiaTaskSystemMainData);
                } else {
                    this.f450116c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450116c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class j implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f450117a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450118b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f450119c;

        public j(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f450117a = dVar;
            this.f450118b = str;
            this.f450119c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f450119c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            y yVar;
            try {
                Object a16 = this.f450117a.a(this.f450118b, data);
                if (!(a16 instanceof y)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    yVar = null;
                } else if (a16 != null) {
                    yVar = (y) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.task_engine_svr.nano.ReportLeYuanTaskRsp");
                }
                if (yVar != null) {
                    this.f450119c.onResultSuccess(yVar);
                } else {
                    this.f450119c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f450119c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    public l(int i3) {
        super(i3);
    }

    private final ZootopiaTaskSystemMainData f(p leYuanTaskRsp) {
        return ZootopiaTaskSystemMainData.INSTANCE.a(leYuanTaskRsp != null ? leYuanTaskRsp.f448815a : null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // yb4.d
    public Object a(String method, byte[] data) {
        Object obj;
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("ZootopiaTaskSystemService", 4, "convertData, method:" + method + ", data" + data);
        switch (method.hashCode()) {
            case -1770393990:
                if (method.equals("GetTaskRedPoint")) {
                    obj = r.c(data);
                    Intrinsics.checkNotNullExpressionValue(obj, "parseFrom(data)");
                    break;
                }
                obj = "";
                break;
            case -1642375895:
                if (method.equals("GetBlindBoxRewardInfo")) {
                    obj = ZootopiaTaskBlindBoxData.INSTANCE.c(n.c(data));
                    break;
                }
                obj = "";
                break;
            case -1575423523:
                if (method.equals("GetLeYuanTask")) {
                    p c16 = p.c(data);
                    QLog.i("ZootopiaTaskSystemService", 4, "convertData, method:" + method + ", data" + c16);
                    obj = f(c16);
                    break;
                }
                obj = "";
                break;
            case -1028700349:
                if (method.equals("GuidePopups")) {
                    obj = t.c(data);
                    Intrinsics.checkNotNullExpressionValue(obj, "parseFrom(data)");
                    break;
                }
                obj = "";
                break;
            case -806777221:
                if (method.equals("ReportLeYuanTask")) {
                    obj = y.c(data);
                    Intrinsics.checkNotNullExpressionValue(obj, "parseFrom(data)");
                    break;
                }
                obj = "";
                break;
            case 450992148:
                if (method.equals("ClearLeYuanTask")) {
                    obj = xv4.c.c(data);
                    Intrinsics.checkNotNullExpressionValue(obj, "parseFrom(data)");
                    break;
                }
                obj = "";
                break;
            case 517415487:
                if (method.equals("FetchBlindBoxReward")) {
                    obj = ZootopiaTaskCommonRewardData.INSTANCE.a(xv4.h.c(data));
                    break;
                }
                obj = "";
                break;
            case 687058862:
                if (method.equals("FetchDailyReward")) {
                    obj = ZootopiaTaskCommonRewardData.INSTANCE.b(xv4.j.c(data));
                    break;
                }
                obj = "";
                break;
            case 1273294775:
                if (method.equals("FetchQuestReward")) {
                    obj = ZootopiaTaskCommonRewardData.INSTANCE.c(xv4.l.c(data));
                    break;
                }
                obj = "";
                break;
            default:
                obj = "";
                break;
        }
        QLog.i("ZootopiaTaskSystemService", 4, "convertData, method:" + method + ", data" + obj);
        return obj;
    }

    @Override // yb4.d
    public String c(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return "trpc.metaverse.task_engine_svr.TaskEngineCgi";
    }

    public final void e(com.tencent.mobileqq.zootopia.api.e<xv4.c> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        xv4.b bVar = new xv4.b();
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:ClearLeYuanTask");
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("ClearLeYuanTask");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "ClearLeYuanTask", byteArray, emptyMap, new b(this, "ClearLeYuanTask", callback), source, 0, 128, null);
    }

    public final void g(com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskCommonRewardData> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        xv4.g gVar = new xv4.g();
        gVar.f448797a = 1L;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:FetchBlindBoxReward");
        byte[] byteArray = MessageNano.toByteArray(gVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("FetchBlindBoxReward");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "FetchBlindBoxReward", byteArray, emptyMap, new c(this, "FetchBlindBoxReward", callback), source, 0, 128, null);
    }

    public final void j(com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskBlindBoxData> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        xv4.m mVar = new xv4.m();
        mVar.f448811a = 1L;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:GetBlindBoxRewardInfo");
        byte[] byteArray = MessageNano.toByteArray(mVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("GetBlindBoxRewardInfo");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "GetBlindBoxRewardInfo", byteArray, emptyMap, new f(this, "GetBlindBoxRewardInfo", callback), source, 0, 128, null);
    }

    public final void k(long taskId, com.tencent.mobileqq.zootopia.api.e<r> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        q qVar = new q();
        qVar.f448816a = taskId;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:GetTaskRedPoint");
        byte[] byteArray = MessageNano.toByteArray(qVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("GetTaskRedPoint");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "GetTaskRedPoint", byteArray, emptyMap, new g(this, "GetTaskRedPoint", callback), source, 0, 128, null);
    }

    public final void l(com.tencent.mobileqq.zootopia.api.e<t> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        s sVar = new s();
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:GuidePopups");
        byte[] byteArray = MessageNano.toByteArray(sVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("GuidePopups");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "GuidePopups", byteArray, emptyMap, new h(this, "GuidePopups", callback), source, 0, 128, null);
    }

    public final void m(long taskId, com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskSystemMainData> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        o oVar = new o();
        oVar.f448814a = taskId;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:GetLeYuanTask");
        byte[] byteArray = MessageNano.toByteArray(oVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("GetLeYuanTask");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "GetLeYuanTask", byteArray, emptyMap, new i(this, "GetLeYuanTask", callback), source, 0, 128, null);
    }

    public final void h(int index, com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskCommonRewardData> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        xv4.i iVar = new xv4.i();
        iVar.f448801a = 1L;
        iVar.f448802b = index;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:FetchDailyReward");
        byte[] byteArray = MessageNano.toByteArray(iVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("FetchDailyReward");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "FetchDailyReward", byteArray, emptyMap, new d(this, "FetchDailyReward", callback), source, 0, 128, null);
    }

    public final void i(long taskId, long questId, com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskCommonRewardData> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        xv4.k kVar = new xv4.k();
        kVar.f448806a = taskId;
        kVar.f448807b = questId;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:FetchQuestReward");
        byte[] byteArray = MessageNano.toByteArray(kVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("FetchQuestReward");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "FetchQuestReward", byteArray, emptyMap, new e(this, "FetchQuestReward", callback), source, 0, 128, null);
    }

    public final void n(int rewardType, com.tencent.mobileqq.zootopia.api.e<y> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        x xVar = new x();
        xVar.f448852a = 1L;
        xVar.f448853b = rewardType;
        xVar.f448854c = 0L;
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:ReportLeYuanTask");
        byte[] byteArray = MessageNano.toByteArray(xVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
        int source = getSource();
        AppInterface b16 = b(callback);
        if (b16 == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String c16 = c("ReportLeYuanTask");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "ReportLeYuanTask", byteArray, emptyMap, new j(this, "ReportLeYuanTask", callback), source, 0, 128, null);
    }
}
