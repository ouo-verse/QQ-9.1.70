package sw1;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.richmedia.provider.h;
import com.tencent.qqnt.aio.adapter.richmedia.provider.i;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IRichMediaService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lsw1/g;", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "", "channelId", "guildId", "", "isSelfGuest", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface g extends h {
    boolean isSelfGuest(String channelId, String guildId);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public static final class a {
        public static boolean a(g gVar, int i3, int i16) {
            return h.a.a(gVar, i3, i16);
        }

        public static void c(g gVar, MsgRecord msgRecord, int i3, int i16, MsgElement msgElement, int i17, int i18, VideoCodecFormatType videoCodecFormat, i iVar) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(videoCodecFormat, "videoCodecFormat");
            h.a.c(gVar, msgRecord, i3, i16, msgElement, i17, i18, videoCodecFormat, iVar);
        }

        public static int e(g gVar, MsgRecord msgRecord, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            return h.a.e(gVar, msgRecord, i3, z16);
        }

        public static boolean f(g gVar, String channelId, String guildId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).hasDirectMsgFlag(channelId)) {
                return false;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IGPSService iGPSService = peekAppRuntime != null ? (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "") : null;
            if (iGPSService != null) {
                return iGPSService.isGuest(guildId);
            }
            return true;
        }

        public static boolean g(g gVar, ChatMessage msg2, MsgRecord msgRecord, QBaseActivity topActivity, AppRuntime app) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(topActivity, "topActivity");
            Intrinsics.checkNotNullParameter(app, "app");
            return h.a.f(gVar, msg2, msgRecord, topActivity, app);
        }

        public static void b(g gVar, MsgRecord msgRecord, long j3, int i3, int i16) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            ((IMsgService) QRoute.api(IMsgService.class)).cancelGetRichMediaElement(new RichMediaElementGetReq(msgRecord.msgId, msgRecord.peerUid, msgRecord.chatType, j3, i3, i16, "", 0L, 0, 0));
        }

        public static void d(g gVar, MsgRecord msgRecord, MsgElement element, int i3, int i16) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(element, "element");
            String str = msgRecord.channelId;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.channelId");
            String str2 = msgRecord.guildId;
            Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.guildId");
            if (gVar.isSelfGuest(str, str2)) {
                ((IRichMediaService) QRoute.api(IRichMediaService.class)).downloadRichMediaInVisit(new RichDownLoadReq(1, 0, msgRecord.msgId, msgRecord.msgRandom, msgRecord.msgSeq, msgRecord.msgTime, msgRecord.chatType, msgRecord.senderUid, msgRecord.peerUid, msgRecord.guildId, element, null));
            } else {
                ((IMsgService) QRoute.api(IMsgService.class)).getRichMediaElement(new RichMediaElementGetReq(msgRecord.msgId, msgRecord.peerUid, msgRecord.chatType, element.elementId, i3, i16, "", 0L, 0, 0));
            }
        }
    }
}
