package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$CancelSmobaAuthReq extends MessageMicro<GameDataServerOuterClass$CancelSmobaAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uid", "sense"}, new Object[]{0L, 0}, GameDataServerOuterClass$CancelSmobaAuthReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field sense = PBField.initInt32(0);
}
