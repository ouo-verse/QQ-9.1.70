package yo3;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lyo3/a;", "", "", "toString", "", "a", UserInfo.SEX_FEMALE, "b", "()F", HippyTKDListViewAdapter.X, "c", "y", "<init>", "(FF)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yo3.a, reason: from toString */
/* loaded from: classes36.dex */
public final class Offset {

    /* renamed from: d, reason: collision with root package name */
    public static final int f450729d = 0;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Offset f450730e = new Offset(0.0f, 0.0f);

    /* renamed from: f, reason: collision with root package name */
    private static final Offset f450731f = new Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: g, reason: collision with root package name */
    private static final Offset f450732g = new Offset(Float.NaN, Float.NaN);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lyo3/a$a;", "", "Lyo3/a;", "Zero", "Lyo3/a;", "a", "()Lyo3/a;", "getZero$annotations", "()V", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yo3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Offset a() {
            return Offset.f450730e;
        }

        Companion() {
        }
    }

    public Offset(float f16, float f17) {
        this.x = f16;
        this.y = f17;
    }

    /* renamed from: b, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: c, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public String toString() {
        return "Offset(" + this.x + ", " + this.y + ')';
    }
}
