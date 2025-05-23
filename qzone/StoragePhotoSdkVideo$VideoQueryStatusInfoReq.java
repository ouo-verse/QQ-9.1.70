package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoQueryStatusInfoReq extends MessageMicro<StoragePhotoSdkVideo$VideoQueryStatusInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field auth_timeout;
    public final PBBytesField file_name;
    public final PBBytesField videoid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"videoid", "file_name", "auth_timeout"}, new Object[]{byteStringMicro, byteStringMicro, 0}, StoragePhotoSdkVideo$VideoQueryStatusInfoReq.class);
    }

    public StoragePhotoSdkVideo$VideoQueryStatusInfoReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.videoid = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
        this.auth_timeout = PBField.initUInt32(0);
    }
}
