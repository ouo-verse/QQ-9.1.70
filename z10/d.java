package z10;

import androidx.recyclerview.widget.GridLayoutManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.biz.pubaccount.weishi.view.recyclerview.a f451721a;

    /* renamed from: b, reason: collision with root package name */
    private final GridLayoutManager f451722b;

    /* renamed from: c, reason: collision with root package name */
    private GridLayoutManager.SpanSizeLookup f451723c;

    public d(com.tencent.biz.pubaccount.weishi.view.recyclerview.a aVar, GridLayoutManager gridLayoutManager) {
        this.f451721a = aVar;
        this.f451722b = gridLayoutManager;
    }

    public void a(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f451723c = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i3) {
        int itemViewType = this.f451721a.getItemViewType(i3);
        if (this.f451721a.n0(itemViewType) || this.f451721a.m0(itemViewType) || itemViewType == 1024 || itemViewType == 1025) {
            return this.f451722b.getSpanCount();
        }
        return 1;
    }
}
