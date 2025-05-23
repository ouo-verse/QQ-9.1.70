package r10;

import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0002R$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lr10/e;", "", "", "g", "f", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "data", "", "e", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "videoHolder", "a", tl.h.F, "", com.tencent.luggage.wxa.c8.c.G, "isSeekBarAuto", "b", "isScroll", "c", "d", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/n;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/n;", "getCommentController", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/n;", "setCommentController", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/n;)V", "commentController", "Lmqq/util/WeakReference;", "Lcom/tencent/biz/pubaccount/weishi/comment/WsCommentPresenter;", "Lmqq/util/WeakReference;", "getCommentPresenterWeakReference", "()Lmqq/util/WeakReference;", "setCommentPresenterWeakReference", "(Lmqq/util/WeakReference;)V", "commentPresenterWeakReference", "Z", "isScrollCommentPause", "()Z", "setScrollCommentPause", "(Z)V", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;", "view", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private n commentController;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<WsCommentPresenter> commentPresenterWeakReference;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isScrollCommentPause;

    public e(com.tencent.biz.pubaccount.weishi.verticalvideo.h view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof WSVerticalPageFragment) {
            this.commentPresenterWeakReference = new WeakReference<>(((WSVerticalPageFragment) view).f81812c0);
        }
    }

    private final void f() {
        n nVar = this.commentController;
        if (nVar != null) {
            nVar.D();
        }
    }

    private final void g() {
        n nVar = this.commentController;
        if (nVar != null) {
            nVar.E();
        }
    }

    public final void a(au videoHolder) {
        Intrinsics.checkNotNullParameter(videoHolder, "videoHolder");
        Object obj = videoHolder.f82127d;
        if (obj instanceof WSVerticalVideoOperationRightItemView) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalVideoOperationRightItemView");
            com.tencent.biz.pubaccount.weishi.baseui.b<j> A = ((WSVerticalVideoOperationRightItemView) obj).A();
            Intrinsics.checkNotNullExpressionValue(A, "itemView.bottomContentController");
            if (A instanceof n) {
                this.commentController = (n) A;
            }
        }
    }

    public final void b(long pos, boolean isSeekBarAuto) {
        int e16;
        if (this.isScrollCommentPause) {
            return;
        }
        n nVar = this.commentController;
        if (e(nVar != null ? nVar.c() : null)) {
            return;
        }
        a aVar = a.f430463a;
        if (aVar.f() && (e16 = aVar.e()) > 0) {
            if (!isSeekBarAuto) {
                f();
                return;
            }
            if (pos > e16) {
                n nVar2 = this.commentController;
                if (nVar2 != null) {
                    nVar2.K();
                    return;
                }
                return;
            }
            n nVar3 = this.commentController;
            if (nVar3 != null) {
                nVar3.E();
            }
        }
    }

    public final void d() {
        n nVar = this.commentController;
        if (nVar != null) {
            nVar.C();
        }
    }

    public final void h() {
        this.commentController = null;
    }

    private final boolean e(j data) {
        return (data != null ? data.f() : null) != null;
    }

    public final void c(boolean isScroll) {
        this.isScrollCommentPause = !isScroll;
        if (isScroll) {
            g();
        } else {
            f();
        }
    }
}
