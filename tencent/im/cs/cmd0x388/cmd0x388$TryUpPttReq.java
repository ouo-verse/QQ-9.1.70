package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class cmd0x388$TryUpPttReq extends MessageMicro<cmd0x388$TryUpPttReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_new_up_chan;
    public final PBBytesField bytes_build_ver;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_name;
    public final PBUInt32Field uint32_bu_id;
    public final PBUInt32Field uint32_bu_type;
    public final PBUInt32Field uint32_codec;
    public final PBUInt32Field uint32_inner_ip;
    public final PBUInt32Field uint32_platform_type;
    public final PBUInt32Field uint32_src_term;
    public final PBUInt32Field uint32_voice_length;
    public final PBUInt32Field uint32_voice_type;
    public final PBUInt64Field uint64_file_size;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128}, new String[]{"uint64_group_code", "uint64_src_uin", "uint64_file_id", "bytes_file_md5", "uint64_file_size", "bytes_file_name", "uint32_src_term", "uint32_platform_type", "uint32_bu_type", "bytes_build_ver", "uint32_inner_ip", "uint32_voice_length", "bool_new_up_chan", "uint32_codec", "uint32_voice_type", "uint32_bu_id"}, new Object[]{0L, 0L, 0L, byteStringMicro, 0L, byteStringMicro, 0, 0, 0, byteStringMicro, 0, 0, Boolean.FALSE, 0, 0, 0}, cmd0x388$TryUpPttReq.class);
    }

    public cmd0x388$TryUpPttReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_file_size = PBField.initUInt64(0L);
        this.bytes_file_name = PBField.initBytes(byteStringMicro);
        this.uint32_src_term = PBField.initUInt32(0);
        this.uint32_platform_type = PBField.initUInt32(0);
        this.uint32_bu_type = PBField.initUInt32(0);
        this.bytes_build_ver = PBField.initBytes(byteStringMicro);
        this.uint32_inner_ip = PBField.initUInt32(0);
        this.uint32_voice_length = PBField.initUInt32(0);
        this.bool_new_up_chan = PBField.initBool(false);
        this.uint32_codec = PBField.initUInt32(0);
        this.uint32_voice_type = PBField.initUInt32(0);
        this.uint32_bu_id = PBField.initUInt32(0);
    }
}
