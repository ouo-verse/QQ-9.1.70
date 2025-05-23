package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CameraEmotionRoaming_sso$UploadImgInfo extends MessageMicro<CameraEmotionRoaming_sso$UploadImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_img_md5;
    public final PBBytesField bytes_img_other;
    public final PBUInt32Field uint32_img_height;
    public final PBUInt32Field uint32_img_width;
    public final PBUInt64Field uint64_img_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"bytes_img_md5", "uint32_img_width", "uint32_img_height", "uint64_img_size", "bytes_img_other"}, new Object[]{byteStringMicro, 0, 0, 0L, byteStringMicro}, CameraEmotionRoaming_sso$UploadImgInfo.class);
    }

    public CameraEmotionRoaming_sso$UploadImgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_img_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_img_width = PBField.initUInt32(0);
        this.uint32_img_height = PBField.initUInt32(0);
        this.uint64_img_size = PBField.initUInt64(0L);
        this.bytes_img_other = PBField.initBytes(byteStringMicro);
    }
}
