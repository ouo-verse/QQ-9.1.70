package ta1;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public List<a> f435686d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public Map<String, Long> f435687e = new HashMap();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String[] f435688a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f435689b;

        /* renamed from: c, reason: collision with root package name */
        public String f435690c;

        /* renamed from: d, reason: collision with root package name */
        public String f435691d;

        public a(JSONObject jSONObject) {
            String optString = jSONObject.optString("words");
            if (!TextUtils.isEmpty(optString)) {
                this.f435688a = optString.split("\\/");
            }
            String optString2 = jSONObject.optString("overlay");
            if (!TextUtils.isEmpty(optString2)) {
                this.f435689b = optString2.split("\\/");
            }
            this.f435690c = jSONObject.optString("optString");
            this.f435691d = jSONObject.optString("aioTips");
        }
    }

    public static i b(String str) {
        if (str != null && !str.isEmpty()) {
            QLog.d("TencentDocFormKeyWordsBean", 2, str);
            i iVar = new i();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("collection")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("collection");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        iVar.f435686d.add(new a(jSONArray.getJSONObject(i3)));
                    }
                }
                if (jSONObject.has("collectionTypeAndSize")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("collectionTypeAndSize");
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        iVar.f435687e.put(str2, Long.valueOf(jSONObject2.getLong(str2)));
                    }
                }
            } catch (JSONException e16) {
                QLog.e("TencentDocFormKeyWordsBean", 1, e16.getLocalizedMessage(), e16);
            }
            return iVar;
        }
        QLog.e("TencentDocFormKeyWordsBean", 1, "content is empty, return");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str) {
        boolean z16;
        for (int i3 = 0; i3 < this.f435686d.size(); i3++) {
            a aVar = this.f435686d.get(i3);
            if (aVar.f435688a != null) {
                int i16 = 0;
                while (true) {
                    String[] strArr = aVar.f435688a;
                    if (i16 >= strArr.length) {
                        break;
                    }
                    String str2 = strArr[i16];
                    if (str != null && str.indexOf(str2) >= 0) {
                        z16 = true;
                        break;
                    }
                    i16++;
                }
            }
            z16 = false;
            if (z16) {
                if (aVar.f435689b == null) {
                    return true;
                }
                int i17 = 0;
                while (true) {
                    String[] strArr2 = aVar.f435689b;
                    if (i17 < strArr2.length) {
                        String str3 = strArr2[i17];
                        if (str != null && str.indexOf(str3) >= 0) {
                            return true;
                        }
                        i17++;
                    }
                }
            }
        }
        return false;
    }
}
