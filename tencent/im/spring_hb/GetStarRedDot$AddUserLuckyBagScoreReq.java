package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$AddUserLuckyBagScoreReq extends MessageMicro<GetStarRedDot$AddUserLuckyBagScoreReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"ID", "scene", "count", "promotion_id"}, new Object[]{"", 0, 0, 0}, GetStarRedDot$AddUserLuckyBagScoreReq.class);
    public final PBStringField ID = PBField.initString("");
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
}
