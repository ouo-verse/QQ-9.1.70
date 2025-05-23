package vc3;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\t\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lvc3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", WadlProxyConsts.PARAM_FILENAME, "", UserInfo.SEX_FEMALE, "c", "()F", "iconSize", "I", "d", "()I", "loadingDrawableId", "Lcom/tencent/image/URLDrawable;", "Lcom/tencent/image/URLDrawable;", "()Lcom/tencent/image/URLDrawable;", "e", "(Lcom/tencent/image/URLDrawable;)V", "cacheUrlDrawable", "<init>", "(Ljava/lang/String;FILcom/tencent/image/URLDrawable;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vc3.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaDynamicIconData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String fileName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float iconSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int loadingDrawableId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private URLDrawable cacheUrlDrawable;

    public ZootopiaDynamicIconData(String fileName, float f16, int i3, URLDrawable uRLDrawable) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.fileName = fileName;
        this.iconSize = f16;
        this.loadingDrawableId = i3;
        this.cacheUrlDrawable = uRLDrawable;
    }

    /* renamed from: a, reason: from getter */
    public final URLDrawable getCacheUrlDrawable() {
        return this.cacheUrlDrawable;
    }

    /* renamed from: b, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: c, reason: from getter */
    public final float getIconSize() {
        return this.iconSize;
    }

    /* renamed from: d, reason: from getter */
    public final int getLoadingDrawableId() {
        return this.loadingDrawableId;
    }

    public final void e(URLDrawable uRLDrawable) {
        this.cacheUrlDrawable = uRLDrawable;
    }

    public int hashCode() {
        int hashCode = ((((this.fileName.hashCode() * 31) + Float.floatToIntBits(this.iconSize)) * 31) + this.loadingDrawableId) * 31;
        URLDrawable uRLDrawable = this.cacheUrlDrawable;
        return hashCode + (uRLDrawable == null ? 0 : uRLDrawable.hashCode());
    }

    public String toString() {
        return "ZootopiaDynamicIconData(fileName=" + this.fileName + ", iconSize=" + this.iconSize + ", loadingDrawableId=" + this.loadingDrawableId + ", cacheUrlDrawable=" + this.cacheUrlDrawable + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaDynamicIconData)) {
            return false;
        }
        ZootopiaDynamicIconData zootopiaDynamicIconData = (ZootopiaDynamicIconData) other;
        return Intrinsics.areEqual(this.fileName, zootopiaDynamicIconData.fileName) && Float.compare(this.iconSize, zootopiaDynamicIconData.iconSize) == 0 && this.loadingDrawableId == zootopiaDynamicIconData.loadingDrawableId && Intrinsics.areEqual(this.cacheUrlDrawable, zootopiaDynamicIconData.cacheUrlDrawable);
    }
}
