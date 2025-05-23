package wz1;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\r\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lwz1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "tinyId", "b", "c", "userName", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "d", "I", "()I", "setUserType", "(I)V", MessageRoamJsPlugin.USERTYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wz1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildSettingMemberData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String userName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProUserInfo userInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int userType;

    public GuildSettingMemberData(@NotNull String tinyId, @NotNull String userName, @Nullable IGProUserInfo iGProUserInfo, int i3) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        this.tinyId = tinyId;
        this.userName = userName;
        this.userInfo = iGProUserInfo;
        this.userType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final IGProUserInfo getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: d, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildSettingMemberData)) {
            return false;
        }
        GuildSettingMemberData guildSettingMemberData = (GuildSettingMemberData) other;
        if (Intrinsics.areEqual(this.tinyId, guildSettingMemberData.tinyId) && Intrinsics.areEqual(this.userName, guildSettingMemberData.userName) && Intrinsics.areEqual(this.userInfo, guildSettingMemberData.userInfo) && this.userType == guildSettingMemberData.userType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.tinyId.hashCode() * 31) + this.userName.hashCode()) * 31;
        IGProUserInfo iGProUserInfo = this.userInfo;
        if (iGProUserInfo == null) {
            hashCode = 0;
        } else {
            hashCode = iGProUserInfo.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.userType;
    }

    @NotNull
    public String toString() {
        return "GuildSettingMemberData(tinyId=" + this.tinyId + ", userName=" + this.userName + ", userInfo=" + this.userInfo + ", userType=" + this.userType + ")";
    }

    public /* synthetic */ GuildSettingMemberData(String str, String str2, IGProUserInfo iGProUserInfo, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, iGProUserInfo, (i16 & 8) != 0 ? 1 : i3);
    }
}
