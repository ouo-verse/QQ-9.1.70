package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect_commu$RspBody extends MessageMicro<group_effect_commu$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 2402}, new String[]{"ret", "st_get_detail", "st_get_effect", "st_set_effect", "st_get_switch_others", "st_set_switch", "st_set_global_effect", "st_set_switch_others", "st_entry_notify"}, new Object[]{0, null, null, null, null, null, null, null, null}, group_effect_commu$RspBody.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public group_effect_commu$TGetEffectDetailRsp0x1 st_get_detail = new MessageMicro<group_effect_commu$TGetEffectDetailRsp0x1>() { // from class: tencent.qun.group_effect.group_effect_commu$TGetEffectDetailRsp0x1
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "rpt_effectinfo"}, new Object[]{0, null}, group_effect_commu$TGetEffectDetailRsp0x1.class);
        public final PBInt32Field ret = PBField.initInt32(0);
        public final PBRepeatMessageField<group_effect$EffectInfo> rpt_effectinfo = PBField.initRepeatMessage(group_effect$EffectInfo.class);
    };
    public group_effect_commu$TGetMyEffectRsp0x2 st_get_effect = new group_effect_commu$TGetMyEffectRsp0x2();
    public group_effect_commu$TSetMyEffectRsp0x4 st_set_effect = new MessageMicro<group_effect_commu$TSetMyEffectRsp0x4>() { // from class: tencent.qun.group_effect.group_effect_commu$TSetMyEffectRsp0x4
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, group_effect_commu$TSetMyEffectRsp0x4.class);
        public final PBInt32Field ret = PBField.initInt32(0);
    };
    public group_effect_commu$TGetSwitchOthersRsp0x8 st_get_switch_others = new MessageMicro<group_effect_commu$TGetSwitchOthersRsp0x8>() { // from class: tencent.qun.group_effect.group_effect_commu$TGetSwitchOthersRsp0x8
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ret", "forbid_others"}, new Object[]{0, 0}, group_effect_commu$TGetSwitchOthersRsp0x8.class);
        public final PBInt32Field ret = PBField.initInt32(0);
        public final PBInt32Field forbid_others = PBField.initInt32(0);
    };
    public group_effect_commu$TSetSwitchRsp0x10 st_set_switch = new MessageMicro<group_effect_commu$TSetSwitchRsp0x10>() { // from class: tencent.qun.group_effect.group_effect_commu$TSetSwitchRsp0x10
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, group_effect_commu$TSetSwitchRsp0x10.class);
        public final PBInt32Field ret = PBField.initInt32(0);
    };
    public group_effect_commu$TSetGlobalEffectRsp0x20 st_set_global_effect = new MessageMicro<group_effect_commu$TSetGlobalEffectRsp0x20>() { // from class: tencent.qun.group_effect.group_effect_commu$TSetGlobalEffectRsp0x20
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, group_effect_commu$TSetGlobalEffectRsp0x20.class);
        public final PBInt32Field ret = PBField.initInt32(0);
    };
    public group_effect_commu$TSetSwitchOthersRsp0x40 st_set_switch_others = new MessageMicro<group_effect_commu$TSetSwitchOthersRsp0x40>() { // from class: tencent.qun.group_effect.group_effect_commu$TSetSwitchOthersRsp0x40
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, group_effect_commu$TSetSwitchOthersRsp0x40.class);
        public final PBInt32Field ret = PBField.initInt32(0);
    };
    public group_effect_commu$TEntryNotifyRsp0x2000 st_entry_notify = new group_effect_commu$TEntryNotifyRsp0x2000();
}
