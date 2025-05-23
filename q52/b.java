package q52;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.videoplatform.QAReport;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends a {

    /* renamed from: m0, reason: collision with root package name */
    public static Map<String, String> f428422m0 = new HashMap();

    private HashMap<String, String> b() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>(f428422m0);
        hashMap.put("param_uin", com.tencent.mobileqq.kandian.base.utils.b.a());
        hashMap.put("param_vid", this.f428386b);
        hashMap.put("param_busiType", String.valueOf(this.f428388c));
        hashMap.put("param_sceneType", String.valueOf(this.f428411p));
        hashMap.put("param_vid2UrlTime", String.valueOf(this.f428412q));
        hashMap.put("param_vid2UrlErrorCode", String.valueOf(this.f428413r));
        hashMap.put("param_isHitCache", String.valueOf(this.f428419x));
        hashMap.put("param_jumpFromScene", String.valueOf(this.f428421z));
        hashMap.put("param_index", String.valueOf(this.A));
        hashMap.put(QAReport.REPORT_KEY_VIDEO_BITRATE, String.valueOf(this.B));
        hashMap.put("param_downloadedDuration", String.valueOf(this.D));
        hashMap.put("param_totalDuration", String.valueOf(this.G));
        hashMap.put("param_videoCodeFormat", String.valueOf(this.J));
        hashMap.put("param_fileBitRate", c());
        hashMap.put("param_preloadStatus", String.valueOf(this.L));
        String str2 = this.f428384a;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("param_rowKey", str2);
        StringBuilder sb5 = new StringBuilder();
        String str3 = AppSetting.f99551k;
        sb5.append(str3);
        sb5.append(".");
        sb5.append(AppSetting.f99542b);
        hashMap.put("param_version", sb5.toString());
        hashMap.put("param_subversion", str3);
        hashMap.put("param_bandwidth", String.valueOf(this.f428389c0));
        hashMap.put("param_isSeamlessPlay", String.valueOf(this.f428399h0));
        hashMap.put("param_loop_count", String.valueOf(this.f428392e));
        if (this.f428407l0) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("param_first_video", str);
        return hashMap;
    }

    private String c() {
        int i3 = this.f428388c;
        if ((i3 == 2 || i3 == 6) && !TextUtils.isEmpty(this.f428386b)) {
            return this.K;
        }
        long j3 = this.C;
        if (j3 != 0) {
            long j16 = this.G;
            if (j16 != 0) {
                return String.valueOf((j3 * 8) / (j16 * 1024));
            }
            return "0";
        }
        return "0";
    }

    @Override // q52.a
    public HashMap<String, String> a() {
        return b();
    }
}
