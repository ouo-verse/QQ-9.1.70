package qzone;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkCommon$PhotoPath extends MessageMicro<StoragePhotoSdkCommon$PhotoPath> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField albumid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> lloccodes = PBField.initRepeat(PBBytesField.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"albumid", "lloccodes"}, new Object[]{byteStringMicro, byteStringMicro}, StoragePhotoSdkCommon$PhotoPath.class);
    }
}
