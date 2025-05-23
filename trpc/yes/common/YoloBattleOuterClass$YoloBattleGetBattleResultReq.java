package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattleGetBattleResultReq extends MessageMicro<YoloBattleOuterClass$YoloBattleGetBattleResultReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"get_last_n"}, new Object[]{0}, YoloBattleOuterClass$YoloBattleGetBattleResultReq.class);
    public final PBInt32Field get_last_n = PBField.initInt32(0);
}
