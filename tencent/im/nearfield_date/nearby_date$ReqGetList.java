package tencent.im.nearfield_date;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_date$ReqGetList extends MessageMicro<nearby_date$ReqGetList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 74}, new String[]{"msg_head", "msg_lbs_info", "uint32_time", "uint32_subject", "uint32_gender", "uint32_age_low", "uint32_age_up", "uint32_profession", "bytes_cookie"}, new Object[]{null, null, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY}, nearby_date$ReqGetList.class);
    public nearby_date$BusiReqHead msg_head = new MessageMicro<nearby_date$BusiReqHead>() { // from class: tencent.im.nearfield_date.nearby_date$BusiReqHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_version", "int32_seq"}, new Object[]{1, 0}, nearby_date$BusiReqHead.class);
        public final PBInt32Field int32_version = PBField.initInt32(1);
        public final PBInt32Field int32_seq = PBField.initInt32(0);
    };
    public nearby_date$LBSInfo msg_lbs_info = new MessageMicro<nearby_date$LBSInfo>() { // from class: tencent.im.nearfield_date.nearby_date$LBSInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_gps", "rpt_msg_wifis", "rpt_msg_cells"}, new Object[]{null, null, null}, nearby_date$LBSInfo.class);
        public nearby_date$GPS msg_gps = new MessageMicro<nearby_date$GPS>() { // from class: tencent.im.nearfield_date.nearby_date$GPS
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int32_lat", "int32_lon", "int32_alt", "eType"}, new Object[]{900000000, 900000000, -10000000, 0}, nearby_date$GPS.class);
            public final PBInt32Field int32_lat = PBField.initInt32(900000000);
            public final PBInt32Field int32_lon = PBField.initInt32(900000000);
            public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
            public final PBEnumField eType = PBField.initEnum(0);
        };
        public final PBRepeatMessageField<nearby_date$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(nearby_date$Wifi.class);
        public final PBRepeatMessageField<nearby_date$Cell> rpt_msg_cells = PBField.initRepeatMessage(nearby_date$Cell.class);
    };
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subject = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age_low = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age_up = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
