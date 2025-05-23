package sj1;

import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsReq;
import ij1.g;
import ij1.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\u001c\b\u0002\u0010'\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u000b\u0010\u0019R\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u0012\u0010 R+\u0010'\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b\u001d\u0010&\u00a8\u0006*"}, d2 = {"Lsj1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lij1/g;", "a", "Ljava/util/List;", "d", "()Ljava/util/List;", "tempFeedListData", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsReq;", "b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;", "c", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;", "reqParam", "Z", "g", "()Z", "isFinish", "f", QAdRewardDefine$VideoParams.ISCACHE, "e", "forceScrollTop", "Ljava/lang/String;", "()Ljava/lang/String;", "refreshToast", "Ljava/util/ArrayList;", "Lij1/h;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "tempTopFeedsList", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;ZZZLjava/lang/String;Ljava/util/ArrayList;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> tempFeedListData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> reqParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isFinish;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean forceScrollTop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String refreshToast;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArrayList<h> tempTopFeedsList;

    public a(@NotNull List<g> tempFeedListData, @NotNull GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> reqParam, boolean z16, boolean z17, boolean z18, @NotNull String refreshToast, @Nullable ArrayList<h> arrayList) {
        Intrinsics.checkNotNullParameter(tempFeedListData, "tempFeedListData");
        Intrinsics.checkNotNullParameter(reqParam, "reqParam");
        Intrinsics.checkNotNullParameter(refreshToast, "refreshToast");
        this.tempFeedListData = tempFeedListData;
        this.reqParam = reqParam;
        this.isFinish = z16;
        this.isCache = z17;
        this.forceScrollTop = z18;
        this.refreshToast = refreshToast;
        this.tempTopFeedsList = arrayList;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getForceScrollTop() {
        return this.forceScrollTop;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRefreshToast() {
        return this.refreshToast;
    }

    @NotNull
    public final GuildFeedListDataRepo.b<GProStGetChannelFeedsReq> c() {
        return this.reqParam;
    }

    @NotNull
    public final List<g> d() {
        return this.tempFeedListData;
    }

    @Nullable
    public final ArrayList<h> e() {
        return this.tempTopFeedsList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.tempFeedListData, aVar.tempFeedListData) && Intrinsics.areEqual(this.reqParam, aVar.reqParam) && this.isFinish == aVar.isFinish && this.isCache == aVar.isCache && this.forceScrollTop == aVar.forceScrollTop && Intrinsics.areEqual(this.refreshToast, aVar.refreshToast) && Intrinsics.areEqual(this.tempTopFeedsList, aVar.tempTopFeedsList)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.tempFeedListData.hashCode() * 31) + this.reqParam.hashCode()) * 31;
        boolean z16 = this.isFinish;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.isCache;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.forceScrollTop;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        int hashCode3 = (((i19 + i3) * 31) + this.refreshToast.hashCode()) * 31;
        ArrayList<h> arrayList = this.tempTopFeedsList;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        return hashCode3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "tempFeedListSize:" + this.tempFeedListData.size() + ",isLoadMore:" + this.reqParam.getCom.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE java.lang.String() + ",isFinish:" + this.isFinish + ",isCache:" + this.isCache + ",forceScrollTop:" + this.forceScrollTop + ",refreshToast:" + this.refreshToast;
    }
}
