package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoQueryPiecesReq extends MessageMicro<StoragePhotoSdkVideo$VideoQueryPiecesReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_name;
    public final PBUInt32Field list_num;
    public final PBBytesField part_num_maker;
    public final PBBytesField ukey;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"ukey", "file_name", "part_num_maker", "list_num"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0}, StoragePhotoSdkVideo$VideoQueryPiecesReq.class);
    }

    public StoragePhotoSdkVideo$VideoQueryPiecesReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ukey = PBField.initBytes(byteStringMicro);
        this.file_name = PBField.initBytes(byteStringMicro);
        this.part_num_maker = PBField.initBytes(byteStringMicro);
        this.list_num = PBField.initUInt32(0);
    }
}
