package rc4;

import androidx.recyclerview.widget.GridLayoutManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a f431049a;

    /* renamed from: b, reason: collision with root package name */
    private final GridLayoutManager f431050b;

    /* renamed from: c, reason: collision with root package name */
    private GridLayoutManager.SpanSizeLookup f431051c;

    public a(com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a aVar, GridLayoutManager gridLayoutManager) {
        this.f431049a = aVar;
        this.f431050b = gridLayoutManager;
    }

    public void a(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f431051c = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i3) {
        int itemViewType = this.f431049a.getItemViewType(i3);
        if (this.f431049a.n0(itemViewType) || this.f431049a.m0(itemViewType) || itemViewType == 1024 || itemViewType == 1025) {
            return this.f431050b.getSpanCount();
        }
        GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f431051c;
        if (spanSizeLookup != null) {
            return spanSizeLookup.getSpanSize(i3);
        }
        return 1;
    }
}
