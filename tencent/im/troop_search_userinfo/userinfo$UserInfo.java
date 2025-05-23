package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class userinfo$UserInfo extends MessageMicro<userinfo$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"uin", "skey", "gps", "rpt_wifi", "rpt_cell", "attr", j.T0, "bytes_client_version"}, new Object[]{0L, "", null, null, null, null, null, ByteStringMicro.EMPTY}, userinfo$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField skey = PBField.initString("");
    public userinfo$GPS gps = new MessageMicro<userinfo$GPS>() { // from class: tencent.im.troop_search_userinfo.userinfo$GPS
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_lat", "uint32_lon", "int32_alt", "type"}, new Object[]{0, 0, 0, 0}, userinfo$GPS.class);
        public final PBUInt32Field uint32_lat = PBField.initUInt32(0);
        public final PBUInt32Field uint32_lon = PBField.initUInt32(0);
        public final PBInt32Field int32_alt = PBField.initInt32(0);
        public final PBEnumField type = PBField.initEnum(0);
    };
    public final PBRepeatMessageField<userinfo$Wifi> rpt_wifi = PBField.initRepeatMessage(userinfo$Wifi.class);
    public final PBRepeatMessageField<userinfo$Cell> rpt_cell = PBField.initRepeatMessage(userinfo$Cell.class);
    public userinfo$DevAttr attr = new MessageMicro<userinfo$DevAttr>() { // from class: tencent.im.troop_search_userinfo.userinfo$DevAttr
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_imei", "str_imsi", "str_phonenum"}, new Object[]{"", "", ""}, userinfo$DevAttr.class);
        public final PBStringField str_imei = PBField.initString("");
        public final PBStringField str_imsi = PBField.initString("");
        public final PBStringField str_phonenum = PBField.initString("");
    };
    public userinfo$AppInfo app_info = new MessageMicro<userinfo$AppInfo>() { // from class: tencent.im.troop_search_userinfo.userinfo$AppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"plat_type", "str_app_version"}, new Object[]{1, ""}, userinfo$AppInfo.class);
        public final PBEnumField plat_type = PBField.initEnum(1);
        public final PBStringField str_app_version = PBField.initString("");
    };
    public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
}
