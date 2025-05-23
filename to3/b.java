package to3;

import com.tencent.kuikly.core.views.bs;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lto3/b;", "", "", "offsetDp", "", "animated", "Lcom/tencent/kuikly/core/views/bs;", "springAnimation", "a", "", "b", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface b {
    float a(float offsetDp, boolean animated, bs springAnimation);

    void b(float offsetDp, boolean animated, bs springAnimation);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public static final class a {
        public static /* synthetic */ float a(b bVar, float f16, boolean z16, bs bsVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    bsVar = null;
                }
                return bVar.a(f16, z16, bsVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollBy");
        }

        public static /* synthetic */ void b(b bVar, float f16, boolean z16, bs bsVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    bsVar = null;
                }
                bVar.b(f16, z16, bsVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollTo");
        }
    }
}
