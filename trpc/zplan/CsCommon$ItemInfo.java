package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$ItemInfo extends MessageMicro<CsCommon$ItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"item_id", "inst_id", "purchase_time"}, new Object[]{0, 0L, 0L}, CsCommon$ItemInfo.class);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBUInt64Field inst_id = PBField.initUInt64(0);
    public final PBUInt64Field purchase_time = PBField.initUInt64(0);
}
