package vu1;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0006*\u00010\u0018\u0000 \b2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0006R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00101\u00a8\u00065"}, d2 = {"Lvu1/f;", "Landroidx/recyclerview/widget/SnapHelper;", "Landroid/view/View;", "targetView", "Landroidx/recyclerview/widget/OrientationHelper;", "orientationHelper", "", "j", "k", "", "l", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "getVerticalHelper", "getHorizontalHelper", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "attachToRecyclerView", "", "calculateDistanceToFinalSnap", "velocityX", "velocityY", "findTargetSnapPosition", "findSnapView", "width", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Landroidx/recyclerview/widget/OrientationHelper;", "verticalHelper", "b", "horizontalHelper", "c", "I", "itemViewWidth", "d", "itemViewHeight", "e", "currentScrolledX", "f", "currentScrolledY", "g", "scrolledX", tl.h.F, "scrolledY", "", "i", "Z", "fling", "vu1/f$b", "Lvu1/f$b;", "scrollListener", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends SnapHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OrientationHelper verticalHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OrientationHelper horizontalHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int itemViewWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int itemViewHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentScrolledX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentScrolledY;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int scrolledX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int scrolledY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean fling;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b scrollListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"vu1/f$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "", "d", "Z", "scrolledByUser", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean scrolledByUser;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 1) {
                this.scrolledByUser = true;
            }
            if (newState == 0 && this.scrolledByUser) {
                this.scrolledByUser = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            f.this.scrolledX += dx5;
            f.this.scrolledY += dy5;
            if (this.scrolledByUser) {
                f.this.currentScrolledX += dx5;
                f.this.currentScrolledY += dy5;
            }
        }
    }

    public f() {
        a aVar = a.f443516a;
        this.itemViewWidth = aVar.b();
        this.itemViewHeight = aVar.a();
        this.scrollListener = new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r0.getLayoutManager() != r2) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.horizontalHelper;
        if (orientationHelper != null) {
            Intrinsics.checkNotNull(orientationHelper);
        }
        this.horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        OrientationHelper orientationHelper2 = this.horizontalHelper;
        Intrinsics.checkNotNull(orientationHelper2);
        return orientationHelper2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r0.getLayoutManager() != r2) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.verticalHelper;
        if (orientationHelper != null) {
            Intrinsics.checkNotNull(orientationHelper);
        }
        this.verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        OrientationHelper orientationHelper2 = this.verticalHelper;
        Intrinsics.checkNotNull(orientationHelper2);
        return orientationHelper2;
    }

    private final int j(View targetView, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(targetView) - orientationHelper.getStartAfterPadding();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int k() {
        int i3;
        int i16;
        Logger.f235387a.d().d("Guild.mission.PagerSnapHelper", 1, "getTargetPosition, mScrolledX: " + this.scrolledX + ", mCurrentScrolledX: " + this.currentScrolledX + "\uff0c mItemViewWidth\uff1a " + this.itemViewWidth);
        int i17 = this.currentScrolledX;
        if (i17 > 0) {
            i16 = this.scrolledX / this.itemViewWidth;
        } else {
            if (i17 < 0) {
                i3 = this.scrolledX / this.itemViewWidth;
            } else {
                int i18 = this.currentScrolledY;
                if (i18 > 0) {
                    i16 = this.scrolledY / this.itemViewHeight;
                } else if (i18 < 0) {
                    i3 = this.scrolledY / this.itemViewHeight;
                } else {
                    i3 = -1;
                }
            }
            l();
            if (i3 != -1) {
                return -1;
            }
            return i3;
        }
        i3 = i16 + 1;
        l();
        if (i3 != -1) {
        }
    }

    private final void l() {
        this.currentScrolledX = 0;
        this.currentScrolledY = 0;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.scrollListener);
        }
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @NotNull
    public int[] calculateDistanceToFinalSnap(@NotNull RecyclerView.LayoutManager layoutManager, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = j(targetView, getHorizontalHelper(layoutManager));
            iArr[1] = 0;
        } else if (layoutManager.canScrollVertically()) {
            iArr[0] = 0;
            iArr[1] = j(targetView, getVerticalHelper(layoutManager));
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(@Nullable RecyclerView.LayoutManager layoutManager) {
        if (this.fling) {
            l();
            this.fling = false;
            return null;
        }
        if (layoutManager == null) {
            return null;
        }
        int k3 = k();
        Logger.f235387a.d().d("Guild.mission.PagerSnapHelper", 1, "findSnapView, pos: " + k3);
        if (k3 == -1) {
            return null;
        }
        RecyclerView.SmoothScroller createScroller = createScroller(layoutManager);
        if (createScroller != null) {
            createScroller.setTargetPosition(k3);
        }
        layoutManager.startSmoothScroll(createScroller);
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(@Nullable RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        boolean z16;
        int k3 = k();
        if (k3 != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.fling = z16;
        Logger.f235387a.d().d("Guild.mission.PagerSnapHelper", 1, "findTargetSnapPosition, pos: " + k3);
        return k3;
    }

    public final void m(int width) {
        this.itemViewWidth = width;
    }
}
