package uz2;

import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Luz2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "rewardType", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "rewardItem", "d", GetAdInfoRequest.SOURCE_FROM, "attachInfo", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: uz2.b, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasRewardAdReqParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rewardType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String rewardItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sourceFrom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String attachInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\f\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Luz2/b$a;", "", "Luz2/b;", "a", "", "I", "getRewardType", "()I", "d", "(I)V", "rewardType", "", "b", "Ljava/lang/String;", "getRewardItem", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "rewardItem", "getSourceFrom", "e", GetAdInfoRequest.SOURCE_FROM, "getAttachInfo", "attachInfo", "<init>", "()V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uz2.b$a */
    /* loaded from: classes20.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int rewardType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int sourceFrom;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String rewardItem = "";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String attachInfo = "";

        @NotNull
        public final VasRewardAdReqParams a() {
            return new VasRewardAdReqParams(this.rewardType, this.rewardItem, this.sourceFrom, this.attachInfo);
        }

        public final void b(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.attachInfo = str;
        }

        public final void c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.rewardItem = str;
        }

        public final void d(int i3) {
            this.rewardType = i3;
        }

        public final void e(int i3) {
            this.sourceFrom = i3;
        }
    }

    public VasRewardAdReqParams(int i3, @NotNull String rewardItem, int i16, @NotNull String attachInfo) {
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.rewardType = i3;
        this.rewardItem = rewardItem;
        this.sourceFrom = i16;
        this.attachInfo = attachInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRewardItem() {
        return this.rewardItem;
    }

    /* renamed from: c, reason: from getter */
    public final int getRewardType() {
        return this.rewardType;
    }

    /* renamed from: d, reason: from getter */
    public final int getSourceFrom() {
        return this.sourceFrom;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasRewardAdReqParams)) {
            return false;
        }
        VasRewardAdReqParams vasRewardAdReqParams = (VasRewardAdReqParams) other;
        if (this.rewardType == vasRewardAdReqParams.rewardType && Intrinsics.areEqual(this.rewardItem, vasRewardAdReqParams.rewardItem) && this.sourceFrom == vasRewardAdReqParams.sourceFrom && Intrinsics.areEqual(this.attachInfo, vasRewardAdReqParams.attachInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.rewardType * 31) + this.rewardItem.hashCode()) * 31) + this.sourceFrom) * 31) + this.attachInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "VasRewardAdReqParams(rewardType=" + this.rewardType + ", rewardItem=" + this.rewardItem + ", sourceFrom=" + this.sourceFrom + ", attachInfo=" + this.attachInfo + ')';
    }
}
