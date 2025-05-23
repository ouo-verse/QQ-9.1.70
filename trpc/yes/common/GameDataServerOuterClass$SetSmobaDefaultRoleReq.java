package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$SetSmobaDefaultRoleReq extends MessageMicro<GameDataServerOuterClass$SetSmobaDefaultRoleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "uid"}, new Object[]{0, 0, 0L}, GameDataServerOuterClass$SetSmobaDefaultRoleReq.class);
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
