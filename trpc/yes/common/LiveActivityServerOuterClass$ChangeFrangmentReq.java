package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$ChangeFrangmentReq extends MessageMicro<LiveActivityServerOuterClass$ChangeFrangmentReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uid", "commodity_id"}, new Object[]{0L, 0}, LiveActivityServerOuterClass$ChangeFrangmentReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field commodity_id = PBField.initInt32(0);
}
