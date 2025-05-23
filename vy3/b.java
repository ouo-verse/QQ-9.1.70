package vy3;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f443751a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f443752b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f443753c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f443754d = false;

    /* renamed from: e, reason: collision with root package name */
    public String f443755e = "0.0f|0.0f|0.0f|0.0f";

    /* renamed from: f, reason: collision with root package name */
    public String f443756f = "-1";

    /* renamed from: g, reason: collision with root package name */
    public String f443757g = "-1";

    /* renamed from: h, reason: collision with root package name */
    public boolean f443758h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f443759i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f443760j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f443761k = true;

    public static b b(String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        if (str == null) {
            return null;
        }
        try {
            b bVar = new b();
            JSONObject jSONObject = new JSONObject(str);
            bVar.f443755e = jSONObject.optString("userratio_new", "0.0f|0.0f|0.0f|0.0f");
            bVar.f443756f = jSONObject.optString("extralsteps_new", "-1");
            bVar.f443757g = jSONObject.optString("predownloadwhitelist_new", "-1");
            bVar.f443758h = jSONObject.optBoolean("useapm_new", false);
            bVar.f443761k = jSONObject.optBoolean("suspendWhiteListOnly", true);
            Float valueOf = Float.valueOf(Float.parseFloat(jSONObject.optString("suspend_user_ratio", "0.0f")));
            if (valueOf != null) {
                if (valueOf.floatValue() > Math.random()) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                bVar.f443759i = z27;
            }
            Float valueOf2 = Float.valueOf(Float.parseFloat(jSONObject.optString("fake_suspend_user_ratio", "0.0f")));
            if (valueOf2 != null) {
                if (valueOf2.floatValue() > Math.random()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                bVar.f443760j = z26;
            }
            if (!bVar.f443755e.isEmpty()) {
                String[] split = bVar.f443755e.split("\\|");
                if (split.length == 4) {
                    float parseFloat = Float.parseFloat(split[0]);
                    float parseFloat2 = Float.parseFloat(split[1]);
                    float parseFloat3 = Float.parseFloat(split[2]);
                    float parseFloat4 = Float.parseFloat(split[3]);
                    if (parseFloat > Math.random()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    bVar.f443751a = z16;
                    if (parseFloat2 > Math.random()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    bVar.f443752b = z17;
                    if (parseFloat3 > Math.random()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    bVar.f443753c = z18;
                    if (parseFloat4 > Math.random()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    bVar.f443754d = z19;
                    QLog.d("Perf", 1, "disable_preload_user_ratio = " + parseFloat + ",disable_predownload_user_ratio = " + parseFloat2 + ",disable_gettroop_user_ratio = " + parseFloat3 + ",enable_auto_user_ratio = " + parseFloat4 + ",suspend_user_ratio = " + valueOf + ",fake_suspend_user_ratio = " + valueOf2);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Perf", 2, "confBean = " + bVar.toString());
            }
            return bVar;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("Perf", 1, "parse e:", th5.toString());
            }
            return null;
        }
    }

    public boolean a() {
        return !this.f443758h;
    }

    public String toString() {
        return "LowEndPerfBean{mDisablePreloadProcess=" + this.f443751a + ",mDisablePredownload=" + this.f443752b + ",mDisableGetTroopList=" + this.f443753c + ",mEnableAutomatorDelay=" + this.f443754d + ",mUserRatio=" + this.f443755e + ",mExtraSteps=" + this.f443756f + ",mPredownLoadWhiteList=" + this.f443757g + ",mUseApmConfig=" + this.f443758h + ",mSuspend_Thread=" + this.f443759i + ",mFake_Suspend_Thread = " + this.f443760j + ",mSuspendWhiteListThreadOnly = " + this.f443761k + '}';
    }
}
