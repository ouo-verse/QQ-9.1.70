package tencent.im.oidb.cmd0xf51;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf51$ReqBody extends MessageMicro<oidb_cmd0xf51$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_c2c_msg_info", "msg_group_msg_info", "msg_comm_gray_tips_info"}, new Object[]{null, null, null}, oidb_cmd0xf51$ReqBody.class);
    public oidb_cmd0xf51$C2CMsgInfo msg_c2c_msg_info = new oidb_cmd0xf51$C2CMsgInfo();
    public oidb_cmd0xf51$GroupMsgInfo msg_group_msg_info = new oidb_cmd0xf51$GroupMsgInfo();
    public oidb_cmd0xf51$CommGrayTipsInfo msg_comm_gray_tips_info = new oidb_cmd0xf51$CommGrayTipsInfo();
}
