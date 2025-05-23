package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd46$RspBody extends MessageMicro<oidb_cmd0xd46$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"msg_ks_clear_unread_rsp", "msg_ks_get_subscribed_list_rsp"}, new Object[]{null, null}, oidb_cmd0xd46$RspBody.class);
    public oidb_cmd0xd46$KsClearUnreadRsp msg_ks_clear_unread_rsp = new MessageMicro<oidb_cmd0xd46$KsClearUnreadRsp>() { // from class: tencent.im.oidb.cmd0xd46.oidb_cmd0xd46$KsClearUnreadRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xd46$KsClearUnreadRsp.class);
    };
    public oidb_cmd0xd46$KsGetSubscribedListRsp msg_ks_get_subscribed_list_rsp = new MessageMicro<oidb_cmd0xd46$KsGetSubscribedListRsp>() { // from class: tencent.im.oidb.cmd0xd46.oidb_cmd0xd46$KsGetSubscribedListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_ks_subscribed_list"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xd46$KsGetSubscribedListRsp.class);
        public final PBBytesField bytes_ks_subscribed_list = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
