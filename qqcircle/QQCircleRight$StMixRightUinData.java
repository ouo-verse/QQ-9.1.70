package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$StMixRightUinData extends MessageMicro<QQCircleRight$StMixRightUinData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "rightData"}, new Object[]{0L, null}, QQCircleRight$StMixRightUinData.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public QQCircleRight$StRightData rightData = new MessageMicro<QQCircleRight$StRightData>() { // from class: qqcircle.QQCircleRight$StRightData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uncareFlag", "blackFlag"}, new Object[]{0, 0}, QQCircleRight$StRightData.class);
        public final PBInt32Field uncareFlag = PBField.initInt32(0);
        public final PBInt32Field blackFlag = PBField.initInt32(0);
    };
}
