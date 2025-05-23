package st0;

import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.icgame.common.api.IICGameCrashReportApi;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f434678a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f434679b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f434680c = "";

    /* renamed from: d, reason: collision with root package name */
    private static OkHttpClient f434681d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f434682e;

    /* renamed from: f, reason: collision with root package name */
    private static long f434683f;

    /* renamed from: g, reason: collision with root package name */
    private static final HashSet<String> f434684g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f434685h;

    /* renamed from: i, reason: collision with root package name */
    private static final Runnable f434686i;

    /* renamed from: j, reason: collision with root package name */
    private static final List<f> f434687j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f434688k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f434689a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f434690b;

        a(String str, boolean z16) {
            this.f434689a = str;
            this.f434690b = z16;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.i("ICGameLiveAegisLog", 1, "finalUrl=" + this.f434689a + ",fail: " + iOException.toString());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            if (this.f434690b) {
                QMMKV.from(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext(), QMMKVFile.FILE_ICGAME).removeKey("key_cache_qqlive_crash_info_" + e.f434680c);
            }
            try {
                response.close();
            } catch (Exception e16) {
                QLog.e("ICGameLiveAegisLog", 1, "response.close() e= " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f434691a;

        b(String str) {
            this.f434691a = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.e("ICGameLiveAegisLog", 1, "finalUrl=" + this.f434691a + ",fail: " + iOException.toString());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            try {
                response.close();
            } catch (Exception e16) {
                QLog.e("ICGameLiveAegisLog", 1, "reportEvent response.close() e= " + e16);
            }
        }
    }

    static {
        Handler handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        f434685h = handler;
        f434686i = new Runnable() { // from class: st0.a
            @Override // java.lang.Runnable
            public final void run() {
                e.v(false);
            }
        };
        f434687j = new ArrayList(10);
        f434688k = ah.Q(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext());
        handler.post(new Runnable() { // from class: st0.b
            @Override // java.lang.Runnable
            public final void run() {
                e.u();
            }
        });
    }

    @Deprecated
    public static void A(String str, int i3, String str2) {
        QLog.w(str, i3, str2);
        if (1 == i3) {
            x(str2, str, "5");
        }
    }

    public static void B(String str, String str2) {
        A(str, 1, str2);
    }

    public static void f(String str, String str2) {
        g(str, str2, null);
    }

    public static void g(String str, String str2, tt0.a aVar) {
        QLog.e(str, 1, str2);
        if (aVar == null) {
            aVar = tt0.a.a();
        }
        y("[process:" + aVar.f437439b + "]" + str2, str, "2048", aVar.f437438a, aVar.f437440c);
        if (aVar.f437440c) {
            QMMKV.from(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext(), QMMKVFile.FILE_ICGAME).encodeString("key_cache_qqlive_crash_info_" + f434680c, str2);
        }
    }

    private static void h(boolean z16, boolean z17) {
        List<f> list = f434687j;
        if (list.size() != 10 && !z16) {
            if (list.size() <= 1) {
                f434685h.postDelayed(f434686i, 8000L);
                return;
            }
            return;
        }
        v(z17);
    }

    public static void i(String str, String str2) {
        QLog.d(str, 2, str2);
    }

    @Deprecated
    public static void j(String str, int i3, String str2) {
        QLog.e(str, i3, str2);
        if (1 == i3) {
            x(str2, str, "4");
        }
    }

    public static void k(String str, String str2) {
        j(str, 1, str2);
    }

    public static void l(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
        x(str2 + "," + th5, str, "4");
    }

    private static OkHttpClient m() {
        if (f434681d == null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            f434681d = okHttpClient;
            okHttpClient.dispatcher().setMaxRequests(2);
            f434681d.dispatcher().setMaxRequestsPerHost(2);
            if (f434681d.dispatcher().executorService() instanceof ThreadPoolExecutor) {
                ((ThreadPoolExecutor) f434681d.dispatcher().executorService()).setMaximumPoolSize(4);
            }
        }
        return f434681d;
    }

    @Deprecated
    public static void n(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
        if (1 == i3) {
            x(str2, str, "2");
        }
    }

    public static void o(String str, String str2) {
        n(str, 1, str2);
    }

    private static void p() {
        JsonArray jsonArray;
        f434680c = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        f434682e = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).isSwitchOn(ICGameQMCCConfigKeysKt.KEY_ICGAME_IN_AEGIS_WHITE_LIST, false);
        n("ICGameLiveAegisLog", 1, "isReportAegis=" + f434682e);
        try {
            jsonArray = ((ICGameAegisLogBean) ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_AEGIS_LOG_CONFIG, ICGameAegisLogBean.class, new ICGameAegisLogBean())).getTagsArray();
        } catch (OutOfMemoryError e16) {
            k("ICGameLiveAegisLog", "initAegisInfo getConfigBean oom=" + e16);
            jsonArray = null;
        }
        n("ICGameLiveAegisLog", 1, "mainPathConfigItem=" + jsonArray);
        if (jsonArray == null) {
            return;
        }
        for (int i3 = 0; i3 < jsonArray.size(); i3++) {
            try {
                String asString = jsonArray.get(i3).getAsString();
                if (!TextUtils.isEmpty(asString)) {
                    f434684g.add(asString);
                }
            } catch (UnsupportedOperationException e17) {
                k("ICGameLiveAegisLog", "initAegisInfo contentJsonArr e=" + e17);
            }
        }
        q();
        f434683f = System.currentTimeMillis();
    }

    private static void q() {
        String decodeString = QMMKV.from(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext(), QMMKVFile.FILE_ICGAME).decodeString("key_cache_qqlive_crash_info_" + f434680c, null);
        if (!TextUtils.isEmpty(decodeString)) {
            y(decodeString, ((IICGameCrashReportApi) QRoute.api(IICGameCrashReportApi.class)).getClass().getSimpleName(), "2048", "", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(String str, String str2, String str3, String str4, long j3, boolean z16) {
        if (!f434680c.equals(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount())) {
            p();
        }
        if (!f434682e && !f434684g.contains(str) && !"2048".equalsIgnoreCase(str2)) {
            return;
        }
        f fVar = new f();
        fVar.f434693b = "[" + f434688k + "]" + str3;
        fVar.f434694c = str2;
        fVar.f434692a = str;
        fVar.f434695d = str4;
        fVar.f434696e = String.valueOf(j3);
        f434687j.add(fVar);
        h("2048".equalsIgnoreCase(str2), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(String str, String str2, String str3) {
        if (!f434684g.contains("ReportAegisEventTag")) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("ext1", String.valueOf(str2));
            jSONObject.put("ext2", String.valueOf(str3));
        } catch (JSONException e16) {
            QLog.e("ICGameLiveAegisLog", 1, "reportEvent JSONException e= " + e16);
        }
        jSONArray.mo162put(jSONObject);
        String str4 = f434679b + "uin" + ContainerUtils.KEY_VALUE_DELIMITER + f434680c + ContainerUtils.FIELD_DELIMITER + "sessionId" + ContainerUtils.KEY_VALUE_DELIMITER + f434683f + "&payload=" + jSONArray.toString();
        m().newCall(new Request.Builder().url(str4).addHeader("Content-Type", "application/x-www-form-urlencoded").get().build()).enqueue(new b(str4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("https://aegis.qq.com/collect?id=BbqtKtIenzdyjzSbYP&count=1&version=");
        String str = f434688k;
        sb5.append(str);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("platform");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append("1");
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("ext1");
        sb5.append("=isDebug:");
        sb5.append(false);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        f434678a = sb5.toString();
        f434679b = "https://aegis.qq.com/collect/events?id=BbqtKtIenzdyjzSbYP&version=" + str + ContainerUtils.FIELD_DELIMITER + "platform" + ContainerUtils.KEY_VALUE_DELIMITER + "1" + ContainerUtils.FIELD_DELIMITER + "ext1=isDebug:false" + ContainerUtils.FIELD_DELIMITER;
        f434684g.add("ICGameAudienceView");
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(boolean z16) {
        List<f> list = f434687j;
        if (!list.isEmpty()) {
            w(z16);
        }
        f434685h.removeCallbacks(f434686i);
        list.clear();
    }

    private static void w(boolean z16) {
        String str = f434678a + "uin" + ContainerUtils.KEY_VALUE_DELIMITER + f434680c + ContainerUtils.FIELD_DELIMITER + "sessionId" + ContainerUtils.KEY_VALUE_DELIMITER + f434683f;
        FormBody.Builder builder = new FormBody.Builder();
        int i3 = 0;
        while (true) {
            List<f> list = f434687j;
            if (i3 < list.size()) {
                f fVar = list.get(i3);
                if (fVar != null) {
                    builder.addEncoded(String.format("msg[%d]", Integer.valueOf(i3)), "[" + fVar.f434696e + "]" + fVar.f434692a + "," + fVar.f434693b);
                    builder.addEncoded(String.format("level[%d]", Integer.valueOf(i3)), String.valueOf(fVar.f434694c));
                    builder.addEncoded(String.format("from[%d]", Integer.valueOf(i3)), String.valueOf(fVar.f434692a));
                    builder.addEncoded(String.format("ext1[%d]", Integer.valueOf(i3)), String.valueOf(fVar.f434692a));
                    builder.addEncoded(String.format("ext2[%d]", Integer.valueOf(i3)), String.valueOf(fVar.f434695d));
                }
                i3++;
            } else {
                builder.addEncoded("count", String.valueOf(list.size()));
                m().newCall(new Request.Builder().url(str).post(builder.build()).build()).enqueue(new a(str, z16));
                return;
            }
        }
    }

    private static void x(String str, String str2, String str3) {
        y(str, str2, str3, null, false);
    }

    private static void y(final String str, final String str2, final String str3, final String str4, final boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final long currentTimeMillis = System.currentTimeMillis();
            f434685h.post(new Runnable() { // from class: st0.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.r(str2, str3, str, str4, currentTimeMillis, z16);
                }
            });
        }
    }

    public static void z(final String str, final String str2, final String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f434685h.post(new Runnable() { // from class: st0.c
            @Override // java.lang.Runnable
            public final void run() {
                e.s(str, str2, str3);
            }
        });
    }
}
