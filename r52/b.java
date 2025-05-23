package r52;

import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b f430765e;

    /* renamed from: f, reason: collision with root package name */
    private static MQLruCache<String, c> f430766f = new MQLruCache<>(300);

    /* renamed from: b, reason: collision with root package name */
    private Set<String> f430768b;

    /* renamed from: a, reason: collision with root package name */
    public Long f430767a = 0L;

    /* renamed from: c, reason: collision with root package name */
    private boolean f430769c = true;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f430770d = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface a {
    }

    b() {
    }

    public static b a() {
        if (f430765e == null) {
            synchronized (b.class) {
                if (f430765e == null) {
                    f430765e = new b();
                }
            }
        }
        return f430765e;
    }

    public static String b(String str) {
        c c16 = c(str);
        if (c16 != null) {
            return c16.f430754a;
        }
        return "";
    }

    public static c c(String str) {
        c cVar;
        if (TextUtils.isEmpty(str) || (cVar = f430766f.get(str)) == null || TextUtils.isEmpty(cVar.f430754a) || !cVar.a(NetConnInfoCenter.getServerTime())) {
            return null;
        }
        return cVar;
    }

    private boolean d(String str) {
        Set<String> set = this.f430768b;
        if (set == null) {
            return false;
        }
        boolean contains = set.contains(str);
        if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "isDomainInLocalDnsBlackList(), result = " + contains);
        }
        return contains;
    }

    public String[] e(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                URL url = new URL(str);
                String host = url.getHost();
                String protocol2 = url.getProtocol();
                String file = url.getFile();
                if (!TextUtils.isEmpty(host) && this.f430769c && !d(host)) {
                    ArrayList<String> reqDnsForIpList = InnerDns.getInstance().reqDnsForIpList(host, 1006);
                    int size = reqDnsForIpList != null ? reqDnsForIpList.size() : 0;
                    if (size > 0) {
                        String[] strArr = new String[size + 1];
                        for (int i3 = 0; i3 < size; i3++) {
                            if (!TextUtils.isEmpty(file) && file.indexOf(47) != 0) {
                                file = "/" + file;
                            }
                            String str3 = protocol2 + QzoneWebViewOfflinePlugin.STR_DEVIDER + reqDnsForIpList.get(i3) + file;
                            if (!str3.contains(ContainerUtils.FIELD_DELIMITER)) {
                                str2 = str3 + "?txhost=" + host;
                            } else {
                                str2 = str3 + "&txhost=" + host;
                            }
                            strArr[i3] = str2;
                        }
                        strArr[size] = str;
                        return strArr;
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.readinjoy.video.ThirdVideoManager", 2, "replaceDomain2Ip Exception:", e16);
                }
            }
        }
        return new String[]{str};
    }

    public void g(String str, a aVar) {
        f(str, null, aVar);
    }

    public void f(String str, String str2, a aVar) {
    }
}
