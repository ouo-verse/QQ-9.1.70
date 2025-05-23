package sw1;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.richmedia.provider.i;
import com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RMReqExParams;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoPlayUrlInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoPlayUrlResult;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IRichMediaService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import mqq.app.AppRuntime;
import sw1.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ,\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\bH\u0016\u00a8\u0006\u0019"}, d2 = {"Lsw1/f;", "Lsw1/g;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "subId", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "c", "type", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "cb", "", "g", "a", "l", "curType", "Landroid/content/Intent;", h.F, "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements g {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MsgRecord msgRecord, MsgElement msgElement, f this$0, i iVar, int i3, String str, VideoPlayUrlResult videoPlayUrlResult) {
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        if (videoPlayUrlResult != null) {
            ArrayList<VideoPlayUrlInfo> arrayList2 = videoPlayUrlResult.v4IpUrl;
            if (arrayList2 != null) {
                Iterator<VideoPlayUrlInfo> it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().url);
                }
            }
            ArrayList<VideoPlayUrlInfo> arrayList3 = videoPlayUrlResult.domainUrl;
            if (arrayList3 != null) {
                Iterator<VideoPlayUrlInfo> it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    arrayList.add(it5.next().url);
                }
            }
            ArrayList<VideoPlayUrlInfo> arrayList4 = videoPlayUrlResult.v6IpUrl;
            if (arrayList4 != null) {
                Iterator<VideoPlayUrlInfo> it6 = arrayList4.iterator();
                while (it6.hasNext()) {
                    arrayList.add(it6.next().url);
                }
            }
        }
        if (arrayList.isEmpty()) {
            QLog.i("AIOVideoProvider", 1, "getVideoUrl FAIL. result: " + i3 + ", errMsg: " + str + ", msgSeq: " + msgRecord.msgSeq + ", msgId: " + msgRecord.msgId + ", elemId: " + msgElement.elementId + ". download media.");
            this$0.k(msgRecord, msgElement, 1, 0);
            return;
        }
        QLog.i("AIOVideoProvider", 1, "getVideoUrl. msgSeq: " + msgRecord.msgSeq + ", msgId: " + msgRecord.msgId + ", elemId: " + msgElement.elementId + ". url list size: " + arrayList.size());
        if (iVar != null) {
            QRouteApi api = QRoute.api(IGuildVideoApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildVideoApi::class.java)");
            String e16 = IGuildVideoApi.a.e((IGuildVideoApi) api, msgRecord, false, 2, null);
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            iVar.b(e16, (String[]) array, "");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void a(MsgRecord msgRecord, int subId, int type, MsgElement msgElement) {
        MsgElement msgElement2;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null) {
            msgElement2 = k.f415564a.f(msgRecord);
            if (msgElement2 == null) {
                return;
            }
        } else {
            msgElement2 = msgElement;
        }
        QLog.i("AIOVideoProvider", 1, "cancel, msgSeq: " + msgRecord.msgSeq + ", msgId: " + msgRecord.msgId + ", elemId: " + (msgElement != null ? Long.valueOf(msgElement.elementId) : null));
        if (type == 0) {
            j(msgRecord, msgElement2.elementId, 2, 0);
        } else {
            if (type != 3) {
                return;
            }
            j(msgRecord, msgElement2.elementId, 1, 0);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void b(MsgRecord msgRecord, int i3, int i16, MsgElement msgElement, int i17, int i18, VideoCodecFormatType videoCodecFormatType, i iVar) {
        g.a.c(this, msgRecord, i3, i16, msgElement, i17, i18, videoCodecFormatType, iVar);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public List<AIORichMediaData> c(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement, int subId) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList arrayList = new ArrayList();
        if (msgElement == null && (msgElement = k.f415564a.f(msgRecord)) == null) {
            return arrayList;
        }
        VideoElement videoElement = msgElement.videoElement;
        AIOShortVideoData aIOShortVideoData = new AIOShortVideoData();
        rw1.e.f432610a.a(msgRecord, aIOShortVideoData);
        aIOShortVideoData.R = msgRecord.senderUid;
        aIOShortVideoData.T = msgRecord.peerUid;
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2) {
            aIOShortVideoData.U = 1;
        }
        aIOShortVideoData.f179631h = videoElement.fileSize;
        QRouteApi api = QRoute.api(IGuildVideoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildVideoApi::class.java)");
        aIOShortVideoData.G = IGuildVideoApi.a.e((IGuildVideoApi) api, msgRecord, false, 2, null);
        aIOShortVideoData.H = videoElement.fileTime;
        aIOShortVideoData.I = videoElement.busiType;
        aIOShortVideoData.L = videoElement.thumbWidth;
        aIOShortVideoData.M = videoElement.thumbHeight;
        Integer num = videoElement.invalidState;
        Intrinsics.checkNotNullExpressionValue(num, "videoElement.invalidState");
        aIOShortVideoData.V = num.intValue();
        aIOShortVideoData.f179629e = subId;
        QRouteApi api2 = QRoute.api(IGuildVideoApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IGuildVideoApi::class.java)");
        aIOShortVideoData.F = IGuildVideoApi.a.c((IGuildVideoApi) api2, msgRecord, false, 2, null);
        arrayList.add(aIOShortVideoData);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean d(ChatMessage chatMessage, MsgRecord msgRecord, QBaseActivity qBaseActivity, AppRuntime appRuntime) {
        return g.a.g(this, chatMessage, msgRecord, qBaseActivity, appRuntime);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean e(int i3, int i16) {
        return g.a.a(this, i3, i16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public int f(MsgRecord msgRecord, int i3, boolean z16) {
        return g.a.e(this, msgRecord, i3, z16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void g(MsgRecord msgRecord, int subId, int type, MsgElement msgElement, i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = k.f415564a.f(msgRecord)) == null) {
            return;
        }
        if (type == 0) {
            k(msgRecord, msgElement, 2, 0);
        } else {
            if (type != 3) {
                return;
            }
            l(msgRecord, msgElement, cb5);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public Intent h(MsgRecord msgRecord, int subId, MsgElement msgElement, int curType) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = k.f415564a.f(msgRecord)) == null) {
            return null;
        }
        VideoElement videoElement = msgElement.videoElement;
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 21);
        QRouteApi api = QRoute.api(IGuildVideoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildVideoApi::class.java)");
        String c16 = IGuildVideoApi.a.c((IGuildVideoApi) api, msgRecord, false, 2, null);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, c16);
        bundle.putString(ShortVideoConstants.THUMBFILE_SEND_PATH, c16);
        bundle.putString(ShortVideoConstants.FROM_UIN, msgRecord.peerUid);
        bundle.putInt(ShortVideoConstants.FROM_BUSI_TYPE, videoElement.busiType);
        bundle.putInt(ShortVideoConstants.FILE_SEND_SIZE, (int) videoElement.fileSize);
        bundle.putInt(ShortVideoConstants.FILE_SEND_DURATION, videoElement.fileTime);
        bundle.putString("file_name", videoElement.fileName);
        bundle.putInt(ShortVideoConstants.FILE_FORMAT, videoElement.fileFormat);
        bundle.putBoolean(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
        QRouteApi api2 = QRoute.api(IGuildVideoApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IGuildVideoApi::class.java)");
        String e16 = IGuildVideoApi.a.e((IGuildVideoApi) api2, msgRecord, false, 2, null);
        bundle.putString("file_send_path", e16);
        bundle.putString(ShortVideoConstants.FILE_SHORTVIDEO_MD5, videoElement.videoMd5);
        bundle.putInt(ShortVideoConstants.THUMBFILE_SEND_WIDTH, videoElement.thumbWidth);
        bundle.putInt(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, videoElement.thumbHeight);
        bundle.putString(ShortVideoConstants.THUMBFILE_MD5, videoElement.thumbMd5);
        bundle.putInt(ShortVideoConstants.FILE_THUMB_SIZE, videoElement.thumbSize);
        if (FileUtils.fileExistsAndNotEmpty(e16)) {
            bundle.putBoolean("k_dataline", true);
            bundle.putString(AppConstants.Key.FORWARD_EXTRA, e16);
            bundle.putBoolean("direct_send_if_dataline_forward", true);
        }
        Intent putExtras = new Intent().putExtras(bundle);
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent().putExtras(bundle)");
        putExtras.putExtra(ShortVideoConstants.FROM_UIN_TYPE, curType);
        putExtras.putExtra("extra.MSG_ID", msgRecord.msgId);
        putExtras.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHAT_TYPE, msgRecord.chatType);
        putExtras.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_ID, msgRecord.guildId);
        putExtras.putExtra(IGuildForwardUtilsApi.EXTRA_GUILD_CHANNEL_ID, msgRecord.channelId);
        return putExtras;
    }

    @Override // sw1.g
    public boolean isSelfGuest(String str, String str2) {
        return g.a.f(this, str, str2);
    }

    public void j(MsgRecord msgRecord, long j3, int i3, int i16) {
        g.a.b(this, msgRecord, j3, i3, i16);
    }

    public void k(MsgRecord msgRecord, MsgElement msgElement, int i3, int i16) {
        g.a.d(this, msgRecord, msgElement, i3, i16);
    }

    public final void l(final MsgRecord msgRecord, final MsgElement msgElement, final i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        QLog.i("AIOVideoProvider", 1, "getVideoUrl, msgSeq: " + msgRecord.msgSeq + ", msgId: " + msgRecord.msgId + ", elemId: " + msgElement.elementId);
        ((IRichMediaService) QRoute.api(IRichMediaService.class)).getVideoPlayUrlV2(new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId), msgRecord.msgId, msgElement.elementId, VideoCodecFormatType.KCODECFORMATH264, new RMReqExParams(1, 0), new IVideoPlayUrlCallback() { // from class: sw1.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback
            public final void onResult(int i3, String str, VideoPlayUrlResult videoPlayUrlResult) {
                f.m(MsgRecord.this, msgElement, this, cb5, i3, str, videoPlayUrlResult);
            }
        });
    }
}
