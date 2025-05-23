package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$GetTaskRoomSchemaReq extends MessageMicro<LiveActivityServerOuterClass$GetTaskRoomSchemaReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uid", "task_type"}, new Object[]{0L, 1}, LiveActivityServerOuterClass$GetTaskRoomSchemaReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBEnumField task_type = PBField.initEnum(1);
}
