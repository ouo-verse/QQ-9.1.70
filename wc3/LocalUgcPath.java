package wc3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lwc3/c;", "", "", "a", "Luv4/az;", "b", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "local_ugc_texture_path", "Luv4/az;", "d", "()Luv4/az;", "store_item", "<init>", "(Ljava/lang/String;Luv4/az;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wc3.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class LocalUgcPath {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String local_ugc_texture_path;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final az store_item;

    public LocalUgcPath(String local_ugc_texture_path, az store_item) {
        Intrinsics.checkNotNullParameter(local_ugc_texture_path, "local_ugc_texture_path");
        Intrinsics.checkNotNullParameter(store_item, "store_item");
        this.local_ugc_texture_path = local_ugc_texture_path;
        this.store_item = store_item;
    }

    /* renamed from: a, reason: from getter */
    public final String getLocal_ugc_texture_path() {
        return this.local_ugc_texture_path;
    }

    /* renamed from: b, reason: from getter */
    public final az getStore_item() {
        return this.store_item;
    }

    public final String c() {
        return this.local_ugc_texture_path;
    }

    public final az d() {
        return this.store_item;
    }

    public int hashCode() {
        return (this.local_ugc_texture_path.hashCode() * 31) + this.store_item.hashCode();
    }

    public String toString() {
        return "LocalUgcPath(local_ugc_texture_path=" + this.local_ugc_texture_path + ", store_item=" + this.store_item + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalUgcPath)) {
            return false;
        }
        LocalUgcPath localUgcPath = (LocalUgcPath) other;
        return Intrinsics.areEqual(this.local_ugc_texture_path, localUgcPath.local_ugc_texture_path) && Intrinsics.areEqual(this.store_item, localUgcPath.store_item);
    }
}
