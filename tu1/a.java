package tu1;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.util.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uu1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Ltu1/a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "", "c", "a", "Landroid/app/Activity;", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f437478a = new a();

    a() {
    }

    private final String a(String guildId) {
        List<cy> channelCategoryList = ((IGPSService) ch.R0(IGPSService.class)).getChannelCategoryList(guildId);
        if (channelCategoryList != null) {
            Iterator<T> it = channelCategoryList.iterator();
            while (it.hasNext()) {
                List<IGProChannelInfo> channelList = ((cy) it.next()).getChannelList();
                Intrinsics.checkNotNullExpressionValue(channelList, "category.channelList");
                for (IGProChannelInfo iGProChannelInfo : channelList) {
                    if (iGProChannelInfo.getType() == 1) {
                        String channelUin = iGProChannelInfo.getChannelUin();
                        Intrinsics.checkNotNullExpressionValue(channelUin, "channel.channelUin");
                        return channelUin;
                    }
                }
            }
            return "";
        }
        return "";
    }

    @JvmStatic
    public static final void c(@NotNull QBaseActivity activity, @NotNull String guildId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        String a16 = f437478a.a(guildId);
        if (a16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.mission.MissionHelper", 2, "openFirstChatFragment but channelId is empty");
            }
            CreateSubChannelInfo createSubChannelInfo = new CreateSubChannelInfo(guildId, 0L, "main_setting");
            createSubChannelInfo.b(1);
            QQGuildSubChannelCreateDialogFragment.Eh(createSubChannelInfo).show(activity.getSupportFragmentManager(), "QQGuildSubChannelCreateDialogFragment");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("toggleSoftKeyBoard", true);
        GuildMainFrameUtils.r(activity, 1, new LaunchGuildChatPieParam().l(guildId).b(a16).k(bundle).r(false).g(3).a());
    }

    public final void b(@NotNull Activity activity, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (FastClickUtils.isFastDoubleClick("Guild.mission.MissionHelper inviteFriend")) {
            Logger.f235387a.d().w("Guild.mission.MissionHelper", 1, "inviteFriend hit isFastDoubleClick");
            return;
        }
        IGProGuildInfo j3 = e.j(guildId);
        if (j3 == null) {
            return;
        }
        m mVar = new m(activity, j3, null, GuildSharePageSource.GUILD_MISSION);
        c.c(mVar, 1);
        mVar.z();
    }
}
