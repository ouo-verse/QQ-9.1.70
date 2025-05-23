package tencent.im.s2c.msgtype0x211.submsgtype0x4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x4$WlanRecvNotify extends MessageMicro<SubMsgType0x4$WlanRecvNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56}, new String[]{"uint64_session_id", "uint32_send_client_type", "uint32_target_client_type", "str_file_name", "uint64_file_size", "uint32_time", "uint32_random"}, new Object[]{0L, 0, 0, "", 0L, 0, 0}, SubMsgType0x4$WlanRecvNotify.class);
    public final PBUInt64Field uint64_session_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_send_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_target_client_type = PBField.initUInt32(0);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_random = PBField.initUInt32(0);
}
