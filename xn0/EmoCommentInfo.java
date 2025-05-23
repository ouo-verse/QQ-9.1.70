package xn0;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lxn0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getTargetMsg", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsg", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "emojiId", "c", "I", "()I", "emojiType", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/String;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xn0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class EmoCommentInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MsgRecord targetMsg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String emojiId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emojiType;

    public EmoCommentInfo(@NotNull MsgRecord targetMsg, @NotNull String emojiId, int i3) {
        Intrinsics.checkNotNullParameter(targetMsg, "targetMsg");
        Intrinsics.checkNotNullParameter(emojiId, "emojiId");
        this.targetMsg = targetMsg;
        this.emojiId = emojiId;
        this.emojiType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: b, reason: from getter */
    public final int getEmojiType() {
        return this.emojiType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmoCommentInfo)) {
            return false;
        }
        EmoCommentInfo emoCommentInfo = (EmoCommentInfo) other;
        if (Intrinsics.areEqual(this.targetMsg, emoCommentInfo.targetMsg) && Intrinsics.areEqual(this.emojiId, emoCommentInfo.emojiId) && this.emojiType == emoCommentInfo.emojiType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.targetMsg.hashCode() * 31) + this.emojiId.hashCode()) * 31) + this.emojiType;
    }

    @NotNull
    public String toString() {
        return "EmoCommentInfo(targetMsg=" + this.targetMsg + ", emojiId=" + this.emojiId + ", emojiType=" + this.emojiType + ")";
    }
}
