package tencent.im.oidb.cmd0x98d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.qun.group_effect.group_effect$EffectInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x98d$RspBody extends MessageMicro<oidb_0x98d$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"y_list_rsp", "z_list_rsp", "get_rsp"}, new Object[]{null, null, null}, oidb_0x98d$RspBody.class);
    public oidb_0x98d$YListRsp y_list_rsp = new MessageMicro<oidb_0x98d$YListRsp>() { // from class: tencent.im.oidb.cmd0x98d.oidb_0x98d$YListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"rpt_effect_info", "user_setting", "svip_level", "group_level"}, new Object[]{null, null, 0, 0}, oidb_0x98d$YListRsp.class);
        public final PBRepeatMessageField<group_effect$EffectInfo> rpt_effect_info = PBField.initRepeatMessage(group_effect$EffectInfo.class);
        public group_effect$EffectInfo user_setting = new group_effect$EffectInfo();
        public final PBUInt32Field svip_level = PBField.initUInt32(0);
        public final PBUInt32Field group_level = PBField.initUInt32(0);
    };
    public oidb_0x98d$ZListRsp z_list_rsp = new MessageMicro<oidb_0x98d$ZListRsp>() { // from class: tencent.im.oidb.cmd0x98d.oidb_0x98d$ZListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x98d$ZListRsp.class);
    };
    public oidb_0x98d$GetRsp get_rsp = new MessageMicro<oidb_0x98d$GetRsp>() { // from class: tencent.im.oidb.cmd0x98d.oidb_0x98d$GetRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"effect_info", "svip_level", "group_level"}, new Object[]{null, 0, 0}, oidb_0x98d$GetRsp.class);
        public group_effect$EffectInfo effect_info = new group_effect$EffectInfo();
        public final PBUInt32Field svip_level = PBField.initUInt32(0);
        public final PBUInt32Field group_level = PBField.initUInt32(0);
    };
}
