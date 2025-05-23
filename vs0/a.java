package vs0;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a.\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003\u001a&\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u001a\u0018\u0010\u0015\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0016\u0010\u0016\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u001a\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003\u001a\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H\u0002\u001a2\u0010\u001d\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u00072\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u001a2\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u001a\n\u0010!\u001a\u00020 *\u00020\u0000\u001a\n\u0010\"\u001a\u00020\u0001*\u00020\u0000\u001a\u0016\u0010%\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007\u00a8\u0006&"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "", "f", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "channelId", "tinyId", "isRobot", "", "j", "msgItem", "i", "appId", "k", "Landroid/view/View;", "view", "show", "p", "e", "b", "c", "id", "", "", "elementParams", DomainData.DOMAIN_NAME, "eventId", "l", "", "a", h.F, "Lcom/tencent/aio/data/msglist/a;", "key", "d", "aio-guild-media_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {
    public static final long a(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getLong("extra_key_show_max_msg_seq", -1L);
    }

    @NotNull
    public static final String b(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String nickFromMsg = msgItem.getMsgRecord().sendMemberName;
        if (com.tencent.guild.aio.util.h.f112401a.a(msgItem) && !TextUtils.isEmpty(nickFromMsg)) {
            Intrinsics.checkNotNullExpressionValue(nickFromMsg, "nickFromMsg");
            return nickFromMsg;
        }
        String c16 = c(msgItem);
        if (TextUtils.isEmpty(c16)) {
            if (!TextUtils.isEmpty(nickFromMsg)) {
                Intrinsics.checkNotNullExpressionValue(nickFromMsg, "nickFromMsg");
                return nickFromMsg;
            }
            String str = msgItem.getMsgRecord().sendNickName;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.sendNickName");
            return str;
        }
        return c16;
    }

    private static final String c(GuildMsgItem guildMsgItem) {
        String guildId = guildMsgItem.getMsgRecord().guildId;
        IGuildDirectMsgUtilApi iGuildDirectMsgUtilApi = (IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class);
        String str = guildMsgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "it.msgRecord.peerUid");
        long sourceGuildId = iGuildDirectMsgUtilApi.getSourceGuildId(str);
        if (sourceGuildId != 0) {
            guildId = String.valueOf(sourceGuildId);
        }
        String str2 = guildMsgItem.getMsgRecord().senderUid.toString();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        return iq0.a.u(str2, guildId);
    }

    @NotNull
    public static final String d(@NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull String key) {
        GrayTipElement grayTipElement;
        LocalGrayTipElement localGrayTipElement;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(msgItem instanceof GuildMsgItem)) {
            return "";
        }
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        boolean z17 = true;
        if (guildMsgItem.getMsgRecord() != null && guildMsgItem.getMsgRecord().elements != null) {
            ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
            for (MsgElement msgElement : arrayList) {
                if (msgElement.elementType == 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        msgElement = null;
        if (msgElement == null || (grayTipElement = msgElement.grayTipElement) == null || (localGrayTipElement = grayTipElement.localGrayTipElement) == null) {
            return "";
        }
        String paramsJsonContent = localGrayTipElement.extraJson;
        Intrinsics.checkNotNullExpressionValue(paramsJsonContent, "paramsJsonContent");
        if (paramsJsonContent.length() <= 0) {
            z17 = false;
        }
        if (!z17) {
            return "";
        }
        try {
            String string = new JSONObject(paramsJsonContent).getString(key);
            Intrinsics.checkNotNullExpressionValue(string, "JSONObject(paramsJsonContent).getString(key)");
            return string;
        } catch (JSONException unused) {
            return "";
        }
    }

    public static final boolean e(@NotNull String guildId, @NotNull String channelId) {
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
        Boolean hasTargetSecondaryPermission = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(30003, guildId, channelId);
        Intrinsics.checkNotNullExpressionValue(hasTargetSecondaryPermission, "api(IQQGuildUtilApi::cla\u2026,\n        channelId\n    )");
        return hasTargetSecondaryPermission.booleanValue();
    }

    public static final boolean f(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        AIOParam aioParam = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam, "aioParam");
        String g16 = com.tencent.guild.aio.util.a.g(aioParam);
        AIOParam aioParam2 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(aioParam2, "aioParam");
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isGuildOrChannelManager(g16, com.tencent.guild.aio.util.a.b(aioParam2));
    }

    public static final boolean g(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.isLocalSend() && guildMsgItem.getMsgRecord().sendStatus != 2) {
            return false;
        }
        return true;
    }

    public static final boolean h(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getBoolean("extra_key_show_aio_msg", true);
    }

    public static final void i(@NotNull Activity activity, @NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String str = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
        String str2 = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
        String str3 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
        j(activity, str, str2, str3, com.tencent.guild.aio.util.h.f112401a.x(msgItem));
    }

    public static final void j(@NotNull Activity activity, @NotNull String guildId, @NotNull String channelId, @NotNull String tinyId, boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        com.tencent.guild.aio.util.h.f112401a.z(activity, guildId, channelId, tinyId, z16);
    }

    public static final void k(@NotNull Activity activity, @NotNull String appId, @NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildMediaThirdAppProfileCard(activity, appId, guildId, channelId);
    }

    public static final void l(@NotNull String eventId, @Nullable View view, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
    }

    public static /* synthetic */ void m(String str, View view, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        l(str, view, map);
    }

    public static final void n(@Nullable View view, @NotNull String id5, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(id5, "id");
        com.tencent.guild.aio.util.h.f112401a.C(view, id5, map);
    }

    public static /* synthetic */ void o(View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        n(view, str, map);
    }

    public static final void p(@Nullable View view, boolean z16) {
        int i3;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }
}
