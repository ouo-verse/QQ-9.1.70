package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d6$ReqBody extends MessageMicro<oidb_0x6d6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"upload_file_req", "resend_file_req", "download_file_req", "delete_file_req", "rename_file_req", "move_file_req"}, new Object[]{null, null, null, null, null, null}, oidb_0x6d6$ReqBody.class);
    public oidb_0x6d6$UploadFileReqBody upload_file_req = new oidb_0x6d6$UploadFileReqBody();
    public oidb_0x6d6$ResendReqBody resend_file_req = new oidb_0x6d6$ResendReqBody();
    public oidb_0x6d6$DownloadFileReqBody download_file_req = new oidb_0x6d6$DownloadFileReqBody();
    public oidb_0x6d6$DeleteFileReqBody delete_file_req = new oidb_0x6d6$DeleteFileReqBody();
    public oidb_0x6d6$RenameFileReqBody rename_file_req = new MessageMicro<oidb_0x6d6$RenameFileReqBody>() { // from class: tencent.im.oidb.cmd0x6d6.oidb_0x6d6$RenameFileReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "str_parent_folder_id", "str_new_file_name"}, new Object[]{0L, 0, 0, "", "", ""}, oidb_0x6d6$RenameFileReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
        public final PBStringField str_file_id = PBField.initString("");
        public final PBStringField str_parent_folder_id = PBField.initString("");
        public final PBStringField str_new_file_name = PBField.initString("");
    };
    public oidb_0x6d6$MoveFileReqBody move_file_req = new oidb_0x6d6$MoveFileReqBody();
}
