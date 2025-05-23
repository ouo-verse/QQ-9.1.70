package u73;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lu73/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "_centerX", "b", "_centerY", "c", "_width", "d", "_height", "()F", "centerX", "centerY", "scale", "<init>", "(FFFF)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u73.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class Frame {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float _centerX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float _centerY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float _width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float _height;

    public Frame(float f16, float f17, float f18, float f19) {
        this._centerX = f16;
        this._centerY = f17;
        this._width = f18;
        this._height = f19;
    }

    public final float a() {
        return (this._centerX * 2) - 1;
    }

    public final float b() {
        return 1 - (this._centerY * 2);
    }

    public final float c() {
        return (this._width * 720) / 800;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Frame)) {
            return false;
        }
        Frame frame = (Frame) other;
        if (Float.compare(this._centerX, frame._centerX) == 0 && Float.compare(this._centerY, frame._centerY) == 0 && Float.compare(this._width, frame._width) == 0 && Float.compare(this._height, frame._height) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this._centerX) * 31) + Float.floatToIntBits(this._centerY)) * 31) + Float.floatToIntBits(this._width)) * 31) + Float.floatToIntBits(this._height);
    }

    @NotNull
    public String toString() {
        return "Frame(_centerX=" + this._centerX + ", _centerY=" + this._centerY + ", _width=" + this._width + ", _height=" + this._height + ")";
    }
}
