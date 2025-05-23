package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect_commu$ReqBody extends MessageMicro<group_effect_commu$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 2402}, new String[]{"u64_cmd", "u64_uin", "i32_implat", "str_version", "st_get_detail", "st_get_effect", "st_set_effect", "st_get_switch_others", "st_set_switch", "st_set_global_effect", "st_set_switch_others", "st_entry_notify"}, new Object[]{0L, 0L, 0, "", null, null, null, null, null, null, null, null}, group_effect_commu$ReqBody.class);
    public final PBUInt64Field u64_cmd = PBField.initUInt64(0);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public final PBStringField str_version = PBField.initString("");
    public group_effect_commu$TGetEffectDetailReq0x1 st_get_detail = new MessageMicro<group_effect_commu$TGetEffectDetailReq0x1>() { // from class: tencent.qun.group_effect.group_effect_commu$TGetEffectDetailReq0x1
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QzoneCameraConst.Tag.ARG_PARAM_EFFECT_ID}, new Object[]{0L}, group_effect_commu$TGetEffectDetailReq0x1.class);
        public final PBRepeatField<Long> effect_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public group_effect_commu$TGetMyEffectReq0x2 st_get_effect = new group_effect_commu$TGetMyEffectReq0x2();
    public group_effect_commu$TSetMyEffectReq0x4 st_set_effect = new MessageMicro<group_effect_commu$TSetMyEffectReq0x4>() { // from class: tencent.qun.group_effect.group_effect_commu$TSetMyEffectReq0x4
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_config"}, new Object[]{null}, group_effect_commu$TSetMyEffectReq0x4.class);
        public final PBRepeatMessageField<group_effect$UserConfig> user_config = PBField.initRepeatMessage(group_effect$UserConfig.class);
    };
    public group_effect_commu$TGetSwitchOthersReq0x8 st_get_switch_others = new MessageMicro<group_effect_commu$TGetSwitchOthersReq0x8>() { // from class: tencent.qun.group_effect.group_effect_commu$TGetSwitchOthersReq0x8
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_id"}, new Object[]{0L}, group_effect_commu$TGetSwitchOthersReq0x8.class);
        public final PBUInt64Field group_id = PBField.initUInt64(0);
    };
    public group_effect_commu$TSetSwitchReq0x10 st_set_switch = new MessageMicro<group_effect_commu$TSetSwitchReq0x10>() { // from class: tencent.qun.group_effect.group_effect_commu$TSetSwitchReq0x10
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "forbid_self"}, new Object[]{0L, 0L}, group_effect_commu$TSetSwitchReq0x10.class);
        public final PBUInt64Field group_id = PBField.initUInt64(0);
        public final PBUInt64Field forbid_self = PBField.initUInt64(0);
    };
    public group_effect_commu$TSetGlobalEffectReq0x20 st_set_global_effect = new MessageMicro<group_effect_commu$TSetGlobalEffectReq0x20>() { // from class: tencent.qun.group_effect.group_effect_commu$TSetGlobalEffectReq0x20
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"global_effect_id"}, new Object[]{0}, group_effect_commu$TSetGlobalEffectReq0x20.class);
        public final PBUInt32Field global_effect_id = PBField.initUInt32(0);
    };
    public group_effect_commu$TSetSwitchOthersReq0x40 st_set_switch_others = new MessageMicro<group_effect_commu$TSetSwitchOthersReq0x40>() { // from class: tencent.qun.group_effect.group_effect_commu$TSetSwitchOthersReq0x40
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "forbid_others"}, new Object[]{0L, 0}, group_effect_commu$TSetSwitchOthersReq0x40.class);
        public final PBUInt64Field group_id = PBField.initUInt64(0);
        public final PBInt32Field forbid_others = PBField.initInt32(0);
    };
    public group_effect_commu$TEntryNotifyReq0x2000 st_entry_notify = new group_effect_commu$TEntryNotifyReq0x2000();
}
