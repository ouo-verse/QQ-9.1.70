package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class AIFacePtaData$CoinInfo extends MessageMicro<AIFacePtaData$CoinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"coin_type", "coin_price"}, new Object[]{0, 0}, AIFacePtaData$CoinInfo.class);
    public final PBEnumField coin_type = PBField.initEnum(0);
    public final PBInt32Field coin_price = PBField.initInt32(0);
}
