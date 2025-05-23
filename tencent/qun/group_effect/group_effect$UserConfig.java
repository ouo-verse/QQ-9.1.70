package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect$UserConfig extends MessageMicro<group_effect$UserConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"group_code", QzoneCameraConst.Tag.ARG_PARAM_EFFECT_ID, "status", "set_mode"}, new Object[]{0L, 0, 0L, 0L}, group_effect$UserConfig.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt32Field effect_id = PBField.initUInt32(0);
    public final PBUInt64Field status = PBField.initUInt64(0);
    public final PBUInt64Field set_mode = PBField.initUInt64(0);
}
