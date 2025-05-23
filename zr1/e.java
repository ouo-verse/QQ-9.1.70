package zr1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeJoinInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lzr1/e;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lzr1/e$a;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "sourceInfo", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "a", "", "PARAM_FACADE_ARGS_DATA", "Ljava/lang/String;", "PARAM_FACADE_IS_DIALOG", "PARAM_FIRST_SHOW_TEXT", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zr1.e$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
        @JvmStatic
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final FacadeArgsData a(@NotNull JumpGuildParam jumpGuildParam, @Nullable GuildAppReportSourceInfo sourceInfo) {
            Serializable serializable;
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
            Bundle bundle = jumpGuildParam.extras;
            GuildFacadeType guildFacadeType = null;
            if (bundle != null) {
                serializable = bundle.getSerializable("guild_facade_type");
            } else {
                serializable = null;
            }
            if (serializable instanceof GuildFacadeType) {
                guildFacadeType = (GuildFacadeType) serializable;
            }
            if (!((IGPSService) ch.R0(IGPSService.class)).isGuest(jumpGuildParam.guildId)) {
                if (guildFacadeType != null && guildFacadeType.isPreviewStyle()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z16 = false;
                    FacadeArgsData facadeArgsData = new FacadeArgsData();
                    facadeArgsData.f227656e = jumpGuildParam.guildId;
                    facadeArgsData.f227657f = jumpGuildParam.getCategoryId();
                    facadeArgsData.f227658h = jumpGuildParam.getChannelId();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("GuildAppReportSourceInfo", sourceInfo);
                    bundle2.putAll(jumpGuildParam.extras);
                    facadeArgsData.C = bundle2;
                    if (!z16) {
                        facadeArgsData.f227655d = 0;
                    } else {
                        facadeArgsData.f227655d = 1;
                    }
                    FacadeJoinInfo facadeJoinInfo = new FacadeJoinInfo();
                    facadeArgsData.f227659i = facadeJoinInfo;
                    facadeJoinInfo.b(jumpGuildParam.getJoinInfoParam());
                    facadeArgsData.c(jumpGuildParam.getDetailPageJumpInfo());
                    Logger.f235387a.d().d("Guild.MFS.StandaloneFacadeContainerFragment", 1, "parseJoinGuildParam joinGuildParam: " + jumpGuildParam);
                    return facadeArgsData;
                }
            }
            z16 = true;
            FacadeArgsData facadeArgsData2 = new FacadeArgsData();
            facadeArgsData2.f227656e = jumpGuildParam.guildId;
            facadeArgsData2.f227657f = jumpGuildParam.getCategoryId();
            facadeArgsData2.f227658h = jumpGuildParam.getChannelId();
            Bundle bundle22 = new Bundle();
            bundle22.putSerializable("GuildAppReportSourceInfo", sourceInfo);
            bundle22.putAll(jumpGuildParam.extras);
            facadeArgsData2.C = bundle22;
            if (!z16) {
            }
            FacadeJoinInfo facadeJoinInfo2 = new FacadeJoinInfo();
            facadeArgsData2.f227659i = facadeJoinInfo2;
            facadeJoinInfo2.b(jumpGuildParam.getJoinInfoParam());
            facadeArgsData2.c(jumpGuildParam.getDetailPageJumpInfo());
            Logger.f235387a.d().d("Guild.MFS.StandaloneFacadeContainerFragment", 1, "parseJoinGuildParam joinGuildParam: " + jumpGuildParam);
            return facadeArgsData2;
        }

        Companion() {
        }
    }
}
