package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSwitch$GetCircleTabBucketReq extends MessageMicro<QQCircleSwitch$GetCircleTabBucketReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"userIp", "lbsData"}, new Object[]{"", null}, QQCircleSwitch$GetCircleTabBucketReq.class);
    public final PBStringField userIp = PBField.initString("");
    public QQCircleSwitch$LBSData lbsData = new MessageMicro<QQCircleSwitch$LBSData>() { // from class: qqcircle.QQCircleSwitch$LBSData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"stCommon", "stGps", "vCellData", "vWifiData"}, new Object[]{null, null, null, null}, QQCircleSwitch$LBSData.class);
        public QQCircleSwitch$ReqCommon_V2 stCommon = new MessageMicro<QQCircleSwitch$ReqCommon_V2>() { // from class: qqcircle.QQCircleSwitch$ReqCommon_V2
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"iAppId", "iDeviceType"}, new Object[]{0, 0}, QQCircleSwitch$ReqCommon_V2.class);
            public final PBInt32Field iAppId = PBField.initInt32(0);
            public final PBInt32Field iDeviceType = PBField.initInt32(0);
        };
        public QQCircleSwitch$GPS_V2 stGps = new MessageMicro<QQCircleSwitch$GPS_V2>() { // from class: qqcircle.QQCircleSwitch$GPS_V2
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"iLat", "iLon", "eType", "iAlt"}, new Object[]{0, 0, 0, 0}, QQCircleSwitch$GPS_V2.class);
            public final PBInt32Field iLat = PBField.initInt32(0);
            public final PBInt32Field iLon = PBField.initInt32(0);
            public final PBInt32Field eType = PBField.initInt32(0);
            public final PBInt32Field iAlt = PBField.initInt32(0);
        };
        public final PBRepeatMessageField<QQCircleSwitch$Cell_V2> vCellData = PBField.initRepeatMessage(QQCircleSwitch$Cell_V2.class);
        public final PBRepeatMessageField<QQCircleSwitch$Wifi_V2> vWifiData = PBField.initRepeatMessage(QQCircleSwitch$Wifi_V2.class);
    };
}
