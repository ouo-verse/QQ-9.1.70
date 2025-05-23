package ui1;

import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b \u0010!J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lui1/b;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$a;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$b;", "", "distanceX", "distanceY", "", "dragType", "Landroid/view/View;", "draggedView", "", "onDrag", "", "done", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "from", "onChange", "Lcom/tencent/mobileqq/activity/recent/cur/b;", "c", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragHost", "a", "b", "Lui1/b$b;", "d", "Lui1/b$b;", "onItemDragged", "e", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "Ljava/lang/ref/WeakReference;", "f", "Ljava/lang/ref/WeakReference;", "<init>", "(Lui1/b$b;)V", h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements DragFrameLayout.a, DragFrameLayout.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterfaceC11351b onItemDragged;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DragFrameLayout dragHost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<View> draggedView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lui1/b$b;", "", "", "b", "a", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ui1.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC11351b {
        void a();

        void b();

        void c();
    }

    public b(@NotNull InterfaceC11351b onItemDragged) {
        Intrinsics.checkNotNullParameter(onItemDragged, "onItemDragged");
        this.onItemDragged = onItemDragged;
        this.draggedView = new WeakReference<>(null);
    }

    public final void a(@NotNull DragFrameLayout dragHost) {
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        Logger.f235387a.d().i("FeedUnreadRedPointDragHandler", 1, "attachToDragHost(" + dragHost + ")");
        this.dragHost = dragHost;
        dragHost.addOnDragModeChangeListenerByGroup("guild", this, false);
        dragHost.addOnDragModeChangeListener(this, false);
        cr1.a.INSTANCE.a(dragHost, this);
    }

    public final void b(@NotNull DragFrameLayout dragHost) {
        Intrinsics.checkNotNullParameter(dragHost, "dragHost");
        Logger.f235387a.d().i("FeedUnreadRedPointDragHandler", 1, "detachFromDragHost(" + dragHost + ")");
        this.dragHost = null;
        dragHost.removeOnDragModeChangeListenerByGroup("guild", this);
        dragHost.removeOnDragModeChangeListener(this);
        cr1.a.INSTANCE.b(dragHost, this);
    }

    @Nullable
    public final com.tencent.mobileqq.activity.recent.cur.b c() {
        return this.dragHost;
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean done, int dragType, @NotNull QUIBadgeDragLayout from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FeedUnreadRedPointDragHandler", 2, "onChange(" + done + ", " + dragType + ", " + from.getMode() + ")");
        }
        if (from.getMode() == -1) {
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
            this.draggedView.clear();
            this.onItemDragged.a();
        }
        if (from.getMode() == -1 && from.getDragView() != null) {
            this.onItemDragged.c();
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragListener
    public void onDrag(float distanceX, float distanceY, int dragType, @NotNull View draggedView) {
        Intrinsics.checkNotNullParameter(draggedView, "draggedView");
        if (!Intrinsics.areEqual(this.draggedView.get(), draggedView)) {
            DragFrameLayout dragFrameLayout = this.dragHost;
            if (dragFrameLayout != null) {
                dragFrameLayout.removeOnDragModeChangeListener(this);
            }
            DragFrameLayout dragFrameLayout2 = this.dragHost;
            if (dragFrameLayout2 != null) {
                dragFrameLayout2.addOnDragModeChangeListener(this, false);
            }
            this.draggedView = new WeakReference<>(draggedView);
        }
        this.onItemDragged.b();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FeedUnreadRedPointDragHandler", 2, "onDrag(" + distanceX + ", " + distanceY + ", " + dragType + ", " + draggedView + ")");
        }
    }
}
