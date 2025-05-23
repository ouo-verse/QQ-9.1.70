package sa;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.qzone.reborn.feedx.util.ah;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.AppSetting;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends e {
    private boolean G = false;
    private boolean H = false;
    private final Set<ua.a> I = new HashSet();
    private final b J = new b(this);
    protected ua.b K = new aa.b();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            g.this.traverseRecyclerViewParent(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            g.this.traverseRecyclerViewParent(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<g> f433553d;

        public b(g gVar) {
            this.f433553d = new WeakReference<>(gVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            g gVar;
            super.onScrollStateChanged(recyclerView, i3);
            if (!ah.b(recyclerView) || (gVar = this.f433553d.get()) == null) {
                return;
            }
            gVar.D0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            g gVar = this.f433553d.get();
            if (gVar == null) {
                return;
            }
            gVar.w0(i3, i16);
        }
    }

    private void A0(boolean z16) {
        boolean z17 = this.G;
        this.G = z16;
        if (z17 || !z16) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: sa.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.B0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        logDebug(" tryToLoadPreviewIfNeed");
        if (!this.H && this.G) {
            if (v0(this.mRecyclerView) == -1) {
                logDebug("find first position is error");
                return;
            } else if (this.mRecyclerView.getAdapter() == null) {
                logDebug("adapter is empty");
                return;
            } else {
                this.H = true;
                u0();
                return;
            }
        }
        logDebug("mIsLoading:" + this.H + " hasPreview:" + this.G);
    }

    private void logDebug(String str) {
        if (AppSetting.isDebugVersion()) {
            RFWLog.d("QZAlbumxListLoadMoreAndPreviewAdapter", RFWLog.USR, str);
        }
    }

    private void t0(boolean z16) {
        Iterator<ua.a> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().h6(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewParent] */
    public void traverseRecyclerViewParent(boolean z16) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        for (RecyclerView recyclerView2 = recyclerView.getParent(); recyclerView2 != null; recyclerView2 = recyclerView2.getParent()) {
            if (recyclerView2 instanceof RecyclerView) {
                registerScrollListenerOrNot(z16, recyclerView2);
            }
        }
    }

    private void u0() {
        Iterator<ua.a> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().U6();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i3, int i16) {
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        if (layoutManager instanceof LinearLayoutManager) {
            C0(i3, i16, ((LinearLayoutManager) layoutManager).getOrientation());
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            C0(i3, i16, ((StaggeredGridLayoutManager) layoutManager).getOrientation());
        } else {
            RFWLog.fatal("QZAlbumxListLoadMoreAndPreviewAdapter", RFWLog.USR, new UnsupportedOperationException("LayoutManager \u4e0d\u662fLinearLayoutManager\u6216StaggeredGridLayoutManager\u5b50\u7c7b"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B0() {
        if (this.G && !this.H && this.K.a(this.mRecyclerView)) {
            this.H = true;
            u0();
        }
    }

    public boolean E0(ua.a aVar) {
        return this.I.remove(aVar);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mLayoutManager = recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(this.J);
        recyclerView.addOnAttachStateChangeListener(new a());
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public boolean x0(ua.a aVar) {
        return this.I.add(aVar);
    }

    public void z0(boolean z16, boolean z17, boolean z18) {
        super.setLoadState(z16, z17);
        if (this.H != z16) {
            this.H = z16;
            A0(z18);
            if (z16) {
                u0();
                return;
            } else {
                t0(z18);
                return;
            }
        }
        A0(z18);
    }

    public void y0() {
        this.G = false;
        this.H = false;
    }

    public int v0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return -1;
        }
        try {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
            }
            if (!(recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager)) {
                return -1;
            }
            int[] iArr = new int[recyclerView.getLayoutManager().getColumnCountForAccessibility(null, null)];
            ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPositions(iArr);
            return iArr[0];
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private void C0(int i3, int i16, int i17) {
        if (i17 == 0 && i3 < 0) {
            B0();
        } else {
            if (i17 != 1 || i16 >= 0) {
                return;
            }
            B0();
        }
    }

    private void registerScrollListenerOrNot(boolean z16, RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        if (z16) {
            recyclerView.removeOnScrollListener(this.J);
            recyclerView.addOnScrollListener(this.J);
        } else {
            recyclerView.removeOnScrollListener(this.J);
        }
    }
}
