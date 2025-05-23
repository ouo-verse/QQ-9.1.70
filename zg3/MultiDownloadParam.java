package zg3;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\n\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001e\u0010\u001c\u00a8\u0006\""}, d2 = {"Lzg3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "setStartProgress", "(F)V", "startProgress", "", "J", "d", "()J", "setTotalSize", "(J)V", "totalSize", "c", "I", "()I", "setIndex", "(I)V", "index", "setTotalCount", "totalCount", "<init>", "(FJII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zg3.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class MultiDownloadParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float startProgress;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long totalSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int index;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int totalCount;

    public MultiDownloadParam(float f16, long j3, int i3, int i16) {
        this.startProgress = f16;
        this.totalSize = j3;
        this.index = i3;
        this.totalCount = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: b, reason: from getter */
    public final float getStartProgress() {
        return this.startProgress;
    }

    /* renamed from: c, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: d, reason: from getter */
    public final long getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.startProgress) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.totalSize)) * 31) + this.index) * 31) + this.totalCount;
    }

    public String toString() {
        return "MultiDownloadParam(startProgress=" + this.startProgress + ", totalSize=" + this.totalSize + ", index=" + this.index + ", totalCount=" + this.totalCount + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiDownloadParam)) {
            return false;
        }
        MultiDownloadParam multiDownloadParam = (MultiDownloadParam) other;
        return Float.compare(this.startProgress, multiDownloadParam.startProgress) == 0 && this.totalSize == multiDownloadParam.totalSize && this.index == multiDownloadParam.index && this.totalCount == multiDownloadParam.totalCount;
    }
}
