package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSpringPrizePopup$StTurnOffPrizePopupReq extends MessageMicro<QQCircleSpringPrizePopup$StTurnOffPrizePopupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"popup_id"}, new Object[]{""}, QQCircleSpringPrizePopup$StTurnOffPrizePopupReq.class);
    public final PBStringField popup_id = PBField.initString("");
}
