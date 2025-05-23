package yz;

import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import java.util.List;
import jz.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lyz/f;", "Lyz/b;", "Ljz/e;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "listener", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements b {
    @Override // yz.b
    public boolean a(jz.e<List<j>> listener) {
        jz.f.d().c(false, false, "", 10, 0L, new a(listener));
        return true;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"yz/f$a", "Ljz/f$c;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "", "isFirst", "isRefresh", "isSuccess", "", "resultBean", "", "b", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "data", "isFinish", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements f.c<j> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jz.e<List<j>> f451576a;

        a(jz.e<List<j>> eVar) {
            this.f451576a = eVar;
        }

        @Override // jz.f.c
        public void a(boolean isLoadMore, List<j> data, boolean isFinish) {
            Intrinsics.checkNotNullParameter(data, "data");
            jz.e<List<j>> eVar = this.f451576a;
            if (eVar != null) {
                eVar.a(data, false, false, null);
            }
        }

        @Override // jz.f.c
        public void b(boolean isFirst, boolean isRefresh, boolean isSuccess, Object resultBean) {
            jz.e<List<j>> eVar;
            if (isSuccess || (eVar = this.f451576a) == null) {
                return;
            }
            eVar.i(-1, "task failed.", isFirst, isRefresh);
        }
    }
}
