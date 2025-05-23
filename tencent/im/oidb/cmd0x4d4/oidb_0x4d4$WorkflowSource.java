package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x4d4$WorkflowSource extends MessageMicro<oidb_0x4d4$WorkflowSource> {
    public static final int NEED_APPROVE = 2;
    public static final int NEED_OBSERVE = 1;
    public static final int SELF_CREATE = 3;
    public static final int SHARED = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"enum_source_type"}, new Object[]{1}, oidb_0x4d4$WorkflowSource.class);
    public final PBEnumField enum_source_type = PBField.initEnum(1);
}
