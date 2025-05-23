package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_file_common$FileItem extends MessageMicro<group_file_common$FileItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_type", "folder_info", "file_info"}, new Object[]{0, null, null}, group_file_common$FileItem.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public group_file_common$FolderInfo folder_info = new group_file_common$FolderInfo();
    public group_file_common$FileInfo file_info = new group_file_common$FileInfo();
}
