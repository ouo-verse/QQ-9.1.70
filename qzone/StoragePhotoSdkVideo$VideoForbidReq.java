package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoForbidReq extends MessageMicro<StoragePhotoSdkVideo$VideoForbidReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_name;
    public final PBUInt32Field flag;
    public final PBBytesField sign;
    public final PBBytesField videoid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"videoid", "file_name", "flag", "sign"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro}, StoragePhotoSdkVideo$VideoForbidReq.class);
    }

    public StoragePhotoSdkVideo$VideoForbidReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.videoid = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
        this.flag = PBField.initUInt32(0);
        this.sign = PBField.initBytes(byteStringMicro);
    }
}
