package tencent.im.oidb.cmd0x922;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x922$RspBody extends MessageMicro<cmd0x922$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint32_need_update_flag", "uint64_timestamp", "msg_push_info", "uint32_next_req_time"}, new Object[]{0, 0L, null, 0}, cmd0x922$RspBody.class);
    public final PBUInt32Field uint32_need_update_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
    public cmd0x922$PushInfo msg_push_info = new cmd0x922$PushInfo();
    public final PBUInt32Field uint32_next_req_time = PBField.initUInt32(0);
}
