package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$ExifInfo extends MessageMicro<StorageNTSdkExtInfo$ExifInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"camera_maker", "camera_model", "time", "latitude_ref", "latitude", "longitude_ref", "longitude"}, new Object[]{"", "", "", "", "", "", ""}, StorageNTSdkExtInfo$ExifInfo.class);
    public final PBStringField camera_maker = PBField.initString("");
    public final PBStringField camera_model = PBField.initString("");
    public final PBStringField time = PBField.initString("");
    public final PBStringField latitude_ref = PBField.initString("");
    public final PBStringField latitude = PBField.initString("");
    public final PBStringField longitude_ref = PBField.initString("");
    public final PBStringField longitude = PBField.initString("");
}
