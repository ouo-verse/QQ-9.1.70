package tencent.im.cs.nearby_troop_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_troop_activity$RspBody extends MessageMicro<nearby_troop_activity$RspBody> {
    public static final int RPT_ACTIVITY_FIELD_NUMBER = 6;
    public static final int STR_TITLE_FIELD_NUMBER = 3;
    public static final int STR_URL_LIST_FIELD_NUMBER = 5;
    public static final int STR_WORDING_FIELD_NUMBER = 4;
    public static final int UINT32_RET_FIELD_NUMBER = 1;
    public static final int UINT64_COUNT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"uint32_ret", "uint64_count", "str_title", "str_wording", "str_url_list", "rpt_activity"}, new Object[]{0, 0L, "", "", "", null}, nearby_troop_activity$RspBody.class);
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBUInt64Field uint64_count = PBField.initUInt64(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
    public final PBStringField str_url_list = PBField.initString("");
    public final PBRepeatMessageField<nearby_troop_activity$ActivityDigest> rpt_activity = PBField.initRepeatMessage(nearby_troop_activity$ActivityDigest.class);
}
