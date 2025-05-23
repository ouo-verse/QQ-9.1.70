package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MqqLbs$LBSInfo extends MessageMicro<MqqLbs$LBSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_gps", "rpt_msg_wifis", "rpt_msg_cells"}, new Object[]{null, null, null}, MqqLbs$LBSInfo.class);
    public MqqLbs$GPS msg_gps = new MessageMicro<MqqLbs$GPS>() { // from class: tencent.im.oidb.olympic.MqqLbs$GPS
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"int32_lat", "int32_lon", "int32_alt", "int32_type", "uint32_precision", "str_addr"}, new Object[]{900000000, 900000000, -10000000, 0, 0, ""}, MqqLbs$GPS.class);
        public final PBInt32Field int32_lat = PBField.initInt32(900000000);
        public final PBInt32Field int32_lon = PBField.initInt32(900000000);
        public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
        public final PBInt32Field int32_type = PBField.initInt32(0);
        public final PBUInt32Field uint32_precision = PBField.initUInt32(0);
        public final PBStringField str_addr = PBField.initString("");
    };
    public final PBRepeatMessageField<MqqLbs$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(MqqLbs$Wifi.class);
    public final PBRepeatMessageField<MqqLbs$Cell> rpt_msg_cells = PBField.initRepeatMessage(MqqLbs$Cell.class);
}
