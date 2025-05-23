package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$MsgHead extends MessageMicro<common$MsgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"routing_head", "content_head"}, new Object[]{null, null}, common$MsgHead.class);
    public common$RoutingHead routing_head = new common$RoutingHead();
    public common$ContentHead content_head = new common$ContentHead();
}
