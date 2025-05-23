package z05;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.adapter.internal.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lz05/e;", "Lz05/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "transactionId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "payTime", "getPayTime", "totalFee", "getTotalFee", "callbackUrl", "getCallbackUrl", "spData", "getSpData", "errorMsg", "a", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: z05.e, reason: from toString */
/* loaded from: classes28.dex */
public final /* data */ class RspDataV2 extends c {

    @SerializedName("callback_url")
    @Nullable
    private final String callbackUrl;

    @SerializedName("err_msg")
    @Nullable
    private final String errorMsg;

    @SerializedName("pay_time")
    @Nullable
    private final String payTime;

    @SerializedName("sp_data")
    @Nullable
    private final String spData;

    @SerializedName("total_fee")
    @Nullable
    private final String totalFee;

    @SerializedName(CommonCode.MapKey.TRANSACTION_ID)
    @Nullable
    private final String transactionId;

    public RspDataV2() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RspDataV2)) {
            return false;
        }
        RspDataV2 rspDataV2 = (RspDataV2) other;
        if (Intrinsics.areEqual(this.transactionId, rspDataV2.transactionId) && Intrinsics.areEqual(this.payTime, rspDataV2.payTime) && Intrinsics.areEqual(this.totalFee, rspDataV2.totalFee) && Intrinsics.areEqual(this.callbackUrl, rspDataV2.callbackUrl) && Intrinsics.areEqual(this.spData, rspDataV2.spData) && Intrinsics.areEqual(this.errorMsg, rspDataV2.errorMsg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        String str = this.transactionId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.payTime;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.totalFee;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.callbackUrl;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.spData;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.errorMsg;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "RspDataV2(transactionId=" + this.transactionId + ", payTime=" + this.payTime + ", totalFee=" + this.totalFee + ", callbackUrl=" + this.callbackUrl + ", spData=" + this.spData + ", errorMsg=" + this.errorMsg + ")";
    }

    public /* synthetic */ RspDataV2(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : str6);
    }

    public RspDataV2(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        super(null);
        this.transactionId = str;
        this.payTime = str2;
        this.totalFee = str3;
        this.callbackUrl = str4;
        this.spData = str5;
        this.errorMsg = str6;
    }
}
