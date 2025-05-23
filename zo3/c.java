package zo3;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0010\u0092\u0001\u00020\f\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lzo3/c;", "", "", "c", "([F)Ljava/lang/String;", "", "b", "([F)I", "other", "", "a", "([FLjava/lang/Object;)Z", "", "[F", "getValues", "()[F", "values", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
@JvmInline
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float[] values;

    public static boolean a(float[] fArr, Object obj) {
        return (obj instanceof c) && Intrinsics.areEqual(fArr, ((c) obj).getValues());
    }

    public static int b(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public static String c(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    /* renamed from: d, reason: from getter */
    public final /* synthetic */ float[] getValues() {
        return this.values;
    }

    public boolean equals(Object obj) {
        return a(this.values, obj);
    }

    public int hashCode() {
        return b(this.values);
    }

    public String toString() {
        return c(this.values);
    }
}
