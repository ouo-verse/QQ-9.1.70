package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgShow$UserPMGiftInfo extends MessageMicro<QQCirclePrivateMsgShow$UserPMGiftInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"uid", "relation", "certification", "giftInfos"}, new Object[]{"", 0, 0, null}, QQCirclePrivateMsgShow$UserPMGiftInfo.class);
    public final PBStringField uid = PBField.initString("");
    public final PBUInt32Field relation = PBField.initUInt32(0);
    public final PBUInt32Field certification = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCirclePrivateMsgShow$PMGiftInfo> giftInfos = PBField.initRepeatMessage(QQCirclePrivateMsgShow$PMGiftInfo.class);
}
