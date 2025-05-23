package t12;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J@\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lt12/a;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "dy", "", "g", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "computePosition", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "dispatchScrollStateChanged", "", "isScrollUp", "f", "dx", "e", "resetScrollParam", "Lt12/b;", "scrollListener", "d", "onScrolled", "onScrollStateChanged", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "scrollerList", "Z", "I", "scrollOrient", h.F, "scrollDisY", "", "i", "J", "startComputeTime", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends RecyclerView.OnScrollListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> scrollerList = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isScrollUp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int scrollOrient;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int scrollDisY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long startComputeTime;

    private final int[] computePosition(RecyclerView recyclerView) {
        int[] iArr = new int[4];
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return iArr;
        }
        try {
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                iArr[0] = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
                iArr[1] = staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
                iArr[2] = staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0];
                iArr[3] = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0];
            } else if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                iArr[0] = gridLayoutManager.findFirstVisibleItemPosition();
                iArr[1] = gridLayoutManager.findLastVisibleItemPosition();
                iArr[2] = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
                iArr[3] = gridLayoutManager.findLastCompletelyVisibleItemPosition();
            } else if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                iArr[0] = linearLayoutManager.findFirstVisibleItemPosition();
                iArr[1] = linearLayoutManager.findLastVisibleItemPosition();
                iArr[2] = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                iArr[3] = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            }
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "computePosition error! " + e16;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGSTag.GuildDiscoverScrollManager", 1, (String) it.next(), null);
            }
        }
        return iArr;
    }

    private final void dispatchScrollStateChanged(RecyclerView recyclerView, int newState, RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible) {
        if (firstVisiblePos >= 0 && lastVisiblePos >= firstVisiblePos && firstCompletelyVisible >= 0 && lastCompletelyVisible >= firstCompletelyVisible) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("QGSTag.GuildDiscoverScrollManager", 2, "dispatchScrollStateChanged  firstVisiblePos " + firstVisiblePos + ", lastVisiblePos " + lastVisiblePos + ", firstCompletelyVisible: " + firstCompletelyVisible + ", lastCompletelyVisible: " + lastCompletelyVisible);
            }
            Iterator<T> it = this.scrollerList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(recyclerView, newState, manager, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible, this.isScrollUp);
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "dispatchScrollStateChanged error firstVisiblePos " + firstVisiblePos + ", lastVisiblePos " + lastVisiblePos + ", firstCompletelyVisible: " + firstCompletelyVisible + ", lastCompletelyVisible: " + lastCompletelyVisible;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it5 = bVar.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("QGSTag.GuildDiscoverScrollManager", 1, (String) it5.next(), null);
        }
    }

    private final void e(RecyclerView recyclerView, int dx5, int dy5, boolean isScrollUp) {
        Iterator<T> it = this.scrollerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).c(recyclerView, dx5, dy5, isScrollUp);
        }
    }

    private final void f(RecyclerView recyclerView, boolean isScrollUp) {
        int[] computePosition = computePosition(recyclerView);
        int i3 = computePosition[0];
        int i16 = computePosition[1];
        int i17 = computePosition[2];
        int i18 = computePosition[3];
        if (i3 >= 0 && i16 >= i3 && i17 >= 0 && i18 >= i17) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("QGSTag.GuildDiscoverScrollManager", 2, "disPatchSlowScroll, isScrollUp " + isScrollUp + ", firstVisiblePos " + i3 + ", lastVisiblePos " + i16 + ", firstCompletelyVisible: " + i17 + ", lastCompletelyVisible: " + i18);
            }
            Iterator<T> it = this.scrollerList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(i3, i16, i17, i18, isScrollUp);
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "disPatchSlowScroll error, isScrollUp " + isScrollUp + ", firstVisiblePos " + i3 + ", lastVisiblePos " + i16 + ", firstCompletelyVisible: " + i17 + ", lastCompletelyVisible: " + i18;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it5 = bVar.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("QGSTag.GuildDiscoverScrollManager", 1, (String) it5.next(), null);
        }
    }

    private final void g(int dy5) {
        boolean z16;
        int i3 = 0;
        if (dy5 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isScrollUp = z16;
        if (dy5 >= 0) {
            int i16 = this.scrollOrient;
            if (i16 != 0 && i16 != -1) {
                resetScrollParam();
                QLog.d("QGSTag.GuildDiscoverScrollManager", 4, "change orient to up:" + this.scrollOrient);
            }
        } else {
            int i17 = this.scrollOrient;
            if (i17 != 1 && i17 != -1) {
                resetScrollParam();
                QLog.d("QGSTag.GuildDiscoverScrollManager", 4, "change orient to down:" + this.scrollOrient);
            }
            i3 = 1;
        }
        this.scrollOrient = i3;
        this.scrollDisY += dy5;
        if (this.startComputeTime == 0) {
            this.startComputeTime = System.currentTimeMillis();
        }
    }

    private final void resetScrollParam() {
        this.scrollOrient = -1;
        this.scrollDisY = 0;
        this.startComputeTime = 0L;
    }

    public final void d(@NotNull b scrollListener) {
        Intrinsics.checkNotNullParameter(scrollListener, "scrollListener");
        this.scrollerList.add(scrollListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        int[] computePosition = computePosition(recyclerView);
        dispatchScrollStateChanged(recyclerView, newState, layoutManager, computePosition[0], computePosition[1], computePosition[2], computePosition[3]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
        boolean z16;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx5, dy5);
        g(dy5);
        long currentTimeMillis = System.currentTimeMillis() - this.startComputeTime;
        boolean z17 = true;
        if (currentTimeMillis > 200) {
            resetScrollParam();
            if (Math.abs((this.scrollDisY * 1.0f) / ((float) currentTimeMillis)) < 3.0f) {
                if (dy5 >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                f(recyclerView, z16);
            }
        }
        if (dy5 < 0) {
            z17 = false;
        }
        e(recyclerView, dx5, dy5, z17);
    }
}
