package tencent.im.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_msg_common$MsgHead extends MessageMicro<nt_msg_common$MsgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"routing_head", "content_head"}, new Object[]{null, null}, nt_msg_common$MsgHead.class);
    public nt_msg_common$RoutingHead routing_head = new nt_msg_common$RoutingHead();
    public nt_msg_common$ContentHead content_head = new nt_msg_common$ContentHead();
}
