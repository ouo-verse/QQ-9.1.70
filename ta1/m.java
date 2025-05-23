package ta1;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public String f435714d = HardCodeUtil.qqStr(R.string.f172769u23);

    /* renamed from: e, reason: collision with root package name */
    public String f435715e = HardCodeUtil.qqStr(R.string.u2_);

    /* renamed from: f, reason: collision with root package name */
    public String f435716f = HardCodeUtil.qqStr(R.string.u26);

    /* renamed from: h, reason: collision with root package name */
    public String f435717h = HardCodeUtil.qqStr(R.string.u28);

    /* renamed from: i, reason: collision with root package name */
    public String f435718i = HardCodeUtil.qqStr(R.string.f172767u21);

    public static m a(String str) {
        m mVar = new m();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("MyFileNameConfig");
            mVar.f435714d = optJSONObject.optString("tdfileTabName");
            mVar.f435715e = optJSONObject.optString("wyfileTabName");
            mVar.f435716f = optJSONObject.optString("tdlistTabviewName");
            mVar.f435717h = optJSONObject.optString("createTXDocTitle");
            mVar.f435718i = optJSONObject.optString("safeShareToastWording");
        } catch (JSONException e16) {
            QLog.e("TencentDocMyFileNameBean", 1, e16.getLocalizedMessage(), e16);
        }
        return mVar;
    }
}
