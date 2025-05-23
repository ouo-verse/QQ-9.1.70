package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkCommon$TimeRangeInfo extends MessageMicro<StoragePhotoSdkCommon$TimeRangeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"time_range", "total_photo", "photo_infos"}, new Object[]{null, 0, null}, StoragePhotoSdkCommon$TimeRangeInfo.class);
    public StoragePhotoSdkCommon$TimeRange time_range = new MessageMicro<StoragePhotoSdkCommon$TimeRange>() { // from class: qzone.StoragePhotoSdkCommon$TimeRange
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"time_begin", "time_end"}, new Object[]{0, 0}, StoragePhotoSdkCommon$TimeRange.class);
        public final PBUInt32Field time_begin = PBField.initUInt32(0);
        public final PBUInt32Field time_end = PBField.initUInt32(0);
    };
    public final PBUInt32Field total_photo = PBField.initUInt32(0);
    public final PBRepeatMessageField<StoragePhotoSdkCommon$StoragePhotoInfo> photo_infos = PBField.initRepeatMessage(StoragePhotoSdkCommon$StoragePhotoInfo.class);
}
