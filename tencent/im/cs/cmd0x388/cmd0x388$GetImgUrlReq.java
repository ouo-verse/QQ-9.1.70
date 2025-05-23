package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$GetImgUrlReq extends MessageMicro<cmd0x388$GetImgUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver;
    public final PBBytesField bytes_download_index;
    public final PBBytesField bytes_file_md5;
    public final PBUInt32Field uint32_bu_type;
    public final PBUInt32Field uint32_file_height;
    public final PBUInt32Field uint32_file_width;
    public final PBUInt32Field uint32_inner_ip;
    public final PBUInt32Field uint32_original_pic;
    public final PBUInt32Field uint32_pic_type;
    public final PBUInt32Field uint32_pic_up_timestamp;
    public final PBUInt32Field uint32_req_platform_type;
    public final PBUInt32Field uint32_req_term;
    public final PBUInt32Field uint32_req_transfer_type;
    public final PBUInt32Field uint32_retry_req;
    public final PBUInt32Field uint32_url_flag;
    public final PBUInt32Field uint32_url_type;
    public final PBUInt64Field uint64_file_id;
    public final PBUInt64Field uint64_file_size;
    public final PBUInt64Field uint64_qqmeet_channel_id;
    public final PBUInt64Field uint64_qqmeet_guild_id;
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 72, 80, 90, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 186}, new String[]{"uint64_group_code", "uint64_dst_uin", "uint64_fileid", "bytes_file_md5", "uint32_url_flag", "uint32_url_type", "uint32_req_term", "uint32_req_platform_type", "uint32_inner_ip", "uint32_bu_type", "bytes_build_ver", "uint64_file_id", "uint64_file_size", "uint32_original_pic", "uint32_retry_req", "uint32_file_height", "uint32_file_width", "uint32_pic_type", "uint32_pic_up_timestamp", "uint32_req_transfer_type", "uint64_qqmeet_guild_id", "uint64_qqmeet_channel_id", "bytes_download_index"}, new Object[]{0L, 0L, 0L, byteStringMicro, 0, 0, 0, 0, 0, 0, byteStringMicro, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, byteStringMicro}, cmd0x388$GetImgUrlReq.class);
    }

    public cmd0x388$GetImgUrlReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_url_flag = PBField.initUInt32(0);
        this.uint32_url_type = PBField.initUInt32(0);
        this.uint32_req_term = PBField.initUInt32(0);
        this.uint32_req_platform_type = PBField.initUInt32(0);
        this.uint32_inner_ip = PBField.initUInt32(0);
        this.uint32_bu_type = PBField.initUInt32(0);
        this.bytes_build_ver = PBField.initBytes(byteStringMicro);
        this.uint64_file_id = PBField.initUInt64(0L);
        this.uint64_file_size = PBField.initUInt64(0L);
        this.uint32_original_pic = PBField.initUInt32(0);
        this.uint32_retry_req = PBField.initUInt32(0);
        this.uint32_file_height = PBField.initUInt32(0);
        this.uint32_file_width = PBField.initUInt32(0);
        this.uint32_pic_type = PBField.initUInt32(0);
        this.uint32_pic_up_timestamp = PBField.initUInt32(0);
        this.uint32_req_transfer_type = PBField.initUInt32(0);
        this.uint64_qqmeet_guild_id = PBField.initUInt64(0L);
        this.uint64_qqmeet_channel_id = PBField.initUInt64(0L);
        this.bytes_download_index = PBField.initBytes(byteStringMicro);
    }
}
