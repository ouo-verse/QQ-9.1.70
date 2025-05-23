package vl2;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator;
import com.tencent.oskplayer.util.HttpParser;
import com.tencent.oskplayer.util.MD5;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends DefaultVideoKeyGenerator {
    static String a(String str) {
        String[] split = str.split("/");
        for (int length = split.length - 1; length >= 0; length++) {
            if (split[length].length() > 0) {
                return split[length];
            }
        }
        return null;
    }

    private String b(String str, String str2) {
        return MD5.md5(str + str2).substring(0, 20);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0184  */
    @Override // com.tencent.oskplayer.proxy.DefaultVideoKeyGenerator, com.tencent.oskplayer.proxy.VideoKeyGenerator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String generate(String str) {
        URL url;
        if (!URLUtil.isNetworkUrl(str)) {
            return str;
        }
        Uri uri = null;
        try {
            url = new URL(str);
            try {
                uri = Uri.parse(str);
            } catch (MalformedURLException e16) {
                e = e16;
                PlayerUtils.log(6, "DefaultVideoKeyGenerator", PlayerUtils.getPrintableStackTrace(e));
                if (url != null) {
                }
                if (!TextUtils.isEmpty(str)) {
                }
                return super.generate(str);
            }
        } catch (MalformedURLException e17) {
            e = e17;
            url = null;
        }
        if (url != null) {
            String path = url.getPath();
            String host = url.getHost();
            if (!TextUtils.isEmpty(host) && host.toLowerCase().contains("qzvv.video.qq.com")) {
                Map<String, String> parseParams = HttpParser.parseParams(str);
                String a16 = a(path);
                if (parseParams != null && parseParams.containsKey(TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE)) {
                    a16 = a16 + parseParams.get(TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE);
                }
                return b("qzvv.video.qq.com", a16);
            }
            if ((!TextUtils.isEmpty(path) && b.d(path)) || (!TextUtils.isEmpty(host) && b.d(host))) {
                return b("ugc_video_ugc", uri.getLastPathSegment());
            }
            if ((!TextUtils.isEmpty(path) && b.f(path)) || (!TextUtils.isEmpty(host) && b.f(host))) {
                return b("weishi_video", uri.getLastPathSegment());
            }
            if ((!TextUtils.isEmpty(path) && b.e(path)) || (!TextUtils.isEmpty(host) && b.e(host))) {
                return b("weishi_ugc_video", uri.getLastPathSegment());
            }
            if (!TextUtils.isEmpty(path) && b.c(path) != null) {
                return b(b.c(path), uri.getLastPathSegment());
            }
            if (!TextUtils.isEmpty(host) && b.c(host) != null) {
                return b(b.c(host), uri.getLastPathSegment());
            }
            if (!TextUtils.isEmpty(host) && host.toLowerCase().equals("h5vv.video.qq.com")) {
                Map<String, String> parseParams2 = HttpParser.parseParams(str);
                if (parseParams2 != null && parseParams2.containsKey("vid")) {
                    str = parseParams2.get("vid");
                }
                return b("h5vv.video.qq.com", str);
            }
            if (!TextUtils.isEmpty(path) && b.b(path)) {
                String lastPathSegment = uri.getLastPathSegment();
                if (TextUtils.isEmpty(lastPathSegment)) {
                    lastPathSegment = a(path);
                }
                return b("content_video", lastPathSegment);
            }
            if (!TextUtils.isEmpty(host) && host.toLowerCase().endsWith("vod.myqcloud.com")) {
                String lastPathSegment2 = uri.getLastPathSegment();
                if (TextUtils.isEmpty(lastPathSegment2)) {
                    lastPathSegment2 = a(path);
                }
                return b("vod.myqcloud.com", lastPathSegment2);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("vkey=[A-Z0-9]+", "");
        }
        return super.generate(str);
    }
}
