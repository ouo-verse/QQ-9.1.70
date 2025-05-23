package sk2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lsk2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "hbOpenUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Lsk2/a;", "hbDetail", "Lsk2/a;", "b", "()Lsk2/a;", "hbHideSelect", "Z", "c", "()Z", "grabVoiceHbNow", "a", "<init>", "(Ljava/lang/String;Lsk2/a;ZZ)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sk2.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QWalletHbCommonConfig {

    @SerializedName("hb_c2c_grab_voice_hb_now")
    private final boolean grabVoiceHbNow;

    @SerializedName("hb_detail")
    @Nullable
    private final HbDetailCommon hbDetail;

    @SerializedName("hb_hide_select")
    private final boolean hbHideSelect;

    @SerializedName("hb_open_url")
    @Nullable
    private final String hbOpenUrl;

    public QWalletHbCommonConfig() {
        this(null, null, false, false, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getGrabVoiceHbNow() {
        return this.grabVoiceHbNow;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final HbDetailCommon getHbDetail() {
        return this.hbDetail;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHbHideSelect() {
        return this.hbHideSelect;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getHbOpenUrl() {
        return this.hbOpenUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QWalletHbCommonConfig)) {
            return false;
        }
        QWalletHbCommonConfig qWalletHbCommonConfig = (QWalletHbCommonConfig) other;
        if (Intrinsics.areEqual(this.hbOpenUrl, qWalletHbCommonConfig.hbOpenUrl) && Intrinsics.areEqual(this.hbDetail, qWalletHbCommonConfig.hbDetail) && this.hbHideSelect == qWalletHbCommonConfig.hbHideSelect && this.grabVoiceHbNow == qWalletHbCommonConfig.grabVoiceHbNow) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        String str = this.hbOpenUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        HbDetailCommon hbDetailCommon = this.hbDetail;
        if (hbDetailCommon != null) {
            i3 = hbDetailCommon.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.hbHideSelect;
        int i18 = 1;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (i17 + i19) * 31;
        boolean z17 = this.grabVoiceHbNow;
        if (!z17) {
            i18 = z17 ? 1 : 0;
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "QWalletHbCommonConfig(hbOpenUrl=" + this.hbOpenUrl + ", hbDetail=" + this.hbDetail + ", hbHideSelect=" + this.hbHideSelect + ", grabVoiceHbNow=" + this.grabVoiceHbNow + ')';
    }

    public QWalletHbCommonConfig(@Nullable String str, @Nullable HbDetailCommon hbDetailCommon, boolean z16, boolean z17) {
        this.hbOpenUrl = str;
        this.hbDetail = hbDetailCommon;
        this.hbHideSelect = z16;
        this.grabVoiceHbNow = z17;
    }

    public /* synthetic */ QWalletHbCommonConfig(String str, HbDetailCommon hbDetailCommon, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : hbDetailCommon, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17);
    }
}
