package trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GetSelfSmobaRunePageReq extends MessageMicro<GameDataServerOuterClass$GetSelfSmobaRunePageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uid", GdtGetUserInfoHandler.KEY_AREA, "partition"}, new Object[]{0L, 0, 0}, GameDataServerOuterClass$GetSelfSmobaRunePageReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);
}
