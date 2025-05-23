package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoQueryPiecesRsp extends MessageMicro<StoragePhotoSdkVideo$VideoQueryPiecesRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField next_maker;
    public final PBRepeatMessageField<StoragePhotoSdkVideo$VideoPartInfo> part_infos;
    public final PBBytesField ukey;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ukey", "part_infos", "next_maker"}, new Object[]{byteStringMicro, null, byteStringMicro}, StoragePhotoSdkVideo$VideoQueryPiecesRsp.class);
    }

    public StoragePhotoSdkVideo$VideoQueryPiecesRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ukey = PBField.initBytes(byteStringMicro);
        this.part_infos = PBField.initRepeatMessage(StoragePhotoSdkVideo$VideoPartInfo.class);
        this.next_maker = PBField.initBytes(byteStringMicro);
    }
}
