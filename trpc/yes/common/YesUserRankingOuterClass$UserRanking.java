package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesUserRankingOuterClass$UserRanking extends MessageMicro<YesUserRankingOuterClass$UserRanking> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"UInfo", "RIdx", "Score", "RType"}, new Object[]{null, 0, "", 0}, YesUserRankingOuterClass$UserRanking.class);
    public CommonOuterClass$QQUserId UInfo = new CommonOuterClass$QQUserId();
    public final PBUInt32Field RIdx = PBField.initUInt32(0);
    public final PBStringField Score = PBField.initString("");
    public final PBEnumField RType = PBField.initEnum(0);
}
