package yd1;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends yd1.c {

    /* renamed from: c, reason: collision with root package name */
    public final List<c> f450172c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public C11604b f450173d = new C11604b();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a extends d {

        /* renamed from: f, reason: collision with root package name */
        public String f450174f;

        /* renamed from: g, reason: collision with root package name */
        public int f450175g;

        public a() {
            this.f450181a = MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK;
        }

        @Override // yd1.b.d, yd1.b.c
        public boolean a(c cVar) {
            if (!(cVar instanceof a) || !TextUtils.equals(this.f450181a, cVar.f450181a)) {
                return false;
            }
            a aVar = (a) cVar;
            if (this.f450183c != aVar.f450183c || this.f450184d != aVar.f450184d || this.f450185e != aVar.f450185e || !TextUtils.equals(aVar.f450174f, this.f450174f) || !TextUtils.equals(aVar.f450182b, this.f450182b)) {
                return false;
            }
            return true;
        }

        @Override // yd1.b.d, yd1.a
        public JSONObject serialize() {
            JSONObject serialize = super.serialize();
            try {
                serialize.put("index", this.f450175g);
                serialize.remove("text");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", URLEncoder.encode(this.f450174f, "UTF-8"));
                if (!TextUtils.isEmpty(this.f450182b)) {
                    jSONObject.put("title", URLEncoder.encode(this.f450182b, "UTF-8"));
                } else {
                    jSONObject.put("title", "");
                }
                serialize.put("data", jSONObject);
            } catch (UnsupportedEncodingException | JSONException e16) {
                QLog.e("ParagraphBlock", 1, e16, new Object[0]);
            }
            return serialize;
        }

        @Override // yd1.b.d
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("LinkSection{");
            stringBuffer.append("type='");
            stringBuffer.append(this.f450181a);
            stringBuffer.append('\'');
            stringBuffer.append(", text='");
            stringBuffer.append(this.f450182b);
            stringBuffer.append('\'');
            stringBuffer.append(", bold=");
            stringBuffer.append(this.f450183c);
            stringBuffer.append(", underline=");
            stringBuffer.append(this.f450184d);
            stringBuffer.append(", italic=");
            stringBuffer.append(this.f450185e);
            stringBuffer.append(", url='");
            stringBuffer.append(this.f450174f);
            stringBuffer.append('\'');
            stringBuffer.append(", index=");
            stringBuffer.append(this.f450175g);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* renamed from: yd1.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C11604b implements yd1.a {

        /* renamed from: b, reason: collision with root package name */
        public int f450177b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f450178c;

        /* renamed from: a, reason: collision with root package name */
        public int f450176a = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f450179d = "left";

        /* renamed from: e, reason: collision with root package name */
        public int f450180e = 16;

        @Override // yd1.a
        public JSONObject serialize() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("textAlignment", this.f450179d);
                jSONObject.put("fontSize", this.f450180e);
                jSONObject.put("serialType", this.f450176a);
                jSONObject.put("serialPropertyNumber", this.f450177b);
                jSONObject.put("serialPropertyIgnoreSpan", this.f450178c);
            } catch (JSONException e16) {
                QLog.e("ParagraphBlock", 1, e16, new Object[0]);
            }
            return jSONObject;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("ParagraphStyle{");
            stringBuffer.append("serialType=");
            stringBuffer.append(this.f450176a);
            stringBuffer.append(", textAlignment='");
            stringBuffer.append(this.f450179d);
            stringBuffer.append('\'');
            stringBuffer.append(", fontSize=");
            stringBuffer.append(this.f450180e);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static abstract class c implements yd1.a {

        /* renamed from: a, reason: collision with root package name */
        public String f450181a;

        public abstract boolean a(c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        public String f450182b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f450183c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f450184d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f450185e;

        public d() {
            this.f450181a = "text";
        }

        @Override // yd1.b.c
        public boolean a(c cVar) {
            if (!(cVar instanceof d) || !TextUtils.equals(this.f450181a, cVar.f450181a)) {
                return false;
            }
            d dVar = (d) cVar;
            if (this.f450183c != dVar.f450183c || this.f450184d != dVar.f450184d || this.f450185e != dVar.f450185e) {
                return false;
            }
            return true;
        }

        @Override // yd1.a
        public JSONObject serialize() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f450181a);
                jSONObject.put("text", this.f450182b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("bold", this.f450183c);
                jSONObject2.put("underline", this.f450184d);
                jSONObject2.put("italic", this.f450185e);
                jSONObject.put("style", jSONObject2);
            } catch (JSONException e16) {
                QLog.e("ParagraphBlock", 1, e16, new Object[0]);
            }
            return jSONObject;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("TextSection{");
            stringBuffer.append("text='");
            stringBuffer.append(this.f450182b);
            stringBuffer.append('\'');
            stringBuffer.append(", bold=");
            stringBuffer.append(this.f450183c);
            stringBuffer.append(", underline=");
            stringBuffer.append(this.f450184d);
            stringBuffer.append(", italic=");
            stringBuffer.append(this.f450185e);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public b() {
        this.f450186a = "paragraph";
    }

    @Override // yd1.a
    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f450186a);
            C11604b c11604b = this.f450173d;
            if (c11604b != null) {
                jSONObject.put("style", c11604b.serialize());
            }
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < this.f450172c.size(); i3++) {
                jSONArray.mo162put(this.f450172c.get(i3).serialize());
            }
            jSONObject.put("sections", jSONArray);
        } catch (JSONException e16) {
            QLog.e("ParagraphBlock", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ParagraphBlock{");
        stringBuffer.append("type='");
        stringBuffer.append(this.f450186a);
        stringBuffer.append('\'');
        stringBuffer.append(", sectionList=");
        stringBuffer.append(this.f450172c);
        stringBuffer.append(", style=");
        stringBuffer.append(this.f450173d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
