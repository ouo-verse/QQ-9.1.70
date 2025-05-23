package r32;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u000fB9\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001c\u00a8\u0006 "}, d2 = {"Lr32/c;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "openid", "Ljava/lang/String;", "c", "()Ljava/lang/String;", CommonConstant.KEY_ACCESS_TOKEN, "a", "payToken", "getPayToken", "expireIn", "I", "getExpireIn", "()I", "", "expireTime", "J", "b", "()J", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: r32.c, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class QQConnectAuthInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    @SerializedName(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN)
    @NotNull
    private final String accessToken;

    @SerializedName("expire_in")
    private final int expireIn;

    @SerializedName(VasQQSettingMeImpl.EXPIRE_TIME)
    private final long expireTime;

    @SerializedName("openid")
    @NotNull
    private final String openid;

    @SerializedName("pay_token")
    @NotNull
    private final String payToken;

    public QQConnectAuthInfo() {
        this(null, null, null, 0, 0L, 31, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: b, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getOpenid() {
        return this.openid;
    }

    public final boolean d() {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (this.openid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.aegisLog.i("ICGameQQConnectAuthInfo", "openid empty, invalid auth info");
            return false;
        }
        if (this.accessToken.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            this.aegisLog.i("ICGameQQConnectAuthInfo", "accessToken empty, invalid auth info");
            return false;
        }
        long seconds = TimeUnit.DAYS.toSeconds(3L);
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = seconds + serverTime;
        long j16 = this.expireTime;
        if (j3 >= j16) {
            z18 = true;
        }
        if (z18) {
            this.aegisLog.i("ICGameQQConnectAuthInfo", "auth info expired, expireTime " + j16 + ", serverTime " + serverTime);
        } else {
            this.aegisLog.i("ICGameQQConnectAuthInfo", "congratulation, auth info valid!");
        }
        return !z18;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQConnectAuthInfo)) {
            return false;
        }
        QQConnectAuthInfo qQConnectAuthInfo = (QQConnectAuthInfo) other;
        if (Intrinsics.areEqual(this.openid, qQConnectAuthInfo.openid) && Intrinsics.areEqual(this.accessToken, qQConnectAuthInfo.accessToken) && Intrinsics.areEqual(this.payToken, qQConnectAuthInfo.payToken) && this.expireIn == qQConnectAuthInfo.expireIn && this.expireTime == qQConnectAuthInfo.expireTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.openid.hashCode() * 31) + this.accessToken.hashCode()) * 31) + this.payToken.hashCode()) * 31) + this.expireIn) * 31) + androidx.fragment.app.a.a(this.expireTime);
    }

    @NotNull
    public String toString() {
        return "QQConnectAuthInfo(openid=" + this.openid + ", accessToken=" + this.accessToken + ", payToken=" + this.payToken + ", expireIn=" + this.expireIn + ", expireTime=" + this.expireTime + ")";
    }

    public QQConnectAuthInfo(@NotNull String openid, @NotNull String accessToken, @NotNull String payToken, int i3, long j3) {
        Intrinsics.checkNotNullParameter(openid, "openid");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(payToken, "payToken");
        this.openid = openid;
        this.accessToken = accessToken;
        this.payToken = payToken;
        this.expireIn = i3;
        this.expireTime = j3;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
    }

    public /* synthetic */ QQConnectAuthInfo(String str, String str2, String str3, int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) == 0 ? str3 : "", (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? 0L : j3);
    }
}
