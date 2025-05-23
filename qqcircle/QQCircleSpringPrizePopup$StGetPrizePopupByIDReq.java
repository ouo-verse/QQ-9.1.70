package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSpringPrizePopup$StGetPrizePopupByIDReq extends MessageMicro<QQCircleSpringPrizePopup$StGetPrizePopupByIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"activity_info", "prize_id"}, new Object[]{null, ""}, QQCircleSpringPrizePopup$StGetPrizePopupByIDReq.class);
    public QQCircleSpringPrizePopup$StActivityInfo activity_info = new QQCircleSpringPrizePopup$StActivityInfo();
    public final PBStringField prize_id = PBField.initString("");
}
