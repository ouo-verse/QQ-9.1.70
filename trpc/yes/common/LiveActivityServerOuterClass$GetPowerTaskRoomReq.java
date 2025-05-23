package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$GetPowerTaskRoomReq extends MessageMicro<LiveActivityServerOuterClass$GetPowerTaskRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "task_type"}, new Object[]{0L, 1}, LiveActivityServerOuterClass$GetPowerTaskRoomReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBEnumField task_type = PBField.initEnum(1);
}
