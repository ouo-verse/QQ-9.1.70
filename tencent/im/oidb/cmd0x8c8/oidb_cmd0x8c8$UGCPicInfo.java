package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$UGCPicInfo extends MessageMicro<oidb_cmd0x8c8$UGCPicInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5;
    public final PBBytesField bytes_pic_url;
    public final PBBytesField bytes_thumbnail_url;
    public final PBUInt32Field is_animation;
    public final PBUInt32Field uint32_pic_type;
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56}, new String[]{"uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url", "bytes_thumbnail_url", "is_animation", "uint32_pic_type"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, oidb_cmd0x8c8$UGCPicInfo.class);
    }

    public oidb_cmd0x8c8$UGCPicInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pic_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_pic_url = PBField.initBytes(byteStringMicro);
        this.bytes_thumbnail_url = PBField.initBytes(byteStringMicro);
        this.is_animation = PBField.initUInt32(0);
        this.uint32_pic_type = PBField.initUInt32(0);
    }
}
