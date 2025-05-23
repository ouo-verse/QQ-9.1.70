package tencent.im.cs.nearby_troop_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_troop_activity$ActivityDigest extends MessageMicro<nearby_troop_activity$ActivityDigest> {
    public static final int STR_ACTIVITY_ID_FIELD_NUMBER = 1;
    public static final int STR_COVER_URL_FIELD_NUMBER = 4;
    public static final int STR_LOC_NAME_FIELD_NUMBER = 5;
    public static final int STR_NAME_FIELD_NUMBER = 2;
    public static final int STR_TIME_FIELD_NUMBER = 3;
    public static final int STR_URL_INFO_FIELD_NUMBER = 7;
    public static final int UINT32_DISTANCE_FIELD_NUMBER = 8;
    public static final int UINT64_ENROLL_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 64}, new String[]{"str_activity_id", "str_name", "str_time", "str_cover_url", "str_loc_name", "uint64_enroll", "str_url_info", "uint32_distance"}, new Object[]{"", "", "", "", "", 0L, "", 0}, nearby_troop_activity$ActivityDigest.class);
    public final PBStringField str_activity_id = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_time = PBField.initString("");
    public final PBStringField str_cover_url = PBField.initString("");
    public final PBStringField str_loc_name = PBField.initString("");
    public final PBUInt64Field uint64_enroll = PBField.initUInt64(0);
    public final PBStringField str_url_info = PBField.initString("");
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
}
