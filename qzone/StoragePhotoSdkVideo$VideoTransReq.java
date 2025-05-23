package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$VideoTransReq extends MessageMicro<StoragePhotoSdkVideo$VideoTransReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"videoid", "trans_info"}, new Object[]{ByteStringMicro.EMPTY, null}, StoragePhotoSdkVideo$VideoTransReq.class);
    public final PBBytesField videoid = PBField.initBytes(ByteStringMicro.EMPTY);
    public StoragePhotoSdkVideo$VideoTransInfo trans_info = new StoragePhotoSdkVideo$VideoTransInfo();
}
