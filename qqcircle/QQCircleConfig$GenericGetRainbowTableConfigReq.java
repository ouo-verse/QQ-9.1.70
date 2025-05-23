package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleConfig$GenericGetRainbowTableConfigReq extends MessageMicro<QQCircleConfig$GenericGetRainbowTableConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"appId", VipFunCallConstants.KEY_GROUP, "cookie", "getOpts"}, new Object[]{"", "", "", null}, QQCircleConfig$GenericGetRainbowTableConfigReq.class);
    public final PBStringField appId = PBField.initString("");
    public final PBStringField group = PBField.initString("");
    public final PBStringField cookie = PBField.initString("");
    public final PBRepeatMessageField<QQCircleConfig$GetOpt> getOpts = PBField.initRepeatMessage(QQCircleConfig$GetOpt.class);
}
