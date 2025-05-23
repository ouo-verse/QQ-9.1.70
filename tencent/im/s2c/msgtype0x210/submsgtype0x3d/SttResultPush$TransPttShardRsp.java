package tencent.im.s2c.msgtype0x210.submsgtype0x3d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SttResultPush$TransPttShardRsp extends MessageMicro<SttResultPush$TransPttShardRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_ptt_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_FileID = PBField.initUInt32(0);
    public final PBStringField str_Filemd5 = PBField.initString("");
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_total_seq = PBField.initUInt32(0);
    public final PBBoolField bool_is_total_end = PBField.initBool(false);
    public final PBBoolField bool_is_cur_end = PBField.initBool(false);
    public SttResultPush$textRsp cur_text_rsp = new SttResultPush$textRsp();
    public SttResultPush$textRsp all_text_rsp = new SttResultPush$textRsp();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 72, 80, 88, 98, 106, 168, 176, 184, 242, 250}, new String[]{"uint64_sessionid", "uint32_ptt_type", "uint32_error_code", "uint64_sender_uin", "uint64_receiver_uin", "uint32_FileID", "str_Filemd5", "str_file_path", "uint32_total_seq", "bool_is_total_end", "bool_is_cur_end", "cur_text_rsp", "all_text_rsp"}, new Object[]{0L, 0, 0, 0L, 0L, 0, "", "", 0, bool, bool, null, null}, SttResultPush$TransPttShardRsp.class);
    }
}
