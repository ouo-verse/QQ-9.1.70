package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoUploadPieceRsp extends MessageMicro<StoragePhotoSdkVideo$VideoUploadPieceRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"part_sha"}, new Object[]{ByteStringMicro.EMPTY}, StoragePhotoSdkVideo$VideoUploadPieceRsp.class);
    public final PBBytesField part_sha = PBField.initBytes(ByteStringMicro.EMPTY);
}
