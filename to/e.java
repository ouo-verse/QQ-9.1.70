package to;

import android.content.Context;
import com.qzone.util.n;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.NetworkUtils;
import com.tenpay.sdk.download.HttpOp;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static final class a {
    }

    public static HttpClient a(boolean z16) {
        ClientConnectionManager singleClientConnManager;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSoTimeout(basicHttpParams, HttpOp.HTTP_READTIMEOUT);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, "android-qzone");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), WebSocketImpl.DEFAULT_WSS_PORT));
        } catch (Exception unused) {
        }
        if (z16) {
            singleClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        } else {
            singleClientConnManager = new SingleClientConnManager(basicHttpParams, schemeRegistry);
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(singleClientConnManager, basicHttpParams);
        defaultHttpClient.setRoutePlanner(new DefaultHttpRoutePlanner(singleClientConnManager.getSchemeRegistry()));
        return defaultHttpClient;
    }

    public static HttpGet b(Context context, String str, a aVar) throws MalformedURLException {
        String h16 = h(str);
        String j3 = j(str);
        String g16 = g(j3);
        HttpGet httpGet = new HttpGet(j3);
        httpGet.addHeader("x-online-host", g16);
        if (h16 != null) {
            httpGet.addHeader("Referer", h16);
        }
        i(context, httpGet, aVar);
        return httpGet;
    }

    public static HttpPost c(Context context, String str, HttpEntity httpEntity, a aVar) throws MalformedURLException {
        String j3 = j(str);
        String g16 = g(j3);
        HttpPost httpPost = new HttpPost(j3);
        httpPost.addHeader("Host", g16);
        httpPost.addHeader("x-online-host", g16);
        if (httpEntity instanceof ByteArrayEntity) {
            httpPost.addHeader("Content-Type", "application/octet-stream");
            if (QZLog.isColorLevel()) {
                QZLog.i("clickreport", 2, "addHeader octet-stream called");
            }
        }
        httpPost.setEntity(httpEntity);
        i(context, httpPost, aVar);
        return httpPost;
    }

    private static void i(Context context, HttpRequest httpRequest, a aVar) {
        Proxy proxy;
        InetSocketAddress inetSocketAddress;
        if (!NetworkState.isMobile() || (proxy = NetworkUtils.getProxy(context, false)) == null || (inetSocketAddress = (InetSocketAddress) proxy.address()) == null) {
            return;
        }
        httpRequest.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(inetSocketAddress.getHostName(), inetSocketAddress.getPort()));
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "use proxy[host:" + inetSocketAddress.getHostName() + ",port:" + inetSocketAddress.getPort() + "]");
    }

    public static HttpResponse d(Context context, String str) throws ClientProtocolException, IOException {
        return e(context, str, null);
    }

    public static HttpResponse e(Context context, String str, a aVar) throws ClientProtocolException, IOException {
        return a(false).execute(b(context, str, aVar));
    }

    public static HttpResponse f(Context context, String str, HttpEntity httpEntity, String str2) throws ClientProtocolException, IOException {
        HttpClient a16 = a(false);
        HttpPost c16 = c(context, str, httpEntity, null);
        c16.setHeader("Referer", str2);
        return a16.execute(c16);
    }

    private static String h(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return n.a(str, null);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String g(String str) throws MalformedURLException {
        AssertUtil.assertTrue(str != null);
        return new URL(str).getAuthority();
    }

    private static String j(String str) {
        AssertUtil.assertTrue(str != null);
        String replace = str.trim().replace(" ", "");
        int indexOf = replace.indexOf(35);
        return indexOf > 0 ? replace.substring(0, indexOf) : replace;
    }
}
