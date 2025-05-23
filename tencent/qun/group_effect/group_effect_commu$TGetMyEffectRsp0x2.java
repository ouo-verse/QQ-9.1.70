package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect_commu$TGetMyEffectRsp0x2 extends MessageMicro<group_effect_commu$TGetMyEffectRsp0x2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"ret", "global_effect_id", "st_global_effectinfo", "rpt_userconfig", "query_interval"}, new Object[]{0, 0, null, null, 0}, group_effect_commu$TGetMyEffectRsp0x2.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBUInt32Field global_effect_id = PBField.initUInt32(0);
    public group_effect$EffectInfo st_global_effectinfo = new group_effect$EffectInfo();
    public final PBRepeatMessageField<group_effect_commu$TEffectDetail> rpt_userconfig = PBField.initRepeatMessage(group_effect_commu$TEffectDetail.class);
    public final PBUInt32Field query_interval = PBField.initUInt32(0);
}
