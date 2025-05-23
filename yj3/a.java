package yj3;

import com.epicgames.ue4.ZPlanVersion;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.dependencyimpl.MmkvStorage;
import com.tencent.rdelivery.reshub.api.ResHubParams;
import com.tencent.rdelivery.reshub.api.TargetType;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.api.n;
import com.tencent.rdelivery.reshub.net.ResHubDefaultDownloadImpl;
import com.tencent.rdelivery.reshub.processor.TryPatchProcessor;
import com.tencent.sqshow.zootopia.utils.ab;
import com.tencent.sqshow.zootopia.utils.w;
import iz3.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;
import vj3.d;
import wj3.ZPlanResHubLoadData;
import wj3.ZPlanResHubPathParam;
import zj3.a;
import zj3.f;
import zj3.j;
import zj3.k;
import zj3.l;
import zj3.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\\\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0002H\u0002J4\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010!\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u0002J\u001e\u0010\"\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J&\u0010%\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#J2\u0010'\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0002J&\u0010(\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J&\u0010)\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004JT\u0010,\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*J\b\u0010.\u001a\u0004\u0018\u00010-J\u0006\u0010/\u001a\u00020\bR\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00040;j\b\u0012\u0004\u0012\u00020\u0004`<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010=R(\u0010@\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010?078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00109R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010B\u00a8\u0006F"}, d2 = {"Lyj3/a;", "", "", "p", "", "appId", com.heytap.mcssdk.a.a.f36102l, MosaicConstants$JsProperty.PROP_ENV, "", "r", "i", "v", "Lcom/tencent/rdelivery/reshub/api/i;", "resHub", "resId", "Lwj3/b;", "savePath", "Lvj3/e;", "callback", "forceRequestLatest", "isLoopRequest", "t", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "k", "o", HippyTKDListViewAdapter.X, "l", h.F, "forceInit", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvj3/d;", "listener", "e", "validateResFile", ReportConstant.COSTREPORT_PREFIX, "g", "f", "Lvj3/b;", "mobileDownloadHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/common/app/AppInterface;", "j", "w", "b", "Z", "ENABLE_MULTI_PROCESS_MODE", "Lzj3/j;", "c", "Lzj3/j;", "storageImpl", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "resForceRequestMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "resHubFullLoadHistory", "Ljava/util/concurrent/CopyOnWriteArrayList;", "resHubFullLoadListenerMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "resHubInited", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f450500a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean ENABLE_MULTI_PROCESS_MODE = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final j storageImpl = new j();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Boolean> resForceRequestMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> resHubFullLoadHistory = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<d>> resHubFullLoadListenerMap = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean resHubInited = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J2\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"yj3/a$a", "Liz3/e;", "", "onSuccess", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "remainedDatas", "updatedDatas", "deletedDatas", "a", "", "reason", "onFail", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yj3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11618a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f450507a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450508b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f450509c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f450510d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f450511e;

        C11618a(long j3, String str, String str2, String str3, String str4) {
            this.f450507a = j3;
            this.f450508b = str;
            this.f450509c = str2;
            this.f450510d = str3;
            this.f450511e = str4;
        }

        @Override // iz3.e, iz3.m
        public void a(List<RDeliveryData> remainedDatas, List<RDeliveryData> updatedDatas, List<RDeliveryData> deletedDatas) {
            Intrinsics.checkNotNullParameter(remainedDatas, "remainedDatas");
            Intrinsics.checkNotNullParameter(updatedDatas, "updatedDatas");
            Intrinsics.checkNotNullParameter(deletedDatas, "deletedDatas");
            QLog.i("ZPlanShiplyRes_Helper", 1, "initGetResHub#FullReq-onSuccess, costTime = " + (System.currentTimeMillis() - this.f450507a));
            if (a.resHubFullLoadHistory.contains(this.f450508b)) {
                return;
            }
            a.resHubFullLoadHistory.add(this.f450508b);
            a.f450500a.r(this.f450509c, this.f450510d, this.f450511e);
        }

        @Override // iz3.m
        public void onFail(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            QLog.e("ZPlanShiplyRes_Helper", 1, "initGetResHub#FullReq-onFail - " + reason + ", costTime = " + (System.currentTimeMillis() - this.f450507a));
        }

        @Override // iz3.e
        public void onSuccess() {
            QLog.i("ZPlanShiplyRes_Helper", 1, "initGetResHub#FullReq-onSuccess tmp");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J2\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\r"}, d2 = {"yj3/a$b", "Liz3/e;", "", "reason", "", "onFail", "onSuccess", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "remainedDatas", "updatedDatas", "deletedDatas", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f450512a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f450513b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f450514c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f450515d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f450516e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ZPlanResHubPathParam f450517f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ vj3.e f450518g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f450519h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ g f450520i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f450521j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ vj3.b f450522k;

        b(i iVar, String str, String str2, String str3, String str4, ZPlanResHubPathParam zPlanResHubPathParam, vj3.e eVar, boolean z16, g gVar, long j3, vj3.b bVar) {
            this.f450512a = iVar;
            this.f450513b = str;
            this.f450514c = str2;
            this.f450515d = str3;
            this.f450516e = str4;
            this.f450517f = zPlanResHubPathParam;
            this.f450518g = eVar;
            this.f450519h = z16;
            this.f450520i = gVar;
            this.f450521j = j3;
            this.f450522k = bVar;
        }

        @Override // iz3.m
        public void onFail(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            QLog.e("ZPlanShiplyRes_Helper", 1, "loadAndUpdateRes, requestFullRemoteResConfig onFail - " + reason);
            a.u(a.f450500a, this.f450512a, this.f450513b, this.f450514c, this.f450515d, this.f450516e, this.f450517f, this.f450518g, this.f450519h, false, 256, null);
        }

        @Override // iz3.e
        public void onSuccess() {
            QLog.i("ZPlanShiplyRes_Helper", 1, "loadAndUpdateRes requestFullRemoteResConfig onSuccess tmp");
        }

        @Override // iz3.e, iz3.m
        public void a(List<RDeliveryData> remainedDatas, List<RDeliveryData> updatedDatas, List<RDeliveryData> deletedDatas) {
            Intrinsics.checkNotNullParameter(remainedDatas, "remainedDatas");
            Intrinsics.checkNotNullParameter(updatedDatas, "updatedDatas");
            Intrinsics.checkNotNullParameter(deletedDatas, "deletedDatas");
            g l3 = this.f450512a.l(this.f450516e);
            long j3 = 0;
            if (l3 != null) {
                g gVar = this.f450520i;
                boolean z16 = false;
                if (gVar != null && l3.getVersion() == gVar.getVersion()) {
                    z16 = true;
                }
                if (!z16) {
                    g gVar2 = this.f450520i;
                    long c16 = l3.c(gVar2 != null ? gVar2.getVersion() : 0L);
                    j3 = c16 == 0 ? l3.getSize() : c16;
                }
            }
            QLog.i("ZPlanShiplyRes_Helper", 1, "loadAndUpdateRes requestFullRemoteResConfig onSuccess, needDownloadSize= " + j3 + ", thresholdMb= 5, latestConfig= " + l3 + ", localCurVersion= " + this.f450520i + ", costTime= " + (System.currentTimeMillis() - this.f450521j));
            if (!this.f450522k.a() && j3 <= MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE * 1024) {
                a.u(a.f450500a, this.f450512a, this.f450513b, this.f450514c, this.f450515d, this.f450516e, this.f450517f, this.f450518g, false, false, 256, null);
                return;
            }
            QLog.e("ZPlanShiplyRes_Helper", 1, "loadAndUpdateRes checkWhenMobileDownload - " + j3);
            this.f450522k.b(j3, new C11619a(this.f450512a, this.f450513b, this.f450514c, this.f450515d, this.f450516e, this.f450517f, this.f450518g));
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"yj3/a$b$a", "Lvj3/c;", "", "continueDownload", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: yj3.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        public static final class C11619a implements vj3.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f450523a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f450524b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f450525c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f450526d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f450527e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ ZPlanResHubPathParam f450528f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ vj3.e f450529g;

            C11619a(i iVar, String str, String str2, String str3, String str4, ZPlanResHubPathParam zPlanResHubPathParam, vj3.e eVar) {
                this.f450523a = iVar;
                this.f450524b = str;
                this.f450525c = str2;
                this.f450526d = str3;
                this.f450527e = str4;
                this.f450528f = zPlanResHubPathParam;
                this.f450529g = eVar;
            }

            @Override // vj3.c
            public void a(boolean continueDownload) {
                QLog.i("ZPlanShiplyRes_Helper", 1, "loadAndUpdateRes checkWhenMobileDownload - " + continueDownload);
                if (continueDownload) {
                    a.u(a.f450500a, this.f450523a, this.f450524b, this.f450525c, this.f450526d, this.f450527e, this.f450528f, this.f450529g, false, false, 256, null);
                    return;
                }
                vj3.e eVar = this.f450529g;
                if (eVar != null) {
                    eVar.a(false, new ZPlanResHubLoadData(this.f450527e, -99001, "mobile download forbidden", null, null, null, 0L, null, null));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"yj3/a$c", "Lcom/tencent/rdelivery/reshub/api/h;", "", "progress", "", "onProgress", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "onComplete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements com.tencent.rdelivery.reshub.api.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f450530a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ vj3.e f450531b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f450532c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f450533d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f450534e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f450535f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f450536g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f450537h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ZPlanResHubPathParam f450538i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f450539j;

        c(String str, vj3.e eVar, boolean z16, long j3, i iVar, String str2, String str3, String str4, ZPlanResHubPathParam zPlanResHubPathParam, boolean z17) {
            this.f450530a = str;
            this.f450531b = eVar;
            this.f450532c = z16;
            this.f450533d = j3;
            this.f450534e = iVar;
            this.f450535f = str2;
            this.f450536g = str3;
            this.f450537h = str4;
            this.f450538i = zPlanResHubPathParam;
            this.f450539j = z17;
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float progress) {
            h.a.a(this, progress);
            vj3.e eVar = this.f450531b;
            if (eVar != null) {
                eVar.onProgress(progress);
            }
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onComplete(boolean isSuccess, g result, n error) {
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("ZPlanShiplyRes_Helper", 1, "realLoadAndUpdateRes onComplete! resId= " + this.f450530a + ", isLoopRequest=" + this.f450532c + ", isSuccess=" + isSuccess + ", errorCode=" + error.b() + " errorMessage=" + error.message() + ", costTime= " + (System.currentTimeMillis() - this.f450533d) + ", version= " + (result != null ? Long.valueOf(result.getVersion()) : null) + ", md5= " + (result != null ? result.a() : null) + ", localPath= " + (result != null ? result.e() : null));
            if (this.f450532c || error.b() != 1005) {
                a.f450500a.k(this.f450530a, isSuccess, result, error, this.f450531b);
                return;
            }
            QLog.e("ZPlanShiplyRes_Helper", 1, "FETCH_CONFIG_INVALID_RESULT_ERROR!!!");
            this.f450534e.m(this.f450530a);
            a.f450500a.t(this.f450534e, this.f450535f, this.f450536g, this.f450537h, this.f450530a, this.f450538i, this.f450531b, this.f450539j, true);
        }
    }

    a() {
    }

    private final String i(String appId, String appKey, String env) {
        return appId + "_" + env;
    }

    private final void l() {
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        jVar.X(new k());
        jVar.W(storageImpl);
        String str = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + File.separator + "shiplylock";
        jVar.V(new f("ireshub", new a.C11686a(str, "ireshub_storage")));
        jVar.Z(new MmkvStorage.b(new zj3.a(str)));
        jVar.c0(new zj3.g());
        jVar.Y(new l());
        jVar.d0(new zj3.h());
    }

    private final void o() {
        IRNetwork cVar;
        String a16 = ab.INSTANCE.a();
        int value = 1 == MobileQQ.sProcessId ? RDeliverySetting.UpdateStrategy.START_UP.getValue() : 0;
        String c16 = o.c();
        HashMap hashMap = new HashMap();
        hashMap.put(NativeMonitorConfigHelper.SUB_KEY_IS_64_BIT, "1");
        hashMap.put("qqUin", w.f373306a.b());
        hashMap.put("zplanUeVersion", ZPlanVersion.ZPlanVersion);
        boolean z16 = ENABLE_MULTI_PROCESS_MODE;
        Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
        Boolean bool = Boolean.TRUE;
        ResHubParams resHubParams = new ResHubParams(a16, c16, false, null, false, false, "1", hashMap, value, 0, z16, bool, bool, true, PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, null);
        AppInterface j3 = j();
        boolean isFeatureSwitchEnable = ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("shiply_use_sso", false);
        String str = SSODebugUtil.loadTestEnvironment()[0];
        QLog.i("ZPlanShiplyRes_Helper", 1, "initResHubInner,useSSOChannel= " + isFeatureSwitchEnable + ", appInterface= " + j3 + ", strategy= " + value + ", version= " + resHubParams.getAppVersion() + ", deviceId= " + resHubParams.getDeviceId() + ", isRdmTest= " + resHubParams.getIsRdmTest() + ", multiProcessMode= " + resHubParams.getMultiProcessMode() + ", variantMap= " + resHubParams.l() + ", isMsfTest=false, testEnvironment=" + str);
        if (isFeatureSwitchEnable && j3 != null) {
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            cVar = new zj3.d(new com.tencent.rdelivery.dependencyimpl.c(sMobileQQ, 0, 0, 6, null));
        } else {
            MobileQQ sMobileQQ2 = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ2, "sMobileQQ");
            cVar = new com.tencent.rdelivery.dependencyimpl.c(sMobileQQ2, 0, 0, 6, null);
        }
        IRNetwork iRNetwork = cVar;
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        jVar.a0(false);
        jVar.b0(true);
        MobileQQ sMobileQQ3 = MobileQQ.sMobileQQ;
        zj3.i iVar = new zj3.i(new ResHubDefaultDownloadImpl());
        m mVar = new m();
        Intrinsics.checkNotNullExpressionValue(sMobileQQ3, "sMobileQQ");
        jVar.N(sMobileQQ3, resHubParams, iVar, iRNetwork, mVar);
    }

    private final boolean p() {
        return resHubInited.compareAndSet(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String appId, String appKey, String env) {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<d> copyOnWriteArrayList = resHubFullLoadListenerMap.get(i(appId, appKey, env));
        if (copyOnWriteArrayList != null) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add((d) it.next());
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((d) it5.next()).a(appId, appKey, env);
        }
        v(appId, appKey, env);
    }

    private final void x() {
        List<? extends com.tencent.rdelivery.reshub.processor.a> listOf;
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new TryPatchProcessor());
        jVar.O(listOf);
    }

    public final void e(String appId, String appKey, String env, d listener) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String i3 = i(appId, appKey, env);
        if (resHubFullLoadHistory.contains(i3)) {
            QLog.i("ZPlanShiplyRes_Helper", 1, "addResHubFullLoadListener " + i3 + " - callback direct");
            listener.a(appId, appKey, env);
            return;
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<d>> concurrentHashMap = resHubFullLoadListenerMap;
        CopyOnWriteArrayList<d> copyOnWriteArrayList = concurrentHashMap.get(i3);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            concurrentHashMap.put(i3, copyOnWriteArrayList);
            QLog.i("ZPlanShiplyRes_Helper", 1, "addResHubFullLoadListener " + i3 + " - newListenerList");
        } else {
            QLog.i("ZPlanShiplyRes_Helper", 1, "addResHubFullLoadListener " + i3 + " - listenerList already exist!!!");
        }
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void f(String appId, String appKey, String env, String resId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resId, "resId");
        long currentTimeMillis = System.currentTimeMillis();
        boolean o16 = m(appId, appKey, env).o(resId);
        QLog.e("ZPlanShiplyRes_Helper", 1, "cancelResDownload, appId= " + appId + ", env= " + env + ", resId= " + resId + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis) + ", ret= " + o16);
    }

    public final void g(String appId, String appKey, String env, String resId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resId, "resId");
        long currentTimeMillis = System.currentTimeMillis();
        m(appId, appKey, env).m(resId);
        QLog.e("ZPlanShiplyRes_Helper", 1, "deleteResInfo, appId= " + appId + ", env= " + env + ", resId= " + resId + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void h() {
        AtomicBoolean atomicBoolean = resHubInited;
        QLog.e("ZPlanShiplyRes_Helper", 1, "---doWhenQQLogout - " + atomicBoolean);
        atomicBoolean.compareAndSet(true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AppInterface j() {
        AppInterface appInterface;
        AppRuntime appRuntime;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (peekAppRuntime instanceof ToolRuntimePeak) {
                appRuntime = peekAppRuntime.getAppRuntime("peak");
            } else if (peekAppRuntime instanceof VideoAppInterface) {
                appRuntime = peekAppRuntime.getAppRuntime("module_video");
            } else {
                appRuntime = peekAppRuntime instanceof ToolAppRuntime ? peekAppRuntime.getAppRuntime("modular_web") : peekAppRuntime;
            }
            if (appRuntime instanceof AppInterface) {
                appInterface = (AppInterface) appRuntime;
                if (QLog.isColorLevel()) {
                    QLog.d("ZPlanShiplyRes_Helper", 2, "getAppInterface runtime = " + peekAppRuntime + ", class = " + (peekAppRuntime != null ? peekAppRuntime.getClass().getName() : null));
                }
                return appInterface;
            }
        }
        appInterface = null;
        if (QLog.isColorLevel()) {
        }
        return appInterface;
    }

    public final i m(String appId, String appKey, String env) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        return com.tencent.rdelivery.reshub.core.j.L.F(appId, appKey, TargetType.AndroidApp, env, new C11618a(System.currentTimeMillis(), i(appId, appKey, env), appId, appKey, env));
    }

    public final synchronized void n(boolean forceInit) {
        boolean p16 = p();
        if (p16 || forceInit) {
            QLog.i("ZPlanShiplyRes_Helper", 1, "---initResHub--- firstInited = " + p16 + ", forceInit = " + forceInit + " ", new Throwable("#InitEntry#"));
            long currentTimeMillis = System.currentTimeMillis();
            o();
            x();
            l();
            QLog.e("ZPlanShiplyRes_Helper", 1, "initResHub FINISH, costTime = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final g s(String appId, String appKey, String env, String resId, boolean validateResFile) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resId, "resId");
        long currentTimeMillis = System.currentTimeMillis();
        g q16 = m(appId, appKey, env).q(resId, validateResFile);
        QLog.i("ZPlanShiplyRes_Helper", 1, "queryResLocalVersion, appId= " + appId + ", env= " + env + ", resId= " + resId + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis) + ", ret = " + (q16 != null ? Long.valueOf(q16.getVersion()) : null) + " - " + (q16 != null ? q16.e() : null));
        return q16;
    }

    private final void v(String appId, String appKey, String env) {
        QLog.i("ZPlanShiplyRes_Helper", 1, "removeResHubFullLoadListener");
        resHubFullLoadListenerMap.remove(i(appId, appKey, env));
    }

    public final void w() {
        QLog.i("ZPlanShiplyRes_Helper", 1, "resetStorageDelegate");
        com.tencent.rdelivery.reshub.core.j.L.W(storageImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String resId, boolean isSuccess, g result, n error, vj3.e callback) {
        String resId2;
        ZPlanResHubLoadData zPlanResHubLoadData = new ZPlanResHubLoadData((result == null || (resId2 = result.getResId()) == null) ? resId : resId2, Integer.valueOf(error.b()), error.message(), result != null ? result.e() : null, result != null ? Long.valueOf(result.getVersion()) : null, result != null ? result.a() : null, result != null ? result.getSize() : 0L, result != null ? result.b() : null, result != null ? result.d() : null);
        QLog.i("ZPlanShiplyRes_Helper", 1, "resId=" + resId + ", handleLoadComplete - resId=" + zPlanResHubLoadData.getResId() + " errorCode=" + zPlanResHubLoadData.getCode() + " errorMessage=" + zPlanResHubLoadData.getMessage() + " md5=" + zPlanResHubLoadData.getMd5() + " extraDesc=" + zPlanResHubLoadData.getExtraDesc(), error.a());
        if (callback != null) {
            callback.a(isSuccess, zPlanResHubLoadData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(i resHub, String appId, String appKey, String env, String resId, ZPlanResHubPathParam savePath, vj3.e callback, boolean forceRequestLatest, boolean isLoopRequest) {
        QLog.i("ZPlanShiplyRes_Helper", 1, "realLoadAndUpdateRes BEGIN, resId= " + resId);
        resHub.j(resId, new c(resId, callback, isLoopRequest, System.currentTimeMillis(), resHub, appId, appKey, env, savePath, forceRequestLatest), forceRequestLatest);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(String appId, String appKey, String env, String resId, ZPlanResHubPathParam savePath, vj3.e callback, boolean forceRequestLatest, vj3.b mobileDownloadHandler) {
        boolean z16;
        i m3;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resId, "resId");
        long currentTimeMillis = System.currentTimeMillis();
        if (!forceRequestLatest) {
            ConcurrentHashMap<String, Boolean> concurrentHashMap = resForceRequestMap;
            Boolean bool = concurrentHashMap.get(resId);
            Boolean bool2 = Boolean.TRUE;
            if (!Intrinsics.areEqual(bool, bool2)) {
                concurrentHashMap.put(resId, bool2);
                z16 = true;
                QLog.i("ZPlanShiplyRes_Helper", 1, "loadAndUpdateRes START, appId= " + appId + ", env= " + env + ", resId= " + resId + ", fixedForceRequestLatest= " + z16 + ", hasMobileHandler= " + (mobileDownloadHandler == null) + ", savePath= " + savePath);
                if (savePath != null) {
                    storageImpl.i(resId, savePath);
                }
                com.tencent.rdelivery.reshub.core.j.L.a0(false);
                m3 = m(appId, appKey, env);
                m3.n("qqUin", w.f373306a.b());
                w();
                if (mobileDownloadHandler == null && (mobileDownloadHandler.a() || com.tencent.mobileqq.zootopia.utils.m.f329564a.a() != 1)) {
                    m3.g(new b(m3, appId, appKey, env, resId, savePath, callback, z16, i.a.b(m3, resId, false, 2, null), currentTimeMillis, mobileDownloadHandler));
                    return;
                } else {
                    u(this, m3, appId, appKey, env, resId, savePath, callback, z16, false, 256, null);
                }
            }
        }
        z16 = forceRequestLatest;
        if (mobileDownloadHandler == null) {
        }
        QLog.i("ZPlanShiplyRes_Helper", 1, "loadAndUpdateRes START, appId= " + appId + ", env= " + env + ", resId= " + resId + ", fixedForceRequestLatest= " + z16 + ", hasMobileHandler= " + (mobileDownloadHandler == null) + ", savePath= " + savePath);
        if (savePath != null) {
        }
        com.tencent.rdelivery.reshub.core.j.L.a0(false);
        m3 = m(appId, appKey, env);
        m3.n("qqUin", w.f373306a.b());
        w();
        if (mobileDownloadHandler == null) {
        }
        u(this, m3, appId, appKey, env, resId, savePath, callback, z16, false, 256, null);
    }

    static /* synthetic */ void u(a aVar, i iVar, String str, String str2, String str3, String str4, ZPlanResHubPathParam zPlanResHubPathParam, vj3.e eVar, boolean z16, boolean z17, int i3, Object obj) {
        aVar.t(iVar, str, str2, str3, str4, (i3 & 32) != 0 ? null : zPlanResHubPathParam, (i3 & 64) != 0 ? null : eVar, (i3 & 128) != 0 ? false : z16, (i3 & 256) != 0 ? false : z17);
    }
}
