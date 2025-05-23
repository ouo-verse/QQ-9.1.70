package tencent.qun.group_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_activity$RspBody extends MessageMicro<group_activity$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_error_code", "act_list"}, new Object[]{0, null}, group_activity$RspBody.class);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBRepeatMessageField<group_activity$GroupAct> act_list = PBField.initRepeatMessage(group_activity$GroupAct.class);
}
