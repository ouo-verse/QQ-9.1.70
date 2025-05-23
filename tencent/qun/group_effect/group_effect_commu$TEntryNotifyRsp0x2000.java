package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect_commu$TEntryNotifyRsp0x2000 extends MessageMicro<group_effect_commu$TEntryNotifyRsp0x2000> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret", "st_userconfig", "notify_interval"}, new Object[]{0, null, 0}, group_effect_commu$TEntryNotifyRsp0x2000.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public group_effect_commu$TEffectDetail st_userconfig = new group_effect_commu$TEffectDetail();
    public final PBUInt32Field notify_interval = PBField.initUInt32(0);
}
