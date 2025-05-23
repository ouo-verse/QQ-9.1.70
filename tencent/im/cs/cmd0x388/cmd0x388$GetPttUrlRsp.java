package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class cmd0x388$GetPttUrlRsp extends MessageMicro<cmd0x388$GetPttUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_ip6;
    public final PBBytesField bytes_down_domain;
    public final PBBytesField bytes_down_para;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_file_md5;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_down_url;
    public final PBRepeatMessageField<cmd0x388$IPv6Info> rpt_msg_down_ip6;
    public final PBStringField rpt_str_domain;
    public final PBRepeatField<Integer> rpt_uint32_down_ip;
    public final PBRepeatField<Integer> rpt_uint32_down_port;
    public final PBUInt32Field uint32_allow_retry;
    public final PBUInt32Field uint32_result;
    public final PBUInt32Field uint32_transfer_type;
    public final PBUInt64Field uint64_file_id;
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 56, 66, 74, 80, 88, 96, 210, 218, 226}, new String[]{"uint64_fileid", "bytes_file_md5", "uint32_result", "bytes_fail_msg", "rpt_bytes_down_url", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_down_domain", "bytes_down_para", "uint64_file_id", "uint32_transfer_type", "uint32_allow_retry", "rpt_msg_down_ip6", "bytes_client_ip6", "rpt_str_domain"}, new Object[]{0L, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0L, 0, 0, null, byteStringMicro, ""}, cmd0x388$GetPttUrlRsp.class);
    }

    public cmd0x388$GetPttUrlRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_result = PBField.initUInt32(0);
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.rpt_bytes_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_down_ip = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_down_port = PBField.initRepeat(pBUInt32Field);
        this.bytes_down_domain = PBField.initBytes(byteStringMicro);
        this.bytes_down_para = PBField.initBytes(byteStringMicro);
        this.uint64_file_id = PBField.initUInt64(0L);
        this.uint32_transfer_type = PBField.initUInt32(0);
        this.uint32_allow_retry = PBField.initUInt32(0);
        this.rpt_msg_down_ip6 = PBField.initRepeatMessage(cmd0x388$IPv6Info.class);
        this.bytes_client_ip6 = PBField.initBytes(byteStringMicro);
        this.rpt_str_domain = PBField.initString("");
    }
}
