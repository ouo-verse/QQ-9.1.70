package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_file_common$OverwriteInfo extends MessageMicro<group_file_common$OverwriteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_file_id", "uint32_download_times"}, new Object[]{"", 0}, group_file_common$OverwriteInfo.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
}
