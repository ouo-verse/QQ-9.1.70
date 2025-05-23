package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class topic_info$TopicRocommend extends MessageMicro<topic_info$TopicRocommend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"topic_id", "pos_score", "start_ts", "end_ts"}, new Object[]{0, 0, 0, 0}, topic_info$TopicRocommend.class);
    public final PBUInt32Field topic_id = PBField.initUInt32(0);
    public final PBUInt32Field pos_score = PBField.initUInt32(0);
    public final PBUInt32Field start_ts = PBField.initUInt32(0);
    public final PBUInt32Field end_ts = PBField.initUInt32(0);
}
