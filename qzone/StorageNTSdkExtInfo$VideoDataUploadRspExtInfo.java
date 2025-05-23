package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StorageNTSdkExtInfo$VideoDataUploadRspExtInfo extends MessageMicro<StorageNTSdkExtInfo$VideoDataUploadRspExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"videoid", "file_name", "upload_retcode", "url"}, new Object[]{"", "", 0, ""}, StorageNTSdkExtInfo$VideoDataUploadRspExtInfo.class);
    public final PBStringField videoid = PBField.initString("");
    public final PBStringField file_name = PBField.initString("");
    public final PBSInt32Field upload_retcode = PBField.initSInt32(0);
    public final PBStringField url = PBField.initString("");
}
