package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PackRanking$RankingElem extends MessageMicro<PackRanking$RankingElem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "count"}, new Object[]{0L, 0}, PackRanking$RankingElem.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
}
