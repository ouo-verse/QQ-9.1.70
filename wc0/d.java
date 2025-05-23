package wc0;

import android.annotation.TargetApi;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes5.dex */
public class d {
    public static URL a(URL url) throws MalformedURLException {
        String host = url.getHost();
        int indexOf = host.indexOf(58);
        if (indexOf != -1) {
            String substring = host.substring(0, indexOf);
            int port = url.getPort();
            if (port == -1) {
                port = Integer.valueOf(host.substring(indexOf + 1)).intValue();
            }
            hd0.c.a("URLChecker", "url is not initilized correctly, so re-create it");
            return new URL(url.getProtocol(), substring, port, url.getFile());
        }
        return url;
    }

    public static boolean b(URL url) {
        if (url.getHost().indexOf(58) == -1) {
            return true;
        }
        return false;
    }
}
