package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.trunk.Qworkflow.Qworkflow$Approver;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x4d4$ApproverChange extends MessageMicro<oidb_0x4d4$ApproverChange> {
    public static final int ADD = 1;
    public static final int DELETE = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_change_type", "msg_approver"}, new Object[]{1, null}, oidb_0x4d4$ApproverChange.class);
    public final PBEnumField enum_change_type = PBField.initEnum(1);
    public Qworkflow$Approver msg_approver = new Qworkflow$Approver();
}
