package rr2;

import com.tencent.hippy.qq.utils.HippyReporter;
import cooperation.qzone.remote.ServiceConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ag {

    /* renamed from: a, reason: collision with root package name */
    public int f432040a;

    /* renamed from: b, reason: collision with root package name */
    public String f432041b;

    /* renamed from: c, reason: collision with root package name */
    public String f432042c;

    /* renamed from: d, reason: collision with root package name */
    public String f432043d;

    /* renamed from: e, reason: collision with root package name */
    public String f432044e;

    /* renamed from: f, reason: collision with root package name */
    public int f432045f;

    /* renamed from: g, reason: collision with root package name */
    public String f432046g;

    /* renamed from: h, reason: collision with root package name */
    public String f432047h;

    /* renamed from: i, reason: collision with root package name */
    public String f432048i;

    public ag(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f432040a = jSONObject.optInt("errcode");
            this.f432041b = jSONObject.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.f432042c = optJSONObject.optString(ServiceConst.PARA_SESSION_ID);
            this.f432043d = optJSONObject.optString("credential_id");
            this.f432044e = optJSONObject.optString("real_name");
            this.f432045f = optJSONObject.optInt("new_account");
            this.f432046g = optJSONObject.optString("cid_type");
            this.f432047h = optJSONObject.optString("openid");
            this.f432048i = optJSONObject.optString("uid");
        } catch (Exception e16) {
            e16.printStackTrace();
            this.f432040a = -1;
            this.f432041b = e16.getMessage();
        }
    }

    public String toString() {
        return "YuekangmaLoginRsp{errorCode=" + this.f432040a + ", errorMessage='" + this.f432041b + "', sessionId='" + this.f432042c + "', credentialId='" + this.f432043d + "', realName='" + this.f432044e + "', newAccount=" + this.f432045f + ", cidType='" + this.f432046g + "', openId='" + this.f432047h + "', uid='" + this.f432048i + "'}";
    }
}
