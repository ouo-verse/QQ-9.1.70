package tencent.im.troop.activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class troopactivity$GroupInfoCardResp extends MessageMicro<troopactivity$GroupInfoCardResp> {
    public static final int ACTIVITYS_FIELD_NUMBER = 1;
    public static final int BEING_ACT_NUM_FIELD_NUMBER = 2;
    public static final int GROUP_ACT_URL_FIELD_NUMBER = 4;
    public static final int HISTORY_ACT_NUM_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"activitys", "being_act_num", "history_act_num", "group_act_url"}, new Object[]{null, 0, 0, ""}, troopactivity$GroupInfoCardResp.class);
    public final PBRepeatMessageField<troopactivity$Activity> activitys = PBField.initRepeatMessage(troopactivity$Activity.class);
    public final PBUInt32Field being_act_num = PBField.initUInt32(0);
    public final PBUInt32Field history_act_num = PBField.initUInt32(0);
    public final PBStringField group_act_url = PBField.initString("");
}
