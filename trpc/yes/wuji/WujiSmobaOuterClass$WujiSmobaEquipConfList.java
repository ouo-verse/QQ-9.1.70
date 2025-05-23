package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiSmobaOuterClass$WujiSmobaEquipConfList extends MessageMicro<WujiSmobaOuterClass$WujiSmobaEquipConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiSmobaOuterClass$WujiSmobaEquipConfList.class);
    public final PBRepeatMessageField<WujiSmobaOuterClass$WujiSmobaEquipConf> data = PBField.initRepeatMessage(WujiSmobaOuterClass$WujiSmobaEquipConf.class);
}
