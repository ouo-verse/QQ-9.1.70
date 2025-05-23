package vm1;

import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lvm1/g;", "Lvm1/d;", "Lwm1/i;", "wordInfo", "Lnm1/b;", "translateInfo", "Lorg/json/JSONObject;", "b", "a", "", "Ljava/lang/Integer;", "mPatternId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mPatternId;

    @Override // vm1.d
    @Nullable
    public JSONObject a(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        wm1.g gVar = (wm1.g) wordInfo;
        int localToServer = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).localToServer(String.valueOf(gVar.getEmoticonSpan().index), gVar.getEmoticonSpan().emojiType);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 2);
        jSONObject.put("id", String.valueOf(this.mPatternId));
        jSONObject.put("emojiType", "1");
        jSONObject.put("emojiId", String.valueOf(localToServer));
        return jSONObject;
    }

    @Override // vm1.d
    @Nullable
    public JSONObject b(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        wm1.g gVar = (wm1.g) wordInfo;
        this.mPatternId = Integer.valueOf(sm1.a.f433976a.a());
        int localToServer = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).localToServer(String.valueOf(gVar.getEmoticonSpan().index), gVar.getEmoticonSpan().emojiType);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "1");
        jSONObject.put("id", String.valueOf(localToServer));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", 4);
        jSONObject2.put("pattern_id", String.valueOf(this.mPatternId));
        jSONObject2.put("emoji_content", jSONObject);
        return jSONObject2;
    }
}
