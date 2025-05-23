package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.icgame.data.login.nano.LoginBusinessData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$RspBody extends MessageMicro<oidb_0xfc2$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 40, 882, 1682, 2482, 3282, LoginBusinessData.MiddlePlatformError}, new String[]{"msg_cmd", "msg_bus_type", "msg_apply_upload_rsp", "msg_upload_completed_rsp", "msg_apply_download_rsp", "msg_apply_preview_rsp", "msg_apply_security_strike_rsp"}, new Object[]{0, 0, null, null, null, null, null}, oidb_0xfc2$RspBody.class);
    public final PBEnumField msg_cmd = PBField.initEnum(0);
    public final PBEnumField msg_bus_type = PBField.initEnum(0);
    public oidb_0xfc2$ApplyUploadRsp msg_apply_upload_rsp = new oidb_0xfc2$ApplyUploadRsp();
    public oidb_0xfc2$UploadCompletedRsp msg_upload_completed_rsp = new oidb_0xfc2$UploadCompletedRsp();
    public oidb_0xfc2$ApplyDownloadRsp msg_apply_download_rsp = new oidb_0xfc2$ApplyDownloadRsp();
    public oidb_0xfc2$ApplyPreviewRsp msg_apply_preview_rsp = new oidb_0xfc2$ApplyPreviewRsp();
    public oidb_0xfc2$SecurityStrikeRsp msg_apply_security_strike_rsp = new MessageMicro<oidb_0xfc2$SecurityStrikeRsp>() { // from class: tencent.im.oidb.cmd0xfc2.oidb_0xfc2$SecurityStrikeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_download_info"}, new Object[]{null}, oidb_0xfc2$SecurityStrikeRsp.class);
        public oidb_0xfc2$DownloadInfo msg_download_info = new oidb_0xfc2$DownloadInfo();
    };
}
