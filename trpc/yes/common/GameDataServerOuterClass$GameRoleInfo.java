package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$GameRoleInfo extends MessageMicro<GameDataServerOuterClass$GameRoleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"hero_count"}, new Object[]{0}, GameDataServerOuterClass$GameRoleInfo.class);
    public final PBInt32Field hero_count = PBField.initInt32(0);
}
