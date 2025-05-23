package tencent.im.msgsync.cmd0x100;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x8a$ReqBody extends MessageMicro<Submsgtype0x8a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48}, new String[]{"msg_info", "uint32_app_id", "uint32_inst_id", "uint32_long_message_flag", "bytes_reserved", "traceless_flag"}, new Object[]{null, 0, 0, 0, ByteStringMicro.EMPTY, Boolean.FALSE}, Submsgtype0x8a$ReqBody.class);
    public final PBRepeatMessageField<Submsgtype0x8a$MsgInfo> msg_info = PBField.initRepeatMessage(Submsgtype0x8a$MsgInfo.class);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField traceless_flag = PBField.initBool(false);
}
