package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class C2CType0x211_SubC2CType0x8$NearfieldInfo extends MessageMicro<C2CType0x211_SubC2CType0x8$NearfieldInfo> {
    public static final int BYTES_EXTRA_FIELD_NUMBER = 6;
    public static final int MSG_CONN_TYPE_FIELD_NUMBER = 2;
    public static final int MSG_IP_INFO_FIELD_NUMBER = 3;
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 1;
    public static final int MSG_WIFI_ABI_FIELD_NUMBER = 5;
    public static final int MSG_WIFI_DETAIL_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"msg_lbs_info", "msg_conn_type", "msg_ip_info", "msg_wifi_detail", "msg_wifi_abi", "bytes_extra"}, new Object[]{null, null, null, null, null, ByteStringMicro.EMPTY}, C2CType0x211_SubC2CType0x8$NearfieldInfo.class);
    public C2CType0x211_SubC2CType0x8$LBSInfo msg_lbs_info = new MessageMicro<C2CType0x211_SubC2CType0x8$LBSInfo>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$LBSInfo
        public static final int MSG_GPS_FIELD_NUMBER = 1;
        public static final int RPT_MSG_CELLS_FIELD_NUMBER = 3;
        public static final int RPT_MSG_WIFIS_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_gps", "rpt_msg_wifis", "rpt_msg_cells"}, new Object[]{null, null, null}, C2CType0x211_SubC2CType0x8$LBSInfo.class);
        public C2CType0x211_SubC2CType0x8$GPS msg_gps = new MessageMicro<C2CType0x211_SubC2CType0x8$GPS>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$GPS
            public static final int ETYPE_FIELD_NUMBER = 4;
            public static final int INT32_ALT_FIELD_NUMBER = 3;
            public static final int INT32_LAT_FIELD_NUMBER = 1;
            public static final int INT32_LON_FIELD_NUMBER = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int32_lat", "int32_lon", "int32_alt", "eType"}, new Object[]{900000000, 900000000, -10000000, 0}, C2CType0x211_SubC2CType0x8$GPS.class);
            public final PBInt32Field int32_lat = PBField.initInt32(900000000);
            public final PBInt32Field int32_lon = PBField.initInt32(900000000);
            public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
            public final PBEnumField eType = PBField.initEnum(0);
        };
        public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8$Wifi> rpt_msg_wifis = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8$Wifi.class);
        public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8$Cell> rpt_msg_cells = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8$Cell.class);
    };
    public C2CType0x211_SubC2CType0x8$ConnType msg_conn_type = new MessageMicro<C2CType0x211_SubC2CType0x8$ConnType>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$ConnType
        public static final int STR_DESRIPTION_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "str_desription"}, new Object[]{1, ""}, C2CType0x211_SubC2CType0x8$ConnType.class);
        public final PBEnumField type = PBField.initEnum(1);
        public final PBStringField str_desription = PBField.initString("");
    };
    public C2CType0x211_SubC2CType0x8$IPAddrInfo msg_ip_info = new MessageMicro<C2CType0x211_SubC2CType0x8$IPAddrInfo>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$IPAddrInfo
        public static final int INT32_GATEWAY_FIELD_NUMBER = 3;
        public static final int INT32_IP_FIELD_NUMBER = 1;
        public static final int INT32_MASK_FIELD_NUMBER = 2;
        public static final int INT32_PORT_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int32_ip", "int32_mask", "int32_gateway", "int32_port"}, new Object[]{0, 0, 0, 0}, C2CType0x211_SubC2CType0x8$IPAddrInfo.class);
        public final PBInt32Field int32_ip = PBField.initInt32(0);
        public final PBInt32Field int32_mask = PBField.initInt32(0);
        public final PBInt32Field int32_gateway = PBField.initInt32(0);
        public final PBInt32Field int32_port = PBField.initInt32(0);
    };
    public C2CType0x211_SubC2CType0x8$WifiDetailInfo msg_wifi_detail = new MessageMicro<C2CType0x211_SubC2CType0x8$WifiDetailInfo>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$WifiDetailInfo
        public static final int BOOL_SELF_ESTABLISH_FIELD_NUMBER = 1;
        public static final int STR_MAC_FIELD_NUMBER = 3;
        public static final int STR_SSID_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"bool_self_establish", "str_ssid", "str_mac"}, new Object[]{Boolean.FALSE, "", ""}, C2CType0x211_SubC2CType0x8$WifiDetailInfo.class);
        public final PBBoolField bool_self_establish = PBField.initBool(false);
        public final PBStringField str_ssid = PBField.initString("");
        public final PBStringField str_mac = PBField.initString("");
    };
    public C2CType0x211_SubC2CType0x8$WifiAbility msg_wifi_abi = new MessageMicro<C2CType0x211_SubC2CType0x8$WifiAbility>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$WifiAbility
        public static final int BOOL_AUTO_CONNECT_ABI_FIELD_NUMBER = 2;
        public static final int BOOL_ESTABLISH_ABI_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_establish_abi = PBField.initBool(false);
        public final PBBoolField bool_auto_connect_abi = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"bool_establish_abi", "bool_auto_connect_abi"}, new Object[]{bool, bool}, C2CType0x211_SubC2CType0x8$WifiAbility.class);
        }
    };
    public final PBBytesField bytes_extra = PBField.initBytes(ByteStringMicro.EMPTY);
}
