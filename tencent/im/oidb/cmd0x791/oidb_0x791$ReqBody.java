package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x791$ReqBody extends MessageMicro<oidb_0x791$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_set_reddot", "msg_get_reddot", "msg_set_reddot_appids"}, new Object[]{null, null, null}, oidb_0x791$ReqBody.class);
    public oidb_0x791$SetRedDotOpt msg_set_reddot = new oidb_0x791$SetRedDotOpt();
    public oidb_0x791$GetRedDotOpt msg_get_reddot = new MessageMicro<oidb_0x791$GetRedDotOpt>() { // from class: tencent.im.oidb.cmd0x791.oidb_0x791$GetRedDotOpt
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "rpt_uint32_appid"}, new Object[]{0L, 0}, oidb_0x791$GetRedDotOpt.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBRepeatField<Integer> rpt_uint32_appid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
    public oidb_0x791$SetRedDotAppids msg_set_reddot_appids = new MessageMicro<oidb_0x791$SetRedDotAppids>() { // from class: tencent.im.oidb.cmd0x791.oidb_0x791$SetRedDotAppids
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_cmd_uin", "uint64_to_uin", "rpt_appid_opt"}, new Object[]{0L, 0L, null}, oidb_0x791$SetRedDotAppids.class);
        public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<oidb_0x791$SetAppidOpt> rpt_appid_opt = PBField.initRepeatMessage(oidb_0x791$SetAppidOpt.class);
    };
}
