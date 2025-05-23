package tencent.im.mobiletips;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MobileTips$TaskInfo extends MessageMicro<MobileTips$TaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"task_id", "msgcnt", "keywords"}, new Object[]{0, 0, ""}, MobileTips$TaskInfo.class);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field msgcnt = PBField.initUInt32(0);
    public final PBRepeatField<String> keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
}
