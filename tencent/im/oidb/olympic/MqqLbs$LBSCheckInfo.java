package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MqqLbs$LBSCheckInfo extends MessageMicro<MqqLbs$LBSCheckInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint32_fake_period", "uint32_fake_times", "rpt_msg_lbs_fake_info", "rpt_msg_cheat_app", "uint32_root_jailbreak"}, new Object[]{60, 0, null, null, 0}, MqqLbs$LBSCheckInfo.class);
    public final PBUInt32Field uint32_fake_period = PBField.initUInt32(60);
    public final PBUInt32Field uint32_fake_times = PBField.initUInt32(0);
    public final PBRepeatMessageField<MqqLbs$LBSFakeInfo> rpt_msg_lbs_fake_info = PBField.initRepeatMessage(MqqLbs$LBSFakeInfo.class);
    public final PBRepeatMessageField<MqqLbs$CheatApp> rpt_msg_cheat_app = PBField.initRepeatMessage(MqqLbs$CheatApp.class);
    public final PBUInt32Field uint32_root_jailbreak = PBField.initUInt32(0);
}
