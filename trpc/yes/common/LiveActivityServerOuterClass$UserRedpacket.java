package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$UserRedpacket extends MessageMicro<LiveActivityServerOuterClass$UserRedpacket> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"activity_id", "status"}, new Object[]{"", 0}, LiveActivityServerOuterClass$UserRedpacket.class);
    public final PBStringField activity_id = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
}
