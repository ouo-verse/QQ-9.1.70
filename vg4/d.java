package vg4;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.timi.game.utils.l;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f441642a = "";

    public d(boolean z16) {
        if (z16) {
            e("0S200MNJT807V3GE");
        }
    }

    private Map<String, String> a(String str, @NonNull Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(map.get("qqlive_user_id"))) {
                map.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06MK9E48EOTF");
            } else {
                map.put(DTParamKey.REPORT_KEY_APPKEY, this.f441642a);
            }
        } else if (((sm4.a) mm4.b.b(sm4.a.class)).y3() && TextUtils.equals(str, "pg_yes_smoba_team")) {
            map.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06MK9E48EOTF");
        } else {
            map.put(DTParamKey.REPORT_KEY_APPKEY, this.f441642a);
        }
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
        this.f441642a = str;
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
                l.e("TimiGameDataReportImpl", "setElementInfo exception:" + e16);
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
            l.e("TimiGameDataReportImpl", "\u9875\u9762\u4e0d\u662fActivity Fragment\u6216\u8005View");
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
