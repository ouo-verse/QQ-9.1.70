package zb3;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\n\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b\u001a\u0010\u001e\u00a8\u0006\""}, d2 = {"Lzb3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "startIndex", "b", "c", "offset", "", "Lzb3/a;", "Ljava/util/List;", "()Ljava/util/List;", "friendsDressUpDataList", "Z", "()Z", "hasMore", "e", "f", "vipMaxVote", "Ljava/lang/String;", "()Ljava/lang/String;", "vipFriendsMaxVotesNotice", "<init>", "(JJLjava/util/List;ZJLjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class FriendsRespData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long offset;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<FriendsDressUpData> friendsDressUpDataList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasMore;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long vipMaxVote;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String vipFriendsMaxVotesNotice;

    public FriendsRespData(long j3, long j16, @NotNull List<FriendsDressUpData> friendsDressUpDataList, boolean z16, long j17, @NotNull String vipFriendsMaxVotesNotice) {
        Intrinsics.checkNotNullParameter(friendsDressUpDataList, "friendsDressUpDataList");
        Intrinsics.checkNotNullParameter(vipFriendsMaxVotesNotice, "vipFriendsMaxVotesNotice");
        this.startIndex = j3;
        this.offset = j16;
        this.friendsDressUpDataList = friendsDressUpDataList;
        this.hasMore = z16;
        this.vipMaxVote = j17;
        this.vipFriendsMaxVotesNotice = vipFriendsMaxVotesNotice;
    }

    @NotNull
    public final List<FriendsDressUpData> a() {
        return this.friendsDressUpDataList;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* renamed from: c, reason: from getter */
    public final long getOffset() {
        return this.offset;
    }

    /* renamed from: d, reason: from getter */
    public final long getStartIndex() {
        return this.startIndex;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getVipFriendsMaxVotesNotice() {
        return this.vipFriendsMaxVotesNotice;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsRespData)) {
            return false;
        }
        FriendsRespData friendsRespData = (FriendsRespData) other;
        if (this.startIndex == friendsRespData.startIndex && this.offset == friendsRespData.offset && Intrinsics.areEqual(this.friendsDressUpDataList, friendsRespData.friendsDressUpDataList) && this.hasMore == friendsRespData.hasMore && this.vipMaxVote == friendsRespData.vipMaxVote && Intrinsics.areEqual(this.vipFriendsMaxVotesNotice, friendsRespData.vipFriendsMaxVotesNotice)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getVipMaxVote() {
        return this.vipMaxVote;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((androidx.fragment.app.a.a(this.startIndex) * 31) + androidx.fragment.app.a.a(this.offset)) * 31) + this.friendsDressUpDataList.hashCode()) * 31;
        boolean z16 = this.hasMore;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((a16 + i3) * 31) + androidx.fragment.app.a.a(this.vipMaxVote)) * 31) + this.vipFriendsMaxVotesNotice.hashCode();
    }

    @NotNull
    public String toString() {
        return "FriendsRespData(startIndex=" + this.startIndex + ", offset=" + this.offset + ", friendsDressUpDataList=" + this.friendsDressUpDataList + ", hasMore=" + this.hasMore + ", vipMaxVote=" + this.vipMaxVote + ", vipFriendsMaxVotesNotice=" + this.vipFriendsMaxVotesNotice + ')';
    }
}
