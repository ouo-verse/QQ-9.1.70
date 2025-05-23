package z05;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.adapter.internal.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013Bg\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\u00a8\u0006#"}, d2 = {"Lz05/d;", "Lz05/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "transactionId", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "payTime", "e", "totalFee", "g", "callbackUrl", "a", "spData", "f", "iswechatpay", "c", "Lz05/d$a;", "paySdkAuthData", "Lz05/d$a;", "d", "()Lz05/d$a;", "setPaySdkAuthData", "(Lz05/d$a;)V", "errorMsg", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lz05/d$a;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: z05.d, reason: from toString */
/* loaded from: classes28.dex */
public final /* data */ class RspDataV1 extends c {

    @SerializedName("callback_url")
    @Nullable
    private final String callbackUrl;

    @SerializedName("err_msg")
    @Nullable
    private final String errorMsg;

    @SerializedName("iswechatpay")
    @Nullable
    private final String iswechatpay;

    @SerializedName("sdk_auth_data")
    @Nullable
    private AuthData paySdkAuthData;

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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lz05/d$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "openId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "authRetCode", "Ljava/lang/Integer;", "getAuthRetCode", "()Ljava/lang/Integer;", "authRetMsg", "getAuthRetMsg", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z05.d$a, reason: from toString */
    /* loaded from: classes28.dex */
    public static final /* data */ class AuthData {

        @SerializedName("ret")
        @Nullable
        private final Integer authRetCode;

        @SerializedName("errMsg")
        @Nullable
        private final String authRetMsg;

        @SerializedName("openId")
        @Nullable
        private final String openId;

        public AuthData() {
            this(null, null, null, 7, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getOpenId() {
            return this.openId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthData)) {
                return false;
            }
            AuthData authData = (AuthData) other;
            if (Intrinsics.areEqual(this.openId, authData.openId) && Intrinsics.areEqual(this.authRetCode, authData.authRetCode) && Intrinsics.areEqual(this.authRetMsg, authData.authRetMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.openId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            Integer num = this.authRetCode;
            if (num == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.authRetMsg;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "AuthData(openId=" + this.openId + ", authRetCode=" + this.authRetCode + ", authRetMsg=" + this.authRetMsg + ")";
        }

        public AuthData(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
            this.openId = str;
            this.authRetCode = num;
            this.authRetMsg = str2;
        }

        public /* synthetic */ AuthData(String str, Integer num, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : str2);
        }
    }

    public RspDataV1() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCallbackUrl() {
        return this.callbackUrl;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getIswechatpay() {
        return this.iswechatpay;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final AuthData getPaySdkAuthData() {
        return this.paySdkAuthData;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getPayTime() {
        return this.payTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RspDataV1)) {
            return false;
        }
        RspDataV1 rspDataV1 = (RspDataV1) other;
        if (Intrinsics.areEqual(this.transactionId, rspDataV1.transactionId) && Intrinsics.areEqual(this.payTime, rspDataV1.payTime) && Intrinsics.areEqual(this.totalFee, rspDataV1.totalFee) && Intrinsics.areEqual(this.callbackUrl, rspDataV1.callbackUrl) && Intrinsics.areEqual(this.spData, rspDataV1.spData) && Intrinsics.areEqual(this.iswechatpay, rspDataV1.iswechatpay) && Intrinsics.areEqual(this.paySdkAuthData, rspDataV1.paySdkAuthData) && Intrinsics.areEqual(this.errorMsg, rspDataV1.errorMsg)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getSpData() {
        return this.spData;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getTotalFee() {
        return this.totalFee;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
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
        String str6 = this.iswechatpay;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        AuthData authData = this.paySdkAuthData;
        if (authData == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = authData.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str7 = this.errorMsg;
        if (str7 != null) {
            i3 = str7.hashCode();
        }
        return i28 + i3;
    }

    @NotNull
    public String toString() {
        return "RspDataV1(transactionId=" + this.transactionId + ", payTime=" + this.payTime + ", totalFee=" + this.totalFee + ", callbackUrl=" + this.callbackUrl + ", spData=" + this.spData + ", iswechatpay=" + this.iswechatpay + ", paySdkAuthData=" + this.paySdkAuthData + ", errorMsg=" + this.errorMsg + ")";
    }

    public /* synthetic */ RspDataV1(String str, String str2, String str3, String str4, String str5, String str6, AuthData authData, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : str6, (i3 & 64) != 0 ? null : authData, (i3 & 128) == 0 ? str7 : null);
    }

    public RspDataV1(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable AuthData authData, @Nullable String str7) {
        super(null);
        this.transactionId = str;
        this.payTime = str2;
        this.totalFee = str3;
        this.callbackUrl = str4;
        this.spData = str5;
        this.iswechatpay = str6;
        this.paySdkAuthData = authData;
        this.errorMsg = str7;
    }
}
