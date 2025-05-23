package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sysmsg_0x20c_0x20$UploadFileRemind extends MessageMicro<sysmsg_0x20c_0x20$UploadFileRemind> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"u64_discuss_code"}, new Object[]{0L}, sysmsg_0x20c_0x20$UploadFileRemind.class);
    public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0);
}
