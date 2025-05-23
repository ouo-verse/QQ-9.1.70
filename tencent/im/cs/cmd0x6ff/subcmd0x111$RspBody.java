package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x111$RspBody extends MessageMicro<subcmd0x111$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{2186}, new String[]{"msg_subcmd_0x111_rsp_body"}, new Object[]{null}, subcmd0x111$RspBody.class);
    public subcmd0x111$SubCmd0x111RspBody msg_subcmd_0x111_rsp_body = new MessageMicro<subcmd0x111$SubCmd0x111RspBody>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x111$SubCmd0x111RspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_contentItem"}, new Object[]{null}, subcmd0x111$SubCmd0x111RspBody.class);
        public final PBRepeatMessageField<subcmd0x111$ContentItem> rpt_msg_contentItem = PBField.initRepeatMessage(subcmd0x111$ContentItem.class);
    };
}
