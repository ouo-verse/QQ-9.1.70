package yt3;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f451197a;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f451197a = hashMap;
        hashMap.put("ConnectException", 3);
        f451197a.put("FileNotFoundException", 8);
        f451197a.put("SSLException", 16);
        f451197a.put("SSLHandshakeException", 17);
        f451197a.put("SSLKeyException", 18);
        f451197a.put("SSLPeerUnverifiedException", 19);
        f451197a.put("SSLProtocolException", 20);
        f451197a.put("SocketException", 21);
        f451197a.put("SocketTimeoutException", 5);
        f451197a.put("XmlPullParserException", 15);
        f451197a.put("UnknownHostException", 2);
        f451197a.put("UnsupportedEncodingException", 15);
    }

    public static int a(Throwable th5) {
        if (th5 == null) {
            return 1;
        }
        for (Map.Entry<String, Integer> entry : f451197a.entrySet()) {
            if (th5.toString().contains(entry.getKey())) {
                return entry.getValue().intValue();
            }
        }
        return 1;
    }
}
