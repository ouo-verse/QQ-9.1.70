package um1;

import fm1.i;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016R0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lum1/d;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "", "Lorg/json/JSONObject;", "publishJson", "", "Lfm1/i;", "mediaList", "", "b", "Lnm1/b;", "translateInfo", "a", "Ljava/util/HashMap;", "", "Lum1/a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mMediaParserMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, a> mMediaParserMap;

    public d() {
        HashMap<Integer, a> hashMap = new HashMap<>();
        hashMap.put(1, new b());
        hashMap.put(2, new e());
        this.mMediaParserMap = hashMap;
    }

    private final void b(JSONObject publishJson, List<? extends i> mediaList) {
        a aVar;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        publishJson.put("images", jSONArray);
        publishJson.put("videos", jSONArray2);
        if (mediaList.isEmpty()) {
            return;
        }
        JSONArray jSONArray3 = new JSONArray();
        int size = mediaList.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = mediaList.get(i3);
            if (fm1.d.a(iVar)) {
                a aVar2 = this.mMediaParserMap.get(1);
                if (aVar2 != null) {
                    JSONObject b16 = aVar2.b(iVar, i3);
                    if (b16 != null) {
                        jSONArray.mo162put(b16);
                    }
                    JSONObject a16 = aVar2.a(iVar, i3);
                    if (a16 != null) {
                        jSONArray3.mo162put(a16);
                    }
                }
            } else if (fm1.d.e(iVar) && (aVar = this.mMediaParserMap.get(2)) != null) {
                JSONObject b17 = aVar.b(iVar, i3);
                if (b17 != null) {
                    jSONArray2.mo162put(b17);
                }
                JSONObject a17 = aVar.a(iVar, i3);
                if (a17 != null) {
                    jSONArray3.mo162put(a17);
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 11);
        jSONArray3.mo162put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", UUID.randomUUID().toString());
        jSONObject2.put("type", "blockParagraph");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("textAlignment", 0);
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("props", jSONObject3);
        jSONObject2.put("data", jSONArray3);
        publishJson.getJSONArray("patterns").mo162put(jSONObject2);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e
    public void a(@NotNull JSONObject publishJson, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(publishJson, "publishJson");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        b(publishJson, translateInfo.c());
    }
}
