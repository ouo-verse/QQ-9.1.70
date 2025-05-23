package tencent.im.s2c.msgtype0x210.submsgtype0x3d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SttResultPush$TransPttResp extends MessageMicro<SttResultPush$TransPttResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 88, 98, 106}, new String[]{"uint64_sessionid", "uint32_ptt_type", "uint32_error_code", "uint32_total_len", "uint32_seq", "uint32_pos", "uint32_len", "bytes_text", "uint64_sender_uin", "uint64_receiver_uin", "uint32_FileID", "str_Filemd5", "str_file_path"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, 0L, 0L, 0, "", ""}, SttResultPush$TransPttResp.class);
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_ptt_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
    public final PBUInt32Field uint32_len = PBField.initUInt32(0);
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_FileID = PBField.initUInt32(0);
    public final PBStringField str_Filemd5 = PBField.initString("");
    public final PBStringField str_file_path = PBField.initString("");
}
