package xq0;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0013\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lxq0/d;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "spanStart", "b", "spanEnd", "Ljava/lang/Object;", "()Ljava/lang/Object;", TtmlNode.TAG_SPAN, "<init>", "(IILjava/lang/Object;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xq0.d, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class SpanInfo<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int spanStart;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int spanEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final T span;

    public SpanInfo(int i3, int i16, T t16) {
        this.spanStart = i3;
        this.spanEnd = i16;
        this.span = t16;
    }

    public final T a() {
        return this.span;
    }

    /* renamed from: b, reason: from getter */
    public final int getSpanEnd() {
        return this.spanEnd;
    }

    /* renamed from: c, reason: from getter */
    public final int getSpanStart() {
        return this.spanStart;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpanInfo)) {
            return false;
        }
        SpanInfo spanInfo = (SpanInfo) other;
        if (this.spanStart == spanInfo.spanStart && this.spanEnd == spanInfo.spanEnd && Intrinsics.areEqual(this.span, spanInfo.span)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((this.spanStart * 31) + this.spanEnd) * 31;
        T t16 = this.span;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "SpanInfo(spanStart=" + this.spanStart + ", spanEnd=" + this.spanEnd + ", span=" + this.span + ")";
    }
}
