package tencent.im.oidb.cloud_print;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cloud_print$GetFileDownloadKeyReq extends MessageMicro<cloud_print$GetFileDownloadKeyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"mini_program_info", "file_scene_type", "file_download_req_params"}, new Object[]{null, 0, null}, cloud_print$GetFileDownloadKeyReq.class);
    public cloud_print$QQMiniProgramInfo mini_program_info = new cloud_print$QQMiniProgramInfo();
    public final PBEnumField file_scene_type = PBField.initEnum(0);
    public cloud_print$QQFileDownloadReqParams file_download_req_params = new cloud_print$QQFileDownloadReqParams();
}
