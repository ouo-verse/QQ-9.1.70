package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$MyItemInfo extends MessageMicro<CsCommon$MyItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"item_id", "buy_time"}, new Object[]{0, 0L}, CsCommon$MyItemInfo.class);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBUInt64Field buy_time = PBField.initUInt64(0);
}
