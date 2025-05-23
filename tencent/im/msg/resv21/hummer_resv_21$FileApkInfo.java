package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_resv_21$FileApkInfo extends MessageMicro<hummer_resv_21$FileApkInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"str_package_name", "str_version", "str_app_name", "str_icon_url"}, new Object[]{"", "", "", ""}, hummer_resv_21$FileApkInfo.class);
    public final PBStringField str_package_name = PBField.initString("");
    public final PBStringField str_version = PBField.initString("");
    public final PBStringField str_app_name = PBField.initString("");
    public final PBStringField str_icon_url = PBField.initString("");
}
