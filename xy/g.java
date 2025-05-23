package xy;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lxy/g;", "Lcom/tencent/biz/pubaccount/weishi/presenter/a;", "Lxy/c;", "", "Lyy/b;", "B0", "", "isFirst", "isRefresh", "", "A0", "Lxy/d;", "f", "Lxy/d;", "mDataFetcher", tl.h.F, "Lyy/b;", "mPageData", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g extends com.tencent.biz.pubaccount.weishi.presenter.a<c> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private d mDataFetcher = new d();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private yy.b mPageData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"xy/g$a", "Lkz/a;", "Lyy/b;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFailure", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements kz.a<yy.b> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f449021b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f449022c;

        a(boolean z16, boolean z17) {
            this.f449021b = z16;
            this.f449022c = z17;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(yy.b data) {
            List<yy.c> e16;
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.g() || data.h()) {
                g.this.mPageData = data;
            } else {
                yy.b bVar = g.this.mPageData;
                if (bVar != null) {
                    bVar.i(data.g(), data.h(), data.a(), data.f());
                }
                yy.b bVar2 = g.this.mPageData;
                if (bVar2 != null && (e16 = bVar2.e()) != null) {
                    List<yy.c> e17 = data.e();
                    Intrinsics.checkNotNullExpressionValue(e17, "data.sectionList");
                    e16.addAll(e17);
                }
            }
            c x06 = g.this.x0();
            if (x06 != null) {
                x06.hideLoadingView();
            }
            c x07 = g.this.x0();
            if (x07 != null) {
                x07.U4(data, this.f449021b, this.f449022c, !data.f());
            }
        }

        @Override // kz.a
        public void onFailure(int errorCode, String errorMsg) {
            c x06 = g.this.x0();
            if (x06 != null) {
                x06.hideLoadingView();
            }
            c x07 = g.this.x0();
            if (x07 != null) {
                if (errorMsg == null) {
                    errorMsg = "";
                }
                x07.Q0(errorCode, errorMsg, this.f449021b);
            }
        }
    }

    public void A0(boolean isFirst, boolean isRefresh) {
        this.mDataFetcher.f(new jz.a(isFirst, isRefresh), new a(isFirst, isRefresh));
    }

    /* renamed from: B0, reason: from getter */
    public yy.b getMPageData() {
        return this.mPageData;
    }
}
