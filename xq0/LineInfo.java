package xq0;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\t\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lxq0/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "lineStart", "b", "d", "lineEnd", "", "c", UserInfo.SEX_FEMALE, "getLineWidth", "()F", "lineWidth", "Z", "()Z", "drawLine", "extraSpace", "f", "firstNotSpaceChar", "<init>", "(IIFZFI)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xq0.c, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class LineInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int lineStart;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int lineEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float lineWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean drawLine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float extraSpace;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int firstNotSpaceChar;

    public LineInfo(int i3, int i16, float f16, boolean z16, float f17, int i17) {
        this.lineStart = i3;
        this.lineEnd = i16;
        this.lineWidth = f16;
        this.drawLine = z16;
        this.extraSpace = f17;
        this.firstNotSpaceChar = i17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDrawLine() {
        return this.drawLine;
    }

    /* renamed from: b, reason: from getter */
    public final float getExtraSpace() {
        return this.extraSpace;
    }

    /* renamed from: c, reason: from getter */
    public final int getFirstNotSpaceChar() {
        return this.firstNotSpaceChar;
    }

    /* renamed from: d, reason: from getter */
    public final int getLineEnd() {
        return this.lineEnd;
    }

    /* renamed from: e, reason: from getter */
    public final int getLineStart() {
        return this.lineStart;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LineInfo)) {
            return false;
        }
        LineInfo lineInfo = (LineInfo) other;
        if (this.lineStart == lineInfo.lineStart && this.lineEnd == lineInfo.lineEnd && Float.compare(this.lineWidth, lineInfo.lineWidth) == 0 && this.drawLine == lineInfo.drawLine && Float.compare(this.extraSpace, lineInfo.extraSpace) == 0 && this.firstNotSpaceChar == lineInfo.firstNotSpaceChar) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((this.lineStart * 31) + this.lineEnd) * 31) + Float.floatToIntBits(this.lineWidth)) * 31;
        boolean z16 = this.drawLine;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((floatToIntBits + i3) * 31) + Float.floatToIntBits(this.extraSpace)) * 31) + this.firstNotSpaceChar;
    }

    @NotNull
    public String toString() {
        return "LineInfo(lineStart=" + this.lineStart + ", lineEnd=" + this.lineEnd + ", lineWidth=" + this.lineWidth + ", drawLine=" + this.drawLine + ", extraSpace=" + this.extraSpace + ", firstNotSpaceChar=" + this.firstNotSpaceChar + ")";
    }
}
