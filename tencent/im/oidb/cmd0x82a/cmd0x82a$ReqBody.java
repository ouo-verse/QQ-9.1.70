package tencent.im.oidb.cmd0x82a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x82a$ReqBody extends MessageMicro<cmd0x82a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"msg_info", "uint32_app_id", "uint32_inst_id", "uint32_long_message_flag", "bytes_reserved"}, new Object[]{null, 0, 0, 0, ByteStringMicro.EMPTY}, cmd0x82a$ReqBody.class);
    public final PBRepeatMessageField<cmd0x82a$MsgInfo> msg_info = PBField.initRepeatMessage(cmd0x82a$MsgInfo.class);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
}
