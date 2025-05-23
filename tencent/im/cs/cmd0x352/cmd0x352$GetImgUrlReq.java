package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x352$GetImgUrlReq extends MessageMicro<cmd0x352$GetImgUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_address_book;
    public final PBBytesField bytes_build_ver;
    public final PBBytesField bytes_file_resid;
    public final PBUInt32Field uint32_bu_type;
    public final PBUInt32Field uint32_inner_ip;
    public final PBUInt32Field uint32_pic_up_timestamp;
    public final PBUInt32Field uint32_req_platform_type;
    public final PBUInt32Field uint32_req_term;
    public final PBUInt32Field uint32_req_transfer_type;
    public final PBUInt32Field uint32_src_file_type;
    public final PBUInt32Field uint32_url_flag;
    public final PBUInt32Field uint32_url_type;
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 48, 56, 64, 72, 80, 88, 96, 106, 112, 120}, new String[]{"uint64_src_uin", "uint64_dst_uin", "bytes_file_resid", "uint32_url_flag", "uint32_url_type", "uint32_req_term", "uint32_req_platform_type", "uint32_src_file_type", "uint32_inner_ip", "bool_address_book", "uint32_bu_type", "bytes_build_ver", "uint32_pic_up_timestamp", "uint32_req_transfer_type"}, new Object[]{0L, 0L, byteStringMicro, 0, 0, 0, 0, 0, 0, Boolean.FALSE, 0, byteStringMicro, 0, 0}, cmd0x352$GetImgUrlReq.class);
    }

    public cmd0x352$GetImgUrlReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_resid = PBField.initBytes(byteStringMicro);
        this.uint32_url_flag = PBField.initUInt32(0);
        this.uint32_url_type = PBField.initUInt32(0);
        this.uint32_req_term = PBField.initUInt32(0);
        this.uint32_req_platform_type = PBField.initUInt32(0);
        this.uint32_src_file_type = PBField.initUInt32(0);
        this.uint32_inner_ip = PBField.initUInt32(0);
        this.bool_address_book = PBField.initBool(false);
        this.uint32_bu_type = PBField.initUInt32(0);
        this.bytes_build_ver = PBField.initBytes(byteStringMicro);
        this.uint32_pic_up_timestamp = PBField.initUInt32(0);
        this.uint32_req_transfer_type = PBField.initUInt32(0);
    }
}
