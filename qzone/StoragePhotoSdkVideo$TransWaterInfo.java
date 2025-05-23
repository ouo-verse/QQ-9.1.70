package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$TransWaterInfo extends MessageMicro<StoragePhotoSdkVideo$TransWaterInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"trans_codes", "water_image", "water_text"}, new Object[]{0, null, null}, StoragePhotoSdkVideo$TransWaterInfo.class);
    public final PBUInt32Field trans_codes = PBField.initUInt32(0);
    public final PBRepeatMessageField<StoragePhotoSdkVideo$TransWaterImageInfo> water_image = PBField.initRepeatMessage(StoragePhotoSdkVideo$TransWaterImageInfo.class);
    public final PBRepeatMessageField<StoragePhotoSdkVideo$TransWaterTextInfo> water_text = PBField.initRepeatMessage(StoragePhotoSdkVideo$TransWaterTextInfo.class);
}
