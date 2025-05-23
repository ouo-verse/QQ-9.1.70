package tencent.im.oidb.cmd0xe9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe9b$Quest extends MessageMicro<oidb_0xe9b$Quest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"str_id", "str_quest", "uint64_quest_uin", "uint64_time", "str_ans"}, new Object[]{"", "", 0L, 0L, ""}, oidb_0xe9b$Quest.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBStringField str_quest = PBField.initString("");
    public final PBUInt64Field uint64_quest_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBStringField str_ans = PBField.initString("");
}
