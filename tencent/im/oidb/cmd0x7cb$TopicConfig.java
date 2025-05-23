package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cb$TopicConfig extends MessageMicro<cmd0x7cb$TopicConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_topic_id", "str_topic_name", "uint32_deadline", "str_err_deadline"}, new Object[]{0, "", 0, ""}, cmd0x7cb$TopicConfig.class);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBStringField str_topic_name = PBField.initString("");
    public final PBUInt32Field uint32_deadline = PBField.initUInt32(0);
    public final PBStringField str_err_deadline = PBField.initString("");
}
