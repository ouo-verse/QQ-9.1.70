package tencent.im.oidb.cmd0x6d7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.cs.group_file_common.group_file_common$FolderInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d7$RspBody extends MessageMicro<oidb_0x6d7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"create_folder_rsp", "delete_folder_rsp", "rename_folder_rsp", "move_folder_rsp"}, new Object[]{null, null, null, null}, oidb_0x6d7$RspBody.class);
    public oidb_0x6d7$CreateFolderRspBody create_folder_rsp = new oidb_0x6d7$CreateFolderRspBody();
    public oidb_0x6d7$DeleteFolderRspBody delete_folder_rsp = new oidb_0x6d7$DeleteFolderRspBody();
    public oidb_0x6d7$RenameFolderRspBody rename_folder_rsp = new oidb_0x6d7$RenameFolderRspBody();
    public oidb_0x6d7$MoveFolderRspBody move_folder_rsp = new MessageMicro<oidb_0x6d7$MoveFolderRspBody>() { // from class: tencent.im.oidb.cmd0x6d7.oidb_0x6d7$MoveFolderRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "folder_info"}, new Object[]{0, "", "", null}, oidb_0x6d7$MoveFolderRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_ret_msg = PBField.initString("");
        public final PBStringField str_client_wording = PBField.initString("");
        public group_file_common$FolderInfo folder_info = new group_file_common$FolderInfo();
    };
}
