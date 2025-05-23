package tencent.im.msg;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_sys_msg_common$Msg extends MessageMicro<nt_sys_msg_common$Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"routing_head", "content_head", "body"}, new Object[]{null, null, null}, nt_sys_msg_common$Msg.class);
    public nt_sys_msg_common$RoutingHead routing_head = new nt_sys_msg_common$RoutingHead();
    public nt_sys_msg_common$ContentHead content_head = new MessageMicro<nt_sys_msg_common$ContentHead>() { // from class: tencent.im.msg.nt_sys_msg_common$ContentHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "sub_type", "c2c_cmd", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "msg_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "pkg_num", "pkg_index", "div_seq", "auto_reply", "nt_msg_seq", "msg_uid"}, new Object[]{0L, 0L, 0, 0L, 0L, 0L, 0, 0, 0, 0, 0L, 0L}, nt_sys_msg_common$ContentHead.class);
        public final PBUInt64Field msg_type = PBField.initUInt64(0);
        public final PBUInt64Field sub_type = PBField.initUInt64(0);
        public final PBUInt32Field c2c_cmd = PBField.initUInt32(0);
        public final PBUInt64Field random = PBField.initUInt64(0);
        public final PBUInt64Field msg_seq = PBField.initUInt64(0);
        public final PBUInt64Field msg_time = PBField.initUInt64(0);
        public final PBUInt32Field pkg_num = PBField.initUInt32(0);
        public final PBUInt32Field pkg_index = PBField.initUInt32(0);
        public final PBUInt32Field div_seq = PBField.initUInt32(0);
        public final PBUInt32Field auto_reply = PBField.initUInt32(0);
        public final PBUInt64Field nt_msg_seq = PBField.initUInt64(0);
        public final PBUInt64Field msg_uid = PBField.initUInt64(0);
    };
    public nt_im_msg_body$MsgBody body = new nt_im_msg_body$MsgBody();
}
