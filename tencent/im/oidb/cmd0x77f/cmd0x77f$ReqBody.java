package tencent.im.oidb.cmd0x77f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x77f$ReqBody extends MessageMicro<cmd0x77f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_listtype", "rpt_msg_visit_prof_rec", "uint32_list_ruleid"}, new Object[]{0, null, 0}, cmd0x77f$ReqBody.class);
    public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x77f$VisitProfRec> rpt_msg_visit_prof_rec = PBField.initRepeatMessage(cmd0x77f$VisitProfRec.class);
    public final PBUInt32Field uint32_list_ruleid = PBField.initUInt32(0);
}
