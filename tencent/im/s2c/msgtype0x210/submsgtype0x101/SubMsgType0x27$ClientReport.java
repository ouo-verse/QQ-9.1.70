package tencent.im.s2c.msgtype0x210.submsgtype0x101;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$ClientReport extends MessageMicro<SubMsgType0x27$ClientReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_service_id", "str_content_id"}, new Object[]{0, ""}, SubMsgType0x27$ClientReport.class);
    public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
    public final PBStringField str_content_id = PBField.initString("");
}
