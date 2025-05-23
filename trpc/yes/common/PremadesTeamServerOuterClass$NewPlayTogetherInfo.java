package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$NewPlayTogetherInfo extends MessageMicro<PremadesTeamServerOuterClass$NewPlayTogetherInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{208, 216}, new String[]{"method_switch", "mode_switch"}, new Object[]{0, 0}, PremadesTeamServerOuterClass$NewPlayTogetherInfo.class);
    public final PBInt32Field method_switch = PBField.initInt32(0);
    public final PBInt32Field mode_switch = PBField.initInt32(0);
}
