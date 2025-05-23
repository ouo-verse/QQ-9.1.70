package un4;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J&\u0010\u0017\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001aj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dRP\u0010\"\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u001fj\b\u0012\u0004\u0012\u00020\u0004` 0\u001aj\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u001fj\b\u0012\u0004\u0012\u00020\u0004` `\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR0\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001aj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001d\u00a8\u0006&"}, d2 = {"Lun4/d;", "", "", "unionKey", "Lcom/tencent/mobileqq/ark/module/g;", "j", "appID", "", "f", "cb", DomainData.DOMAIN_NAME, "r", "key", "params", "k", "arkUin", "e", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "l", "appName", AdMetricTag.EVENT_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mUnionKeyCallbackPool", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "mAppIdCallbackPool", "mNotifyCallbackOfArkApp", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f439289a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, g> mUnionKeyCallbackPool = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, ArrayList<g>> mAppIdCallbackPool = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, g> mNotifyCallbackOfArkApp = new HashMap<>();

    d() {
    }

    private final void d(String appID, g cb5) {
        ArrayList<g> arrayList = mAppIdCallbackPool.get(appID);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.size() == 0) {
            f(appID);
        }
        if (arrayList.contains(cb5)) {
            return;
        }
        arrayList.add(cb5);
    }

    private final void e(String appID, String arkUin, g cb5) {
        mUnionKeyCallbackPool.put(l(appID, arkUin), cb5);
    }

    private final void f(String appID) {
        g gVar = new g() { // from class: un4.a
            @Override // com.tencent.mobileqq.ark.module.g
            public final boolean notify(String str, String str2, String str3) {
                boolean g16;
                g16 = d.g(str, str2, str3);
                return g16;
            }
        };
        n(appID, gVar);
        mNotifyCallbackOfArkApp.put(appID, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(final String str, final String str2, final String str3) {
        String str4;
        d dVar = f439289a;
        String k3 = dVar.k("arkuin", str3);
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        final g j3 = dVar.j(dVar.l(str4, k3));
        l.h("TimiArkCbCenter_", 1, "notify " + str + ", " + str2 + ", " + str3 + ", " + k3 + ", cb:" + j3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: un4.b
            @Override // java.lang.Runnable
            public final void run() {
                d.h(g.this, str, str2, str3);
            }
        });
        ThreadManagerV2.excute(new Runnable() { // from class: un4.c
            @Override // java.lang.Runnable
            public final void run() {
                d.i(str, str2, str3);
            }
        }, 128, null, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(g gVar, String str, String str2, String str3) {
        if (gVar != null) {
            gVar.notify(str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String str, String str2, String str3) {
        f439289a.m(str, str2, str3);
    }

    private final synchronized g j(String unionKey) {
        return mUnionKeyCallbackPool.get(unionKey);
    }

    private final String k(String key, String params) {
        if (params == null || Intrinsics.areEqual(params, "")) {
            return "";
        }
        try {
            String string = new JSONObject(params).getString(key);
            Intrinsics.checkNotNullExpressionValue(string, "param.getString(key)");
            return string;
        } catch (JSONException e16) {
            l.l("TimiArkCbCenter_", 1, "getDataForParam failed", e16);
            return "";
        }
    }

    private final String l(String appID, String arkUin) {
        return appID + "_" + arkUin;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0030, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(k("loadTimestamp", r7));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m(String appName, String eventName, String params) {
        Long longOrNull;
        l.i("TimiArkCbCenter_", "handleArkCommonNotify " + appName + ", " + eventName + ", " + params);
        if (Intrinsics.areEqual(eventName, "ark_load_finish") && longOrNull != null) {
            long longValue = longOrNull.longValue();
            String k3 = k("view", params);
            long currentTimeMillis = System.currentTimeMillis() - longValue;
            HashMap hashMap = new HashMap();
            hashMap.put("k_cost_time", String.valueOf(currentTimeMillis));
            if (appName == null) {
                appName = "";
            }
            hashMap.put("k_ark_app_id", appName);
            hashMap.put("k_ark_view", k3);
            ((ug4.b) mm4.b.b(ug4.b.class)).e("e_ark_load_finish", hashMap);
        }
    }

    private final void n(String appID, g cb5) {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(appID, cb5);
    }

    private final void p(g cb5) {
        Iterator<Map.Entry<String, ArrayList<g>>> it = mAppIdCallbackPool.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().remove(cb5);
        }
        for (Map.Entry<String, ArrayList<g>> entry : mAppIdCallbackPool.entrySet()) {
            if (entry.getValue().size() == 0) {
                r(entry.getKey());
            }
        }
    }

    private final void q(g cb5) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, g> entry : mUnionKeyCallbackPool.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue(), cb5)) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            mUnionKeyCallbackPool.remove((String) it.next());
        }
    }

    private final void r(String appID) {
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(appID, null);
    }

    public final synchronized void o(@NotNull String appID, @NotNull String arkUin, @NotNull g cb5) {
        Intrinsics.checkNotNullParameter(appID, "appID");
        Intrinsics.checkNotNullParameter(arkUin, "arkUin");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        e(appID, arkUin, cb5);
        d(appID, cb5);
    }

    public final synchronized void s(@NotNull g cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        q(cb5);
        p(cb5);
    }
}
