package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleConfig$GetRainbowKVConfReq extends MessageMicro<QQCircleConfig$GetRainbowKVConfReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"appId", VipFunCallConstants.KEY_GROUP, "key", "cookie"}, new Object[]{"", "", "", ""}, QQCircleConfig$GetRainbowKVConfReq.class);
    public final PBStringField appId = PBField.initString("");
    public final PBStringField group = PBField.initString("");
    public final PBStringField key = PBField.initString("");
    public final PBStringField cookie = PBField.initString("");
}
