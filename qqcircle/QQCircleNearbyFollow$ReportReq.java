package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleNearbyFollow$ReportReq extends MessageMicro<QQCircleNearbyFollow$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"coordinate"}, new Object[]{null}, QQCircleNearbyFollow$ReportReq.class);
    public QQCircleNearbyFollow$Coordinate coordinate = new MessageMicro<QQCircleNearbyFollow$Coordinate>() { // from class: qqcircle.QQCircleNearbyFollow$Coordinate
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBDoubleField longitude = PBField.initDouble(0.0d);
        public final PBDoubleField latitude = PBField.initDouble(0.0d);

        static {
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{9, 17}, new String[]{"longitude", "latitude"}, new Object[]{valueOf, valueOf}, QQCircleNearbyFollow$Coordinate.class);
        }
    };
}
