package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg$MsgHead extends MessageMicro<im_msg$MsgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"routing_head", "content_head", "gbk_tmp_msg_body"}, new Object[]{null, null, ByteStringMicro.EMPTY}, im_msg$MsgHead.class);
    public im_msg$RoutingHead routing_head = new im_msg$RoutingHead();
    public im_msg$ContentHead content_head = new im_msg$ContentHead();
    public final PBBytesField gbk_tmp_msg_body = PBField.initBytes(ByteStringMicro.EMPTY);
}
