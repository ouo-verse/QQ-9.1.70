package um1;

import fm1.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lum1/c;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "", "Lorg/json/JSONObject;", "publishJson", "", "Lfm1/i;", "mediaList", "", "b", "Lnm1/b;", "translateInfo", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e {
    private final void b(JSONObject publishJson, List<? extends i> mediaList) {
        JSONArray jSONArray = new JSONArray();
        publishJson.put("medias", jSONArray);
        int size = mediaList.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = mediaList.get(i3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("localType", iVar.f());
            jSONObject.put("mediaInfo", iVar.a());
            jSONArray.mo162put(jSONObject);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e
    public void a(@NotNull JSONObject publishJson, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(publishJson, "publishJson");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        b(publishJson, translateInfo.c());
    }
}
