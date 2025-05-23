package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdb1$ReqBody extends MessageMicro<oidb_0xdb1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_get_search_keywords", "uint32_get_online_num", "msg_lbs_info"}, new Object[]{0, 0, null}, oidb_0xdb1$ReqBody.class);
    public final PBUInt32Field uint32_get_search_keywords = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_online_num = PBField.initUInt32(0);
    public oidb_0xdb1$LBSInfo msg_lbs_info = new MessageMicro<oidb_0xdb1$LBSInfo>() { // from class: tencent.im.oidb.cmd0xdb1.oidb_0xdb1$LBSInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_gps", "rpt_msg_wifis", "rpt_msg_cells"}, new Object[]{null, null, null}, oidb_0xdb1$LBSInfo.class);
        public oidb_0xdb1$GPS msg_gps = new MessageMicro<oidb_0xdb1$GPS>() { // from class: tencent.im.oidb.cmd0xdb1.oidb_0xdb1$GPS
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int32_lat", "int32_lon", "int32_alt", "int32_type"}, new Object[]{900000000, 900000000, -10000000, 0}, oidb_0xdb1$GPS.class);
            public final PBInt32Field int32_lat = PBField.initInt32(900000000);
            public final PBInt32Field int32_lon = PBField.initInt32(900000000);
            public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
            public final PBInt32Field int32_type = PBField.initInt32(0);
        };
        public final PBRepeatMessageField<oidb_0xdb1$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xdb1$Wifi.class);
        public final PBRepeatMessageField<oidb_0xdb1$Cell> rpt_msg_cells = PBField.initRepeatMessage(oidb_0xdb1$Cell.class);
    };
}
