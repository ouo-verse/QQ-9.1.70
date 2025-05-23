package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePendant$BuyPendantReq extends MessageMicro<QQCirclePendant$BuyPendantReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pendantKey"}, new Object[]{""}, QQCirclePendant$BuyPendantReq.class);
    public final PBStringField pendantKey = PBField.initString("");
}
