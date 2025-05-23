package yo3;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R \u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR \u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0012\u0010\rR \u0010\u0017\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0015\u0010\rR \u0010\u0019\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\n\u0010\rR\u001a\u0010\u001c\u001a\u00020\t8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001a\u0010\rR\u001a\u0010\u001e\u001a\u00020\t8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u0011\u0010\r\u00a8\u0006!"}, d2 = {"Lyo3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "getLeft$annotations", "()V", "left", "b", "d", "getTop$annotations", "top", "getRight", "getRight$annotations", "right", "getBottom$annotations", "bottom", "e", "getWidth$annotations", "width", "getHeight$annotations", "height", "<init>", "(FFFF)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final /* data */ class b {

    /* renamed from: f, reason: collision with root package name */
    private static final b f450736f = new b(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float left;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float top;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float right;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float bottom;

    public b(float f16, float f17, float f18, float f19) {
        this.left = f16;
        this.top = f17;
        this.right = f18;
        this.bottom = f19;
    }

    /* renamed from: a, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    public final float b() {
        return this.bottom - this.top;
    }

    /* renamed from: c, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* renamed from: d, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    public final float e() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom);
    }

    public String toString() {
        return "Rect.fromLTRB(" + this.left + ", " + this.top + ", " + this.right + ", " + this.bottom + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        return Float.compare(this.left, bVar.left) == 0 && Float.compare(this.top, bVar.top) == 0 && Float.compare(this.right, bVar.right) == 0 && Float.compare(this.bottom, bVar.bottom) == 0;
    }
}
