package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class cmd0x388$GetPttUrlReq extends MessageMicro<cmd0x388$GetPttUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver;
    public final PBBytesField bytes_file_key;
    public final PBBytesField bytes_file_md5;
    public final PBUInt32Field uint32_bu_id;
    public final PBUInt32Field uint32_bu_type;
    public final PBUInt32Field uint32_codec;
    public final PBUInt32Field uint32_inner_ip;
    public final PBUInt32Field uint32_is_auto;
    public final PBUInt32Field uint32_req_platform_type;
    public final PBUInt32Field uint32_req_term;
    public final PBUInt32Field uint32_req_transfer_type;
    public final PBUInt64Field uint64_file_id;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 74, 80, 90, 96, 104, 112, 120}, new String[]{"uint64_group_code", "uint64_dst_uin", "uint64_fileid", "bytes_file_md5", "uint32_req_term", "uint32_req_platform_type", "uint32_inner_ip", "uint32_bu_type", "bytes_build_ver", "uint64_file_id", "bytes_file_key", "uint32_codec", "uint32_bu_id", "uint32_req_transfer_type", "uint32_is_auto"}, new Object[]{0L, 0L, 0L, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0L, byteStringMicro, 0, 0, 0, 0}, cmd0x388$GetPttUrlReq.class);
    }

    public cmd0x388$GetPttUrlReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_req_term = PBField.initUInt32(0);
        this.uint32_req_platform_type = PBField.initUInt32(0);
        this.uint32_inner_ip = PBField.initUInt32(0);
        this.uint32_bu_type = PBField.initUInt32(0);
        this.bytes_build_ver = PBField.initBytes(byteStringMicro);
        this.uint64_file_id = PBField.initUInt64(0L);
        this.bytes_file_key = PBField.initBytes(byteStringMicro);
        this.uint32_codec = PBField.initUInt32(0);
        this.uint32_bu_id = PBField.initUInt32(0);
        this.uint32_req_transfer_type = PBField.initUInt32(0);
        this.uint32_is_auto = PBField.initUInt32(0);
    }
}
