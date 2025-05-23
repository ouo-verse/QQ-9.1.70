package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$LiveAddPowerReq extends MessageMicro<LiveActivityServerOuterClass$LiveAddPowerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uid", "power", "ext_info"}, new Object[]{0L, 0L, ""}, LiveActivityServerOuterClass$LiveAddPowerReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field power = PBField.initUInt64(0);
    public final PBStringField ext_info = PBField.initString("");
}
