package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleBase$StAppInfo extends MessageMicro<QQCircleBase$StAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"app_version", "qua", "platform"}, new Object[]{"", "", ""}, QQCircleBase$StAppInfo.class);
    public final PBStringField app_version = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
}
