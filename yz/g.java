package yz;

import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lyz/g;", "Lyz/b;", "Ljz/e;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "listener", "", "a", "", "Ljava/lang/String;", "personId", "", "b", "I", "pageType", "Lw00/a;", "Lw00/c;", "c", "Lw00/a;", "fetcher", "<init>", "(Ljava/lang/String;ILw00/a;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String personId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int pageType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final w00.a<w00.c, j> fetcher;

    public g(String personId, int i3, w00.a<w00.c, j> fetcher) {
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.personId = personId;
        this.pageType = i3;
        this.fetcher = fetcher;
    }

    @Override // yz.b
    public boolean a(jz.e<List<j>> listener) {
        ArrayList arrayList = new ArrayList();
        String str = this.personId;
        int i3 = this.pageType;
        return this.fetcher.a(new w00.c(false, false, str, arrayList, i3, i3));
    }
}
