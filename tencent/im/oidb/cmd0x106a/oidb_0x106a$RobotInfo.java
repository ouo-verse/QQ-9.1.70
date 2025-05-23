package tencent.im.oidb.cmd0x106a;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x106a$RobotInfo extends MessageMicro<oidb_0x106a$RobotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 56, 64, 72, 82}, new String[]{"robot_uin", "robot_name", "robot_avatar", "robot_desc", "robot_offline", "robot_features", "robot_test_status", "robot_tid", "robot_ban", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{0L, "", "", "", 0, null, 0, 0L, Boolean.FALSE, ""}, oidb_0x106a$RobotInfo.class);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
    public final PBStringField robot_name = PBField.initString("");
    public final PBStringField robot_avatar = PBField.initString("");
    public final PBStringField robot_desc = PBField.initString("");
    public final PBUInt32Field robot_offline = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x106a$FeatureInfo> robot_features = PBField.initRepeatMessage(oidb_0x106a$FeatureInfo.class);
    public final PBUInt32Field robot_test_status = PBField.initUInt32(0);
    public final PBUInt64Field robot_tid = PBField.initUInt64(0);
    public final PBBoolField robot_ban = PBField.initBool(false);
    public final PBRepeatField<String> tags = PBField.initRepeat(PBStringField.__repeatHelper__);
}
