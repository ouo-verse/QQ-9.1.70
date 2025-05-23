package tencent.im.lbs;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class member_lbs$ReqBody extends MessageMicro<member_lbs$ReqBody> {
    public static final int BOOL_NEED_NEIGHBOURS_FIELD_NUMBER = 4;
    public static final int MSG_LBSINFO_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"msg_lbsinfo", "uint64_group_code", "uint64_uin", "bool_need_neighbours"}, new Object[]{null, 0L, 0L, Boolean.FALSE}, member_lbs$ReqBody.class);
    public member_lbs$LBSInfo msg_lbsinfo = new MessageMicro<member_lbs$LBSInfo>() { // from class: tencent.im.lbs.member_lbs$LBSInfo
        public static final int INT64_PRECISION_FIELD_NUMBER = 6;
        public static final int MSG_ATTR_FIELD_NUMBER = 5;
        public static final int MSG_GPS_FIELD_NUMBER = 1;
        public static final int RPT_MSG_CELLS_FIELD_NUMBER = 3;
        public static final int RPT_MSG_WIFIS_FIELD_NUMBER = 2;
        public static final int UINT32_IP_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 37, 42, 48}, new String[]{"msg_gps", "rpt_msg_wifis", "rpt_msg_cells", "uint32_ip", "msg_attr", "int64_precision"}, new Object[]{null, null, null, 0, null, 0L}, member_lbs$LBSInfo.class);
        public member_lbs$GPS msg_gps = new MessageMicro<member_lbs$GPS>() { // from class: tencent.im.lbs.member_lbs$GPS
            public static final int INT64_ALTITUDE_FIELD_NUMBER = 3;
            public static final int INT64_LATITUDE_FIELD_NUMBER = 1;
            public static final int INT64_LONGITUDE_FIELD_NUMBER = 2;
            public static final int UINT32_GPS_TYPE_FIELD_NUMBER = 4;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int64_latitude", "int64_longitude", "int64_altitude", "uint32_gps_type"}, new Object[]{0L, 0L, 0L, 0}, member_lbs$GPS.class);
            public final PBInt64Field int64_latitude = PBField.initInt64(0);
            public final PBInt64Field int64_longitude = PBField.initInt64(0);
            public final PBInt64Field int64_altitude = PBField.initInt64(0);
            public final PBUInt32Field uint32_gps_type = PBField.initUInt32(0);
        };
        public final PBRepeatMessageField<member_lbs$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(member_lbs$Wifi.class);
        public final PBRepeatMessageField<member_lbs$Cell> rpt_msg_cells = PBField.initRepeatMessage(member_lbs$Cell.class);
        public final PBFixed32Field uint32_ip = PBField.initFixed32(0);
        public member_lbs$Attr msg_attr = new MessageMicro<member_lbs$Attr>() { // from class: tencent.im.lbs.member_lbs$Attr
            public static final int STR_IMEI_FIELD_NUMBER = 1;
            public static final int STR_IMSI_FIELD_NUMBER = 2;
            public static final int STR_PHONE_NUM_FIELD_NUMBER = 3;
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField str_imei;
            public final PBBytesField str_imsi;
            public final PBBytesField str_phone_num;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_imei", "str_imsi", "str_phone_num"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, member_lbs$Attr.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.str_imei = PBField.initBytes(byteStringMicro);
                this.str_imsi = PBField.initBytes(byteStringMicro);
                this.str_phone_num = PBField.initBytes(byteStringMicro);
            }
        };
        public final PBInt64Field int64_precision = PBField.initInt64(0);
    };
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBoolField bool_need_neighbours = PBField.initBool(false);
}
