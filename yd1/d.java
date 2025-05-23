package yd1;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yd1.b;
import yd1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private final List<c> f450193a = new ArrayList();

    public static c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        if ("paragraph".equals(optString)) {
            b bVar = new b();
            bVar.f450173d = c(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("sections");
            for (int i3 = 0; optJSONArray != null && i3 < optJSONArray.length(); i3++) {
                b.c e16 = e(optJSONArray.optJSONObject(i3));
                if (e16 != null) {
                    bVar.f450172c.add(e16);
                }
            }
            return bVar;
        }
        if ("pic".equals(optString)) {
            c.a aVar = new c.a();
            aVar.f450188c = jSONObject.optInt("index");
            return aVar;
        }
        if ("ref".equals(optString)) {
            c.b bVar2 = new c.b();
            bVar2.f450189c = jSONObject.optInt("index");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                bVar2.f450190d = optJSONObject.optString("url");
                bVar2.f450191e = optJSONObject.optString("title");
                try {
                    if (TextUtils.isEmpty(bVar2.f450190d)) {
                        bVar2.f450190d = URLEncoder.encode(bVar2.f450190d, "UTF-8");
                    }
                    if (TextUtils.isEmpty(bVar2.f450191e)) {
                        bVar2.f450191e = URLEncoder.encode(bVar2.f450191e, "UTF-8");
                    }
                } catch (Exception e17) {
                    QLog.e("RichText", 1, e17, new Object[0]);
                }
            }
            return bVar2;
        }
        if (!"video".equals(optString)) {
            return null;
        }
        c.C11605c c11605c = new c.C11605c();
        c11605c.f450192c = jSONObject.optInt("index");
        return c11605c;
    }

    private static b.C11604b c(JSONObject jSONObject) {
        b.C11604b c11604b = new b.C11604b();
        if (jSONObject == null) {
            return c11604b;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject == null) {
            return c11604b;
        }
        c11604b.f450179d = optJSONObject.optString("textAlignment");
        c11604b.f450180e = optJSONObject.optInt("fontSize");
        c11604b.f450176a = optJSONObject.optInt("serialType");
        return c11604b;
    }

    public static d d(String str) {
        JSONArray optJSONArray;
        d dVar = new d();
        if (TextUtils.isEmpty(str)) {
            return dVar;
        }
        try {
            optJSONArray = new JSONObject(str).optJSONArray("blocks");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                c b16 = b(optJSONArray.optJSONObject(i3));
                if (b16 != null) {
                    dVar.f450193a.add(b16);
                }
            }
            return dVar;
        }
        return dVar;
    }

    private static b.c e(JSONObject jSONObject) {
        b.a aVar = null;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        if ("text".equals(optString)) {
            b.d dVar = new b.d();
            dVar.f450182b = jSONObject.optString("text");
            JSONObject optJSONObject = jSONObject.optJSONObject("style");
            if (optJSONObject != null) {
                dVar.f450183c = optJSONObject.optBoolean("bold");
                dVar.f450184d = optJSONObject.optBoolean("underline");
                dVar.f450185e = optJSONObject.optBoolean("italic");
            }
            return dVar;
        }
        if (MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK.equals(optString)) {
            aVar = new b.a();
            aVar.f450175g = jSONObject.optInt("index");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
            if (optJSONObject2 != null) {
                aVar.f450183c = optJSONObject2.optBoolean("bold");
                aVar.f450184d = optJSONObject2.optBoolean("underline");
                aVar.f450185e = optJSONObject2.optBoolean("italic");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
            if (optJSONObject3 != null) {
                aVar.f450174f = optJSONObject3.optString("url");
                aVar.f450182b = optJSONObject3.optString("title");
                try {
                    if (TextUtils.isEmpty(aVar.f450174f)) {
                        aVar.f450174f = URLEncoder.encode(aVar.f450174f, "UTF-8");
                    }
                    if (TextUtils.isEmpty(aVar.f450182b)) {
                        aVar.f450182b = URLEncoder.encode(aVar.f450182b, "UTF-8");
                    }
                } catch (Exception e16) {
                    QLog.e("RichText", 1, e16, new Object[0]);
                }
            }
        }
        return aVar;
    }

    public List<c> a() {
        return this.f450193a;
    }

    @Override // yd1.a
    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.f450193a.size(); i3++) {
            jSONArray.mo162put(this.f450193a.get(i3).serialize());
        }
        try {
            jSONObject.put("blocks", jSONArray);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RichText{");
        stringBuffer.append("mBlocks=");
        stringBuffer.append(this.f450193a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
