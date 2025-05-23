package sn0;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.article.launcher.GuildBaseFragment;
import com.tencent.guild.aio.chosen.fragment.GuildChosenWrapperFragment;
import com.tencent.guild.api.activity.IAIOSingleActivityApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0010\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000f\u001a\u00020\u0006\u00a8\u0006\u0014"}, d2 = {"Lsn0/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", IProfileCardConst.KEY_FROM_TYPE, "", "a", "Landroid/content/Intent;", "intent", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/article/launcher/GuildBaseFragment;", "cls", "requestCode", "", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f433994a = new b();

    b() {
    }

    public final void a(@NotNull Activity activity, @NotNull Contact contact, int fromType) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(contact, "contact");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(contact.peerUid);
        }
        if (iGProChannelInfo == null) {
            return;
        }
        if (iGProChannelInfo.getType() != 1) {
            QLog.e("GuildChosenMsgLauncher", 1, "type != CHANNEL_TYPE_TEXT! channelId = " + contact.peerUid);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("LAUNCHER_FROM_KEY", fromType);
        intent.putExtra("guild_chosen_guild_id", contact.guildId);
        intent.putExtra("guild_chosen_channel_id", contact.peerUid);
        b(activity, intent, GuildChosenWrapperFragment.class, 0);
    }

    public final boolean b(@NotNull Activity activity, @NotNull Intent intent, @NotNull Class<? extends GuildBaseFragment> cls, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(cls, "cls");
        intent.setClass(activity, ((IAIOSingleActivityApi) QRoute.api(IAIOSingleActivityApi.class)).getAIOSingleActivityClass());
        intent.putExtra("public_fragment_class", cls.getName());
        activity.startActivityForResult(intent, requestCode);
        return true;
    }
}
