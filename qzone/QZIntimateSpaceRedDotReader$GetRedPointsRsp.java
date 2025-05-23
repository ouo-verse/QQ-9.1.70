package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceRedDotReader$GetRedPointsRsp extends MessageMicro<QZIntimateSpaceRedDotReader$GetRedPointsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"red_points", "entrance_info"}, new Object[]{null, null}, QZIntimateSpaceRedDotReader$GetRedPointsRsp.class);
    public final PBRepeatMessageField<QZIntimateSpaceRedDotReader$RedPoint> red_points = PBField.initRepeatMessage(QZIntimateSpaceRedDotReader$RedPoint.class);
    public QZIntimateSpaceRedDotReader$EntranceInfo entrance_info = new QZIntimateSpaceRedDotReader$EntranceInfo();
}
