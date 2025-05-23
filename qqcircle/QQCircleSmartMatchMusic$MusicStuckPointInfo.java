package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$MusicStuckPointInfo extends MessageMicro<QQCircleSmartMatchMusic$MusicStuckPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"mid", "version", "allData"}, new Object[]{"", "", null}, QQCircleSmartMatchMusic$MusicStuckPointInfo.class);
    public final PBStringField mid = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$StuckPointData> allData = PBField.initRepeatMessage(QQCircleSmartMatchMusic$StuckPointData.class);
}
