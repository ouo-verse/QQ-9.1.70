package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleSwitch$GetCirclePopupRsp extends MessageMicro<QQCircleSwitch$GetCirclePopupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"popupList"}, new Object[]{null}, QQCircleSwitch$GetCirclePopupRsp.class);
    public final PBRepeatMessageField<QQCircleSwitch$StCirclePopup> popupList = PBField.initRepeatMessage(QQCircleSwitch$StCirclePopup.class);
}
