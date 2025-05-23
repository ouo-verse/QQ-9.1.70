package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiSmobaOuterClass$WujiSmobaShowTypeConfList extends MessageMicro<WujiSmobaOuterClass$WujiSmobaShowTypeConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiSmobaOuterClass$WujiSmobaShowTypeConfList.class);
    public final PBRepeatMessageField<WujiSmobaOuterClass$WujiSmobaShowTypeConf> data = PBField.initRepeatMessage(WujiSmobaOuterClass$WujiSmobaShowTypeConf.class);
}
