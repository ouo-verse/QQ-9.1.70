package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgShow$PMGiftInfo extends MessageMicro<QQCirclePrivateMsgShow$PMGiftInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"giftType", "giftCnt", "display"}, new Object[]{0, 0, null}, QQCirclePrivateMsgShow$PMGiftInfo.class);
    public final PBEnumField giftType = PBField.initEnum(0);
    public final PBUInt32Field giftCnt = PBField.initUInt32(0);
    public QQCirclePrivateMsgShow$PMGiftDisplayInfo display = new MessageMicro<QQCirclePrivateMsgShow$PMGiftDisplayInfo>() { // from class: qqcircle.QQCirclePrivateMsgShow$PMGiftDisplayInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"icon", "backgroudColor", "numberColor"}, new Object[]{"", "", ""}, QQCirclePrivateMsgShow$PMGiftDisplayInfo.class);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField backgroudColor = PBField.initString("");
        public final PBStringField numberColor = PBField.initString("");
    };
}
