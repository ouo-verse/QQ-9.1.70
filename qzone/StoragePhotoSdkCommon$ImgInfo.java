package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkCommon$ImgInfo extends MessageMicro<StoragePhotoSdkCommon$ImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field img_class;
    public final PBUInt32Field img_height;
    public final PBBytesField img_md5;
    public final PBUInt32Field img_size;
    public final PBUInt32Field img_type;
    public final PBStringField img_url;
    public final PBUInt32Field img_width;
    public final PBBytesField lloccode;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 66}, new String[]{"lloccode", "img_class", "img_size", "img_width", "img_height", "img_type", "img_md5", "img_url"}, new Object[]{byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, ""}, StoragePhotoSdkCommon$ImgInfo.class);
    }

    public StoragePhotoSdkCommon$ImgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.lloccode = PBField.initBytes(byteStringMicro);
        this.img_class = PBField.initUInt32(0);
        this.img_size = PBField.initUInt32(0);
        this.img_width = PBField.initUInt32(0);
        this.img_height = PBField.initUInt32(0);
        this.img_type = PBField.initUInt32(0);
        this.img_md5 = PBField.initBytes(byteStringMicro);
        this.img_url = PBField.initString("");
    }
}
