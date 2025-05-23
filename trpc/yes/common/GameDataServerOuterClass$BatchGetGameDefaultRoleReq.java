package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GameDataServerOuterClass$BatchGetGameDefaultRoleReq extends MessageMicro<GameDataServerOuterClass$BatchGetGameDefaultRoleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uid_list", "game_id", "scene", "user_id_list"}, new Object[]{0L, 0, 0, null}, GameDataServerOuterClass$BatchGetGameDefaultRoleReq.class);
    public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBRepeatMessageField<CommonOuterClass$QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
}
