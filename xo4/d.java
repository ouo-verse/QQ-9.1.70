package xo4;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u001b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lxo4/d;", "Lxo4/b;", "", "I", "", "J", "", "troopUin", "H", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "Landroid/content/Context;", "ctx", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class d extends b {
    public d(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
    }

    @Override // xo4.b
    public boolean H(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return Intrinsics.areEqual(troopUin, f("group_code"));
    }

    @Override // xo4.b
    public void I() {
        if (this.f307437b != null) {
            String guildId = f("guild_id");
            String channelId = f("channel_id");
            String troopUin = f("group_code");
            QLog.i("TroopGuildFeedPublishAction", 1, "TroopGuildFeedPublishAction guildId: " + guildId + " channelId: " + channelId + " troopUin: " + troopUin);
            if (!TextUtils.isEmpty(guildId) && !TextUtils.isEmpty(channelId) && !TextUtils.isEmpty(troopUin)) {
                IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
                Context context = this.f307437b;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                iGuildFeedLauncherApi.launchGuildFeedPublish(context, guildId, channelId, troopUin);
                if (f.INSTANCE.a(this)) {
                    ITroopGuildAIOApi iTroopGuildAIOApi = (ITroopGuildAIOApi) QRoute.api(ITroopGuildAIOApi.class);
                    Context context2 = this.f307437b;
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    iTroopGuildAIOApi.jumpToTroopFeedList(context2, troopUin);
                }
            }
        }
    }

    public final boolean J() {
        String guildId = f("guild_id");
        String troopUin = f("group_code");
        if (TextUtils.isEmpty(guildId) || TextUtils.isEmpty(troopUin)) {
            return false;
        }
        IRuntimeService runtimeService = this.f307436a.getRuntimeService(ITroopGuildPermissionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        ITroopGuildPermissionService iTroopGuildPermissionService = (ITroopGuildPermissionService) runtimeService;
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        int troopFeedTalkPermission = iTroopGuildPermissionService.getTroopFeedTalkPermission(guildId, false);
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        if (iTroopGuildPermissionService.isMute(troopUin)) {
            return false;
        }
        if (1 != troopFeedTalkPermission && (2 != troopFeedTalkPermission || !iTroopGuildPermissionService.isAdmin(troopUin))) {
            return false;
        }
        return true;
    }
}
