package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkVideo$TimeLineInfo extends MessageMicro<StoragePhotoSdkVideo$TimeLineInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField start = PBField.initFloat(0.0f);
    public final PBFloatField duration = PBField.initFloat(0.0f);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21}, new String[]{"start", "duration"}, new Object[]{valueOf, valueOf}, StoragePhotoSdkVideo$TimeLineInfo.class);
    }
}
