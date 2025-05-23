package zb3;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u000b\u0010\u0012R$\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001a\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lzb3/p;", "", "", "f", tl.h.F, "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "rank", "Ljava/lang/String;", "c", "()Ljava/lang/String;", LocalPhotoFaceInfo.SCORE, "d", "scoreSuffix", "Z", "g", "()Z", "isSelf", "e", "openId", "Lzb3/l;", "Lzb3/l;", "()Lzb3/l;", "i", "(Lzb3/l;)V", "zootopiaRankHeadNickData", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lzb3/l;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.p, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaUserRankData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rank;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String score;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String scoreSuffix;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelf;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String openId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaRankHeadNickData zootopiaRankHeadNickData;

    public ZootopiaUserRankData(int i3, String score, String scoreSuffix, boolean z16, String openId, ZootopiaRankHeadNickData zootopiaRankHeadNickData) {
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(scoreSuffix, "scoreSuffix");
        Intrinsics.checkNotNullParameter(openId, "openId");
        this.rank = i3;
        this.score = score;
        this.scoreSuffix = scoreSuffix;
        this.isSelf = z16;
        this.openId = openId;
        this.zootopiaRankHeadNickData = zootopiaRankHeadNickData;
    }

    /* renamed from: a, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    /* renamed from: b, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    /* renamed from: c, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* renamed from: d, reason: from getter */
    public final String getScoreSuffix() {
        return this.scoreSuffix;
    }

    /* renamed from: e, reason: from getter */
    public final ZootopiaRankHeadNickData getZootopiaRankHeadNickData() {
        return this.zootopiaRankHeadNickData;
    }

    public final String f() {
        String headUrl;
        ZootopiaRankHeadNickData zootopiaRankHeadNickData = this.zootopiaRankHeadNickData;
        return (zootopiaRankHeadNickData == null || (headUrl = zootopiaRankHeadNickData.getHeadUrl()) == null) ? "" : headUrl;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsSelf() {
        return this.isSelf;
    }

    public final String h() {
        String nick;
        ZootopiaRankHeadNickData zootopiaRankHeadNickData = this.zootopiaRankHeadNickData;
        return (zootopiaRankHeadNickData == null || (nick = zootopiaRankHeadNickData.getNick()) == null) ? "" : nick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.rank * 31) + this.score.hashCode()) * 31) + this.scoreSuffix.hashCode()) * 31;
        boolean z16 = this.isSelf;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((hashCode + i3) * 31) + this.openId.hashCode()) * 31;
        ZootopiaRankHeadNickData zootopiaRankHeadNickData = this.zootopiaRankHeadNickData;
        return hashCode2 + (zootopiaRankHeadNickData == null ? 0 : zootopiaRankHeadNickData.hashCode());
    }

    public final void i(ZootopiaRankHeadNickData zootopiaRankHeadNickData) {
        this.zootopiaRankHeadNickData = zootopiaRankHeadNickData;
    }

    public String toString() {
        return "ZootopiaUserRankData(rank=" + this.rank + ", score=" + this.score + ", scoreSuffix=" + this.scoreSuffix + ", isSelf=" + this.isSelf + ", openId=" + this.openId + ", zootopiaRankHeadNickData=" + this.zootopiaRankHeadNickData + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaUserRankData)) {
            return false;
        }
        ZootopiaUserRankData zootopiaUserRankData = (ZootopiaUserRankData) other;
        return this.rank == zootopiaUserRankData.rank && Intrinsics.areEqual(this.score, zootopiaUserRankData.score) && Intrinsics.areEqual(this.scoreSuffix, zootopiaUserRankData.scoreSuffix) && this.isSelf == zootopiaUserRankData.isSelf && Intrinsics.areEqual(this.openId, zootopiaUserRankData.openId) && Intrinsics.areEqual(this.zootopiaRankHeadNickData, zootopiaUserRankData.zootopiaRankHeadNickData);
    }
}
