package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import common.config.service.QzoneConfig;

/* loaded from: classes29.dex */
public final class StoragePhotoSdkCommon$EnvInfo extends MessageMicro<StoragePhotoSdkCommon$EnvInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58}, new String[]{"net", "operators", "refer", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "source", "device_info", "qua"}, new Object[]{0, "", "", 11, 0, "", ""}, StoragePhotoSdkCommon$EnvInfo.class);
    public final PBEnumField net = PBField.initEnum(0);
    public final PBStringField operators = PBField.initString("");
    public final PBStringField refer = PBField.initString("");
    public final PBEnumField entrance = PBField.initEnum(11);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBStringField device_info = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
}
