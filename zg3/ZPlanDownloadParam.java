package zg3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lzg3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "category", "b", "d", "url", "", "c", "J", "()J", "fileSize", "Lzg3/a;", "Lzg3/a;", "()Lzg3/a;", "e", "(Lzg3/a;)V", "multiDownloadParam", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLzg3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zg3.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZPlanDownloadParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String category;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long fileSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private MultiDownloadParam multiDownloadParam;

    public ZPlanDownloadParam(String category, String url, long j3, MultiDownloadParam multiDownloadParam) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(url, "url");
        this.category = category;
        this.url = url;
        this.fileSize = j3;
        this.multiDownloadParam = multiDownloadParam;
    }

    /* renamed from: a, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: b, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: c, reason: from getter */
    public final MultiDownloadParam getMultiDownloadParam() {
        return this.multiDownloadParam;
    }

    /* renamed from: d, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final void e(MultiDownloadParam multiDownloadParam) {
        this.multiDownloadParam = multiDownloadParam;
    }

    public int hashCode() {
        int hashCode = ((((this.category.hashCode() * 31) + this.url.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.fileSize)) * 31;
        MultiDownloadParam multiDownloadParam = this.multiDownloadParam;
        return hashCode + (multiDownloadParam == null ? 0 : multiDownloadParam.hashCode());
    }

    public String toString() {
        return "ZPlanDownloadParam(category=" + this.category + ", url=" + this.url + ", fileSize=" + this.fileSize + ", multiDownloadParam=" + this.multiDownloadParam + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanDownloadParam)) {
            return false;
        }
        ZPlanDownloadParam zPlanDownloadParam = (ZPlanDownloadParam) other;
        return Intrinsics.areEqual(this.category, zPlanDownloadParam.category) && Intrinsics.areEqual(this.url, zPlanDownloadParam.url) && this.fileSize == zPlanDownloadParam.fileSize && Intrinsics.areEqual(this.multiDownloadParam, zPlanDownloadParam.multiDownloadParam);
    }

    public /* synthetic */ ZPlanDownloadParam(String str, String str2, long j3, MultiDownloadParam multiDownloadParam, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j3, (i3 & 8) != 0 ? null : multiDownloadParam);
    }
}
