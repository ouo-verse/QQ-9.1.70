package tencent.im.oidb.cmd0xee5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xee5$QuestTimes extends MessageMicro<oidb_0xee5$QuestTimes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"str_quest_id", "uint64_quest_time", "uint64_uin", "uint64_show_times"}, new Object[]{"", 0L, 0L, 0L}, oidb_0xee5$QuestTimes.class);
    public final PBStringField str_quest_id = PBField.initString("");
    public final PBUInt64Field uint64_quest_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_show_times = PBField.initUInt64(0);
}
