package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$ExtensionReq extends MessageMicro<cmd0x346$ExtensionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 162, 800, 720802, 721600, 722400, 723200, 724000, 724800, 725600, 726400, 727200, 728000, 728800}, new String[]{"uint64_id", "uint64_type", "str_dst_phonenum", "int32_phone_convert_type", "bytes_sig", "uint64_route_id", "msg_del_message_req", "uint32_download_url_type", "uint32_ptt_format", "uint32_is_need_inner_ip", "uint32_net_type", "uint32_voice_type", "uint32_file_type", "uint32_ptt_time", "uint32_bdh_cmdid", "uint32_req_transfer_type", "uint32_is_auto"}, new Object[]{0L, 0L, "", 0, ByteStringMicro.EMPTY, 0L, null, 0, 0, 0, 255, 0, 0, 0, 0, 0, 0}, cmd0x346$ExtensionReq.class);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0);
    public final PBStringField str_dst_phonenum = PBField.initString("");
    public final PBInt32Field int32_phone_convert_type = PBField.initInt32(0);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_route_id = PBField.initUInt64(0);
    public cmd0x346$DelMessageReq msg_del_message_req = new MessageMicro<cmd0x346$DelMessageReq>() { // from class: tencent.im.cs.cmd0x346.cmd0x346$DelMessageReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 80, 160, 240}, new String[]{"uint64_uin_sender", "uint64_uin_receiver", "uint32_msg_time", "uint32_msg_random", "uint32_msg_seq_no"}, new Object[]{0L, 0L, 0, 0, 0}, cmd0x346$DelMessageReq.class);
        public final PBUInt64Field uint64_uin_sender = PBField.initUInt64(0);
        public final PBUInt64Field uint64_uin_receiver = PBField.initUInt64(0);
        public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_seq_no = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_download_url_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_need_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(255);
    public final PBUInt32Field uint32_voice_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bdh_cmdid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_auto = PBField.initUInt32(0);
}
