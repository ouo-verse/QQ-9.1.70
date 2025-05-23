package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class adSchedule$QueryReq extends MessageMicro<adSchedule$QueryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"app_id"}, new Object[]{""}, adSchedule$QueryReq.class);
    public final PBStringField app_id = PBField.initString("");
}
