package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoGetUploadRsp extends MessageMicro<StoragePhotoSdkVideo$VideoGetUploadRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_name;
    public final PBBytesField ukey;
    public final PBBytesField videoid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ukey", "videoid", "file_name"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, StoragePhotoSdkVideo$VideoGetUploadRsp.class);
    }

    public StoragePhotoSdkVideo$VideoGetUploadRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ukey = PBField.initBytes(byteStringMicro);
        this.videoid = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
    }
}
