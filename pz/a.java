package pz;

import android.view.ViewGroup;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a extends BaseViewHolder<mz.d> {

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<com.tencent.biz.pubaccount.weishi.drama.c> f428076d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.biz.pubaccount.weishi.baseui.c<mz.d> f428077e;

    /* renamed from: f, reason: collision with root package name */
    public mz.d f428078f;

    public a(ViewGroup viewGroup, int i3, int i16, com.tencent.biz.pubaccount.weishi.drama.c cVar) {
        super(viewGroup, i3);
        this.f428076d = new WeakReference<>(cVar);
        this.f428077e = c(i16);
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void bindData(mz.d dVar) {
        this.f428078f = dVar;
        com.tencent.biz.pubaccount.weishi.baseui.c<mz.d> cVar = this.f428077e;
        if (cVar != null) {
            cVar.setData(dVar);
            this.f428077e.setPosition(getLayoutPosition() - 1);
        }
    }

    public abstract com.tencent.biz.pubaccount.weishi.baseui.c<mz.d> c(int i3);

    public com.tencent.biz.pubaccount.weishi.drama.c d() {
        WeakReference<com.tencent.biz.pubaccount.weishi.drama.c> weakReference = this.f428076d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void e(int i3) {
        com.tencent.biz.pubaccount.weishi.baseui.c<mz.d> cVar = this.f428077e;
        if (cVar != null) {
            cVar.onPageSelected(i3);
        }
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        com.tencent.biz.pubaccount.weishi.baseui.c<mz.d> cVar = this.f428077e;
        if (cVar != null) {
            cVar.c();
        }
    }
}
