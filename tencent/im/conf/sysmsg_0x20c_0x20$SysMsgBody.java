package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sysmsg_0x20c_0x20$SysMsgBody extends MessageMicro<sysmsg_0x20c_0x20$SysMsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"u32_cmd", "msg_convert_to_group", "msg_mem_num_remind", "msg_upload_file_remind"}, new Object[]{0, null, null, null}, sysmsg_0x20c_0x20$SysMsgBody.class);
    public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
    public sysmsg_0x20c_0x20$Convert2Group msg_convert_to_group = new sysmsg_0x20c_0x20$Convert2Group();
    public sysmsg_0x20c_0x20$MemberNumRemind msg_mem_num_remind = new sysmsg_0x20c_0x20$MemberNumRemind();
    public sysmsg_0x20c_0x20$UploadFileRemind msg_upload_file_remind = new sysmsg_0x20c_0x20$UploadFileRemind();
}
