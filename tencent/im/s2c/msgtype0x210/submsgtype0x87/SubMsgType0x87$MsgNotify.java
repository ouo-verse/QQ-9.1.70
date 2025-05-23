package tencent.im.s2c.msgtype0x210.submsgtype0x87;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x87$MsgNotify extends MessageMicro<SubMsgType0x87$MsgNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"uint64_uin", "uint64_fuin", "uint32_time", "uint32_reqsubtype", "uint32_max_count", "msg_clone_info"}, new Object[]{0L, 0L, 0, 0, 0, null}, SubMsgType0x87$MsgNotify.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reqsubtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
    public SubMsgType0x87$CloneInfo msg_clone_info = new SubMsgType0x87$CloneInfo();
}
