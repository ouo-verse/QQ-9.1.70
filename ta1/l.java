package ta1;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public List<a> f435702d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public Map<String, Long> f435703e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public String f435704f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f435705h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f435706i = "";

    /* renamed from: m, reason: collision with root package name */
    public String f435707m = "";

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String[] f435708a;

        /* renamed from: b, reason: collision with root package name */
        public String f435709b;

        /* renamed from: c, reason: collision with root package name */
        public String f435710c;

        /* renamed from: d, reason: collision with root package name */
        public String f435711d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f435712e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f435713f;

        public a(JSONObject jSONObject) {
            String optString = jSONObject.optString(MimeTypeParser.ATTR_EXTENSION);
            if (!TextUtils.isEmpty(optString)) {
                this.f435708a = optString.split("\\|");
            }
            this.f435709b = jSONObject.optString("text");
            this.f435710c = jSONObject.optString("tShow");
            this.f435711d = jSONObject.optString("tPress");
        }

        public boolean a(String str) {
            if (this.f435708a != null && str != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.f435708a;
                    if (i3 >= strArr.length) {
                        break;
                    }
                    if (str.equals(strArr[i3])) {
                        return true;
                    }
                    i3++;
                }
            }
            return false;
        }
    }

    public static l d(String str) {
        QLog.d("TencentDocLocalCooperationBean", 2, str);
        l lVar = new l();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("report")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("report");
                lVar.f435704f = jSONObject2.optString("inviteTShow");
                lVar.f435705h = jSONObject2.optString("inviteTClick");
                lVar.f435706i = jSONObject2.optString("stateTShow");
                lVar.f435707m = jSONObject2.optString("stateTClick");
            }
            if (jSONObject.has("viewTogether")) {
                a aVar = new a(jSONObject.getJSONObject("viewTogether"));
                aVar.f435712e = false;
                lVar.f435702d.add(aVar);
            }
            if (jSONObject.has("editTogether")) {
                a aVar2 = new a(jSONObject.getJSONObject("editTogether"));
                aVar2.f435712e = true;
                lVar.f435702d.add(aVar2);
            }
            if (jSONObject.has("viewPrivate")) {
                a aVar3 = new a(jSONObject.getJSONObject("viewPrivate"));
                aVar3.f435713f = true;
                lVar.f435702d.add(aVar3);
            }
            if (jSONObject.has("editSupport")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("editSupport");
                Iterator keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    lVar.f435703e.put(str2, Long.valueOf(jSONObject3.getLong(str2)));
                }
            }
        } catch (JSONException e16) {
            QLog.e("TencentDocLocalCooperationBean", 1, e16.getLocalizedMessage(), e16);
        }
        return lVar;
    }

    public a a(String str) {
        String noDotExtension = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getNoDotExtension(str);
        for (int i3 = 0; i3 < this.f435702d.size(); i3++) {
            a aVar = this.f435702d.get(i3);
            if (aVar.a(noDotExtension)) {
                return aVar;
            }
        }
        return null;
    }

    public boolean b(String str) {
        a a16 = a(str);
        if (a16 != null) {
            return a16.f435712e;
        }
        return false;
    }

    public boolean c(String str) {
        a a16 = a(str);
        if (a16 != null) {
            return a16.f435713f;
        }
        return false;
    }
}
