package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class WujiShopOuterClass$WujiLotteryConfList extends MessageMicro<WujiShopOuterClass$WujiLotteryConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiShopOuterClass$WujiLotteryConfList.class);
    public final PBRepeatMessageField<WujiShopOuterClass$WujiLotteryConf> data = PBField.initRepeatMessage(WujiShopOuterClass$WujiLotteryConf.class);
}
