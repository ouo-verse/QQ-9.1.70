package tencent.im.qqgame;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameCheckDownload$SsoCheckEnvReq extends MessageMicro<QQGameCheckDownload$SsoCheckEnvReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48}, new String[]{"app_id", "version_code", AppConstants.Preferences.QQ_VERSION, "android_version", "device_model", "disk_remaining_space"}, new Object[]{"", 0, "", "", "", 0L}, QQGameCheckDownload$SsoCheckEnvReq.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBInt32Field version_code = PBField.initInt32(0);
    public final PBStringField qq_version = PBField.initString("");
    public final PBStringField android_version = PBField.initString("");
    public final PBStringField device_model = PBField.initString("");
    public final PBInt64Field disk_remaining_space = PBField.initInt64(0);
}
