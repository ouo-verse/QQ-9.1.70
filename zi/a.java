package zi;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yi.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lzi/a;", "Lwi/a;", "Lyi/e;", "Lzi/b;", "child", "", "f", "", "Lwi/b;", "d", "Ljava/util/List;", "mediaItemList", "b", "()Ljava/util/List;", "childNode", "<init>", "(Ljava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a extends wi.a implements e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<wi.b> mediaItemList;

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // wi.b
    public List<wi.b> b() {
        return this.mediaItemList;
    }

    public final void f(b child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.mediaItemList.add(child);
        child.e(this);
    }

    public /* synthetic */ a(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list);
    }

    public a(List<wi.b> mediaItemList) {
        Intrinsics.checkNotNullParameter(mediaItemList, "mediaItemList");
        this.mediaItemList = mediaItemList;
    }
}
