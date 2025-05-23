package qz2;

import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.fileupload.FileUploadBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lqz2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "b", "J", "()J", "aid", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "posId", "f", "traceId", "actionType", FileUploadBase.ATTACHMENT, "<init>", "(IJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qz2.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasAdMetaReportParamNew {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int busiType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long aid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String posId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String attachment;

    public VasAdMetaReportParamNew(int i3, long j3, @NotNull String posId, @NotNull String traceId, int i16, @NotNull String attachment) {
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        this.busiType = i3;
        this.aid = j3;
        this.posId = posId;
        this.traceId = traceId;
        this.actionType = i16;
        this.attachment = attachment;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    /* renamed from: b, reason: from getter */
    public final long getAid() {
        return this.aid;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAttachment() {
        return this.attachment;
    }

    /* renamed from: d, reason: from getter */
    public final int getBusiType() {
        return this.busiType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPosId() {
        return this.posId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasAdMetaReportParamNew)) {
            return false;
        }
        VasAdMetaReportParamNew vasAdMetaReportParamNew = (VasAdMetaReportParamNew) other;
        if (this.busiType == vasAdMetaReportParamNew.busiType && this.aid == vasAdMetaReportParamNew.aid && Intrinsics.areEqual(this.posId, vasAdMetaReportParamNew.posId) && Intrinsics.areEqual(this.traceId, vasAdMetaReportParamNew.traceId) && this.actionType == vasAdMetaReportParamNew.actionType && Intrinsics.areEqual(this.attachment, vasAdMetaReportParamNew.attachment)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        return (((((((((this.busiType * 31) + androidx.fragment.app.a.a(this.aid)) * 31) + this.posId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.actionType) * 31) + this.attachment.hashCode();
    }

    @NotNull
    public String toString() {
        return "VasAdMetaReportParamNew(busiType=" + this.busiType + ", aid=" + this.aid + ", posId=" + this.posId + ", traceId=" + this.traceId + ", actionType=" + this.actionType + ", attachment=" + this.attachment + ')';
    }
}
