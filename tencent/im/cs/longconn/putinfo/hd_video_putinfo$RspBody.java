package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_putinfo$RspBody extends MessageMicro<hd_video_putinfo$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_putinfo_head", "msg_to_client_config_info_rsq_body"}, new Object[]{null, null}, hd_video_putinfo$RspBody.class);
    public hd_video_putinfo$PutinfoHead msg_putinfo_head = new hd_video_putinfo$PutinfoHead();
    public hd_video_putinfo$CmdToClientConfigInfoRspBody msg_to_client_config_info_rsq_body = new hd_video_putinfo$CmdToClientConfigInfoRspBody();
}
