package xg1;

import android.os.Bundle;
import com.tencent.ark.ark;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.contentshare.AnchorInfo;
import com.tencent.mobileqq.guild.contentshare.ChannelInfo;
import com.tencent.mobileqq.guild.contentshare.d;
import com.tencent.mobileqq.guild.feed.picshare.restorer.FeedDetailJsonParser;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002JF\u0010\u001f\u001a\u00020\u001d2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010#\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060!j\u0002`\"\u00a8\u0006&"}, d2 = {"Lxg1/b;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", "k", "", ark.ARKMETADATA_JSON, "f", "parser", "shareUrl", "Lcom/tencent/mobileqq/guild/contentshare/d;", "g", "Lcom/tencent/mobileqq/guild/contentshare/b;", "c", "Lcom/tencent/mobileqq/guild/contentshare/c;", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", h.F, "data", "b", "d", "", "scene", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shareInfo", "", "callback", "i", "(Landroid/os/Bundle;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "l", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f447962a = new b();

    b() {
    }

    private final AnchorInfo b(GuildMsgItem data) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        String guildUserDisplayName = ((IGPSService) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(IGPSService.class)).getGuildUserDisplayName(data.getMsgRecord().guildId, data.getMsgRecord().senderUid);
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "app.getRuntimeService(IG\u2026data.msgRecord.senderUid)");
        String str = data.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.senderUid");
        return new AnchorInfo(str, guildUserDisplayName);
    }

    private final AnchorInfo c(IFeedDetailDataParser parser) {
        return new AnchorInfo(parser.getAnchorUid(), parser.getAnchorNick());
    }

    private final ChannelInfo d(GuildMsgItem data) {
        String str = data.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.guildId");
        String str2 = data.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "data.msgRecord.channelId");
        return new ChannelInfo(str, str2, null, 4, null);
    }

    private final ChannelInfo e(IFeedDetailDataParser parser, String shareUrl) {
        return new ChannelInfo(parser.getGuildId(), parser.getChannelId(), shareUrl);
    }

    private final IFeedDetailDataParser f(String json) {
        FeedDetailJsonParser feedDetailJsonParser = new FeedDetailJsonParser();
        feedDetailJsonParser.parser(json);
        return feedDetailJsonParser;
    }

    private final d g(IFeedDetailDataParser parser, String shareUrl) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(parser));
        return new d(parser.getFeedId(), parser, arrayList, e(parser, shareUrl), ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxWidth(), ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxHeight());
    }

    private final d h(GuildMsgItem msg2, String shareUrl) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b(msg2));
        ChannelInfo d16 = d(msg2);
        d16.c(shareUrl);
        return new d(String.valueOf(msg2.getMsgRecord().msgSeq), msg2, arrayList, d16, ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxWidth(), ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 callback, String shareUrl, Integer num, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(shareUrl, "$shareUrl");
        if (arrayList.size() > 0) {
            b bVar = f447962a;
            Object obj = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "msgRecords[0]");
            callback.invoke(bVar.h(new GuildMsgItem((MsgRecord) obj), shareUrl));
            return;
        }
        QLog.e("ContentShareUtils", 1, "[createShareInfo] fail. scene: " + num + ", msgRecord not found! result: " + i3 + ", errMsg: " + str);
        callback.invoke(null);
    }

    private final IFeedDetailDataParser k(Bundle bundle) {
        Object remove = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getDataStore().remove(Integer.valueOf(bundle.getInt("guild_content_share_data_store_key", 0)));
        if (remove instanceof IFeedDetailDataParser) {
            return (IFeedDetailDataParser) remove;
        }
        String string = bundle.getString("guild_content_share_data_key");
        if (string == null) {
            string = "";
        }
        return f(string);
    }

    public final void i(@Nullable Bundle bundle, @Nullable final Integer scene, @NotNull final Function1<? super d, Unit> callback) {
        ArrayList<Long> arrayListOf;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (bundle != null) {
            final String str = "";
            if (scene != null && scene.intValue() == 0) {
                long j3 = bundle.getLong("guild_content_share_msg_id_key", -1L);
                Serializable serializable = bundle.getSerializable("guild_content_share_contact_key");
                if (j3 == -1 || !(serializable instanceof Contact)) {
                    QLog.e("ContentShareUtils", 1, "[createShareInfo] fail. scene: " + scene + ", invalid arguments!");
                    callback.invoke(null);
                }
                String string = bundle.getString("guild_content_share_url_key");
                if (string != null) {
                    str = string;
                }
                Intrinsics.checkNotNullExpressionValue(str, "it.getString(GuildConten\u2026TENT_SHARE_URL_KEY) ?: \"\"");
                IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
                Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.qqnt.kernelpublic.nativeinterface.Contact");
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(j3));
                iMsgService.getMsgsByMsgId((Contact) serializable, arrayListOf, new IMsgOperateCallback() { // from class: xg1.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i3, String str2, ArrayList arrayList) {
                        b.j(Function1.this, str, scene, i3, str2, arrayList);
                    }
                });
                return;
            }
            if (scene != null && scene.intValue() == 1) {
                String string2 = bundle.getString("guild_content_share_url_key");
                if (string2 != null) {
                    str = string2;
                }
                Intrinsics.checkNotNullExpressionValue(str, "it.getString(GuildConten\u2026TENT_SHARE_URL_KEY) ?: \"\"");
                b bVar = f447962a;
                callback.invoke(bVar.g(bVar.k(bundle), str));
                return;
            }
            QLog.e("ContentShareUtils", 1, "[createShareInfo] fail. scene: " + scene + ". Invalid scene!");
            callback.invoke(null);
        }
    }

    @NotNull
    public final String l(@NotNull Exception e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(e16.getMessage());
        StackTraceElement[] stackTrace = e16.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append("\n");
            sb5.append(stackTraceElement.toString());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }
}
