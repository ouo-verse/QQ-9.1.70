package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_putinfo$CmdToClientConfigInfoRspBody extends MessageMicro<hd_video_putinfo$CmdToClientConfigInfoRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 26, 34, 42, 48, 58, 66, 74}, new String[]{"uint32_log_flag", "bytes_log_report_time", "msg_android_camera_set", "msg_sharp_trae_info_set", "uint64_switch", "msg_qq_ptt_info_set", "msg_audio_quality_set", "rpt_msg_trans_buffer_list"}, new Object[]{0, ByteStringMicro.EMPTY, null, null, 0L, null, null, null}, hd_video_putinfo$CmdToClientConfigInfoRspBody.class);
    public final PBUInt32Field uint32_log_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_log_report_time = PBField.initBytes(ByteStringMicro.EMPTY);
    public hd_video_putinfo$AndroidCameraInfo msg_android_camera_set = new hd_video_putinfo$AndroidCameraInfo();
    public hd_video_putinfo$SharpTraeInfo msg_sharp_trae_info_set = new hd_video_putinfo$SharpTraeInfo();
    public final PBUInt64Field uint64_switch = PBField.initUInt64(0);
    public hd_video_putinfo$MobileQQPttInfo msg_qq_ptt_info_set = new hd_video_putinfo$MobileQQPttInfo();
    public hd_video_putinfo$AudioSwitchPointInfo msg_audio_quality_set = new hd_video_putinfo$AudioSwitchPointInfo();
    public final PBRepeatMessageField<hd_video_putinfo$TransBuffer> rpt_msg_trans_buffer_list = PBField.initRepeatMessage(hd_video_putinfo$TransBuffer.class);
}
