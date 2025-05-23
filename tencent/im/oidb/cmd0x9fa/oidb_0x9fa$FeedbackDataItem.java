package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9fa$FeedbackDataItem extends MessageMicro<oidb_0x9fa$FeedbackDataItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_group_code", "uint64_feedback_time"}, new Object[]{0L, 0L}, oidb_0x9fa$FeedbackDataItem.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_feedback_time = PBField.initUInt64(0);
}
