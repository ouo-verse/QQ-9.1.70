package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb86$ExamineHead extends MessageMicro<oidb_cmd0xb86$ExamineHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"head", "uint64_timestamp"}, new Object[]{null, 0L}, oidb_cmd0xb86$ExamineHead.class);
    public oidb_cmd0xb86$HeadInfo head = new oidb_cmd0xb86$HeadInfo();
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
}
