package pw2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.QAdStandardClickReportInfo;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdH5UrlItem;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class u {
    private static boolean a(@NonNull wv2.a aVar) {
        AdH5UrlItem adH5UrlItem;
        AdActionItem adActionItem = aVar.f446565a;
        if (adActionItem != null && (adH5UrlItem = adActionItem.adH5UrlItem) != null && !TextUtils.isEmpty(adH5UrlItem.url)) {
            return true;
        }
        return false;
    }

    public static AdActionItem b(AdActionItem adActionItem) {
        if (adActionItem == null) {
            return adActionItem;
        }
        try {
            byte[] byteArray = adActionItem.toByteArray();
            AdActionItem adActionItem2 = new AdActionItem();
            adActionItem2.readFrom(new JceInputStream(byteArray));
            return adActionItem2;
        } catch (Exception unused) {
            n.e("QAdUrlUtil", "cloneAdH5UrlItem error");
            return adActionItem;
        }
    }

    public static HashMap<String, String> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                String str3 = split[0];
                String a16 = iv2.d.a(split[1]);
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(a16)) {
                    hashMap.put(str3, a16);
                }
            }
        }
        return hashMap;
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            String[] split = str.split("\\?");
            if (split.length < 2) {
                return null;
            }
            return split[1];
        } catch (Exception e16) {
            n.b("QAdUrlUtil", "getUrlBody error, msg=" + e16.getMessage());
            return null;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        try {
            String[] split = str.split("\\?");
            if (split.length < 1) {
                return null;
            }
            return split[0];
        } catch (Exception e16) {
            n.b("QAdUrlUtil", "getUrlDomain error, msg=" + e16.getMessage());
            return null;
        }
    }

    public static String f(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) == -1) {
            return null;
        }
        return str.substring(0, indexOf + 1);
    }

    public static HashMap<String, String> g(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) == -1) {
            return null;
        }
        return c(str.substring(indexOf + 1));
    }

    private static boolean h(@Nullable wv2.a aVar) {
        AdActionItem adActionItem;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && adActionItem.adH5UrlItem != null) {
            return true;
        }
        return false;
    }

    public static boolean i(wv2.a aVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, boolean z16) {
        if (aVar == null || TextUtils.isEmpty(aVar.f446588x) || !h(aVar)) {
            return false;
        }
        if ((aVar.f446565a.adH5UrlItem.actionJumpType == 0 && !z16) || !aVar.f446588x.contains("__CNT__")) {
            return false;
        }
        String str = aVar.f446588x;
        String a16 = y.a(str);
        aVar.f446588x = a16;
        aVar.f446585u = z16;
        if (dVar instanceof QAdStandardClickReportInfo) {
            ((QAdStandardClickReportInfo) dVar).J(a16);
        }
        if (a(aVar)) {
            AdActionItem b16 = b(aVar.f446565a);
            AdH5UrlItem adH5UrlItem = b16.adH5UrlItem;
            adH5UrlItem.url = adH5UrlItem.url.replace(str, aVar.f446588x);
            aVar.f446585u = z16;
            aVar.f446565a = b16;
            n.e("QAdUrlUtil", "replaceClickId destUrl = " + aVar.f446565a.adH5UrlItem.url);
            return true;
        }
        return true;
    }

    public static String j(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    sb5.append(entry.getKey());
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(entry.getValue());
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
            }
            String sb6 = sb5.toString();
            return sb6.substring(0, sb6.lastIndexOf(ContainerUtils.FIELD_DELIMITER));
        }
        return null;
    }
}
