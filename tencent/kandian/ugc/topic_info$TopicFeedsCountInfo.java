package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class topic_info$TopicFeedsCountInfo extends MessageMicro<topic_info$TopicFeedsCountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"topic_id", "content_count", "end_rowkey", "end_score"}, new Object[]{0, 0, "", 0L}, topic_info$TopicFeedsCountInfo.class);
    public final PBUInt32Field topic_id = PBField.initUInt32(0);
    public final PBUInt32Field content_count = PBField.initUInt32(0);
    public final PBStringField end_rowkey = PBField.initString("");
    public final PBUInt64Field end_score = PBField.initUInt64(0);
}
