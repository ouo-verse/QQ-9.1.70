package qr1;

import android.content.Context;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\b\u0010+\u001a\u0004\u0018\u00010(\u0012\b\u0010/\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0011\u0010!\"\u0004\b\"\u0010#R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u0017\u0010'\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b&\u0010!R\u0019\u0010+\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b&\u0010)\u001a\u0004\b\u001f\u0010*R\u0019\u0010/\u001a\u0004\u0018\u00010,8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b\n\u0010.\u00a8\u00062"}, d2 = {"Lqr1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "c", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setJumpGuildId", "(Ljava/lang/String;)V", "jumpGuildId", "f", "setJumpChannelId", "jumpChannelId", "d", "i", "setSourceChannelId", "sourceChannelId", "e", "Z", "()Z", "setCheckSourceChannelIsValid", "(Z)V", "checkSourceChannelIsValid", "factoryName", h.F, "openFeedSquare", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "()Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "appReportSourceInfo", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qr1.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class HashTagJumpParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jumpGuildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jumpChannelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String sourceChannelId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean checkSourceChannelIsValid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String factoryName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean openFeedSquare;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final JumpGuildParam.JoinInfoParam joinInfoParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GuildAppReportSourceInfo appReportSourceInfo;

    public HashTagJumpParams(@NotNull Context context, @NotNull String jumpGuildId, @NotNull String jumpChannelId, @NotNull String sourceChannelId, boolean z16, @NotNull String factoryName, boolean z17, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildId, "jumpGuildId");
        Intrinsics.checkNotNullParameter(jumpChannelId, "jumpChannelId");
        Intrinsics.checkNotNullParameter(sourceChannelId, "sourceChannelId");
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        this.context = context;
        this.jumpGuildId = jumpGuildId;
        this.jumpChannelId = jumpChannelId;
        this.sourceChannelId = sourceChannelId;
        this.checkSourceChannelIsValid = z16;
        this.factoryName = factoryName;
        this.openFeedSquare = z17;
        this.joinInfoParam = joinInfoParam;
        this.appReportSourceInfo = guildAppReportSourceInfo;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final GuildAppReportSourceInfo getAppReportSourceInfo() {
        return this.appReportSourceInfo;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCheckSourceChannelIsValid() {
        return this.checkSourceChannelIsValid;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFactoryName() {
        return this.factoryName;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final JumpGuildParam.JoinInfoParam getJoinInfoParam() {
        return this.joinInfoParam;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashTagJumpParams)) {
            return false;
        }
        HashTagJumpParams hashTagJumpParams = (HashTagJumpParams) other;
        if (Intrinsics.areEqual(this.context, hashTagJumpParams.context) && Intrinsics.areEqual(this.jumpGuildId, hashTagJumpParams.jumpGuildId) && Intrinsics.areEqual(this.jumpChannelId, hashTagJumpParams.jumpChannelId) && Intrinsics.areEqual(this.sourceChannelId, hashTagJumpParams.sourceChannelId) && this.checkSourceChannelIsValid == hashTagJumpParams.checkSourceChannelIsValid && Intrinsics.areEqual(this.factoryName, hashTagJumpParams.factoryName) && this.openFeedSquare == hashTagJumpParams.openFeedSquare && Intrinsics.areEqual(this.joinInfoParam, hashTagJumpParams.joinInfoParam) && Intrinsics.areEqual(this.appReportSourceInfo, hashTagJumpParams.appReportSourceInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getJumpChannelId() {
        return this.jumpChannelId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getJumpGuildId() {
        return this.jumpGuildId;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getOpenFeedSquare() {
        return this.openFeedSquare;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.context.hashCode() * 31) + this.jumpGuildId.hashCode()) * 31) + this.jumpChannelId.hashCode()) * 31) + this.sourceChannelId.hashCode()) * 31;
        boolean z16 = this.checkSourceChannelIsValid;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode3 = (((hashCode2 + i16) * 31) + this.factoryName.hashCode()) * 31;
        boolean z17 = this.openFeedSquare;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i17 = (hashCode3 + i3) * 31;
        JumpGuildParam.JoinInfoParam joinInfoParam = this.joinInfoParam;
        int i18 = 0;
        if (joinInfoParam == null) {
            hashCode = 0;
        } else {
            hashCode = joinInfoParam.hashCode();
        }
        int i19 = (i17 + hashCode) * 31;
        GuildAppReportSourceInfo guildAppReportSourceInfo = this.appReportSourceInfo;
        if (guildAppReportSourceInfo != null) {
            i18 = guildAppReportSourceInfo.hashCode();
        }
        return i19 + i18;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getSourceChannelId() {
        return this.sourceChannelId;
    }

    @NotNull
    public String toString() {
        return "HashTagJumpParams(context=" + this.context + ", jumpGuildId=" + this.jumpGuildId + ", jumpChannelId=" + this.jumpChannelId + ", sourceChannelId=" + this.sourceChannelId + ", checkSourceChannelIsValid=" + this.checkSourceChannelIsValid + ", factoryName=" + this.factoryName + ", openFeedSquare=" + this.openFeedSquare + ", joinInfoParam=" + this.joinInfoParam + ", appReportSourceInfo=" + this.appReportSourceInfo + ')';
    }
}
