package ur1;

import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\r\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lur1/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "avatarId", "b", "d", "userName", "c", "I", "e", "()I", MessageRoamJsPlugin.USERTYPE, "setGuildId", "(Ljava/lang/String;)V", "guildId", "Z", "()Z", "enable", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ur1.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildCreateMemberData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String userName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int userType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enable;

    public GuildCreateMemberData(@NotNull String avatarId, @NotNull String userName, int i3, @NotNull String guildId, boolean z16) {
        Intrinsics.checkNotNullParameter(avatarId, "avatarId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.avatarId = avatarId;
        this.userName = userName;
        this.userType = i3;
        this.guildId = guildId;
        this.enable = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarId() {
        return this.avatarId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: e, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCreateMemberData)) {
            return false;
        }
        GuildCreateMemberData guildCreateMemberData = (GuildCreateMemberData) other;
        if (Intrinsics.areEqual(this.avatarId, guildCreateMemberData.avatarId) && Intrinsics.areEqual(this.userName, guildCreateMemberData.userName) && this.userType == guildCreateMemberData.userType && Intrinsics.areEqual(this.guildId, guildCreateMemberData.guildId) && this.enable == guildCreateMemberData.enable) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.avatarId.hashCode() * 31) + this.userName.hashCode()) * 31) + this.userType) * 31) + this.guildId.hashCode()) * 31;
        boolean z16 = this.enable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "GuildCreateMemberData(avatarId=" + this.avatarId + ", userName=" + this.userName + ", userType=" + this.userType + ", guildId=" + this.guildId + ", enable=" + this.enable + ")";
    }

    public /* synthetic */ GuildCreateMemberData(String str, String str2, int i3, String str3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? true : z16);
    }
}
