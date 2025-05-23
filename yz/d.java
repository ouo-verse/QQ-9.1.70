package yz;

import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lyz/d;", "Lyz/a;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "Lcom/tencent/biz/pubaccount/weishi/player/l;", "", "data", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements a<j, l> {
    @Override // yz.a
    public List<l> a(List<j> data) {
        List<l> n3 = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.n(data, 0);
        Intrinsics.checkNotNullExpressionValue(n3, "getVideoInfoList(data, 0)");
        return n3;
    }
}
