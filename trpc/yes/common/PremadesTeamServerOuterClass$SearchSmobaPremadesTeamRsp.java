package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$SearchSmobaPremadesTeamRsp extends MessageMicro<PremadesTeamServerOuterClass$SearchSmobaPremadesTeamRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"total", "list", "more", "refresh_interval"}, new Object[]{0, null, Boolean.FALSE, 0}, PremadesTeamServerOuterClass$SearchSmobaPremadesTeamRsp.class);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$SmobaPremadesTeamInfo> list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$SmobaPremadesTeamInfo.class);
    public final PBBoolField more = PBField.initBool(false);
    public final PBInt32Field refresh_interval = PBField.initInt32(0);
}
