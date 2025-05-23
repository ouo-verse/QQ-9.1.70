package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopMultiGroupManageSvr$JumpInfo extends MessageMicro<TroopMultiGroupManageSvr$JumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"data_center", "member_manage", "add_manage", "batch_manage"}, new Object[]{"", "", "", ""}, TroopMultiGroupManageSvr$JumpInfo.class);
    public final PBStringField data_center = PBField.initString("");
    public final PBStringField member_manage = PBField.initString("");
    public final PBStringField add_manage = PBField.initString("");
    public final PBStringField batch_manage = PBField.initString("");
}
