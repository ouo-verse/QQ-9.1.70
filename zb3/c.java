package zb3;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzb3/c;", "", "", "a", "I", "()I", "adId", "Ljava/util/ArrayList;", "Lzb3/d;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "items", "<init>", "(ILjava/util/ArrayList;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int adId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ZootopiaBannerItem> items;

    public c() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final int getAdId() {
        return this.adId;
    }

    public final ArrayList<ZootopiaBannerItem> b() {
        return this.items;
    }

    public c(int i3, ArrayList<ZootopiaBannerItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.adId = i3;
        this.items = items;
    }

    public /* synthetic */ c(int i3, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? new ArrayList() : arrayList);
    }
}
