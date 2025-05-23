package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hd_video_putinfo$ReqBody extends MessageMicro<hd_video_putinfo$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_putinfo_head", "msg_report_client_info_req_body"}, new Object[]{null, null}, hd_video_putinfo$ReqBody.class);
    public hd_video_putinfo$PutinfoHead msg_putinfo_head = new hd_video_putinfo$PutinfoHead();
    public hd_video_putinfo$CmdReportClientInfoReqBody msg_report_client_info_req_body = new hd_video_putinfo$CmdReportClientInfoReqBody();
}
