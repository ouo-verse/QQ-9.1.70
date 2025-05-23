package wn;

import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lwn/b;", "", "Lcooperation/qzone/model/PhotoInfo;", "a", "Lcooperation/qzone/model/PhotoInfo;", "()Lcooperation/qzone/model/PhotoInfo;", "currentInfo", "Lcooperation/qzone/model/PhotoParam;", "b", "Lcooperation/qzone/model/PhotoParam;", "c", "()Lcooperation/qzone/model/PhotoParam;", "photoParam", "", "I", "()I", "from", "<init>", "(Lcooperation/qzone/model/PhotoInfo;Lcooperation/qzone/model/PhotoParam;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PhotoInfo currentInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final PhotoParam photoParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int from;

    public b(PhotoInfo currentInfo, PhotoParam photoParam, int i3) {
        Intrinsics.checkNotNullParameter(currentInfo, "currentInfo");
        this.currentInfo = currentInfo;
        this.photoParam = photoParam;
        this.from = i3;
    }

    /* renamed from: a, reason: from getter */
    public final PhotoInfo getCurrentInfo() {
        return this.currentInfo;
    }

    /* renamed from: b, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    /* renamed from: c, reason: from getter */
    public final PhotoParam getPhotoParam() {
        return this.photoParam;
    }
}
