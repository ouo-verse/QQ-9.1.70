package vm1;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wm1.GroupInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lvm1/c;", "Lvm1/d;", "Lwm1/i;", "wordInfo", "Lnm1/b;", "translateInfo", "Lorg/json/JSONObject;", "b", "a", "", "Ljava/lang/Integer;", "tempPatternId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer tempPatternId;

    @Override // vm1.d
    @Nullable
    public JSONObject a(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 14);
        jSONObject.put("id", String.valueOf(this.tempPatternId));
        return jSONObject;
    }

    @Override // vm1.d
    @NotNull
    public JSONObject b(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        GroupInfo groupInfo;
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        if (wordInfo instanceof GroupInfo) {
            groupInfo = (GroupInfo) wordInfo;
        } else {
            groupInfo = null;
        }
        if (groupInfo == null) {
            return new JSONObject();
        }
        this.tempPatternId = Integer.valueOf(sm1.a.f433976a.a());
        c.f fVar = c.f.f220910a;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 9);
        jSONObject.put("pattern_id", String.valueOf(this.tempPatternId));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("group_code", groupInfo.getGroupSpan().v());
        jSONObject2.put("group_name", groupInfo.getGroupSpan().w());
        jSONObject2.put("group_member_num", 0);
        jSONObject2.put("group_avatar", "");
        jSONObject2.put("group_join_auth", "");
        Unit unit = Unit.INSTANCE;
        jSONObject.put("group_content", jSONObject2);
        return jSONObject;
    }
}
