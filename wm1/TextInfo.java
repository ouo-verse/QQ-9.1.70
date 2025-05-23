package wm1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lwm1/h;", "Lwm1/i;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "I", "a", "()I", "type", "", "d", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "text", "<init>", "(ILjava/lang/CharSequence;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wm1.h, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class TextInfo extends i {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CharSequence text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInfo(int i3, @NotNull CharSequence text) {
        super(i3);
        Intrinsics.checkNotNullParameter(text, "text");
        this.type = i3;
        this.text = text;
    }

    @Override // wm1.i
    /* renamed from: a, reason: from getter */
    public int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextInfo)) {
            return false;
        }
        TextInfo textInfo = (TextInfo) other;
        if (getType() == textInfo.getType() && Intrinsics.areEqual(this.text, textInfo.text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (getType() * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "TextInfo(type=" + getType() + ", text=" + ((Object) this.text) + ")";
    }
}
