package tencent.im.oidb.cmd0xe27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xe27$ReqBody extends MessageMicro<oidb_cmd0xe27$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_in_out_qq"}, new Object[]{null}, oidb_cmd0xe27$ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xe27$InOutQQ> rpt_msg_in_out_qq = PBField.initRepeatMessage(oidb_cmd0xe27$InOutQQ.class);
}
