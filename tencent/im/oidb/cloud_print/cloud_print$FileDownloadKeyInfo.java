package tencent.im.oidb.cloud_print;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cloud_print$FileDownloadKeyInfo extends MessageMicro<cloud_print$FileDownloadKeyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key_name", "key_content"}, new Object[]{"", ""}, cloud_print$FileDownloadKeyInfo.class);
    public final PBStringField key_name = PBField.initString("");
    public final PBStringField key_content = PBField.initString("");
}
