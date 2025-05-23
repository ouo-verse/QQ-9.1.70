package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x791$RspBody extends MessageMicro<oidb_0x791$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_result", "msg_get_reddot_res", "msg_set_reddot_res", "msg_set_reddot_appids_res"}, new Object[]{0, null, null, null}, oidb_0x791$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public oidb_0x791$GetRedDotRes msg_get_reddot_res = new oidb_0x791$GetRedDotRes();
    public oidb_0x791$SetRedDotRes msg_set_reddot_res = new oidb_0x791$SetRedDotRes();
    public oidb_0x791$SetRotDotAppidsRes msg_set_reddot_appids_res = new MessageMicro<oidb_0x791$SetRotDotAppidsRes>() { // from class: tencent.im.oidb.cmd0x791.oidb_0x791$SetRotDotAppidsRes
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint32_failed_appid"}, new Object[]{0}, oidb_0x791$SetRotDotAppidsRes.class);
        public final PBRepeatField<Integer> rpt_uint32_failed_appid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
}
