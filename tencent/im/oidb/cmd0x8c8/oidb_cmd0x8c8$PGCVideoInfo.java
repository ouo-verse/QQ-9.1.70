package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class oidb_cmd0x8c8$PGCVideoInfo extends MessageMicro<oidb_cmd0x8c8$PGCVideoInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5;
    public final PBBytesField bytes_pic_url;
    public final PBBytesField bytes_video_md5;
    public final PBBytesField bytes_video_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_cmd0x8c8$PGCVideoInfo.class);
    }

    public oidb_cmd0x8c8$PGCVideoInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_video_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_video_url = PBField.initBytes(byteStringMicro);
        this.bytes_pic_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_pic_url = PBField.initBytes(byteStringMicro);
    }
}
