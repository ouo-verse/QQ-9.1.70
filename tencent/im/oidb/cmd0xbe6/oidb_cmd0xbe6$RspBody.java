package tencent.im.oidb.cmd0xbe6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbe6$RspBody extends MessageMicro<oidb_cmd0xbe6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_get_channel_info_rsp", "string_channel_version"}, new Object[]{null, ""}, oidb_cmd0xbe6$RspBody.class);
    public oidb_cmd0xbe6$MsgGetChannelInfoRsp msg_get_channel_info_rsp = new MessageMicro<oidb_cmd0xbe6$MsgGetChannelInfoRsp>() { // from class: tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6$MsgGetChannelInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_channel_info"}, new Object[]{null}, oidb_cmd0xbe6$MsgGetChannelInfoRsp.class);
        public final PBRepeatMessageField<oidb_cmd0xbe6$MsgChannelInfo> rpt_msg_channel_info = PBField.initRepeatMessage(oidb_cmd0xbe6$MsgChannelInfo.class);
    };
    public final PBStringField string_channel_version = PBField.initString("");
}
