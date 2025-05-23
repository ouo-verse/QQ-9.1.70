package tencent.im.troop.activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class troopactivity$Activity extends MessageMicro<troopactivity$Activity> {
    public static final int STR_ACTIVITY_ID_FIELD_NUMBER = 1;
    public static final int STR_COVER_URL_FIELD_NUMBER = 5;
    public static final int STR_END_TIME_FIELD_NUMBER = 4;
    public static final int STR_LOC_NAME_FIELD_NUMBER = 6;
    public static final int STR_NAME_FIELD_NUMBER = 2;
    public static final int STR_POI_LOC_NAME_FIELD_NUMBER = 8;
    public static final int STR_START_TIME_FIELD_NUMBER = 3;
    public static final int UINT64_FLAG_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66}, new String[]{"str_activity_id", "str_name", "str_start_time", "str_end_time", "str_cover_url", "str_loc_name", "uint64_flag", "str_poi_loc_name"}, new Object[]{"", "", "", "", "", "", 0L, ""}, troopactivity$Activity.class);
    public final PBStringField str_activity_id = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_start_time = PBField.initString("");
    public final PBStringField str_end_time = PBField.initString("");
    public final PBStringField str_cover_url = PBField.initString("");
    public final PBStringField str_loc_name = PBField.initString("");
    public final PBUInt64Field uint64_flag = PBField.initUInt64(0);
    public final PBStringField str_poi_loc_name = PBField.initString("");
}
