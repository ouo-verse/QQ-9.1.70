package t74;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ8\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0007J2\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0007\u00a8\u0006\u000e"}, d2 = {"Lt74/r;", "", "", "pageCode", "modeCode", "eventCode", "", "params", "", "c", com.heytap.mcssdk.a.a.f36102l, "d", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class r {

    /* renamed from: a */
    public static final r f435587a = new r();

    static {
        UserAction.registerTunnel(new TunnelInfo("0AND0FB8I14UU93I", AppSetting.n(), "1000"));
    }

    r() {
    }

    @JvmStatic
    public static final void c(final String pageCode, final String modeCode, final String eventCode, final Map<String, String> params) {
        Intrinsics.checkNotNullParameter(pageCode, "pageCode");
        Intrinsics.checkNotNullParameter(modeCode, "modeCode");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        ThreadManagerV2.excute(new Runnable() { // from class: t74.q
            @Override // java.lang.Runnable
            public final void run() {
                r.f(pageCode, modeCode, eventCode, params);
            }
        }, 128, null, false);
    }

    @JvmStatic
    public static final void d(final String r16, final String eventCode, final Map<String, String> params) {
        Intrinsics.checkNotNullParameter(r16, "appKey");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        ThreadManagerV2.excute(new Runnable() { // from class: t74.p
            @Override // java.lang.Runnable
            public final void run() {
                r.g(params, r16, eventCode);
            }
        }, 128, null, false);
    }

    public static final void f(String pageCode, String modeCode, String eventCode, Map map) {
        Intrinsics.checkNotNullParameter(pageCode, "$pageCode");
        Intrinsics.checkNotNullParameter(modeCode, "$modeCode");
        Intrinsics.checkNotNullParameter(eventCode, "$eventCode");
        String str = pageCode + '#' + modeCode + '#' + eventCode;
        HashMap hashMap = new HashMap();
        String currentUin = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        hashMap.put("qqUin", currentUin);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        if (map != null) {
            hashMap.putAll(map);
        }
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            sb5.append((String) entry.getKey());
            sb5.append(":");
            sb5.append((String) entry.getValue());
            sb5.append(";");
        }
        QLog.d("ZPlanBeaconReportUtil", 1, "report " + str + " ; params:  " + ((Object) sb5));
        ReportMethodProxy.onUserActionToTunnel("0AND0FB8I14UU93I", str, hashMap, true, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0030, code lost:
    
        r7 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void g(Map map, String appKey, String eventCode) {
        Map<String, String> linkedHashMap;
        String str;
        Intrinsics.checkNotNullParameter(appKey, "$appKey");
        Intrinsics.checkNotNullParameter(eventCode, "$eventCode");
        boolean z16 = !s.f435588a.a();
        int perfLevel = DeviceInfoUtils.getPerfLevel();
        double ceil = Math.ceil(c.b() / 1024.0d);
        d dVar = d.f435534a;
        String b16 = dVar.b();
        String a16 = dVar.a();
        if (map == null || linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        linkedHashMap.put("app_background", str);
        linkedHashMap.put("device_level", String.valueOf(perfLevel));
        linkedHashMap.put("device_memory", String.valueOf(ceil));
        linkedHashMap.put("device_gpu_name", b16);
        linkedHashMap.put("device_opengl_es_version", a16);
        linkedHashMap.put("device_processors_number", String.valueOf(ah.n()));
        linkedHashMap.put("device_net_type", String.valueOf(HttpUtil.getNetWorkTypeContain5G()));
        String currentUin = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        linkedHashMap.put("params_uin", currentUin);
        linkedHashMap.put("params_timestamp", String.valueOf(System.currentTimeMillis()));
        linkedHashMap.put("params_enable_binary", String.valueOf(((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableLocalShaderBinary()));
        linkedHashMap.put("params_enable_portal_lazy_init_view", "false");
        linkedHashMap.put("params_enable_new_portal", String.valueOf(((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).enableZPlanFilamentNewPortal()));
        EventResult report = BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey(appKey).withCode(eventCode).withParams(linkedHashMap).build());
        if (QLog.isColorLevel()) {
            QLog.i("ZPlanBeaconReportUtil", 2, "report EventResult{ eventID:" + report.eventID + ", errorCode:" + report.errorCode + ", errorMsg:" + report.errMsg + "}, appKey:" + appKey + ", eventCode:" + eventCode + ", params:" + linkedHashMap);
        }
    }

    public static /* synthetic */ void e(String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "0AND0YAG6R40RLM6";
        }
        if ((i3 & 4) != 0) {
            map = null;
        }
        d(str, str2, map);
    }
}
