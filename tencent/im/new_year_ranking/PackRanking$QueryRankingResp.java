package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes29.dex */
public final class PackRanking$QueryRankingResp extends MessageMicro<PackRanking$QueryRankingResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rank_swipe", "rank_combo"}, new Object[]{null, null}, PackRanking$QueryRankingResp.class);
    public PackRanking$RankingInfo rank_swipe = new PackRanking$RankingInfo();
    public PackRanking$RankingInfo rank_combo = new PackRanking$RankingInfo();
}
