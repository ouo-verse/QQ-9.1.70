package tencent.im.s2c.msgtype0x210.submsgtype0x101;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x27$PushPlatform extends MessageMicro<SubMsgType0x27$PushPlatform> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58}, new String[]{"uint64_from_uin", "str_title", "str_desc", "str_target_url", "uint32_forward_type", "str_ext_data", "bytes_ext_data"}, new Object[]{0L, "", "", "", 0, "", ByteStringMicro.EMPTY}, SubMsgType0x27$PushPlatform.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_target_url = PBField.initString("");
    public final PBUInt32Field uint32_forward_type = PBField.initUInt32(0);
    public final PBStringField str_ext_data = PBField.initString("");
    public final PBBytesField bytes_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
