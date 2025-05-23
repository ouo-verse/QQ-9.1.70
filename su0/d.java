package su0;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.icgame.game.utils.g;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f434765a = "";

    public d(boolean z16) {
    }

    private Map<String, String> a(String str, @NonNull Map<String, String> map) {
        map.put(DTParamKey.REPORT_KEY_APPKEY, this.f434765a);
        map.put("is_online", String.valueOf(1));
        return map;
    }

    private Map<String, String> b(@NonNull Map<String, String> map) {
        return a("", map);
    }

    public synchronized void c(@NonNull String str, @NonNull Object obj, @NonNull Map<String, String> map) {
        b(map);
        VideoReport.reportEvent(str, obj, map);
    }

    public synchronized void d(@NonNull String str, @NonNull Map<String, String> map) {
        b(map);
        VideoReport.reportEvent(str, map);
    }

    public synchronized void e(String str) {
        this.f434765a = str;
    }

    public synchronized void f(@NonNull View view, boolean z16, @Nullable String str, @NonNull String str2, @NonNull Map<String, String> map, boolean z17) {
        b(map);
        VideoReport.setElementId(view, str2);
        if (z17) {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        } else {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, map);
        if (str != null) {
            VideoReport.setElementReuseIdentifier(view, str);
        }
        if (z16) {
            try {
                VideoReport.traverseExposure();
            } catch (ConcurrentModificationException e16) {
                g.d("ICGameGameDataReportImpl", "setElementInfo exception:" + e16);
            }
        }
    }

    public synchronized void g(@NonNull View view, boolean z16, @Nullable String str, @NonNull String str2, @NonNull Map<String, String> map) {
        b(map);
        VideoReport.setElementId(view, str2);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementParams(view, map);
        if (str != null) {
            VideoReport.setElementReuseIdentifier(view, str);
        }
        if (z16) {
            VideoReport.traverseExposure();
        }
    }

    public synchronized void h(@Nullable Object obj, @NonNull Object obj2, @NonNull String str, Map<String, String> map) {
        if ((obj instanceof Activity) || (obj instanceof Fragment) || (obj instanceof View) || (obj instanceof Dialog)) {
            if (obj instanceof Fragment) {
                VideoReport.addToDetectionWhitelist(((Fragment) obj).getActivity());
            }
            if (obj instanceof Activity) {
                VideoReport.addToDetectionWhitelist((Activity) obj);
            }
        }
        i(obj2, str, map);
    }

    public synchronized void i(@NonNull Object obj, @NonNull String str, Map<String, String> map) {
        if (!(obj instanceof Activity) && !(obj instanceof Fragment) && !(obj instanceof View) && !(obj instanceof Dialog)) {
            g.d("ICGameGameDataReportImpl", "\u9875\u9762\u4e0d\u662fActivity Fragment\u6216\u8005View");
        }
        if (obj instanceof Fragment) {
            VideoReport.addToDetectionWhitelist(((Fragment) obj).getActivity());
        }
        if (obj instanceof Activity) {
            VideoReport.addToDetectionWhitelist((Activity) obj);
        }
        if (map == null) {
            map = new ConcurrentHashMap<>();
        }
        PageParams pageParams = new PageParams(a(str, new ConcurrentHashMap(map)));
        VideoReport.setPageId(obj, str);
        VideoReport.setPageParams(obj, pageParams);
    }
}
