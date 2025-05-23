package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StMainPageCommBusiRspData extends MessageMicro<QQCircleFeedBase$StMainPageCommBusiRspData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"showSubButtonsPos", "subButtons", "op_mask"}, new Object[]{0, null, 0}, QQCircleFeedBase$StMainPageCommBusiRspData.class);
    public final PBRepeatField<Integer> op_mask;
    public final PBRepeatField<Integer> showSubButtonsPos;
    public QQCircleDitto$StButtonGroup subButtons;

    public QQCircleFeedBase$StMainPageCommBusiRspData() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.showSubButtonsPos = PBField.initRepeat(pBUInt32Field);
        this.subButtons = new QQCircleDitto$StButtonGroup();
        this.op_mask = PBField.initRepeat(pBUInt32Field);
    }
}
