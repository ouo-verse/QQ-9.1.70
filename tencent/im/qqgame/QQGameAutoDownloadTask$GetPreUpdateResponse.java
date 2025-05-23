package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQGameAutoDownloadTask$GetPreUpdateResponse extends MessageMicro<QQGameAutoDownloadTask$GetPreUpdateResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 72}, new String[]{"pre_update_list", "pre_download_list", "res_valid_duration", "update_gap_duration", "circle_game_config", "ret", "msg", "king_card_switch", "electricity"}, new Object[]{null, null, 0L, 0L, null, 0, "", 0, 0}, QQGameAutoDownloadTask$GetPreUpdateResponse.class);
    public final PBRepeatMessageField<QQGameAutoDownloadTask$PreUpdateInfo> pre_update_list = PBField.initRepeatMessage(QQGameAutoDownloadTask$PreUpdateInfo.class);
    public final PBRepeatMessageField<QQGameAutoDownloadTask$PreDownloadInfo> pre_download_list = PBField.initRepeatMessage(QQGameAutoDownloadTask$PreDownloadInfo.class);
    public final PBInt64Field res_valid_duration = PBField.initInt64(0);
    public final PBInt64Field update_gap_duration = PBField.initInt64(0);
    public QQGameAutoDownloadTask$CircleGameConfig circle_game_config = new QQGameAutoDownloadTask$CircleGameConfig();
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436029msg = PBField.initString("");
    public final PBInt32Field king_card_switch = PBField.initInt32(0);
    public final PBInt32Field electricity = PBField.initInt32(0);
}
