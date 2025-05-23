package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaee$ListRsp extends MessageMicro<Oidb_0xaee$ListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_template"}, new Object[]{null}, Oidb_0xaee$ListRsp.class);
    public final PBRepeatMessageField<Oidb_0xaee$Template> rpt_template = PBField.initRepeatMessage(Oidb_0xaee$Template.class);
}
