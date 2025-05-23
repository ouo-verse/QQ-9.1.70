package ze3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lze3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "id", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "url", "c", "Z", "isSelected", "()Z", "setSelected", "(Z)V", "<init>", "(JLjava/lang/String;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ze3.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZPlanEditAvatarBackgroundData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    public ZPlanEditAvatarBackgroundData(long j3, String url, boolean z16) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = j3;
        this.url = url;
        this.isSelected = z16;
    }

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((com.tencent.mobileqq.vas.banner.c.a(this.id) * 31) + this.url.hashCode()) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    public String toString() {
        return "ZPlanEditAvatarBackgroundData(id=" + this.id + ", url=" + this.url + ", isSelected=" + this.isSelected + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEditAvatarBackgroundData)) {
            return false;
        }
        ZPlanEditAvatarBackgroundData zPlanEditAvatarBackgroundData = (ZPlanEditAvatarBackgroundData) other;
        return this.id == zPlanEditAvatarBackgroundData.id && Intrinsics.areEqual(this.url, zPlanEditAvatarBackgroundData.url) && this.isSelected == zPlanEditAvatarBackgroundData.isSelected;
    }
}
