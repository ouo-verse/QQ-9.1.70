package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameAutoDownloadTask$CircleGameConfig extends MessageMicro<QQGameAutoDownloadTask$CircleGameConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"next_check_time", "recent_appid", "recent_online_time", "circle_start_time", "circle_end_time", "circle_gap_duration"}, new Object[]{0L, "", 0L, 0L, 0L, 0L}, QQGameAutoDownloadTask$CircleGameConfig.class);
    public final PBInt64Field next_check_time = PBField.initInt64(0);
    public final PBStringField recent_appid = PBField.initString("");
    public final PBInt64Field recent_online_time = PBField.initInt64(0);
    public final PBInt64Field circle_start_time = PBField.initInt64(0);
    public final PBInt64Field circle_end_time = PBField.initInt64(0);
    public final PBInt64Field circle_gap_duration = PBField.initInt64(0);
}
