package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopJoinQunAutoSwitch$BindedSubGroup extends MessageMicro<TroopJoinQunAutoSwitch$BindedSubGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"group_id", "master_group_id"}, new Object[]{"", ""}, TroopJoinQunAutoSwitch$BindedSubGroup.class);
    public final PBStringField group_id = PBField.initString("");
    public final PBStringField master_group_id = PBField.initString("");
}
