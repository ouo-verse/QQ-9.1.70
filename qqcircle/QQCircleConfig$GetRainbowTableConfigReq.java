package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleConfig$GetRainbowTableConfigReq extends MessageMicro<QQCircleConfig$GetRainbowTableConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{VipFunCallConstants.KEY_GROUP, "uid", "qua", "cookie", "version", "platform"}, new Object[]{"", "", "", "", "", 0}, QQCircleConfig$GetRainbowTableConfigReq.class);
    public final PBStringField group = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
    public final PBStringField cookie = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBInt32Field platform = PBField.initInt32(0);
}
