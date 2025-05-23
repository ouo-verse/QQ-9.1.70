package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class AvGamePlay$GetGameMembersRsp extends MessageMicro<AvGamePlay$GetGameMembersRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"members"}, new Object[]{0L}, AvGamePlay$GetGameMembersRsp.class);
    public final PBRepeatField<Long> members = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
