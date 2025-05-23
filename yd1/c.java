package yd1;

import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class c implements yd1.a {

    /* renamed from: a, reason: collision with root package name */
    public String f450186a;

    /* renamed from: b, reason: collision with root package name */
    public Object f450187b;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a extends c {

        /* renamed from: c, reason: collision with root package name */
        public int f450188c;

        public a() {
            this.f450186a = "pic";
        }

        @Override // yd1.a
        public JSONObject serialize() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f450186a);
                jSONObject.put("index", this.f450188c);
            } catch (JSONException e16) {
                QLog.e("Block", 1, e16, new Object[0]);
            }
            return jSONObject;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("PicBlock{");
            stringBuffer.append("index=");
            stringBuffer.append(this.f450188c);
            stringBuffer.append(", extra='");
            stringBuffer.append(this.f450187b);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends c {

        /* renamed from: c, reason: collision with root package name */
        public int f450189c;

        /* renamed from: d, reason: collision with root package name */
        public String f450190d;

        /* renamed from: e, reason: collision with root package name */
        public String f450191e;

        public b() {
            this.f450186a = "ref";
        }

        @Override // yd1.a
        public JSONObject serialize() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f450186a);
                jSONObject.put("index", this.f450189c);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", URLEncoder.encode(this.f450190d, "UTF-8"));
                jSONObject2.put("title", URLEncoder.encode(this.f450191e, "UTF-8"));
                jSONObject.put("data", jSONObject2);
            } catch (UnsupportedEncodingException | JSONException e16) {
                QLog.e("Block", 1, e16, new Object[0]);
            }
            return jSONObject;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("RefBlock{");
            stringBuffer.append("index=");
            stringBuffer.append(this.f450189c);
            stringBuffer.append(", url='");
            stringBuffer.append(this.f450190d);
            stringBuffer.append('\'');
            stringBuffer.append(", title='");
            stringBuffer.append(this.f450191e);
            stringBuffer.append('\'');
            stringBuffer.append(", extra='");
            stringBuffer.append(this.f450187b);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* renamed from: yd1.c$c, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C11605c extends c {

        /* renamed from: c, reason: collision with root package name */
        public int f450192c;

        public C11605c() {
            this.f450186a = "video";
        }

        @Override // yd1.a
        public JSONObject serialize() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f450186a);
                jSONObject.put("index", this.f450192c);
            } catch (JSONException e16) {
                QLog.e("Block", 1, e16, new Object[0]);
            }
            return jSONObject;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("VideoBlock{");
            stringBuffer.append("index=");
            stringBuffer.append(this.f450192c);
            stringBuffer.append(", extra='");
            stringBuffer.append(this.f450187b);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }
}
