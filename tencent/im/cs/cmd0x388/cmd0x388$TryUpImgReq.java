package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$TryUpImgReq extends MessageMicro<cmd0x388$TryUpImgReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver;
    public final PBBytesField bytes_file_index;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_name;
    public final PBBytesField bytes_transfer_url;
    public final PBUInt32Field uint32_app_pic_type;
    public final PBUInt32Field uint32_bu_type;
    public final PBUInt32Field uint32_inner_ip;
    public final PBUInt32Field uint32_original_pic;
    public final PBUInt32Field uint32_pic_height;
    public final PBUInt32Field uint32_pic_type;
    public final PBUInt32Field uint32_pic_width;
    public final PBUInt32Field uint32_platform_type;
    public final PBUInt32Field uint32_src_term;
    public final PBUInt32Field uint32_srv_upload;
    public final PBUInt64Field uint64_dst_uin;
    public final PBUInt64Field uint64_file_size;
    public final PBUInt64Field uint64_qqmeet_channel_id;
    public final PBUInt64Field uint64_qqmeet_guild_id;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56, 64, 72, 80, 88, 96, 106, 112, 120, 128, 138, 144, 152, 162, 168, 176}, new String[]{"uint64_group_code", "uint64_src_uin", "uint64_file_id", "bytes_file_md5", "uint64_file_size", "bytes_file_name", "uint32_src_term", "uint32_platform_type", "uint32_bu_type", "uint32_pic_width", "uint32_pic_height", "uint32_pic_type", "bytes_build_ver", "uint32_inner_ip", "uint32_app_pic_type", "uint32_original_pic", "bytes_file_index", "uint64_dst_uin", "uint32_srv_upload", "bytes_transfer_url", "uint64_qqmeet_guild_id", "uint64_qqmeet_channel_id"}, new Object[]{0L, 0L, 0L, byteStringMicro, 0L, byteStringMicro, 0, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, 0, byteStringMicro, 0L, 0, byteStringMicro, 0L, 0L}, cmd0x388$TryUpImgReq.class);
    }

    public cmd0x388$TryUpImgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_file_size = PBField.initUInt64(0L);
        this.bytes_file_name = PBField.initBytes(byteStringMicro);
        this.uint32_src_term = PBField.initUInt32(0);
        this.uint32_platform_type = PBField.initUInt32(0);
        this.uint32_bu_type = PBField.initUInt32(0);
        this.uint32_pic_width = PBField.initUInt32(0);
        this.uint32_pic_height = PBField.initUInt32(0);
        this.uint32_pic_type = PBField.initUInt32(0);
        this.bytes_build_ver = PBField.initBytes(byteStringMicro);
        this.uint32_inner_ip = PBField.initUInt32(0);
        this.uint32_app_pic_type = PBField.initUInt32(0);
        this.uint32_original_pic = PBField.initUInt32(0);
        this.bytes_file_index = PBField.initBytes(byteStringMicro);
        this.uint64_dst_uin = PBField.initUInt64(0L);
        this.uint32_srv_upload = PBField.initUInt32(0);
        this.bytes_transfer_url = PBField.initBytes(byteStringMicro);
        this.uint64_qqmeet_guild_id = PBField.initUInt64(0L);
        this.uint64_qqmeet_channel_id = PBField.initUInt64(0L);
    }
}
