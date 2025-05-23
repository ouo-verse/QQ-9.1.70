package v32;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements com.tencent.mobileqq.qqlive.report.tianjige.a {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f440904a = null;

    private JSONObject d() {
        JSONObject jSONObject = this.f440904a;
        if (jSONObject != null) {
            return jSONObject;
        }
        String rawConfig = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getRawConfig(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIVE_OPEN_TELEMETRY_CONFIG, "");
        if (TextUtils.isEmpty(rawConfig)) {
            JSONObject jSONObject2 = new JSONObject();
            this.f440904a = jSONObject2;
            return jSONObject2;
        }
        try {
            JSONObject jSONObject3 = new JSONObject(rawConfig);
            this.f440904a = jSONObject3;
            return jSONObject3;
        } catch (JSONException e16) {
            QLog.i("ICGameOpenTelemetrySwitch", 1, "getGraySwitchJson exception:" + e16.getMessage());
            return null;
        }
    }

    private boolean e(String str) {
        String rawConfig = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getRawConfig(str, "");
        QLog.i("ICGameOpenTelemetrySwitch", 1, "rawConfig " + rawConfig);
        if (TextUtils.isEmpty(rawConfig)) {
            return false;
        }
        try {
        } catch (JSONException e16) {
            QLog.i("ICGameOpenTelemetrySwitch", 1, "isNumTelemetryColor exception:" + e16.getMessage());
        }
        if (new JSONObject(rawConfig).getInt("telemetry_color") == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.a
    public boolean a() {
        try {
            if (d() != null) {
                int i3 = d().getInt("telemetry_exception_report");
                QLog.i("ICGameOpenTelemetrySwitch", 1, "TELEMETRY_EXCEPTION_REPORT enable:" + i3);
                if (i3 != 1) {
                    return false;
                }
                return true;
            }
        } catch (JSONException e16) {
            QLog.i("ICGameOpenTelemetrySwitch", 1, "isExceptionReport exception:" + e16.getMessage());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.a
    public boolean b() {
        boolean e16 = e(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIVE_OPEN_TELEMETRY_NUMBER);
        QLog.i("ICGameOpenTelemetrySwitch", 1, "TELEMETRY_COLOR 1 enable:" + e16);
        if (e16) {
            return true;
        }
        boolean e17 = e(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIVE_OPEN_TELEMETRY_LAST_NUMBER);
        QLog.i("ICGameOpenTelemetrySwitch", 1, "TELEMETRY_COLOR 2 enable:" + e17);
        return e17;
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.a
    public double c() {
        try {
            if (d() != null) {
                double d16 = d().getDouble("trace_sample");
                QLog.i("ICGameOpenTelemetrySwitch", 1, "TRACE_SAMPLE sample:" + d16);
                return d16;
            }
            return 0.0d;
        } catch (JSONException e16) {
            QLog.i("ICGameOpenTelemetrySwitch", 1, "getTraceSample exception:" + e16.getMessage());
            return 0.0d;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.a
    public boolean isEnable() {
        try {
            if (d() != null) {
                int i3 = d().getInt("telemetry_sdk_enable");
                QLog.i("ICGameOpenTelemetrySwitch", 1, "TELEMETRY_SDK_ENABLE enable:" + i3);
                if (i3 != 1) {
                    return false;
                }
                return true;
            }
        } catch (JSONException e16) {
            QLog.i("ICGameOpenTelemetrySwitch", 1, "isEnable exception:" + e16.getMessage());
        }
        return false;
    }
}
