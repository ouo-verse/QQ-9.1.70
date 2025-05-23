package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class adSchedule$QueryAllRsp extends MessageMicro<adSchedule$QueryAllRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"apps", "next_req_gap"}, new Object[]{null, 0L}, adSchedule$QueryAllRsp.class);
    public final PBRepeatMessageField<adSchedule$App> apps = PBField.initRepeatMessage(adSchedule$App.class);
    public final PBInt64Field next_req_gap = PBField.initInt64(0);
}
