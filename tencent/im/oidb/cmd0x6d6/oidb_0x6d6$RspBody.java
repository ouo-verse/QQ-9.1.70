package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d6$RspBody extends MessageMicro<oidb_0x6d6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"upload_file_rsp", "resend_file_rsp", "download_file_rsp", "delete_file_rsp", "rename_file_rsp", "move_file_rsp"}, new Object[]{null, null, null, null, null, null}, oidb_0x6d6$RspBody.class);
    public oidb_0x6d6$UploadFileRspBody upload_file_rsp = new oidb_0x6d6$UploadFileRspBody();
    public oidb_0x6d6$ResendRspBody resend_file_rsp = new oidb_0x6d6$ResendRspBody();
    public oidb_0x6d6$DownloadFileRspBody download_file_rsp = new oidb_0x6d6$DownloadFileRspBody();
    public oidb_0x6d6$DeleteFileRspBody delete_file_rsp = new oidb_0x6d6$DeleteFileRspBody();
    public oidb_0x6d6$RenameFileRspBody rename_file_rsp = new MessageMicro<oidb_0x6d6$RenameFileRspBody>() { // from class: tencent.im.oidb.cmd0x6d6.oidb_0x6d6$RenameFileRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording"}, new Object[]{0, "", ""}, oidb_0x6d6$RenameFileRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
    };
    public oidb_0x6d6$MoveFileRspBody move_file_rsp = new oidb_0x6d6$MoveFileRspBody();
}
