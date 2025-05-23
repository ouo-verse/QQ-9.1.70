package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$AddUserLuckyBagScoreRsp extends MessageMicro<GetStarRedDot$AddUserLuckyBagScoreRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"add_score", "total"}, new Object[]{0, 0}, GetStarRedDot$AddUserLuckyBagScoreRsp.class);
    public final PBUInt32Field add_score = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
}
