package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopMultiGroupManageSvr$SetAddMethodReq extends MessageMicro<TroopMultiGroupManageSvr$SetAddMethodReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"group_ids", "method", "invite_method"}, new Object[]{0L, null, null}, TroopMultiGroupManageSvr$SetAddMethodReq.class);
    public final PBRepeatField<Long> group_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public TroopMultiGroupManageSvr$AddMethod method = new TroopMultiGroupManageSvr$AddMethod();
    public TroopMultiGroupManageSvr$InviteMethod invite_method = new TroopMultiGroupManageSvr$InviteMethod();
}
