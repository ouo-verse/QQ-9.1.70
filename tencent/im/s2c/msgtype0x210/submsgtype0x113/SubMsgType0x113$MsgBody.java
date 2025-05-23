package tencent.im.s2c.msgtype0x210.submsgtype0x113;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x113$MsgBody extends MessageMicro<SubMsgType0x113$MsgBody> {
    public static final int TASK_OP_RECALL = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int32_app_id", "int32_task_id", "enum_task_op"}, new Object[]{0, 0, 1}, SubMsgType0x113$MsgBody.class);
    public final PBInt32Field int32_app_id = PBField.initInt32(0);
    public final PBInt32Field int32_task_id = PBField.initInt32(0);
    public final PBEnumField enum_task_op = PBField.initEnum(1);
}
