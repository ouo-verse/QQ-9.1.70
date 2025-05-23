package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class qqshop_richmsg$SQQSHPRichMsgRsp extends MessageMicro<qqshop_richmsg$SQQSHPRichMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rich_msgs", "ad_msgs"}, new Object[]{null, null}, qqshop_richmsg$SQQSHPRichMsgRsp.class);
    public final PBRepeatMessageField<qqshop_richmsg$SQQSHPRichMsg> rich_msgs = PBField.initRepeatMessage(qqshop_richmsg$SQQSHPRichMsg.class);
    public final PBRepeatMessageField<qqshop_richmsg$SQQSHPFolderAdMsg> ad_msgs = PBField.initRepeatMessage(qqshop_richmsg$SQQSHPFolderAdMsg.class);
}
