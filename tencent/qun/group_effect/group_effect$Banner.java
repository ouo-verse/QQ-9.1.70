package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect$Banner extends MessageMicro<group_effect$Banner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 810}, new String[]{QzoneCameraConst.Tag.ARG_PARAM_EFFECT_ID, "bottom_url", "top_url", "goto_url", "time_begin", "time_end", "effect_info"}, new Object[]{0, "", "", "", 0, 0, null}, group_effect$Banner.class);
    public final PBUInt32Field effect_id = PBField.initUInt32(0);
    public final PBStringField bottom_url = PBField.initString("");
    public final PBStringField top_url = PBField.initString("");
    public final PBStringField goto_url = PBField.initString("");
    public final PBUInt32Field time_begin = PBField.initUInt32(0);
    public final PBUInt32Field time_end = PBField.initUInt32(0);
    public group_effect$EffectInfo effect_info = new group_effect$EffectInfo();
}
