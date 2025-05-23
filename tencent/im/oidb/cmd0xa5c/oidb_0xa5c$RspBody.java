package tencent.im.oidb.cmd0xa5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa5c$RspBody extends MessageMicro<oidb_0xa5c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_finish_task_num", "uint32_all_task_num"}, new Object[]{0, 0}, oidb_0xa5c$RspBody.class);
    public final PBUInt32Field uint32_finish_task_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_all_task_num = PBField.initUInt32(0);
}
