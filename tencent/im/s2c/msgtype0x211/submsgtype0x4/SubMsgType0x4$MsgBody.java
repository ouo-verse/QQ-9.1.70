package tencent.im.s2c.msgtype0x211.submsgtype0x4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_body$NotOnlineFile;
import tencent.im.msg.resv21.hummer_resv_21$FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21$ResvAttr;
import tencent.im.msg.resv21.hummer_resv_21$XtfSenderInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x4$MsgBody extends MessageMicro<SubMsgType0x4$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58}, new String[]{"msg_not_online_file", "uint32_msg_time", "uint32_OnlineFileForPolyToOffline", "file_image_info", "msg_xtf_sender_info", "resv_attr", "msg_wlan_recved_notify"}, new Object[]{null, 0, 0, null, null, null, null}, SubMsgType0x4$MsgBody.class);
    public im_msg_body$NotOnlineFile msg_not_online_file = new im_msg_body$NotOnlineFile();
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_OnlineFileForPolyToOffline = PBField.initUInt32(0);
    public hummer_resv_21$FileImgInfo file_image_info = new hummer_resv_21$FileImgInfo();
    public hummer_resv_21$XtfSenderInfo msg_xtf_sender_info = new MessageMicro<hummer_resv_21$XtfSenderInfo>() { // from class: tencent.im.msg.resv21.hummer_resv_21$XtfSenderInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_lan_ip", "uint32_lan_port", "uint64_lan_srkey"}, new Object[]{0, 0, 0L}, hummer_resv_21$XtfSenderInfo.class);
        public final PBUInt32Field uint32_lan_ip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_lan_port = PBField.initUInt32(0);
        public final PBUInt64Field uint64_lan_srkey = PBField.initUInt64(0);
    };
    public hummer_resv_21$ResvAttr resv_attr = new hummer_resv_21$ResvAttr();
    public SubMsgType0x4$WlanRecvNotify msg_wlan_recved_notify = new SubMsgType0x4$WlanRecvNotify();
}
