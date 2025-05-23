package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoPartInfo extends MessageMicro<StoragePhotoSdkVideo$VideoPartInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField part_mtime;
    public final PBUInt32Field part_num = PBField.initUInt32(0);
    public final PBBytesField part_sha;
    public final PBUInt32Field part_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"part_num", "part_sha", "part_size", "part_mtime"}, new Object[]{0, byteStringMicro, 0, byteStringMicro}, StoragePhotoSdkVideo$VideoPartInfo.class);
    }

    public StoragePhotoSdkVideo$VideoPartInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.part_sha = PBField.initBytes(byteStringMicro);
        this.part_size = PBField.initUInt32(0);
        this.part_mtime = PBField.initBytes(byteStringMicro);
    }
}
