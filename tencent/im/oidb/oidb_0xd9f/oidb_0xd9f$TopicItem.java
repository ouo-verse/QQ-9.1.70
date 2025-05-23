package tencent.im.oidb.oidb_0xd9f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd9f$TopicItem extends MessageMicro<oidb_0xd9f$TopicItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_topic_id", "str_topic", "uint32_frd_num", "rpt_frd_item"}, new Object[]{0, "", 0, null}, oidb_0xd9f$TopicItem.class);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBStringField str_topic = PBField.initString("");
    public final PBUInt32Field uint32_frd_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xd9f$UinItem> rpt_frd_item = PBField.initRepeatMessage(oidb_0xd9f$UinItem.class);
}
