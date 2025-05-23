package zi;

import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yi.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lzi/b;", "Lwi/b;", "Lyi/e;", "Lzi/a;", "c", "Lzi/a;", "d", "()Lzi/a;", "e", "(Lzi/a;)V", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b extends wi.b implements e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public a parent;

    public final a d() {
        a aVar = this.parent;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException(HippyNestedScrollComponent.PRIORITY_PARENT);
        return null;
    }

    public final void e(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.parent = aVar;
    }
}
