package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopMultiGroupManageSvr$GetHomeReq extends MessageMicro<TroopMultiGroupManageSvr$GetHomeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_id"}, new Object[]{0L}, TroopMultiGroupManageSvr$GetHomeReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
}
