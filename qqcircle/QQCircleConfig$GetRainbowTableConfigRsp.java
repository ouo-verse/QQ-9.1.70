package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleConfig$GetRainbowTableConfigRsp extends MessageMicro<QQCircleConfig$GetRainbowTableConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"data", "update", "cookie"}, new Object[]{"", 0, ""}, QQCircleConfig$GetRainbowTableConfigRsp.class);
    public final PBStringField data = PBField.initString("");
    public final PBInt32Field update = PBField.initInt32(0);
    public final PBStringField cookie = PBField.initString("");
}
