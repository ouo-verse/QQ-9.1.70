package q10;

import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import java.util.List;
import jz.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lq10/a;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/k;", "launchParams", "", "a", "Ljz/c;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "listener", "c", "", "from", "", "b", "Lq10/b;", "Lq10/b;", "mediator", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f428181a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static b<j> mediator;

    a() {
    }

    public final void a(k launchParams) {
        Intrinsics.checkNotNullParameter(launchParams, "launchParams");
        if (!b(launchParams.l())) {
            x.j("WSPreposeRequestHelper", "not use prepose request strategy.");
            return;
        }
        x.j("WSPreposeRequestHelper", "use prepose request strategy.");
        List<j> d16 = i.d(launchParams.j());
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.k o16 = new com.tencent.biz.pubaccount.weishi.verticalvideo.data.k(2, true, true).n(launchParams.u()).k(i.j(true, d16)).o(i.l(true, d16));
        mediator = new b<>();
        WSVerticalDataManager.j().g(o16, mediator);
    }

    public final boolean b(String from) {
        return Intrinsics.areEqual(from, "recommend_tab") && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().M();
    }

    public final void c(c<j> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b<j> bVar = mediator;
        if (bVar != null) {
            bVar.c(listener);
        }
    }
}
