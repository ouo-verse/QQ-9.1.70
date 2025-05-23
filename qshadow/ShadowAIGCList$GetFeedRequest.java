package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCList$GetFeedRequest extends MessageMicro<ShadowAIGCList$GetFeedRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"busi_id", "page_size", "feed_id", "direction", "include_self", "img_trace_id"}, new Object[]{"", 0, "", 0, Boolean.FALSE, ""}, ShadowAIGCList$GetFeedRequest.class);
    public final PBStringField busi_id = PBField.initString("");
    public final PBInt32Field page_size = PBField.initInt32(0);
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt32Field direction = PBField.initInt32(0);
    public final PBBoolField include_self = PBField.initBool(false);
    public final PBStringField img_trace_id = PBField.initString("");
}
