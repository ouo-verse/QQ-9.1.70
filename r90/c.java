package r90;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import e80.g;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends d {
    private boolean H;
    private int I;
    private final int[] J = new int[2];
    private int K;

    private void A() {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.f92280e;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        Object m3 = this.G.m();
        int i3 = this.I;
        if (i3 >= 0 && (m3 instanceof View)) {
            z(layoutManager, i3, (View) m3);
        } else {
            QFSSearchPrerenderManager.E(this.f92281f).N("feed", 0, true);
        }
    }

    private boolean B(View view) {
        if (h(view) > 0.1f) {
            return true;
        }
        return false;
    }

    private boolean C(RecyclerView.LayoutManager layoutManager, int i3) {
        for (int i16 = i3 - 1; i16 >= this.K; i16--) {
            View findViewByPosition = layoutManager.findViewByPosition(i16);
            if (findViewByPosition instanceof com.tencent.biz.qqcircle.immersive.scrollers.a) {
                if (h(findViewByPosition) > 0.1f) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private boolean y(View view) {
        ViewParent parent = view.getParent();
        RecyclerView recyclerView = this.f92280e;
        if (parent == recyclerView) {
            if (view.getTop() < 0) {
                return false;
            }
        } else {
            recyclerView.getLocationOnScreen(this.J);
            int[] iArr = this.J;
            int i3 = iArr[1];
            view.getLocationOnScreen(iArr);
            if (this.J[1] < i3) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z(RecyclerView.LayoutManager layoutManager, int i3, View view) {
        int i16;
        if (y(view)) {
            if (!this.H && C(layoutManager, i3)) {
                i16 = -1;
            }
            i16 = -100;
        } else {
            if (this.H && B(view)) {
                i16 = 1;
            }
            i16 = -100;
        }
        if (i16 == -100) {
            return;
        }
        if (view instanceof e80.d) {
            QFSSearchPrerenderManager.E(this.f92281f).N(((e80.d) view).o(), i16, false);
        } else {
            QFSSearchPrerenderManager.E(this.f92281f).N("feed", i16, false);
        }
    }

    @Override // r90.d, r90.b.InterfaceC11125b
    public /* bridge */ /* synthetic */ View a(int i3) {
        return super.a(i3);
    }

    @Override // r90.b.InterfaceC11125b
    public void b(Iterable<g> iterable, g gVar, int i3, int i16) {
        this.I = i16;
        this.K = i3;
    }

    @Override // r90.d, r90.b.InterfaceC11125b
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // r90.d, r90.b.InterfaceC11125b
    public /* bridge */ /* synthetic */ int[] d() {
        return super.d();
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public /* bridge */ /* synthetic */ void e(Context context, RecyclerView recyclerView, BaseListViewAdapter baseListViewAdapter, com.tencent.biz.qqcircle.scrollers.b bVar) {
        super.e(context, recyclerView, baseListViewAdapter, bVar);
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public void o() {
        super.o();
        if (!QCirclePluginUtil.isSharePanelOnShow()) {
            QFSSearchPrerenderManager.E(this.f92281f).v(false);
        }
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public void onDestroy() {
        super.onDestroy();
        QFSSearchPrerenderManager.E(this.f92281f).v(false);
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public void onResume() {
        super.onResume();
        QFSSearchPrerenderManager.E(this.f92281f).v(true);
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public void onStop() {
        super.onStop();
        QFSSearchPrerenderManager.E(this.f92281f).v(false);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void q(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        super.q(recyclerView, i3, i16, z16);
        this.H = z16;
        A();
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public /* bridge */ /* synthetic */ void r(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        super.r(recyclerView, i3, layoutManager, i16, i17, i18, i19, z16);
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public /* bridge */ /* synthetic */ void t(RecyclerView.ViewHolder viewHolder) {
        super.t(viewHolder);
    }

    @Override // r90.d, com.tencent.biz.qqcircle.scrollers.a
    public /* bridge */ /* synthetic */ void x(int i3, int i16, int i17, int i18, boolean z16) {
        super.x(i3, i16, i17, i18, z16);
    }
}
