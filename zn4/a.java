package zn4;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010B)\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0016\u0010\b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lzn4/a;", "Landroid/view/animation/Interpolator;", "", "time", "b", "d", "t", "c", "a", "getInterpolation", "Landroid/graphics/PointF;", "Landroid/graphics/PointF;", "start", "end", "e", "<init>", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "startX", "startY", "endX", "endY", "(FFFF)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF end;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF a;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF b;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF c;

    public a(@NotNull PointF start, @NotNull PointF end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
        float f16 = start.x;
        if (f16 >= 0.0f && f16 <= 1.0f) {
            float f17 = end.x;
            if (f17 >= 0.0f && f17 <= 1.0f) {
                this.start = start;
                this.end = end;
                return;
            }
            throw new IllegalArgumentException("endX value must be in the range [0, 1]".toString());
        }
        throw new IllegalArgumentException("startX value must be in the range [0, 1]".toString());
    }

    private final float a(float time) {
        PointF pointF = this.c;
        float f16 = 3;
        PointF pointF2 = this.start;
        float f17 = pointF2.x * f16;
        pointF.x = f17;
        PointF pointF3 = this.b;
        float f18 = (f16 * (this.end.x - pointF2.x)) - f17;
        pointF3.x = f18;
        PointF pointF4 = this.a;
        float f19 = (1 - pointF.x) - f18;
        pointF4.x = f19;
        return time * (pointF.x + ((pointF3.x + (f19 * time)) * time));
    }

    private final float b(float time) {
        PointF pointF = this.c;
        float f16 = 3;
        PointF pointF2 = this.start;
        float f17 = pointF2.y * f16;
        pointF.y = f17;
        PointF pointF3 = this.b;
        float f18 = (f16 * (this.end.y - pointF2.y)) - f17;
        pointF3.y = f18;
        PointF pointF4 = this.a;
        float f19 = (1 - pointF.y) - f18;
        pointF4.y = f19;
        return time * (pointF.y + ((pointF3.y + (f19 * time)) * time));
    }

    private final float c(float t16) {
        return this.c.x + (t16 * ((2 * this.b.x) + (3 * this.a.x * t16)));
    }

    private final float d(float time) {
        float f16 = time;
        for (int i3 = 1; i3 < 14; i3++) {
            float a16 = a(f16) - time;
            if (Math.abs(a16) < 0.001d) {
                break;
            }
            f16 -= a16 / c(f16);
        }
        return f16;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float time) {
        return b(d(time));
    }

    public a(float f16, float f17, float f18, float f19) {
        this(new PointF(f16, f17), new PointF(f18, f19));
    }
}
