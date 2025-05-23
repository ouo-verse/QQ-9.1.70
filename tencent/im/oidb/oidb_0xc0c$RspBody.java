package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc0c$RspBody extends MessageMicro<oidb_0xc0c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 64}, new String[]{"uint32_is_task_completed", "uint32_task_point", "bytes_guide_wording", "uint32_need_show_progress", "uint32_original_progress", "uint32_now_progress", "uint32_total_progress", "uint32_need_exec_task"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0, 0}, oidb_0xc0c$RspBody.class);
    public final PBUInt32Field uint32_is_task_completed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_task_point = PBField.initUInt32(0);
    public final PBBytesField bytes_guide_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_need_show_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_original_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_now_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_progress = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_exec_task = PBField.initUInt32(0);
}
