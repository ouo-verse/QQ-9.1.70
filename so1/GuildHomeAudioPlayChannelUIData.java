package so1;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import so1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020\u0006\u0012\u0006\u0010+\u001a\u00020\b\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u0017\u0010#\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R\u0017\u0010%\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b\u0019\u0010\"R\u0017\u0010'\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b\u0015\u0010\"R\u0017\u0010)\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b$\u0010\rR\u0017\u0010+\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b\u000f\u0010\"\u00a8\u0006."}, d2 = {"Lso1/f;", "Lso1/h;", "", "other", "", "e", "", "toString", "", "hashCode", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "f", "b", "channelId", "g", "d", "title", tl.h.F, "coverUrl", "", "Lso1/h$b;", "i", "Ljava/util/List;", "j", "()Ljava/util/List;", "micUserList", "getThemeName", "themeName", "k", "I", "()I", "noMemberMaxLimit", "l", "memberMax", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "memberCount", DomainData.DOMAIN_NAME, "sessionId", "o", "cardType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;IIILjava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: so1.f, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildHomeAudioPlayChannelUIData extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<h.MicUser> micUserList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String themeName;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final int noMemberMaxLimit;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final int memberMax;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final int memberCount;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cardType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeAudioPlayChannelUIData(@NotNull String guildId, @NotNull String channelId, @NotNull String title, @NotNull String coverUrl, @NotNull List<h.MicUser> micUserList, @NotNull String themeName, int i3, int i16, int i17, @NotNull String sessionId, int i18) {
        super(null, null, null, 7, null);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(micUserList, "micUserList");
        Intrinsics.checkNotNullParameter(themeName, "themeName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.title = title;
        this.coverUrl = coverUrl;
        this.micUserList = micUserList;
        this.themeName = themeName;
        this.noMemberMaxLimit = i3;
        this.memberMax = i16;
        this.memberCount = i17;
        this.sessionId = sessionId;
        this.cardType = i18;
    }

    @Override // so1.h
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getChannelId() {
        return this.channelId;
    }

    @Override // so1.h
    @NotNull
    /* renamed from: c, reason: from getter */
    public String getGuildId() {
        return this.guildId;
    }

    @Override // so1.h
    @NotNull
    /* renamed from: d, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    @Override // so1.h
    public boolean e(@NotNull Object other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof GuildHomeAudioPlayChannelUIData)) {
            return false;
        }
        GuildHomeAudioPlayChannelUIData guildHomeAudioPlayChannelUIData = (GuildHomeAudioPlayChannelUIData) other;
        if (!Intrinsics.areEqual(guildHomeAudioPlayChannelUIData.getGuildId(), getGuildId()) || !Intrinsics.areEqual(guildHomeAudioPlayChannelUIData.getChannelId(), getChannelId()) || !Intrinsics.areEqual(guildHomeAudioPlayChannelUIData.getTitle(), getTitle()) || !Intrinsics.areEqual(guildHomeAudioPlayChannelUIData.coverUrl, this.coverUrl) || guildHomeAudioPlayChannelUIData.noMemberMaxLimit != this.noMemberMaxLimit || guildHomeAudioPlayChannelUIData.memberMax != this.memberMax || guildHomeAudioPlayChannelUIData.memberCount != this.memberCount || !Intrinsics.areEqual(guildHomeAudioPlayChannelUIData.sessionId, this.sessionId) || guildHomeAudioPlayChannelUIData.cardType != this.cardType || !h.a(guildHomeAudioPlayChannelUIData.micUserList, this.micUserList)) {
            return false;
        }
        return true;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHomeAudioPlayChannelUIData)) {
            return false;
        }
        GuildHomeAudioPlayChannelUIData guildHomeAudioPlayChannelUIData = (GuildHomeAudioPlayChannelUIData) other;
        if (Intrinsics.areEqual(getGuildId(), guildHomeAudioPlayChannelUIData.getGuildId()) && Intrinsics.areEqual(getChannelId(), guildHomeAudioPlayChannelUIData.getChannelId()) && Intrinsics.areEqual(getTitle(), guildHomeAudioPlayChannelUIData.getTitle()) && Intrinsics.areEqual(this.coverUrl, guildHomeAudioPlayChannelUIData.coverUrl) && Intrinsics.areEqual(this.micUserList, guildHomeAudioPlayChannelUIData.micUserList) && Intrinsics.areEqual(this.themeName, guildHomeAudioPlayChannelUIData.themeName) && this.noMemberMaxLimit == guildHomeAudioPlayChannelUIData.noMemberMaxLimit && this.memberMax == guildHomeAudioPlayChannelUIData.memberMax && this.memberCount == guildHomeAudioPlayChannelUIData.memberCount && Intrinsics.areEqual(this.sessionId, guildHomeAudioPlayChannelUIData.sessionId) && this.cardType == guildHomeAudioPlayChannelUIData.cardType) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getCardType() {
        return this.cardType;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: h, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    public int hashCode() {
        return (((((((((((((((((((getGuildId().hashCode() * 31) + getChannelId().hashCode()) * 31) + getTitle().hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.micUserList.hashCode()) * 31) + this.themeName.hashCode()) * 31) + this.noMemberMaxLimit) * 31) + this.memberMax) * 31) + this.memberCount) * 31) + this.sessionId.hashCode()) * 31) + this.cardType;
    }

    /* renamed from: i, reason: from getter */
    public final int getMemberMax() {
        return this.memberMax;
    }

    @NotNull
    public final List<h.MicUser> j() {
        return this.micUserList;
    }

    /* renamed from: k, reason: from getter */
    public final int getNoMemberMaxLimit() {
        return this.noMemberMaxLimit;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public String toString() {
        return "GuildHomeAudioPlayChannelUIData(guildId=" + getGuildId() + ", channelId=" + getChannelId() + ", title=" + getTitle() + ", coverUrl=" + this.coverUrl + ", micUserList=" + this.micUserList + ", themeName=" + this.themeName + ", noMemberMaxLimit=" + this.noMemberMaxLimit + ", memberMax=" + this.memberMax + ", memberCount=" + this.memberCount + ", sessionId=" + this.sessionId + ", cardType=" + this.cardType + ")";
    }
}
