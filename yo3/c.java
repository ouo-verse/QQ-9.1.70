package yo3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lyo3/a;", "offset", "Lyo3/d;", "size", "Lyo3/b;", "a", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {
    public static final b a(Offset offset, Size size) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(size, "size");
        return new b(offset.getX(), offset.getY(), offset.getX() + size.getWidth(), offset.getY() + size.getHeight());
    }
}
