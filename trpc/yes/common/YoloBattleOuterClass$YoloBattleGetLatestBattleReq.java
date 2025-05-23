package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattleGetLatestBattleReq extends MessageMicro<YoloBattleOuterClass$YoloBattleGetLatestBattleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"last_n", "extra_key"}, new Object[]{0, ""}, YoloBattleOuterClass$YoloBattleGetLatestBattleReq.class);
    public final PBUInt32Field last_n = PBField.initUInt32(0);
    public final PBStringField extra_key = PBField.initString("");
}
