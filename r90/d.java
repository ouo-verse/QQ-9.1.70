package r90;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import r90.b;

/* compiled from: P */
/* loaded from: classes4.dex */
abstract class d extends com.tencent.biz.qqcircle.scrollers.a implements b.InterfaceC11125b {
    protected final b G = new b();

    public View a(int i3) {
        return this.f92280e.getLayoutManager().findViewByPosition(i3);
    }

    public boolean c() {
        return this.f92280e.canScrollVertically(1);
    }

    public int[] d() {
        return f();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void e(Context context, RecyclerView recyclerView, BaseListViewAdapter baseListViewAdapter, com.tencent.biz.qqcircle.scrollers.b bVar) {
        super.e(context, recyclerView, baseListViewAdapter, bVar);
        this.G.e(recyclerView, this);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public boolean l() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void o() {
        super.o();
        this.G.u();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onDestroy() {
        super.onDestroy();
        this.G.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onResume() {
        super.onResume();
        this.G.onResume();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onStop() {
        super.onStop();
        this.G.onStop();
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void r(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        this.G.v(i3, i16, i17);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void t(RecyclerView.ViewHolder viewHolder) {
        super.t(viewHolder);
        KeyEvent.Callback callback = viewHolder.itemView;
        if (!(callback instanceof com.tencent.biz.qqcircle.immersive.scrollers.a)) {
            return;
        }
        this.G.w((com.tencent.biz.qqcircle.immersive.scrollers.a) callback);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void x(int i3, int i16, int i17, int i18, boolean z16) {
        this.G.C(i3, i16);
    }
}
