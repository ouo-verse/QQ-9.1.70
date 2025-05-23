package qk2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fB\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lqk2/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqk2/n$a;", "ad", "Lqk2/n$a;", "a", "()Lqk2/n$a;", "<init>", "(Lqk2/n$a;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.n, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class TransferConfig {

    @SerializedName("transfer_ad")
    @Nullable
    private final TransferAd ad;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lqk2/n$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "text", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "level", "c", "url", "e", "beginTime", "a", "endTime", "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.n$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class TransferAd {

        @SerializedName("ad_begin_time")
        @NotNull
        private final String beginTime;

        @SerializedName("ad_end_time")
        @NotNull
        private final String endTime;

        @SerializedName("ad_level")
        @NotNull
        private final String level;

        @SerializedName("ad_text")
        @NotNull
        private final String text;

        @SerializedName("ad_url")
        @NotNull
        private final String url;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getBeginTime() {
            return this.beginTime;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getEndTime() {
            return this.endTime;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getLevel() {
            return this.level;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransferAd)) {
                return false;
            }
            TransferAd transferAd = (TransferAd) other;
            if (Intrinsics.areEqual(this.text, transferAd.text) && Intrinsics.areEqual(this.level, transferAd.level) && Intrinsics.areEqual(this.url, transferAd.url) && Intrinsics.areEqual(this.beginTime, transferAd.beginTime) && Intrinsics.areEqual(this.endTime, transferAd.endTime)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.text.hashCode() * 31) + this.level.hashCode()) * 31) + this.url.hashCode()) * 31) + this.beginTime.hashCode()) * 31) + this.endTime.hashCode();
        }

        @NotNull
        public String toString() {
            return "TransferAd(text=" + this.text + ", level=" + this.level + ", url=" + this.url + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ")";
        }
    }

    public TransferConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final TransferAd getAd() {
        return this.ad;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TransferConfig) && Intrinsics.areEqual(this.ad, ((TransferConfig) other).ad)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        TransferAd transferAd = this.ad;
        if (transferAd == null) {
            return 0;
        }
        return transferAd.hashCode();
    }

    @NotNull
    public String toString() {
        return "TransferConfig(ad=" + this.ad + ")";
    }

    public TransferConfig(@Nullable TransferAd transferAd) {
        this.ad = transferAd;
    }

    public /* synthetic */ TransferConfig(TransferAd transferAd, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : transferAd);
    }
}
