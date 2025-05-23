package qk2;

import com.google.gson.annotations.SerializedName;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lqk2/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "content", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "title", "c", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "I", "b", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.k, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class PrivatePolicyConfig {

    @SerializedName("content")
    @Nullable
    private final String content;

    @SerializedName(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)
    private final int switch;

    @SerializedName("title")
    @Nullable
    private final String title;

    public PrivatePolicyConfig() {
        this(null, null, 0, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final int getSwitch() {
        return this.switch;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivatePolicyConfig)) {
            return false;
        }
        PrivatePolicyConfig privatePolicyConfig = (PrivatePolicyConfig) other;
        if (Intrinsics.areEqual(this.content, privatePolicyConfig.content) && Intrinsics.areEqual(this.title, privatePolicyConfig.title) && this.switch == privatePolicyConfig.switch) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        String str = this.content;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.title;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i16 + i3) * 31) + this.switch;
    }

    @NotNull
    public String toString() {
        return "PrivatePolicyConfig(content=" + this.content + ", title=" + this.title + ", switch=" + this.switch + ")";
    }

    public PrivatePolicyConfig(@Nullable String str, @Nullable String str2, int i3) {
        this.content = str;
        this.title = str2;
        this.switch = i3;
    }

    public /* synthetic */ PrivatePolicyConfig(String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? null : str2, (i16 & 4) != 0 ? 0 : i3);
    }
}
