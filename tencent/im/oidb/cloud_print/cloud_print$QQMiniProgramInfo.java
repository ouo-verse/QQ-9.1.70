package tencent.im.oidb.cloud_print;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class cloud_print$QQMiniProgramInfo extends MessageMicro<cloud_print$QQMiniProgramInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"qqmini_appid", "qqmini_name"}, new Object[]{"", ""}, cloud_print$QQMiniProgramInfo.class);
    public final PBStringField qqmini_appid = PBField.initString("");
    public final PBStringField qqmini_name = PBField.initString("");
}
