package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class topic_info$TopicModuleFeedsCookie extends MessageMicro<topic_info$TopicModuleFeedsCookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 120}, new String[]{"info", "source", "live_rowkeys"}, new Object[]{null, 0, 0}, topic_info$TopicModuleFeedsCookie.class);
    public final PBRepeatMessageField<topic_info$SyncCookie> info = PBField.initRepeatMessage(topic_info$SyncCookie.class);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBRepeatField<Integer> live_rowkeys = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
