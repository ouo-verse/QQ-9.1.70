package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$TeamEntry extends MessageMicro<group_member_info$TeamEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"rpt_uint64_depid", "rpt_uint64_self_depid"}, new Object[]{0L, 0L}, group_member_info$TeamEntry.class);
    public final PBRepeatField<Long> rpt_uint64_depid;
    public final PBRepeatField<Long> rpt_uint64_self_depid;

    public group_member_info$TeamEntry() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_uint64_depid = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint64_self_depid = PBField.initRepeat(pBUInt64Field);
    }
}
