package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class Smartptt$PttUpReq extends MessageMicro<Smartptt$PttUpReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 40, 50, 56, 64, 72, 80, 90, 96, 104, 112}, new String[]{"uint32_bits_per_sample", "uint32_voice_file_type", "uint32_voice_encode_type", "uint32_samples_per_sec", "str_voice_id", "uint32_offset", "uint32_is_first", "uint32_is_end", "uint32_service_id", "str_Filemd5", "uint32_chat_type", "uint32_voice_num", "uint32_voice_offset"}, new Object[]{0, 0, 0, 0, "", 0, 0, 0, 0, "", 0, 0, 0}, Smartptt$PttUpReq.class);
    public final PBUInt32Field uint32_bits_per_sample = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_encode_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_samples_per_sec = PBField.initUInt32(0);
    public final PBStringField str_voice_id = PBField.initString("");
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
    public final PBStringField str_Filemd5 = PBField.initString("");
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_offset = PBField.initUInt32(0);
}
