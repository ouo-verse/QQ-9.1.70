package rr2;

import com.tencent.hippy.qq.utils.HippyReporter;
import java.util.ArrayList;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    public int f432028a;

    /* renamed from: b, reason: collision with root package name */
    public String f432029b;

    /* renamed from: c, reason: collision with root package name */
    public String f432030c;

    /* renamed from: d, reason: collision with root package name */
    public String f432031d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<a> f432032e = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f432033a;

        /* renamed from: b, reason: collision with root package name */
        public String f432034b;

        /* renamed from: c, reason: collision with root package name */
        public String f432035c;

        /* renamed from: d, reason: collision with root package name */
        public String f432036d;

        /* renamed from: e, reason: collision with root package name */
        public String f432037e;

        /* renamed from: f, reason: collision with root package name */
        public int f432038f;

        /* renamed from: g, reason: collision with root package name */
        public int f432039g;

        public a(JSONObject jSONObject, Cipher cipher) {
            this.f432033a = jSONObject.optString("cid");
            this.f432034b = jSONObject.optString("encrypt_cid");
            this.f432036d = jSONObject.optString("name");
            this.f432037e = jSONObject.optString("card_type");
            this.f432038f = jSONObject.optInt("role");
            this.f432039g = jSONObject.optInt("certified");
            this.f432035c = ae.l(this.f432034b, cipher);
        }

        public String toString() {
            return "FamilyMemberInfo{cid='" + this.f432033a + "', encryptCid='" + this.f432034b + "', decryptCid='" + this.f432035c + "', name='" + this.f432036d + "', cardType='" + this.f432037e + "', role=" + this.f432038f + ", certified=" + this.f432039g + '}';
        }
    }

    public af(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f432028a = jSONObject.optInt("errcode");
            this.f432029b = jSONObject.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG);
            this.f432030c = jSONObject.optString("hint");
            this.f432031d = jSONObject.optString("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                Cipher g16 = ae.g();
                JSONArray optJSONArray = optJSONObject.optJSONArray("family_list");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        this.f432032e.add(new a(optJSONObject2, g16));
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            this.f432028a = -1;
            this.f432029b = e16.getMessage();
        }
    }

    public String toString() {
        return "YuekangmaGetFamilyListRsp{errorCode=" + this.f432028a + ", errorMessage='" + this.f432029b + "', hint='" + this.f432030c + "', time='" + this.f432031d + "', familyMemberList=" + this.f432032e + '}';
    }
}
