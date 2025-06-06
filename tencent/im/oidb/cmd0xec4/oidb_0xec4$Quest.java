package tencent.im.oidb.cmd0xec4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xec4$Quest extends MessageMicro<oidb_0xec4$Quest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 66, 72, 82, 88, 96, 104, 112, 120, 128, 136}, new String[]{"str_id", "str_quest", "uint64_quest_uin", "uint64_time", "str_ans", "uint64_ans_time", "rpt_comment", "rpt_praise", "uint64_praise_num", "str_like_key", "uint64_system_id", "uint64_comment_num", "uint64_show_type", "uint64_show_times", "uint64_been_praised", "bool_quest_read", "uint64_ans_show_type"}, new Object[]{"", "", 0L, 0L, "", 0L, null, null, 0L, "", 0L, 0L, 0L, 0L, 0L, Boolean.FALSE, 0L}, oidb_0xec4$Quest.class);
    public final PBStringField str_id = PBField.initString("");
    public final PBStringField str_quest = PBField.initString("");
    public final PBUInt64Field uint64_quest_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBStringField str_ans = PBField.initString("");
    public final PBUInt64Field uint64_ans_time = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0xec4$Comment> rpt_comment = PBField.initRepeatMessage(oidb_0xec4$Comment.class);
    public final PBRepeatMessageField<oidb_0xec4$Praise> rpt_praise = PBField.initRepeatMessage(oidb_0xec4$Praise.class);
    public final PBUInt64Field uint64_praise_num = PBField.initUInt64(0);
    public final PBStringField str_like_key = PBField.initString("");
    public final PBUInt64Field uint64_system_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_comment_num = PBField.initUInt64(0);
    public final PBUInt64Field uint64_show_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_show_times = PBField.initUInt64(0);
    public final PBUInt64Field uint64_been_praised = PBField.initUInt64(0);
    public final PBBoolField bool_quest_read = PBField.initBool(false);
    public final PBUInt64Field uint64_ans_show_type = PBField.initUInt64(0);
}
