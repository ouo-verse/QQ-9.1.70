package yp0;

import android.text.Layout;
import android.text.StaticLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u001a\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001a\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0010"}, d2 = {"", "text", "Landroid/widget/TextView;", "textView", "", "c", "", "guildId", "channelId", "", "d", "name", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "b", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull String name) {
        int i3;
        Intrinsics.checkNotNullParameter(name, "name");
        if (FontSettingManager.isFontSizeLarge()) {
            i3 = 4;
        } else {
            i3 = 8;
        }
        if (name.length() > i3) {
            return ((IGuildNicknameApi) QRoute.api(IGuildNicknameApi.class)).removeIncompleteEmoji(name, i3 - 1) + "\u2026";
        }
        return name;
    }

    @NotNull
    public static final String b(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        String guildId = msgRecord.guildId;
        IGuildDirectMsgUtilApi iGuildDirectMsgUtilApi = (IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class);
        String str = msgRecord.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        long sourceGuildId = iGuildDirectMsgUtilApi.getSourceGuildId(str);
        if (sourceGuildId != 0) {
            guildId = String.valueOf(sourceGuildId);
        }
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        return guildId;
    }

    public static final int c(@NotNull CharSequence text, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textView, "textView");
        return new StaticLayout(text, textView.getPaint(), ViewUtils.getScreenWidth() - ViewUtils.dpToPx(75.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    public static final boolean d(@NotNull String guildId, @NotNull String channelId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
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
            iGProGuildInfo = iGPSService.getGuildInfo(guildId);
        }
        if (((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isQQGuildManager(iGProGuildInfo)) {
            return true;
        }
        Boolean hasTargetSecondaryPermission = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(30004, guildId, channelId);
        Intrinsics.checkNotNullExpressionValue(hasTargetSecondaryPermission, "api(IQQGuildUtilApi::cla\u2026,\n        channelId\n    )");
        return hasTargetSecondaryPermission.booleanValue();
    }
}
