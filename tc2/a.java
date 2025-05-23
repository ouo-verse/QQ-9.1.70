package tc2;

import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ltc2/a;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "Ltc2/a$a;", "listener", "", "a", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "", "velocityX", "velocityY", "findTargetSnapPosition", "Ltc2/a$a;", "mOnFindPositionListener", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends PagerSnapHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterfaceC11283a mOnFindPositionListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Ltc2/a$a;", "", "", "position", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tc2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC11283a {
        void a(int position);
    }

    public final void a(@Nullable InterfaceC11283a listener) {
        this.mOnFindPositionListener = listener;
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(@Nullable RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        int findTargetSnapPosition = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
        InterfaceC11283a interfaceC11283a = this.mOnFindPositionListener;
        if (interfaceC11283a != null) {
            interfaceC11283a.a(findTargetSnapPosition);
        }
        return findTargetSnapPosition;
    }
}
