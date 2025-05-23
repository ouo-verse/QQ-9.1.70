package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$UGCVideoInfo extends MessageMicro<oidb_cmd0x8c8$UGCVideoInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5;
    public final PBBytesField bytes_pic_url;
    public final PBBytesField bytes_share_url;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_uniq_id;
    public final PBBytesField bytes_uuid;
    public final PBBytesField bytes_vid;
    public final PBBytesField bytes_video_md5;
    public final PBBytesField bytes_video_url;
    public final PBUInt32Field uint32_busi_type;
    public final PBUInt32Field uint32_create_time;
    public final PBUInt32Field uint32_pic_height;
    public final PBUInt32Field uint32_pic_width;
    public final PBUInt32Field uint32_video_height;
    public final PBUInt32Field uint32_video_width;
    public final PBUInt64Field uint64_duration;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 88, 98, 104, 114, 120, 130}, new String[]{"bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url", "bytes_title", "bytes_uuid", "uint64_duration", "uint32_video_width", "uint32_video_height", "uint32_pic_width", "uint32_pic_height", "bytes_uniq_id", "uint32_create_time", "bytes_share_url", "uint32_busi_type", "bytes_vid"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0, 0, 0, 0, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro}, oidb_cmd0x8c8$UGCVideoInfo.class);
    }

    public oidb_cmd0x8c8$UGCVideoInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_video_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_video_url = PBField.initBytes(byteStringMicro);
        this.bytes_pic_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_pic_url = PBField.initBytes(byteStringMicro);
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_uuid = PBField.initBytes(byteStringMicro);
        this.uint64_duration = PBField.initUInt64(0L);
        this.uint32_video_width = PBField.initUInt32(0);
        this.uint32_video_height = PBField.initUInt32(0);
        this.uint32_pic_width = PBField.initUInt32(0);
        this.uint32_pic_height = PBField.initUInt32(0);
        this.bytes_uniq_id = PBField.initBytes(byteStringMicro);
        this.uint32_create_time = PBField.initUInt32(0);
        this.bytes_share_url = PBField.initBytes(byteStringMicro);
        this.uint32_busi_type = PBField.initUInt32(0);
        this.bytes_vid = PBField.initBytes(byteStringMicro);
    }
}
