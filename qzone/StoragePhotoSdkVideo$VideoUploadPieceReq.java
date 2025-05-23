package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoUploadPieceReq extends MessageMicro<StoragePhotoSdkVideo$VideoUploadPieceReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_name;
    public final PBBytesField part_data;
    public final PBUInt32Field part_num;
    public final PBBytesField part_sha;
    public final PBBytesField ukey;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"ukey", "file_name", "part_num", "part_data", "part_sha"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro}, StoragePhotoSdkVideo$VideoUploadPieceReq.class);
    }

    public StoragePhotoSdkVideo$VideoUploadPieceReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ukey = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
        this.part_num = PBField.initUInt32(0);
        this.part_data = PBField.initBytes(byteStringMicro);
        this.part_sha = PBField.initBytes(byteStringMicro);
    }
}
