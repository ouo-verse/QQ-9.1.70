package uf2;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.ExecuteContextMode;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.QQKuiklyConfigManager;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.RequestConfig;
import com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.api.n;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0015B+\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J5\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022#\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0014\u0010\u001f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010%R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010&R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010,R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010&\u00a8\u00061"}, d2 = {"Luf2/b;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;", "", "forceRequestConfig", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "res", "", QCircleWeakNetReporter.KEY_COST, "", DomainData.DOMAIN_NAME, "", "pageName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, WadlProxyConsts.PARAM_FILENAME, "l", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/a;", "d", "Ljava/io/File;", "b", "a", "forceUpdate", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/k;", "Lkotlin/ParameterName;", "name", "result", "e", "g", h.F, "resId", "deleteBundle", "c", "Lcom/tencent/rdelivery/reshub/api/i;", "Lcom/tencent/rdelivery/reshub/api/i;", "resHub", "Ljava/lang/String;", "Z", "validateResFile", QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT, "Lcom/tencent/rdelivery/reshub/api/g;", "latestResInfo", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/b;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/b;", "requestConfig", "enableWholePackDex", "<init>", "(Lcom/tencent/rdelivery/reshub/api/i;Ljava/lang/String;ZZ)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final i resHub;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String resId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean validateResFile;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isTest;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private g latestResInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RequestConfig requestConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean enableWholePackDex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"uf2/b$b", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "res", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uf2.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11343b implements com.tencent.rdelivery.reshub.api.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f438895a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f438896b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f438897c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f438898d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f438899e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f438900f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function1<ResError, Unit> f438901g;

        /* JADX WARN: Multi-variable type inference failed */
        C11343b(long j3, boolean z16, boolean z17, long j16, boolean z18, b bVar, Function1<? super ResError, Unit> function1) {
            this.f438895a = j3;
            this.f438896b = z16;
            this.f438897c = z17;
            this.f438898d = j16;
            this.f438899e = z18;
            this.f438900f = bVar;
            this.f438901g = function1;
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onComplete(boolean isSuccess, g res, n error) {
            Intrinsics.checkNotNullParameter(error, "error");
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - this.f438895a;
            QLog.i("QQKuiklyResShiplyFetcher", 1, "[updateDexRes] forceUpdate:" + this.f438896b + " isForceBundleLimit:" + this.f438897c + " isSuccess:" + isSuccess + " updateCost:" + serverTimeMillis + " requestInterval:" + (this.f438898d / 60000) + "min, forceRequest:" + this.f438899e + " error:" + error.b() + "," + error.message() + ", res:" + res);
            this.f438900f.latestResInfo = res;
            this.f438900f.n(this.f438899e, isSuccess, res, serverTimeMillis);
            if (isSuccess && res != null) {
                Function1<ResError, Unit> function1 = this.f438901g;
                if (function1 != null) {
                    function1.invoke(new ResError(0, ""));
                    return;
                }
                return;
            }
            Function1<ResError, Unit> function12 = this.f438901g;
            if (function12 != null) {
                function12.invoke(new ResError(error.b(), error.message()));
            }
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float f16) {
            h.a.a(this, f16);
        }
    }

    public b(i resHub, String resId, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(resHub, "resHub");
        Intrinsics.checkNotNullParameter(resId, "resId");
        this.resHub = resHub;
        this.resId = resId;
        this.validateResFile = z16;
        this.isTest = z17;
        this.enableWholePackDex = VasNormalToggle.VAS_KUIKLY_WHOLE_DEX_SWITCH.isEnable(true);
        long currentTimeMillis = System.currentTimeMillis();
        this.latestResInfo = resHub.q(resId, z16);
        this.requestConfig = QQKuiklyConfigManager.f262835a.g();
        if (QLog.isColorLevel()) {
            QLog.d("QQKuiklyResShiplyFetcher", 2, "init cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", validateResFile:" + z16 + " isRequestConfigByStart:" + this.requestConfig + " resInfo:" + this.latestResInfo);
        }
    }

    private final String m(g res, String pageName) {
        String str;
        String resId;
        if (this.enableWholePackDex) {
            if (res == null || (resId = res.getResId()) == null) {
                str = null;
            } else {
                str = l(res, resId + "_whole_pack.apk");
            }
            if (str != null && new File(str).exists()) {
                return str;
            }
        }
        String l3 = l(res, pageName + ".apk");
        if (l3 == null || !new File(l3).exists()) {
            return null;
        }
        return l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean forceRequestConfig, boolean isSuccess, g res, long cost) {
        Map mapOf;
        ECDataReportManager eCDataReportManager = new ECDataReportManager();
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("result_status", Integer.valueOf(!isSuccess ? 1 : 0));
        pairArr[1] = TuplesKt.to("bundle_name", this.resId);
        pairArr[2] = TuplesKt.to(ReportDataBuilder.KEY_BUNDLE_ID, Long.valueOf(res != null ? res.getVersion() : -1L));
        pairArr[3] = TuplesKt.to("cost_time", Long.valueOf(cost));
        pairArr[4] = TuplesKt.to("type", Integer.valueOf(!forceRequestConfig ? 1 : 0));
        ExecuteContextMode executeContextMode = ExecuteContextMode.DEX;
        pairArr[5] = TuplesKt.to("config_mode", executeContextMode);
        pairArr[6] = TuplesKt.to("execute_mode", executeContextMode);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        IECDataReport.a.a(eCDataReportManager, "ec_quality_ktv_page_download_result", mapOf, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(b this$0, C11343b resCallback, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resCallback, "$resCallback");
        this$0.resHub.j(this$0.resId, resCallback, z16);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    public String a(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return m(this.latestResInfo, pageName);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    public File b() {
        g gVar = this.latestResInfo;
        if (gVar != null) {
            return new File(gVar.e());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    public boolean c() {
        if (this.requestConfig.a().isEmpty()) {
            return false;
        }
        return this.requestConfig.a().contains(this.resId);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[Catch: JSONException -> 0x00a4, TryCatch #0 {JSONException -> 0x00a4, blocks: (B:9:0x0023, B:12:0x0034, B:14:0x0043, B:16:0x0049, B:18:0x0065, B:25:0x0084, B:26:0x0073, B:32:0x0097), top: B:8:0x0023 }] */
    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DexConfig d() {
        File file;
        String readFileContent;
        boolean z16;
        String str;
        String l3 = l(this.latestResInfo, "kuikly_config.json");
        if (l3 != null && new File(l3).exists() && (readFileContent = FileUtils.readFileContent((file = new File(l3)))) != null) {
            try {
                JSONObject jSONObject = new JSONObject(readFileContent);
                JSONArray optJSONArray = jSONObject.optJSONArray("baseDex");
                String str2 = "";
                if (optJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"baseDex\")");
                    int length = optJSONArray.length();
                    String str3 = "";
                    for (int i3 = 0; i3 < length; i3++) {
                        String parent = file.getParent();
                        String str4 = parent != null ? parent + File.separator + optJSONArray.get(i3) : null;
                        if (str4 != null && str4.length() != 0) {
                            z16 = false;
                            if (!z16) {
                                str = "";
                            } else {
                                str = str4 + File.pathSeparator;
                            }
                            str3 = ((Object) str3) + str;
                        }
                        z16 = true;
                        if (!z16) {
                        }
                        str3 = ((Object) str3) + str;
                    }
                    str2 = str3;
                }
                return new DexConfig(jSONObject.optLong("tag"), str2);
            } catch (JSONException e16) {
                QLog.e("QQKuiklyResShiplyFetcher", 1, "getDexConfig " + e16);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    public void deleteBundle(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        this.resHub.m(resId);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    public void e(boolean forceUpdate, Function1<? super ResError, Unit> result) {
        long coerceAtMost;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(Math.abs(serverTimeMillis - this.resHub.k()), Math.abs(serverTimeMillis - this.resHub.getLastRequestServerTime(this.resId)));
        boolean c16 = c();
        final boolean z16 = forceUpdate || coerceAtMost > ((long) ((this.requestConfig.getRequestBundleConfigGapMin() * 60) * 1000));
        final C11343b c11343b = new C11343b(serverTimeMillis, forceUpdate, c16, coerceAtMost, z16, this, result);
        ThreadManagerV2.excute(new Runnable() { // from class: uf2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.o(b.this, c11343b, z16);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    public long f() {
        g gVar = this.latestResInfo;
        if (gVar != null) {
            return gVar.getVersion();
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    public long g() {
        if (!TextUtils.isEmpty(this.resId)) {
            long lastRequestServerTime = this.resHub.getLastRequestServerTime(this.resId);
            long k3 = this.resHub.k();
            return lastRequestServerTime > k3 ? lastRequestServerTime : k3;
        }
        return this.resHub.k();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c
    public long h() {
        g l3 = this.resHub.l(this.resId);
        if (l3 == null) {
            return 0L;
        }
        return l3.getVersion();
    }

    private final String l(g res, String fileName) {
        if (res == null) {
            return null;
        }
        return res.e() + fileName;
    }
}
