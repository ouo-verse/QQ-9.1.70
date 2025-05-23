package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PackRanking$RankingInfo extends MessageMicro<PackRanking$RankingInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uin", "ranking", "count", "elems"}, new Object[]{0L, 0, 0, null}, PackRanking$RankingInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field ranking = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBRepeatMessageField<PackRanking$RankingElem> elems = PBField.initRepeatMessage(PackRanking$RankingElem.class);
}
