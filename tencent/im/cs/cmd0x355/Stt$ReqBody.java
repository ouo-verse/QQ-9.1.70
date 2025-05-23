package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Stt$ReqBody extends MessageMicro<Stt$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 80}, new String[]{"uint32_sub_cmd", "msg_group_ptt_req", "msg_c2c_ptt_req", "msg_corret_text_req", "ptt_version"}, new Object[]{0, null, null, null, 0}, Stt$ReqBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public Stt$TransGroupPttReq msg_group_ptt_req = new Stt$TransGroupPttReq();
    public Stt$TransC2CPttReq msg_c2c_ptt_req = new Stt$TransC2CPttReq();
    public Stt$CorretTextReq msg_corret_text_req = new MessageMicro<Stt$CorretTextReq>() { // from class: tencent.im.cs.cmd0x355.Stt$CorretTextReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 64, 72, 80, 88, 98, 104}, new String[]{"uint64_sessionid", "uint32_ptt_type", "uint64_sender_uin", "uint64_receiver_uin", "uint32_fileid", "str_Filemd5", "str_file_path", "uint32_total_len", "uint32_seq", "uint32_pos", "uint32_len", "bytes_text", "uint32_ptt_format"}, new Object[]{0L, 0, 0L, 0L, 0, "", "", 0, 0, 0, 0, ByteStringMicro.EMPTY, 0}, Stt$CorretTextReq.class);
        public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_ptt_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_fileid = PBField.initUInt32(0);
        public final PBStringField str_Filemd5 = PBField.initString("");
        public final PBStringField str_file_path = PBField.initString("");
        public final PBUInt32Field uint32_total_len = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
        public final PBUInt32Field uint32_len = PBField.initUInt32(0);
        public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
    };
    public final PBUInt32Field ptt_version = PBField.initUInt32(0);
}
