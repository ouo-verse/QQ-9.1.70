package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* loaded from: classes29.dex */
public final class QZoneBaseMeta$TimeLineReqParam extends MessageMicro<QZoneBaseMeta$TimeLineReqParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "event"}, new Object[]{0, null}, QZoneBaseMeta$TimeLineReqParam.class);
    public final PBEnumField type = PBField.initEnum(0);
    public QZoneBaseMeta$StTimeLineEvent event = new MessageMicro<QZoneBaseMeta$StTimeLineEvent>() { // from class: qzone.QZoneBaseMeta$StTimeLineEvent
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField title = PBField.initString("");
        public final PBStringField content = PBField.initString("");
        public final PBStringField attach_info = PBField.initString("");
        public final PBInt64Field begin_time = PBField.initInt64(0);
        public final PBInt64Field end_time = PBField.initInt64(0);
        public final PBEnumField binding_type = PBField.initEnum(0);
        public final PBBoolField disable = PBField.initBool(false);
        public final PBUInt32Field item_count = PBField.initUInt32(0);
        public final PBBoolField is_special_day_node = PBField.initBool(false);

        static {
            String[] strArr = {"type", "title", "content", "attach_info", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", "binding_type", "disable", "item_count", "is_special_day_node"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 48, 56, 72, 80, 96, 104}, strArr, new Object[]{0, "", "", "", 0L, 0L, 0, bool, 0, bool}, QZoneBaseMeta$StTimeLineEvent.class);
        }
    };
}
