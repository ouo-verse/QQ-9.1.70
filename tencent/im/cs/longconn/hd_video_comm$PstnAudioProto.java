package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class hd_video_comm$PstnAudioProto extends MessageMicro<hd_video_comm$PstnAudioProto> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74}, new String[]{"uint32_audio_pt", "uint32_audio_sample", "uint32_audio_ptime", "uint32_proto", "uint32_rfc2833_pt", "uint32_max_average_bitrate", "uint32_use_inband_fec", "uint32_used_tx", "rpt_srtp_info"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, null}, hd_video_comm$PstnAudioProto.class);
    public final PBUInt32Field uint32_audio_pt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audio_sample = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audio_ptime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_proto = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rfc2833_pt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_average_bitrate = PBField.initUInt32(0);
    public final PBUInt32Field uint32_use_inband_fec = PBField.initUInt32(0);
    public final PBUInt32Field uint32_used_tx = PBField.initUInt32(0);
    public final PBRepeatMessageField<hd_video_comm$PstnAudioSrtpSdpInfo> rpt_srtp_info = PBField.initRepeatMessage(hd_video_comm$PstnAudioSrtpSdpInfo.class);
}
