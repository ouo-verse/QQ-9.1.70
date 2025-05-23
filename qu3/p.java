package qu3;

import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lqu3/p;", "Lqu3/d;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class p implements d {
    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // qu3.d
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO);
        MessageForShortVideo messageForShortVideo = d16 instanceof MessageForShortVideo ? (MessageForShortVideo) d16 : null;
        if (messageForShortVideo == null) {
            return null;
        }
        if (msgElement == null && (msgElement = i.f429570a.m(msgRecord)) == null) {
            return null;
        }
        VideoElement videoElement = msgElement.videoElement;
        messageForShortVideo.busiType = videoElement.busiType;
        Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
        messageForShortVideo.videoFileName = aj.e(videoElement);
        messageForShortVideo.md5 = videoElement.videoMd5;
        messageForShortVideo.thumbMD5 = videoElement.thumbMd5;
        messageForShortVideo.videoFileTime = videoElement.fileTime;
        messageForShortVideo.thumbFileSize = videoElement.thumbSize;
        messageForShortVideo.videoFileFormat = videoElement.fileFormat;
        messageForShortVideo.videoFileSize = (int) videoElement.fileSize;
        messageForShortVideo.thumbWidth = videoElement.thumbWidth;
        messageForShortVideo.thumbHeight = videoElement.thumbHeight;
        Integer num = videoElement.progress;
        Intrinsics.checkNotNullExpressionValue(num, "videoElement.progress");
        messageForShortVideo.progress = num.intValue();
        messageForShortVideo.uuid = videoElement.fileUuid;
        messageForShortVideo.mThumbFilePath = aj.f(videoElement);
        Integer num2 = videoElement.invalidState;
        Intrinsics.checkNotNullExpressionValue(num2, "videoElement.invalidState");
        messageForShortVideo.videoFileStatus = num2.intValue();
        messageForShortVideo.subBusiType = videoElement.busiType;
        return messageForShortVideo;
    }
}
