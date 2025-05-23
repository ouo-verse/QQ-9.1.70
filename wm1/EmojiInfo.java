package wm1;

import com.tencent.mobileqq.text.style.EmoticonSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lwm1/b;", "Lwm1/i;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "I", "a", "()I", "type", "Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "d", "Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "b", "()Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "emoticonSpan", "", "e", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "text", "<init>", "(ILcom/tencent/mobileqq/text/style/EmoticonSpan;Ljava/lang/CharSequence;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wm1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class EmojiInfo extends i {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final EmoticonSpan emoticonSpan;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CharSequence text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiInfo(int i3, @NotNull EmoticonSpan emoticonSpan, @NotNull CharSequence text) {
        super(i3);
        Intrinsics.checkNotNullParameter(emoticonSpan, "emoticonSpan");
        Intrinsics.checkNotNullParameter(text, "text");
        this.type = i3;
        this.emoticonSpan = emoticonSpan;
        this.text = text;
    }

    @Override // wm1.i
    /* renamed from: a, reason: from getter */
    public int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final EmoticonSpan getEmoticonSpan() {
        return this.emoticonSpan;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiInfo)) {
            return false;
        }
        EmojiInfo emojiInfo = (EmojiInfo) other;
        if (getType() == emojiInfo.getType() && Intrinsics.areEqual(this.emoticonSpan, emojiInfo.emoticonSpan) && Intrinsics.areEqual(this.text, emojiInfo.text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((getType() * 31) + this.emoticonSpan.hashCode()) * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmojiInfo(type=" + getType() + ", emoticonSpan=" + this.emoticonSpan + ", text=" + ((Object) this.text) + ")";
    }
}
