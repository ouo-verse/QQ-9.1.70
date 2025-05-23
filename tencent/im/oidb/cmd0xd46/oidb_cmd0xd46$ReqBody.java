package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd46$ReqBody extends MessageMicro<oidb_cmd0xd46$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98}, new String[]{"uint32_oper_type", "msg_ks_clear_unread_req", "msg_ks_get_subscribed_list_req"}, new Object[]{0, null, null}, oidb_cmd0xd46$ReqBody.class);
    public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
    public oidb_cmd0xd46$KsClearUnreadReq msg_ks_clear_unread_req = new MessageMicro<oidb_cmd0xd46$KsClearUnreadReq>() { // from class: tencent.im.oidb.cmd0xd46.oidb_cmd0xd46$KsClearUnreadReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint32_ks_topic_id_list"}, new Object[]{0}, oidb_cmd0xd46$KsClearUnreadReq.class);
        public final PBRepeatField<Integer> rpt_uint32_ks_topic_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
    public oidb_cmd0xd46$KsGetSubscribedListReq msg_ks_get_subscribed_list_req = new MessageMicro<oidb_cmd0xd46$KsGetSubscribedListReq>() { // from class: tencent.im.oidb.cmd0xd46.oidb_cmd0xd46$KsGetSubscribedListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_result_type"}, new Object[]{0}, oidb_cmd0xd46$KsGetSubscribedListReq.class);
        public final PBUInt32Field uint32_result_type = PBField.initUInt32(0);
    };
}
