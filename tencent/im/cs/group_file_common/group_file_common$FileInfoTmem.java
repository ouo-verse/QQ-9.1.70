package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_file_common$FileInfoTmem extends MessageMicro<group_file_common$FileInfoTmem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_group_code", "rpt_files"}, new Object[]{0L, null}, group_file_common$FileInfoTmem.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<group_file_common$FileInfo> rpt_files = PBField.initRepeatMessage(group_file_common$FileInfo.class);
}
