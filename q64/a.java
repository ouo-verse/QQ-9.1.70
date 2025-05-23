package q64;

import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", "other", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/StoryBaseInfo;", "b", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    public static final boolean a(@NotNull HalfViewCardNode halfViewCardNode, @Nullable HalfViewCardNode halfViewCardNode2) {
        Intrinsics.checkNotNullParameter(halfViewCardNode, "<this>");
        if (halfViewCardNode2 == null || halfViewCardNode.action != halfViewCardNode2.action || !Intrinsics.areEqual(halfViewCardNode.data, halfViewCardNode2.data) || halfViewCardNode.nodeType != halfViewCardNode2.nodeType) {
            return false;
        }
        StoryBaseInfo storyBaseInfo = halfViewCardNode.storyBaseInfo;
        Intrinsics.checkNotNullExpressionValue(storyBaseInfo, "storyBaseInfo");
        if (!b(storyBaseInfo, halfViewCardNode2.storyBaseInfo)) {
            return false;
        }
        return true;
    }

    public static final boolean b(@NotNull StoryBaseInfo storyBaseInfo, @Nullable StoryBaseInfo storyBaseInfo2) {
        Intrinsics.checkNotNullParameter(storyBaseInfo, "<this>");
        if (storyBaseInfo2 == null || storyBaseInfo.storyId != storyBaseInfo2.storyId || storyBaseInfo.storyType != storyBaseInfo2.storyType || !Intrinsics.areEqual(storyBaseInfo.name, storyBaseInfo2.name) || !Intrinsics.areEqual(storyBaseInfo.title, storyBaseInfo2.title) || !Intrinsics.areEqual(storyBaseInfo.introduce, storyBaseInfo2.introduce) || !Intrinsics.areEqual(storyBaseInfo.pic, storyBaseInfo2.pic) || !Intrinsics.areEqual(storyBaseInfo.callbackData, storyBaseInfo2.callbackData) || !Intrinsics.areEqual(storyBaseInfo.dayBackground, storyBaseInfo2.dayBackground) || !Intrinsics.areEqual(storyBaseInfo.nightBackground, storyBaseInfo2.nightBackground) || !Intrinsics.areEqual(storyBaseInfo.dayBackgroundColor, storyBaseInfo2.dayBackgroundColor) || !Intrinsics.areEqual(storyBaseInfo.nightBackgroundColor, storyBaseInfo2.nightBackgroundColor)) {
            return false;
        }
        return true;
    }
}
