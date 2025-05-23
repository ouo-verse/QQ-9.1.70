package tencent.im.oidb.oidb_0xf15;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf15$DelRequest extends MessageMicro<oidb_0xf15$DelRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "question_id", "answer_id"}, new Object[]{0L, 0L, 0}, oidb_0xf15$DelRequest.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field question_id = PBField.initUInt64(0);
    public final PBUInt32Field answer_id = PBField.initUInt32(0);
}
