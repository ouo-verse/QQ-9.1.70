package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class MqqLbsPack$CFT_AR_INFO extends MessageMicro<MqqLbsPack$CFT_AR_INFO> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26, 32, 40}, new String[]{"msg_lbs_sig", "uint32_qa", "uint32_attempt_num"}, new Object[]{null, 0, 0}, MqqLbsPack$CFT_AR_INFO.class);
    public MqqLbsPack$LBSSig msg_lbs_sig = new MqqLbsPack$LBSSig();
    public final PBUInt32Field uint32_qa = PBField.initUInt32(0);
    public final PBUInt32Field uint32_attempt_num = PBField.initUInt32(0);
}
