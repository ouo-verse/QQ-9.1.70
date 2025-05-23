package w92;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.report.IOkHttpClientFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static a f445082b = new a();

    /* renamed from: a, reason: collision with root package name */
    private Callback f445083a = new C11470a();

    /* compiled from: P */
    /* renamed from: w92.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11470a implements Callback {
        C11470a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.e("TurtleReportCenter", 4, iOException, new Object[0]);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response == null) {
                QLog.e("TurtleReportCenter", 4, "response == null.");
                return;
            }
            if (response.code() == 200) {
                QLog.i("TurtleReportCenter", 4, "data report success.");
            }
            if (response.body() != null) {
                response.body().close();
            }
        }
    }

    a() {
    }

    private String a(Bundle bundle) {
        String string;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        String str = "";
        for (String str2 : bundle.keySet()) {
            if ("tid".equals(str2)) {
                str = bundle.getString(str2);
            } else if (!"bid".equals(str2)) {
                jSONArray.mo162put(str2);
                if (StringUtil.isEmpty(bundle.getString(str2))) {
                    string = "";
                } else {
                    string = bundle.getString(str2);
                }
                jSONArray2.mo162put(string);
            }
        }
        JSONArray jSONArray3 = new JSONArray();
        jSONArray3.mo162put(jSONArray2);
        try {
            return "&table=" + str + "&fields=" + URLEncoder.encode(jSONArray.toString(), "UTF-8") + "&datas=" + URLEncoder.encode(jSONArray3.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private void b(Bundle bundle) {
        Headers build = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded").add("Referer", "https://now.qq.com/").build();
        ((IOkHttpClientFactory) QRoute.api(IOkHttpClientFactory.class)).getRequestClient().newCall(new Request.Builder().url("https://now.qq.com/cgi-bin/now/web/tdw/report").headers(build).post(RequestBody.create(MediaType.get("application/x-www-form-urlencoded"), a(bundle))).build()).enqueue(this.f445083a);
    }

    public void c(Bundle bundle) {
        if (bundle == null) {
            QLog.d("TurtleReportCenter", 4, "send(): no data to report");
        } else {
            b(bundle);
        }
    }
}
