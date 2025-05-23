package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQGameAutoDownloadTask$GetPreCircleResponse extends MessageMicro<QQGameAutoDownloadTask$GetPreCircleResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"pre_download_list", "circle_game_config", "ret", "msg"}, new Object[]{null, null, 0, ""}, QQGameAutoDownloadTask$GetPreCircleResponse.class);
    public final PBRepeatMessageField<QQGameAutoDownloadTask$PreDownloadInfo> pre_download_list = PBField.initRepeatMessage(QQGameAutoDownloadTask$PreDownloadInfo.class);
    public QQGameAutoDownloadTask$CircleGameConfig circle_game_config = new QQGameAutoDownloadTask$CircleGameConfig();
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436028msg = PBField.initString("");
}
