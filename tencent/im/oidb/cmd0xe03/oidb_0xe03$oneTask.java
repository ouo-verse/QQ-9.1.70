package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe03$oneTask extends MessageMicro<oidb_0xe03$oneTask> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_task_status", "uint32_task_match_times", "str_msg"}, new Object[]{0, 0, ""}, oidb_0xe03$oneTask.class);
    public final PBUInt32Field uint32_task_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_task_match_times = PBField.initUInt32(0);
    public final PBStringField str_msg = PBField.initString("");
}
