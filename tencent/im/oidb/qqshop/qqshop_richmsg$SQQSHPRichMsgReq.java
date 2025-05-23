package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class qqshop_richmsg$SQQSHPRichMsgReq extends MessageMicro<qqshop_richmsg$SQQSHPRichMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rich_msgs"}, new Object[]{null}, qqshop_richmsg$SQQSHPRichMsgReq.class);
    public final PBRepeatMessageField<qqshop_richmsg$SQQSHPRichMsg> rich_msgs = PBField.initRepeatMessage(qqshop_richmsg$SQQSHPRichMsg.class);
}
