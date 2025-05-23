package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class adSchedule$QueryRsp extends MessageMicro<adSchedule$QueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField preordered = PBField.initBool(false);
    public final PBBoolField downloaded = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"preordered", "downloaded"}, new Object[]{bool, bool}, adSchedule$QueryRsp.class);
    }
}
