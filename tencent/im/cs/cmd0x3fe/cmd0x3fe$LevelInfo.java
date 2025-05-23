package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fe$LevelInfo extends MessageMicro<cmd0x3fe$LevelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 80, 88, 96, 106, 114}, new String[]{"uint64_uin", "uint32_online_level", "uint32_show_level", "uint32_level_color", "uint32_score", "uint32_req_flag", "uint32_req_timer", "uint32_user_identity", "nickname", "rpt_medal_list"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, "", null}, cmd0x3fe$LevelInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_online_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_timer = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_identity = PBField.initUInt32(0);
    public final PBStringField nickname = PBField.initString("");
    public final PBRepeatMessageField<cmd0x3fe$Medal> rpt_medal_list = PBField.initRepeatMessage(cmd0x3fe$Medal.class);
}
