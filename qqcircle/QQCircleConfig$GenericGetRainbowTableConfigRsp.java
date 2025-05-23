package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleConfig$GenericGetRainbowTableConfigRsp extends MessageMicro<QQCircleConfig$GenericGetRainbowTableConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"data", "update", "cookie", "fetchInterval"}, new Object[]{"", 0, "", 0}, QQCircleConfig$GenericGetRainbowTableConfigRsp.class);
    public final PBStringField data = PBField.initString("");
    public final PBInt32Field update = PBField.initInt32(0);
    public final PBStringField cookie = PBField.initString("");
    public final PBInt32Field fetchInterval = PBField.initInt32(0);
}
