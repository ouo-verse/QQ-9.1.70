package vm1;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lvm1/i;", "Lvm1/d;", "Lwm1/i;", "wordInfo", "Lnm1/b;", "translateInfo", "Lorg/json/JSONObject;", "b", "a", "", "Ljava/lang/Integer;", "tempPatternId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer tempPatternId;

    @Override // vm1.d
    @Nullable
    public JSONObject a(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        if (this.tempPatternId == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 13);
        jSONObject.put("id", String.valueOf(this.tempPatternId));
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    @Override // vm1.d
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject b(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        wm1.f fVar;
        yn1.b bVar;
        CharSequence charSequence;
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        if (wordInfo instanceof wm1.f) {
            fVar = (wm1.f) wordInfo;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            Object b16 = fVar.b();
            if (b16 instanceof yn1.b) {
                bVar = (yn1.b) b16;
                if (bVar != null) {
                    String topicName = bVar.getTopicName();
                    if (topicName != null) {
                        charSequence = GuildFeedPublishUtils.f222315a.F(topicName);
                    } else {
                        charSequence = null;
                    }
                    if (charSequence != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(charSequence);
                        if (!isBlank) {
                            z16 = false;
                            if (!z16) {
                                this.tempPatternId = Integer.valueOf(sm1.a.f433976a.a());
                                c.f fVar2 = c.f.f220910a;
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("type", 8);
                                jSONObject.put("pattern_id", String.valueOf(this.tempPatternId));
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("topic_id", bVar.getTopicId());
                                jSONObject2.put("topic_name", bVar.getTopicName());
                                Unit unit = Unit.INSTANCE;
                                jSONObject.put("topic_content", jSONObject2);
                                return jSONObject;
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
                QLog.e("TopicParser", 1, "cast wordInfo:" + wordInfo + " to TopicWordInfo failed");
                return null;
            }
        }
        bVar = null;
        if (bVar != null) {
        }
        QLog.e("TopicParser", 1, "cast wordInfo:" + wordInfo + " to TopicWordInfo failed");
        return null;
    }
}
