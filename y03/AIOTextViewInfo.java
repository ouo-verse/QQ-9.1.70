package y03;

import android.graphics.Rect;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0016\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Ly03/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getETMaxWidth", "()I", "eTMaxWidth", "b", "maxEms", "c", "maxLines", "d", "e", NodeProps.MIN_WIDTH, NodeProps.MIN_HEIGHT, "f", NodeProps.MAX_WIDTH, "Landroid/graphics/Rect;", "g", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "paddingRect", "<init>", "(IIIIIILandroid/graphics/Rect;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: y03.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class AIOTextViewInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int eTMaxWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxEms;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxLines;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int minWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int minHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Rect paddingRect;

    public AIOTextViewInfo(int i3, int i16, int i17, int i18, int i19, int i26, @NotNull Rect paddingRect) {
        Intrinsics.checkNotNullParameter(paddingRect, "paddingRect");
        this.eTMaxWidth = i3;
        this.maxEms = i16;
        this.maxLines = i17;
        this.minWidth = i18;
        this.minHeight = i19;
        this.maxWidth = i26;
        this.paddingRect = paddingRect;
    }

    /* renamed from: a, reason: from getter */
    public final int getMaxEms() {
        return this.maxEms;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxWidth() {
        return this.maxWidth;
    }

    /* renamed from: d, reason: from getter */
    public final int getMinHeight() {
        return this.minHeight;
    }

    /* renamed from: e, reason: from getter */
    public final int getMinWidth() {
        return this.minWidth;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIOTextViewInfo)) {
            return false;
        }
        AIOTextViewInfo aIOTextViewInfo = (AIOTextViewInfo) other;
        if (this.eTMaxWidth == aIOTextViewInfo.eTMaxWidth && this.maxEms == aIOTextViewInfo.maxEms && this.maxLines == aIOTextViewInfo.maxLines && this.minWidth == aIOTextViewInfo.minWidth && this.minHeight == aIOTextViewInfo.minHeight && this.maxWidth == aIOTextViewInfo.maxWidth && Intrinsics.areEqual(this.paddingRect, aIOTextViewInfo.paddingRect)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final Rect getPaddingRect() {
        return this.paddingRect;
    }

    public int hashCode() {
        return (((((((((((this.eTMaxWidth * 31) + this.maxEms) * 31) + this.maxLines) * 31) + this.minWidth) * 31) + this.minHeight) * 31) + this.maxWidth) * 31) + this.paddingRect.hashCode();
    }

    @NotNull
    public String toString() {
        return "AIOTextViewInfo(eTMaxWidth=" + this.eTMaxWidth + ", maxEms=" + this.maxEms + ", maxLines=" + this.maxLines + ", minWidth=" + this.minWidth + ", minHeight=" + this.minHeight + ", maxWidth=" + this.maxWidth + ", paddingRect=" + this.paddingRect + ")";
    }
}
