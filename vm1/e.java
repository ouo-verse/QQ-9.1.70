package vm1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wm1.NewlineInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lvm1/e;", "Lvm1/d;", "Lwm1/i;", "wordInfo", "Lnm1/b;", "translateInfo", "Lorg/json/JSONObject;", "b", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements d {
    @Override // vm1.d
    @Nullable
    public JSONObject a(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("text", ((NewlineInfo) wordInfo).getText());
        jSONObject.put("type", 9);
        jSONObject.put("props", new JSONObject());
        return jSONObject;
    }

    @Override // vm1.d
    @Nullable
    public JSONObject b(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("text", ((NewlineInfo) wordInfo).getText());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", 1);
        jSONObject2.put("text_content", jSONObject);
        return jSONObject2;
    }
}
