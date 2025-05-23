package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class topic_info$TopicBubbleInfo extends MessageMicro<topic_info$TopicBubbleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_topic_id", "uint32_up_ts"}, new Object[]{0, 0}, topic_info$TopicBubbleInfo.class);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_up_ts = PBField.initUInt32(0);
}
