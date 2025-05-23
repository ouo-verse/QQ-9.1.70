package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class cmd0x388$TryUpPttRsp extends MessageMicro<cmd0x388$TryUpPttRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exit;
    public final PBBytesField bytes_client_ip6;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_file_key;
    public final PBBytesField bytes_up_ukey;
    public final PBRepeatMessageField<cmd0x388$IPv6Info> rpt_msg_up_ip6;
    public final PBRepeatField<Integer> rpt_uint32_up_ip;
    public final PBRepeatField<Integer> rpt_uint32_up_port;
    public final PBUInt32Field uint32_channel_type;
    public final PBUInt64Field uint64_block_size;
    public final PBUInt64Field uint64_fileid;
    public final PBUInt64Field uint64_up_offset;
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 58, 64, 72, 80, 90, 96, 210, 218}, new String[]{"uint64_file_id", "uint32_result", "bytes_fail_msg", "bool_file_exit", "rpt_uint32_up_ip", "rpt_uint32_up_port", "bytes_up_ukey", "uint64_fileid", "uint64_up_offset", "uint64_block_size", "bytes_file_key", "uint32_channel_type", "rpt_msg_up_ip6", "bytes_client_ip6"}, new Object[]{0L, 0, byteStringMicro, Boolean.FALSE, 0, 0, byteStringMicro, 0L, 0L, 0L, byteStringMicro, 0, null, byteStringMicro}, cmd0x388$TryUpPttRsp.class);
    }

    public cmd0x388$TryUpPttRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.bool_file_exit = PBField.initBool(false);
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_up_ip = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_up_port = PBField.initRepeat(pBUInt32Field);
        this.bytes_up_ukey = PBField.initBytes(byteStringMicro);
        this.uint64_fileid = PBField.initUInt64(0L);
        this.uint64_up_offset = PBField.initUInt64(0L);
        this.uint64_block_size = PBField.initUInt64(0L);
        this.bytes_file_key = PBField.initBytes(byteStringMicro);
        this.uint32_channel_type = PBField.initUInt32(0);
        this.rpt_msg_up_ip6 = PBField.initRepeatMessage(cmd0x388$IPv6Info.class);
        this.bytes_client_ip6 = PBField.initBytes(byteStringMicro);
    }
}
