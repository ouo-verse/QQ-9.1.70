package zf2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lzf2/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "name", "b", "iconUrl", "d", "nightIconUrl", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zf2.d, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class PromotionPanelItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String iconUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String nightIconUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String jumpUrl;

    public PromotionPanelItem(String name, String iconUrl, String nightIconUrl, String jumpUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(nightIconUrl, "nightIconUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.name = name;
        this.iconUrl = iconUrl;
        this.nightIconUrl = nightIconUrl;
        this.jumpUrl = jumpUrl;
    }

    /* renamed from: a, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final String getNightIconUrl() {
        return this.nightIconUrl;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.nightIconUrl.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    public String toString() {
        return "PromotionPanelItem(name=" + this.name + ", iconUrl=" + this.iconUrl + ", nightIconUrl=" + this.nightIconUrl + ", jumpUrl=" + this.jumpUrl + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromotionPanelItem)) {
            return false;
        }
        PromotionPanelItem promotionPanelItem = (PromotionPanelItem) other;
        return Intrinsics.areEqual(this.name, promotionPanelItem.name) && Intrinsics.areEqual(this.iconUrl, promotionPanelItem.iconUrl) && Intrinsics.areEqual(this.nightIconUrl, promotionPanelItem.nightIconUrl) && Intrinsics.areEqual(this.jumpUrl, promotionPanelItem.jumpUrl);
    }
}
