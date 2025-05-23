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
public final class cmd0x352$TryUpImgReq extends MessageMicro<cmd0x352$TryUpImgReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_address_book;
    public final PBBoolField bool_pic_original;
    public final PBBoolField bool_reject_tryfast;
    public final PBBytesField bytes_build_ver;
    public final PBBytesField bytes_file_index;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_name;
    public final PBBytesField bytes_transfer_url;
    public final PBUInt32Field uint32_bu_type;
    public final PBUInt32Field uint32_inner_ip;
    public final PBUInt32Field uint32_pic_height;
    public final PBUInt32Field uint32_pic_type;
    public final PBUInt32Field uint32_pic_width;
    public final PBUInt32Field uint32_platform_type;
    public final PBUInt32Field uint32_retry;
    public final PBUInt32Field uint32_src_term;
    public final PBUInt32Field uint32_srv_upload;
    public final PBUInt32Field uint32_store_days;
    public final PBUInt32Field uint32_tryup_stepflag;
    public final PBUInt64Field uint64_file_size;
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 138, 146, 152, 160, 168, 176, 186}, new String[]{"uint64_src_uin", "uint64_dst_uin", "uint64_file_id", "bytes_file_md5", "uint64_file_size", "bytes_file_name", "uint32_src_term", "uint32_platform_type", "uint32_inner_ip", "bool_address_book", "uint32_retry", "uint32_bu_type", "bool_pic_original", "uint32_pic_width", "uint32_pic_height", "uint32_pic_type", "bytes_build_ver", "bytes_file_index", "uint32_store_days", "uint32_tryup_stepflag", "bool_reject_tryfast", "uint32_srv_upload", "bytes_transfer_url"}, new Object[]{0L, 0L, 0L, byteStringMicro, 0L, byteStringMicro, 0, 0, 0, bool, 0, 0, bool, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, bool, 0, byteStringMicro}, cmd0x352$TryUpImgReq.class);
    }

    public cmd0x352$TryUpImgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_file_size = PBField.initUInt64(0L);
        this.bytes_file_name = PBField.initBytes(byteStringMicro);
        this.uint32_src_term = PBField.initUInt32(0);
        this.uint32_platform_type = PBField.initUInt32(0);
        this.uint32_inner_ip = PBField.initUInt32(0);
        this.bool_address_book = PBField.initBool(false);
        this.uint32_retry = PBField.initUInt32(0);
        this.uint32_bu_type = PBField.initUInt32(0);
        this.bool_pic_original = PBField.initBool(false);
        this.uint32_pic_width = PBField.initUInt32(0);
        this.uint32_pic_height = PBField.initUInt32(0);
        this.uint32_pic_type = PBField.initUInt32(0);
        this.bytes_build_ver = PBField.initBytes(byteStringMicro);
        this.bytes_file_index = PBField.initBytes(byteStringMicro);
        this.uint32_store_days = PBField.initUInt32(0);
        this.uint32_tryup_stepflag = PBField.initUInt32(0);
        this.bool_reject_tryfast = PBField.initBool(false);
        this.uint32_srv_upload = PBField.initUInt32(0);
        this.bytes_transfer_url = PBField.initBytes(byteStringMicro);
    }
}
