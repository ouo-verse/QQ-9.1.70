package tencent.im.s2c.msgtype0x210.submsgtype0x71;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x71$ReportAppInfo extends MessageMicro<Submsgtype0x71$ReportAppInfo> {
    public static final int INT32_APPSET_FIELD_NUMBER = 8;
    public static final int INT32_ICON_FLAG_FIELD_NUMBER = 11;
    public static final int INT32_ICON_TYPE_FIELD_NUMBER = 12;
    public static final int INT32_MISSION_LEVEL_FIELD_NUMBER = 19;
    public static final int INT32_NEW_FLAG_FIELD_NUMBER = 2;
    public static final int INT32_NUM_FIELD_NUMBER = 9;
    public static final int MSG_DISPLAY_DESC_FIELD_NUMBER = 20;
    public static final int MSG_VERSION_INFO_FIELD_NUMBER = 14;
    public static final int STR_ANDROID_PATH_FIELD_NUMBER = 17;
    public static final int STR_BUFFER_FIELD_NUMBER = 4;
    public static final int STR_ICON_URL_FIELD_NUMBER = 10;
    public static final int STR_IOS_PATH_FIELD_NUMBER = 18;
    public static final int STR_MISSION_FIELD_NUMBER = 7;
    public static final int STR_PATH_FIELD_NUMBER = 5;
    public static final int UINT32_ANDROID_APP_ID_FIELD_NUMBER = 15;
    public static final int UINT32_APP_ID_FIELD_NUMBER = 1;
    public static final int UINT32_DURATION_FIELD_NUMBER = 13;
    public static final int UINT32_IOS_APP_ID_FIELD_NUMBER = 16;
    public static final int UINT32_PUSH_RED_TS_FIELD_NUMBER = 6;
    public static final int UINT32_TYPE_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 64, 72, 82, 88, 96, 104, 114, 120, 128, 138, 146, 152, 162}, new String[]{"uint32_app_id", "int32_new_flag", "uint32_type", "str_buffer", "str_path", "uint32_push_red_ts", "str_mission", "int32_appset", "int32_num", "str_icon_url", "int32_icon_flag", "int32_icon_type", "uint32_duration", "msg_version_info", "uint32_android_app_id", "uint32_ios_app_id", "str_android_path", "str_ios_path", "int32_mission_level", "msg_display_desc"}, new Object[]{0, 0, 0, "", "", 0, "", 0, 0, "", 0, 0, 0, null, 0, 0, "", "", 0, null}, Submsgtype0x71$ReportAppInfo.class);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBInt32Field int32_new_flag = PBField.initInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField str_buffer = PBField.initString("");
    public final PBStringField str_path = PBField.initString("");
    public final PBUInt32Field uint32_push_red_ts = PBField.initUInt32(0);
    public final PBStringField str_mission = PBField.initString("");
    public final PBInt32Field int32_appset = PBField.initInt32(0);
    public final PBInt32Field int32_num = PBField.initInt32(0);
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBInt32Field int32_icon_flag = PBField.initInt32(0);
    public final PBInt32Field int32_icon_type = PBField.initInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public Submsgtype0x71$ReportVersion msg_version_info = new MessageMicro<Submsgtype0x71$ReportVersion>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71$ReportVersion
        public static final int BOOL_ALLVER_FIELD_NUMBER = 2;
        public static final int INT32_PLANT_ID_FIELD_NUMBER = 1;
        public static final int RPT_STR_VERSION_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"int32_plant_id", "bool_allver", "rpt_str_version"}, new Object[]{0, Boolean.FALSE, ""}, Submsgtype0x71$ReportVersion.class);
        public final PBInt32Field int32_plant_id = PBField.initInt32(0);
        public final PBBoolField bool_allver = PBField.initBool(false);
        public final PBRepeatField<String> rpt_str_version = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public final PBUInt32Field uint32_android_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ios_app_id = PBField.initUInt32(0);
    public final PBStringField str_android_path = PBField.initString("");
    public final PBStringField str_ios_path = PBField.initString("");
    public final PBInt32Field int32_mission_level = PBField.initInt32(0);
    public Submsgtype0x71$RedDisplayInfo msg_display_desc = new MessageMicro<Submsgtype0x71$RedDisplayInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71$RedDisplayInfo
        public static final int MSG_TAB_DISPLAY_INFO_FIELD_NUMBER = 2;
        public static final int RPT_MSG_RED_TYPE_INFO_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_red_type_info", "msg_tab_display_info"}, new Object[]{null, null}, Submsgtype0x71$RedDisplayInfo.class);
        public final PBRepeatMessageField<Submsgtype0x71$RedTypeInfo> rpt_msg_red_type_info = PBField.initRepeatMessage(Submsgtype0x71$RedTypeInfo.class);
        public Submsgtype0x71$RedTypeInfo msg_tab_display_info = new MessageMicro<Submsgtype0x71$RedTypeInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71$RedTypeInfo
            public static final int STR_RED_CONTENT_FIELD_NUMBER = 2;
            public static final int STR_RED_DESC_FIELD_NUMBER = 3;
            public static final int UINT32_RED_PRIORITY_FIELD_NUMBER = 4;
            public static final int UINT32_RED_TYPE_FIELD_NUMBER = 1;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_red_type", "str_red_content", "str_red_desc", "uint32_red_priority"}, new Object[]{0, "", "", 0}, Submsgtype0x71$RedTypeInfo.class);
            public final PBUInt32Field uint32_red_type = PBField.initUInt32(0);
            public final PBStringField str_red_content = PBField.initString("");
            public final PBStringField str_red_desc = PBField.initString("");
            public final PBUInt32Field uint32_red_priority = PBField.initUInt32(0);
        };
    };
}
