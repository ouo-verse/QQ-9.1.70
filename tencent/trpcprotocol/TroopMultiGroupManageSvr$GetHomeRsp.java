package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopMultiGroupManageSvr$GetHomeRsp extends MessageMicro<TroopMultiGroupManageSvr$GetHomeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{"total_member", "avg_member", "total_manager", "total_group_num", "jump_info", "group_wording"}, new Object[]{null, null, null, 0L, null, ""}, TroopMultiGroupManageSvr$GetHomeRsp.class);
    public TroopMultiGroupManageSvr$DataItem total_member = new TroopMultiGroupManageSvr$DataItem();
    public TroopMultiGroupManageSvr$DataItem avg_member = new TroopMultiGroupManageSvr$DataItem();
    public TroopMultiGroupManageSvr$DataItem total_manager = new TroopMultiGroupManageSvr$DataItem();
    public final PBUInt64Field total_group_num = PBField.initUInt64(0);
    public TroopMultiGroupManageSvr$JumpInfo jump_info = new TroopMultiGroupManageSvr$JumpInfo();
    public final PBStringField group_wording = PBField.initString("");
}
