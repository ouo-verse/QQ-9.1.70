package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopJoinQunAutoSwitch$AddSubGroupsReq extends MessageMicro<TroopJoinQunAutoSwitch$AddSubGroupsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"master_group", "sub_groups"}, new Object[]{"", ""}, TroopJoinQunAutoSwitch$AddSubGroupsReq.class);
    public final PBStringField master_group = PBField.initString("");
    public final PBRepeatField<String> sub_groups = PBField.initRepeat(PBStringField.__repeatHelper__);
}
