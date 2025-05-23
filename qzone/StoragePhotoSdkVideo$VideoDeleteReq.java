package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoDeleteReq extends MessageMicro<StoragePhotoSdkVideo$VideoDeleteReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_name;
    public final PBBytesField sign;
    public final PBBytesField videoid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"videoid", "file_name", "sign"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, StoragePhotoSdkVideo$VideoDeleteReq.class);
    }

    public StoragePhotoSdkVideo$VideoDeleteReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.videoid = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
        this.sign = PBField.initBytes(byteStringMicro);
    }
}
