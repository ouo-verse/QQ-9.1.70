package zb3;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b$\u0010%R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u0015\u0010\u001cR\"\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b\u0003\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lzb3/k;", "", "Lzb3/j;", "a", "Lzb3/j;", "b", "()Lzb3/j;", "rankConfig", "", "Ljava/util/List;", "c", "()Ljava/util/List;", "rankConfigList", "Lzb3/p;", "Lzb3/p;", "d", "()Lzb3/p;", "selfRankData", "g", "userRankDataList", "", "e", "I", "f", "()I", "showSwitch", "", "Ljava/lang/String;", "()Ljava/lang/String;", "serverKey", "", "Z", "()Z", "setHasMore", "(Z)V", "hasMore", "<init>", "(Lzb3/j;Ljava/util/List;Lzb3/p;Ljava/util/List;ILjava/lang/String;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaRankConfigData rankConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<ZootopiaRankConfigData> rankConfigList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaUserRankData selfRankData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<ZootopiaUserRankData> userRankDataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int showSwitch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String serverKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasMore;

    public k(ZootopiaRankConfigData rankConfig, List<ZootopiaRankConfigData> rankConfigList, ZootopiaUserRankData selfRankData, List<ZootopiaUserRankData> userRankDataList, int i3, String serverKey, boolean z16) {
        Intrinsics.checkNotNullParameter(rankConfig, "rankConfig");
        Intrinsics.checkNotNullParameter(rankConfigList, "rankConfigList");
        Intrinsics.checkNotNullParameter(selfRankData, "selfRankData");
        Intrinsics.checkNotNullParameter(userRankDataList, "userRankDataList");
        Intrinsics.checkNotNullParameter(serverKey, "serverKey");
        this.rankConfig = rankConfig;
        this.rankConfigList = rankConfigList;
        this.selfRankData = selfRankData;
        this.userRankDataList = userRankDataList;
        this.showSwitch = i3;
        this.serverKey = serverKey;
        this.hasMore = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaRankConfigData getRankConfig() {
        return this.rankConfig;
    }

    public final List<ZootopiaRankConfigData> c() {
        return this.rankConfigList;
    }

    /* renamed from: d, reason: from getter */
    public final ZootopiaUserRankData getSelfRankData() {
        return this.selfRankData;
    }

    /* renamed from: e, reason: from getter */
    public final String getServerKey() {
        return this.serverKey;
    }

    /* renamed from: f, reason: from getter */
    public final int getShowSwitch() {
        return this.showSwitch;
    }

    public final List<ZootopiaUserRankData> g() {
        return this.userRankDataList;
    }
}
