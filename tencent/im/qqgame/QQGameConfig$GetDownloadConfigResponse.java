package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameConfig$GetDownloadConfigResponse extends MessageMicro<QQGameConfig$GetDownloadConfigResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{DownloadInfo.spKey_Config}, new Object[]{null}, QQGameConfig$GetDownloadConfigResponse.class);
    public QQGameConfig$DownloadConfig config = new QQGameConfig$DownloadConfig();
}
