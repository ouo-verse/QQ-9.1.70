package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSwitch$GetCirclePopupSwitchRsp extends MessageMicro<QQCircleSwitch$GetCirclePopupSwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"enable", "popup"}, new Object[]{"", null}, QQCircleSwitch$GetCirclePopupSwitchRsp.class);
    public final PBStringField enable = PBField.initString("");
    public QQCircleSwitch$StPopup popup = new MessageMicro<QQCircleSwitch$StPopup>() { // from class: qqcircle.QQCircleSwitch$StPopup
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"title", "tips", "subtitle"}, new Object[]{"", "", ""}, QQCircleSwitch$StPopup.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField tips = PBField.initString("");
        public final PBStringField subtitle = PBField.initString("");
    };
}
