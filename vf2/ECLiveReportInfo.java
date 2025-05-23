package vf2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lvf2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "userId", "b", "anchorId", "c", h.F, "roomId", "d", "f", "liveType", "e", "liveContent", "g", "programId", "enterId", "comingWay", "abtoken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vf2.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECLiveReportInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String userId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String anchorId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String liveType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String liveContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String programId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final String enterId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String comingWay;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final String abtoken;

    public ECLiveReportInfo(String userId, String anchorId, String roomId, String liveType, String liveContent, String programId, String enterId, String comingWay, String abtoken) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(liveType, "liveType");
        Intrinsics.checkNotNullParameter(liveContent, "liveContent");
        Intrinsics.checkNotNullParameter(programId, "programId");
        Intrinsics.checkNotNullParameter(enterId, "enterId");
        Intrinsics.checkNotNullParameter(comingWay, "comingWay");
        Intrinsics.checkNotNullParameter(abtoken, "abtoken");
        this.userId = userId;
        this.anchorId = anchorId;
        this.roomId = roomId;
        this.liveType = liveType;
        this.liveContent = liveContent;
        this.programId = programId;
        this.enterId = enterId;
        this.comingWay = comingWay;
        this.abtoken = abtoken;
    }

    /* renamed from: a, reason: from getter */
    public final String getAbtoken() {
        return this.abtoken;
    }

    /* renamed from: b, reason: from getter */
    public final String getAnchorId() {
        return this.anchorId;
    }

    /* renamed from: c, reason: from getter */
    public final String getComingWay() {
        return this.comingWay;
    }

    /* renamed from: d, reason: from getter */
    public final String getEnterId() {
        return this.enterId;
    }

    /* renamed from: e, reason: from getter */
    public final String getLiveContent() {
        return this.liveContent;
    }

    /* renamed from: f, reason: from getter */
    public final String getLiveType() {
        return this.liveType;
    }

    /* renamed from: g, reason: from getter */
    public final String getProgramId() {
        return this.programId;
    }

    /* renamed from: h, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return (((((((((((((((this.userId.hashCode() * 31) + this.anchorId.hashCode()) * 31) + this.roomId.hashCode()) * 31) + this.liveType.hashCode()) * 31) + this.liveContent.hashCode()) * 31) + this.programId.hashCode()) * 31) + this.enterId.hashCode()) * 31) + this.comingWay.hashCode()) * 31) + this.abtoken.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "ECLiveReportInfo(userId=" + this.userId + ", anchorId=" + this.anchorId + ", roomId=" + this.roomId + ", liveType=" + this.liveType + ", liveContent=" + this.liveContent + ", programId=" + this.programId + ", enterId=" + this.enterId + ", comingWay=" + this.comingWay + ", abtoken=" + this.abtoken + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECLiveReportInfo)) {
            return false;
        }
        ECLiveReportInfo eCLiveReportInfo = (ECLiveReportInfo) other;
        return Intrinsics.areEqual(this.userId, eCLiveReportInfo.userId) && Intrinsics.areEqual(this.anchorId, eCLiveReportInfo.anchorId) && Intrinsics.areEqual(this.roomId, eCLiveReportInfo.roomId) && Intrinsics.areEqual(this.liveType, eCLiveReportInfo.liveType) && Intrinsics.areEqual(this.liveContent, eCLiveReportInfo.liveContent) && Intrinsics.areEqual(this.programId, eCLiveReportInfo.programId) && Intrinsics.areEqual(this.enterId, eCLiveReportInfo.enterId) && Intrinsics.areEqual(this.comingWay, eCLiveReportInfo.comingWay) && Intrinsics.areEqual(this.abtoken, eCLiveReportInfo.abtoken);
    }
}
