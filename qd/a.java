package qd;

import com.qzone.reborn.feedpro.banner.topbanner.constant.FeedProTopBannerType;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u0014\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lqd/a;", "", "Lcom/qzone/reborn/feedpro/banner/topbanner/constant/FeedProTopBannerType;", "a", "Lcom/qzone/reborn/feedpro/banner/topbanner/constant/FeedProTopBannerType;", "c", "()Lcom/qzone/reborn/feedpro/banner/topbanner/constant/FeedProTopBannerType;", "g", "(Lcom/qzone/reborn/feedpro/banner/topbanner/constant/FeedProTopBannerType;)V", WadlProxyConsts.BANNER_TYPE, "b", "e", "bannerSecondaryType", "", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "bannerText", "", "d", "I", "getPriority", "()I", "i", "(I)V", "priority", "", "Lld/a;", "Ljava/util/List;", "()Ljava/util/List;", h.F, "(Ljava/util/List;)V", "bannerUserList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FeedProTopBannerType bannerType = FeedProTopBannerType.TYPE_UNKNOWN;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private FeedProTopBannerType bannerSecondaryType = FeedProTopBannerType.TYPE_SECOND_UNKNOWN;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String bannerText = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int priority;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<ld.a> bannerUserList;

    /* renamed from: a, reason: from getter */
    public final FeedProTopBannerType getBannerSecondaryType() {
        return this.bannerSecondaryType;
    }

    /* renamed from: b, reason: from getter */
    public final String getBannerText() {
        return this.bannerText;
    }

    /* renamed from: c, reason: from getter */
    public final FeedProTopBannerType getBannerType() {
        return this.bannerType;
    }

    public final List<ld.a> d() {
        return this.bannerUserList;
    }

    public final void e(FeedProTopBannerType feedProTopBannerType) {
        Intrinsics.checkNotNullParameter(feedProTopBannerType, "<set-?>");
        this.bannerSecondaryType = feedProTopBannerType;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bannerText = str;
    }

    public final void g(FeedProTopBannerType feedProTopBannerType) {
        Intrinsics.checkNotNullParameter(feedProTopBannerType, "<set-?>");
        this.bannerType = feedProTopBannerType;
    }

    public final void h(List<ld.a> list) {
        this.bannerUserList = list;
    }

    public final void i(int i3) {
        this.priority = i3;
    }
}
