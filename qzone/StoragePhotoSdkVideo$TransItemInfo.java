package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$TransItemInfo extends MessageMicro<StoragePhotoSdkVideo$TransItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"formatid", "params"}, new Object[]{0, ""}, StoragePhotoSdkVideo$TransItemInfo.class);
    public final PBUInt32Field formatid = PBField.initUInt32(0);
    public final PBStringField params = PBField.initString("");
}
