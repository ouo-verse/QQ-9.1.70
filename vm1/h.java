package vm1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import wm1.TextInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lvm1/h;", "Lvm1/d;", "Lwm1/i;", "wordInfo", "Lorg/json/JSONObject;", "c", "d", "Lnm1/b;", "translateInfo", "b", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h implements d {
    private final JSONObject c(wm1.i wordInfo) {
        Intrinsics.checkNotNull(wordInfo, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.word.TextInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("text", ((TextInfo) wordInfo).getText());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", 1);
        jSONObject2.put("text_content", jSONObject);
        return jSONObject2;
    }

    private final JSONObject d(wm1.i wordInfo) {
        Intrinsics.checkNotNull(wordInfo, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.word.TextInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("text", ((TextInfo) wordInfo).getText());
        jSONObject.put("type", 1);
        jSONObject.put("props", new JSONObject());
        return jSONObject;
    }

    @Override // vm1.d
    @NotNull
    public JSONObject a(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        return d(wordInfo);
    }

    @Override // vm1.d
    @NotNull
    public JSONObject b(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        return c(wordInfo);
    }
}
