package sc4;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sc4.a.AbstractC11222a;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0006H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&\u00a8\u0006\u0012"}, d2 = {"Lsc4/a;", "Lsc4/a$a;", "T", "Ljava/util/Observable;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "d", "(Landroid/view/ViewGroup;I)Lsc4/a$a;", "a", "holder", "position", "", "c", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a<T extends AbstractC11222a> extends Observable {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lsc4/a$a;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "itemView", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sc4.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static abstract class AbstractC11222a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final View itemView;

        public AbstractC11222a(View item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView = item;
        }

        /* renamed from: a, reason: from getter */
        public final View getItemView() {
            return this.itemView;
        }
    }

    public abstract int a();

    public abstract int b(int position);

    public abstract void c(AbstractC11222a holder, int position);

    public abstract T d(ViewGroup parent, int viewType);
}
