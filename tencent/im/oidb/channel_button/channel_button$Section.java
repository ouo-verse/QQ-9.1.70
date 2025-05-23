package tencent.im.oidb.channel_button;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class channel_button$Section extends MessageMicro<channel_button$Section> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"str_section_name", "uint64_section_id", "str_note_text", "rpt_msg_channel"}, new Object[]{"", 0L, "", null}, channel_button$Section.class);
    public final PBStringField str_section_name = PBField.initString("");
    public final PBUInt64Field uint64_section_id = PBField.initUInt64(0);
    public final PBStringField str_note_text = PBField.initString("");
    public final PBRepeatMessageField<channel_button$Channel> rpt_msg_channel = PBField.initRepeatMessage(channel_button$Channel.class);
}
