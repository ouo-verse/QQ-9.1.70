package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$ItemCollectInfo extends MessageMicro<CsCommon$ItemCollectInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"item_id", "add_time"}, new Object[]{0, 0L}, CsCommon$ItemCollectInfo.class);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBUInt64Field add_time = PBField.initUInt64(0);
}
