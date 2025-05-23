package ud1;

import com.tenpay.realname.RealNameSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final List<a> f438842a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f438843a;

        /* renamed from: b, reason: collision with root package name */
        public String f438844b;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f438845c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private final List<b> f438846d = new ArrayList();

        void a(b bVar) {
            this.f438846d.add(bVar);
        }

        public List<b> b() {
            return this.f438846d;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("ArticleType{");
            stringBuffer.append("typeId=");
            stringBuffer.append(this.f438843a);
            stringBuffer.append(", typeName='");
            stringBuffer.append(this.f438844b);
            stringBuffer.append('\'');
            stringBuffer.append(", prefixUrlList='");
            Iterator<String> it = this.f438845c.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append('\'');
            }
            stringBuffer.append(", mSourceTypes=");
            stringBuffer.append(this.f438846d);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f438847a;

        /* renamed from: b, reason: collision with root package name */
        public String f438848b;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("SourceType{");
            stringBuffer.append("sourceId=");
            stringBuffer.append(this.f438847a);
            stringBuffer.append(", sourceName='");
            stringBuffer.append(this.f438848b);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public List<a> a() {
        return this.f438842a;
    }

    public void b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                a aVar = new a();
                aVar.f438843a = optJSONObject.optInt("typeId");
                aVar.f438844b = optJSONObject.optString("typeName");
                JSONArray optJSONArray = optJSONObject.optJSONArray("linkPrefix");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        aVar.f438845c.add(optJSONArray.optString(i16));
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("sourceTypes");
                for (int i17 = 0; i17 < optJSONArray2.length(); i17++) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i17);
                    b bVar = new b();
                    bVar.f438847a = optJSONObject2.optInt("sourceId");
                    bVar.f438848b = optJSONObject2.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
                    aVar.a(bVar);
                }
                this.f438842a.add(aVar);
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QQGameQuestionAnswerConfig{");
        stringBuffer.append("mRefArticleTypes=");
        stringBuffer.append(this.f438842a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
