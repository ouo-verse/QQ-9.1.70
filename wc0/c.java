package wc0;

import android.annotation.TargetApi;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes5.dex */
public class c implements b {

    /* renamed from: c, reason: collision with root package name */
    protected a f445379c;

    /* renamed from: a, reason: collision with root package name */
    protected volatile boolean f445377a = false;

    /* renamed from: b, reason: collision with root package name */
    protected volatile boolean f445378b = false;

    /* renamed from: d, reason: collision with root package name */
    protected String f445380d = null;

    /* renamed from: e, reason: collision with root package name */
    protected int f445381e = 10;

    private void d(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e16) {
                hd0.c.u("Q.qqstory.download:DownloaderImp", "", e16);
                return;
            }
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private int e(java.lang.String r34, java.lang.String r35, java.util.HashMap<java.lang.String, java.lang.String> r36, int r37, long r38, boolean r40) {
        /*
            Method dump skipped, instructions count: 1625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: wc0.c.e(java.lang.String, java.lang.String, java.util.HashMap, int, long, boolean):int");
    }

    private HttpURLConnection h(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap, long j3) {
        String headerField;
        if (httpURLConnection == null) {
            headerField = null;
        } else {
            headerField = httpURLConnection.getHeaderField("Location");
        }
        hd0.c.a("Q.qqstory.download:DownloaderImp", "redirectConnection redirectUrl=" + headerField);
        if (TextUtils.isEmpty(headerField)) {
            return httpURLConnection;
        }
        try {
            URL url = new URL(headerField);
            if (!d.b(url)) {
                url = d.a(url);
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                i(httpURLConnection2, hashMap, j3);
                return httpURLConnection2;
            } catch (IOException e16) {
                e = e16;
                httpURLConnection = httpURLConnection2;
                hd0.c.h("Q.qqstory.download:DownloaderImp", "redirectConnection:", e);
                return httpURLConnection;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }

    private void i(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap, long j3) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        j(hashMap, httpURLConnection);
        httpURLConnection.setRequestProperty("Range", "bytes=" + j3 + "-");
    }

    public static void j(HashMap<String, String> hashMap, HttpURLConnection httpURLConnection) {
        if (hashMap == null) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                httpURLConnection.setRequestProperty(key, value);
            }
        }
    }

    @Override // wc0.b
    public int a(String str, String str2, long j3) {
        return e(str, str2, null, 65536, j3, false);
    }

    @Override // wc0.b
    public void b(a aVar) {
        this.f445379c = aVar;
    }

    public void c() {
        this.f445377a = true;
    }

    public String f() {
        return this.f445380d;
    }

    public boolean g() {
        return this.f445378b;
    }
}
