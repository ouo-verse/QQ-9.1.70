package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x897$ReqBody extends MessageMicro<cmd0x897$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_grp_next_visitor"}, new Object[]{null}, cmd0x897$ReqBody.class);
    public final PBRepeatMessageField<cmd0x897$GroupNextVisitor> rpt_msg_grp_next_visitor = PBField.initRepeatMessage(cmd0x897$GroupNextVisitor.class);
}
