package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$VideoApplyUploadReqExtInfo extends MessageMicro<StorageNTSdkExtInfo$VideoApplyUploadReqExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"is_format_f20", "bitrate"}, new Object[]{Boolean.FALSE, 0}, StorageNTSdkExtInfo$VideoApplyUploadReqExtInfo.class);
    public final PBBoolField is_format_f20 = PBField.initBool(false);
    public final PBInt32Field bitrate = PBField.initInt32(0);
}
