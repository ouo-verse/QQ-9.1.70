package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$NotifyReq extends MessageMicro<PremadesTeamServerOuterClass$NotifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"type", "id", "game_id"}, new Object[]{1, 0L, 0}, PremadesTeamServerOuterClass$NotifyReq.class);
    public final PBEnumField type = PBField.initEnum(1);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f437245id = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
}
