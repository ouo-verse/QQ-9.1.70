package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSpringPrizePopup$StGetPrizePopupReq extends MessageMicro<QQCircleSpringPrizePopup$StGetPrizePopupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"popup_scene", "activity_info", "id"}, new Object[]{0, null, ""}, QQCircleSpringPrizePopup$StGetPrizePopupReq.class);
    public final PBInt32Field popup_scene = PBField.initInt32(0);
    public QQCircleSpringPrizePopup$StActivityInfo activity_info = new QQCircleSpringPrizePopup$StActivityInfo();

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429314id = PBField.initString("");
}
