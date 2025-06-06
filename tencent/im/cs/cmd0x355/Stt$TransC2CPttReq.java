package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class Stt$TransC2CPttReq extends MessageMicro<Stt$TransC2CPttReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 74, 80, 88}, new String[]{"uint64_sessionid", "uint64_sender_uin", "uint64_receiver_uin", "str_file_path", "uint32_ptt_time", "uint32_filesize", "uint32_ptt_format", "uint32_event_type", "str_filemd5", "uint32_msg_type", "is_caption"}, new Object[]{0L, 0L, 0L, "", 0, 0, 0, 1, "", 0, Boolean.FALSE}, Stt$TransC2CPttReq.class);
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filesize = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_event_type = PBField.initUInt32(1);
    public final PBStringField str_filemd5 = PBField.initString("");
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBBoolField is_caption = PBField.initBool(false);
}
