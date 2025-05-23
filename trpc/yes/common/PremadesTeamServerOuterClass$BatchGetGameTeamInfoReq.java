package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$BatchGetGameTeamInfoReq extends MessageMicro<PremadesTeamServerOuterClass$BatchGetGameTeamInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"team_id_list", "uid", "game_id"}, new Object[]{0L, 0L, 0}, PremadesTeamServerOuterClass$BatchGetGameTeamInfoReq.class);
    public final PBRepeatField<Long> team_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
}
