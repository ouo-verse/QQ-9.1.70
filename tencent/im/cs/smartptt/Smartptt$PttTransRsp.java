package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class Smartptt$PttTransRsp extends MessageMicro<Smartptt$PttTransRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"uint32_ret_code", "str_voice_id", "uint32_is_final", "str_text", "uint32_offset"}, new Object[]{0, "", 0, "", 0}, Smartptt$PttTransRsp.class);
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
    public final PBStringField str_voice_id = PBField.initString("");
    public final PBUInt32Field uint32_is_final = PBField.initUInt32(0);
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
}
