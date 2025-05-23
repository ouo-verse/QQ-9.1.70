package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$ReadFeedNotify extends MessageMicro<servtype$ReadFeedNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16}, new String[]{"report_time"}, new Object[]{0L}, servtype$ReadFeedNotify.class);
    public final PBUInt64Field report_time = PBField.initUInt64(0);
}
