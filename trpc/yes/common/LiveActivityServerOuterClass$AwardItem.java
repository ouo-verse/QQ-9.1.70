package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$AwardItem extends MessageMicro<LiveActivityServerOuterClass$AwardItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"index", "icon", "name", "total", "type"}, new Object[]{0, "", "", 0, 0}, LiveActivityServerOuterClass$AwardItem.class);
    public final PBInt32Field index = PBField.initInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
}
