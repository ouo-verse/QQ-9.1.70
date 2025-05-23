package pw2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i extends b {
    public static int h(boolean z16) {
        if (z16) {
            if (TextUtils.isEmpty(QAdDeviceUtils.j())) {
                return 3;
            }
            String j3 = QAdDeviceUtils.j();
            j3.hashCode();
            char c16 = '\uffff';
            switch (j3.hashCode()) {
                case -665462704:
                    if (j3.equals(QADNetStatus.UNAVAILABLE)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 1653:
                    if (j3.equals(QADNetStatus.G_2)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1684:
                    if (j3.equals(QADNetStatus.G_3)) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 1715:
                    if (j3.equals(QADNetStatus.G_4)) {
                        c16 = 3;
                        break;
                    }
                    break;
                case 3649301:
                    if (j3.equals("wifi")) {
                        c16 = 4;
                        break;
                    }
                    break;
                case 3662605:
                    if (j3.equals(QADNetStatus.WWAN)) {
                        c16 = 5;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    return 3;
                case 1:
                case 2:
                case 3:
                case 5:
                    return 2;
                case 4:
                    return 1;
            }
        }
        return 0;
    }

    public static void i(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th5) {
                n.b("QADUtil", th5.getMessage());
            }
        }
    }

    public static void j(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th5) {
                n.b("QADUtil", th5.getMessage());
            }
        }
    }

    @Nullable
    public static Activity k(@Nullable Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return ev2.a.a();
    }

    public static SharedPreferences l(String str) {
        Application a16;
        SharedPreferences c16 = ev2.h.c(str);
        if (c16 == null && (a16 = qv2.b.a()) != null) {
            return a16.getSharedPreferences(str, 0);
        }
        return c16;
    }

    public static boolean m(String str) {
        if (str != null && (str.startsWith("http://") || str.startsWith("https://"))) {
            return true;
        }
        return false;
    }

    public static boolean n(String str) {
        if (str != null && !"".equals(str)) {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        }
        return false;
    }

    public static String o(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            sb5.append(readLine);
        }
        return sb5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(String str, Map<String, String> map, iw2.a aVar) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        boolean z16;
        String str2 = "";
        InputStream inputStream2 = null;
        int i3 = 0;
        try {
            URL url = new URL(str);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                z16 = true;
                try {
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setRequestMethod("GET");
                    r(httpURLConnection, map);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode <= -1 || responseCode >= 400) {
                        z16 = false;
                    }
                    try {
                        n.e("QADUtil", "get response code=" + responseCode);
                        inputStream2 = httpURLConnection.getInputStream();
                        if (inputStream2 != null) {
                            str2 = o(inputStream2);
                        }
                        j(httpURLConnection);
                        i(inputStream2);
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = inputStream2;
                        inputStream2 = url;
                        try {
                            th.printStackTrace();
                            n.b("QADUtil", "report failed: " + inputStream2 + ", with exception" + th.getLocalizedMessage());
                            n.e("QADUtil", "sendGetRequest, url:" + str + ", succeed:" + z16 + ", listener:" + aVar);
                            if (aVar == null) {
                            }
                        } finally {
                            j(httpURLConnection);
                            i(inputStream);
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    z16 = false;
                }
            } catch (Throwable th7) {
                th = th7;
                httpURLConnection = null;
                z16 = false;
                inputStream2 = url;
                inputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            httpURLConnection = null;
            z16 = false;
        }
        n.e("QADUtil", "sendGetRequest, url:" + str + ", succeed:" + z16 + ", listener:" + aVar);
        if (aVar == null) {
            if (!z16) {
                i3 = -827;
            }
            aVar.a(i3, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void q(String str, String str2, Map<String, String> map, iw2.a aVar) {
        DataOutputStream dataOutputStream;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        boolean z16;
        int responseCode;
        String str3 = "";
        InputStream inputStream2 = null;
        int i3 = 0;
        try {
            URL url = new URL(str);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                z16 = true;
                try {
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Accept", "application/json");
                    httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    r(httpURLConnection, map);
                    if (!TextUtils.isEmpty(str2)) {
                        httpURLConnection.setDoOutput(true);
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream.write(str2.getBytes("UTF-8"));
                            dataOutputStream.flush();
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                            z16 = false;
                            inputStream2 = url;
                            try {
                                n.b("QADUtil", "report failed: " + inputStream2 + ", with exception" + th.getLocalizedMessage());
                                n.e("QADUtil", "sendPostRequest, url:" + str + ", succeed:" + z16 + ", listener:" + aVar);
                                if (aVar != null) {
                                }
                            } finally {
                                j(httpURLConnection);
                                i(dataOutputStream);
                                i(inputStream);
                            }
                        }
                    } else {
                        dataOutputStream = null;
                    }
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode <= -1 || responseCode >= 400) {
                        z16 = false;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    dataOutputStream = null;
                    inputStream = null;
                }
                try {
                    n.e("QADUtil", "post response code=" + responseCode);
                    inputStream2 = httpURLConnection.getInputStream();
                    if (inputStream2 != null) {
                        str3 = o(inputStream2);
                    }
                    j(httpURLConnection);
                    i(dataOutputStream);
                    i(inputStream2);
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = inputStream2;
                    inputStream2 = url;
                    n.b("QADUtil", "report failed: " + inputStream2 + ", with exception" + th.getLocalizedMessage());
                    n.e("QADUtil", "sendPostRequest, url:" + str + ", succeed:" + z16 + ", listener:" + aVar);
                    if (aVar != null) {
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                dataOutputStream = null;
                inputStream = null;
                httpURLConnection = null;
            }
        } catch (Throwable th9) {
            th = th9;
            dataOutputStream = null;
            inputStream = null;
            httpURLConnection = null;
            z16 = false;
        }
        n.e("QADUtil", "sendPostRequest, url:" + str + ", succeed:" + z16 + ", listener:" + aVar);
        if (aVar != null) {
            if (!z16) {
                i3 = -827;
            }
            aVar.a(i3, str3);
        }
    }

    private static void r(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (!y.i(map) && httpURLConnection != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                n.e("QADUtil", "request head is = " + entry.toString());
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static String s(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
        } catch (Throwable th5) {
            n.a("QADUtil", "toJson, error=" + th5.getMessage());
            return "";
        }
    }
}
