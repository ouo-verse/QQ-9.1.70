package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopLiveSyncSvr$GroupInfo extends MessageMicro<TroopLiveSyncSvr$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 32, 40, 160}, new String[]{"group_code", "cmduin_privilege", "last_msg_time", "be_choosed"}, new Object[]{0L, 0, 0, Boolean.FALSE}, TroopLiveSyncSvr$GroupInfo.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field cmduin_privilege = PBField.initUInt32(0);
    public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
    public final PBBoolField be_choosed = PBField.initBool(false);
}
