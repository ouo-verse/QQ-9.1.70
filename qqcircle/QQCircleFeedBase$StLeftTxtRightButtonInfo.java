package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StLeftTxtRightButtonInfo extends MessageMicro<QQCircleFeedBase$StLeftTxtRightButtonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"txtInfo", "buttonInfo"}, new Object[]{null, null}, QQCircleFeedBase$StLeftTxtRightButtonInfo.class);
    public QQCircleFeedBase$StNoticeTxtInfo txtInfo = new QQCircleFeedBase$StNoticeTxtInfo();
    public QQCircleFeedBase$StNoticeButtonInfo buttonInfo = new MessageMicro<QQCircleFeedBase$StNoticeButtonInfo>() { // from class: qqcircle.QQCircleFeedBase$StNoticeButtonInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"name", "actionType", "schemaUrl"}, new Object[]{"", 0, ""}, QQCircleFeedBase$StNoticeButtonInfo.class);
        public final PBStringField name = PBField.initString("");
        public final PBUInt32Field actionType = PBField.initUInt32(0);
        public final PBStringField schemaUrl = PBField.initString("");
    };
}
