package sl3;

import android.os.Build;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.mtt.hippy.adapter.http.HippyHttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static HippyHttpAdapter f433952a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f433953b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f433954c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f433955d = "";

    /* renamed from: e, reason: collision with root package name */
    public static boolean f433956e = false;

    private static void a(JSONObject jSONObject) {
        try {
            jSONObject.put("platform", "Android").put("osVersion", Build.VERSION.SDK_INT).put("appName", f433953b).put("appVersion", f433954c);
        } catch (JSONException unused) {
        }
    }

    public static void b(long j3) {
        if (f433956e) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nv_cost_time", j3).put("page", f433955d);
            d("nativevue_hippy_performance", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static void c(boolean z16) {
        int i3;
        if (f433956e) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        try {
            jSONObject.put("success", i3).put("page", f433955d);
            d("nativevue_hippy_result", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static void d(String str, JSONObject jSONObject) throws JSONException {
        if (f433952a == null) {
            return;
        }
        a(jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        JSONArray mo162put = new JSONArray().mo162put(new JSONObject().put("count", 1).put("start", currentTimeMillis).put("id", 999).put("name", str).put("params", jSONObject));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", "383f92e96363f8001556765139223000").put("start", currentTimeMillis).put("status", 2).put("pages", new JSONArray()).put(LinkReportConstant$GlobalKey.EVENTS, mo162put);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type", 2).put("data", jSONObject2);
        JSONArray mo162put2 = new JSONArray().mo162put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("appkey", "0WEB0DKCOJ4I1V9Q").put("versionCode", "1.0.1").put("initTime", currentTimeMillis).put(IjkMediaMeta.IJKM_KEY_LANGUAGE, "zh-CN").put("msgs", mo162put2);
        HippyHttpRequest hippyHttpRequest = new HippyHttpRequest();
        hippyHttpRequest.setMethod("POST");
        hippyHttpRequest.setBody(jSONObject4.toString());
        hippyHttpRequest.setUrl("https://jrlts.beacon.qq.com/analytics/upload?tp=js");
        hippyHttpRequest.setConnectTimeout(5000);
        hippyHttpRequest.addHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        f433952a.sendRequest(hippyHttpRequest, new C11236a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: sl3.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C11236a implements HippyHttpAdapter.HttpTaskCallback {
        C11236a() {
        }

        @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback
        public void onTaskFailed(HippyHttpRequest hippyHttpRequest, Throwable th5) {
        }

        @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback
        public void onTaskSuccess(HippyHttpRequest hippyHttpRequest, HippyHttpResponse hippyHttpResponse) throws Exception {
        }
    }
}
