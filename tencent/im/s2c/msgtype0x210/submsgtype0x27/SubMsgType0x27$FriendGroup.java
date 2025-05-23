package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$FriendGroup extends MessageMicro<SubMsgType0x27$FriendGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_fuin", "rpt_uint32_old_group_id", "rpt_uint32_new_group_id"}, new Object[]{0L, 0, 0}, SubMsgType0x27$FriendGroup.class);
    public final PBRepeatField<Integer> rpt_uint32_new_group_id;
    public final PBRepeatField<Integer> rpt_uint32_old_group_id;
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0);

    public SubMsgType0x27$FriendGroup() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.rpt_uint32_old_group_id = PBField.initRepeat(pBUInt32Field);
        this.rpt_uint32_new_group_id = PBField.initRepeat(pBUInt32Field);
    }
}
