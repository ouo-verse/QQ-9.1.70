package vg3;

import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lvg3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "a", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "b", "()Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "subScene", "I", "d", "()I", "targetWidth", "c", "targetHeight", "Ljava/lang/String;", "()Ljava/lang/String;", "cacheFilePath", "<init>", "(Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;IILjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vg3.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class DrawableTag {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final CoupleAvatarSubScene subScene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int targetWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int targetHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String cacheFilePath;

    public DrawableTag(CoupleAvatarSubScene subScene, int i3, int i16, String str) {
        Intrinsics.checkNotNullParameter(subScene, "subScene");
        this.subScene = subScene;
        this.targetWidth = i3;
        this.targetHeight = i16;
        this.cacheFilePath = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getCacheFilePath() {
        return this.cacheFilePath;
    }

    /* renamed from: b, reason: from getter */
    public final CoupleAvatarSubScene getSubScene() {
        return this.subScene;
    }

    /* renamed from: c, reason: from getter */
    public final int getTargetHeight() {
        return this.targetHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getTargetWidth() {
        return this.targetWidth;
    }

    public int hashCode() {
        int hashCode = ((((this.subScene.hashCode() * 31) + this.targetWidth) * 31) + this.targetHeight) * 31;
        String str = this.cacheFilePath;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DrawableTag(subScene=" + this.subScene + ", targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", cacheFilePath=" + this.cacheFilePath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawableTag)) {
            return false;
        }
        DrawableTag drawableTag = (DrawableTag) other;
        return this.subScene == drawableTag.subScene && this.targetWidth == drawableTag.targetWidth && this.targetHeight == drawableTag.targetHeight && Intrinsics.areEqual(this.cacheFilePath, drawableTag.cacheFilePath);
    }
}
