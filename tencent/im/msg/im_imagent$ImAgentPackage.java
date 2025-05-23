package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class im_imagent$ImAgentPackage extends MessageMicro<im_imagent$ImAgentPackage> {
    public static final int HEAD_FIELD_NUMBER = 1;
    public static final int MSG_SEND_REQ_FIELD_NUMBER = 11;
    public static final int MSG_SEND_RESP_FIELD_NUMBER = 12;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 90, 98}, new String[]{"head", "msg_send_req", "msg_send_resp"}, new Object[]{null, null, null}, im_imagent$ImAgentPackage.class);
    public im_imagent$ImAgentHead head = new im_imagent$ImAgentHead();
    public im_msg$MsgSendReq msg_send_req = new im_msg$MsgSendReq();
    public im_msg$MsgSendResp msg_send_resp = new MessageMicro<im_msg$MsgSendResp>() { // from class: tencent.im.msg.im_msg$MsgSendResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], im_msg$MsgSendResp.class);
    };
}
