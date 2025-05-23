package yo3;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lyo3/d;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "width", "b", "height", "<init>", "(FF)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yo3.d, reason: from toString */
/* loaded from: classes36.dex */
public final class Size {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Size f450742d = new Size(0.0f, 0.0f);

    /* renamed from: e, reason: collision with root package name */
    private static final Size f450743e = new Size(Float.NaN, Float.NaN);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float height;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lyo3/d$a;", "", "Lyo3/d;", "Zero", "Lyo3/d;", "a", "()Lyo3/d;", "getZero$annotations", "()V", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yo3.d$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Size a() {
            return Size.f450742d;
        }

        Companion() {
        }
    }

    public Size(float f16, float f17) {
        this.width = f16;
        this.height = f17;
    }

    /* renamed from: b, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* renamed from: c, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public String toString() {
        return "Size(" + this.width + ", " + this.height + ')';
    }
}
