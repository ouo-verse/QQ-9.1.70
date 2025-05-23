package tencent.im.oidb.oidb_0xd9f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd9f$LongNickItem extends MessageMicro<oidb_0xd9f$LongNickItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_longnick", "rpt_topic_item"}, new Object[]{"", null}, oidb_0xd9f$LongNickItem.class);
    public final PBStringField str_longnick = PBField.initString("");
    public final PBRepeatMessageField<oidb_0xd9f$TopicItem> rpt_topic_item = PBField.initRepeatMessage(oidb_0xd9f$TopicItem.class);
}
