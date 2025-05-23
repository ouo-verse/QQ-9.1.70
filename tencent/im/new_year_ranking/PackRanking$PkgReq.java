package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PackRanking$PkgReq extends MessageMicro<PackRanking$PkgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82}, new String[]{"cmdtype", "uin", "query_ranking"}, new Object[]{0, 0L, null}, PackRanking$PkgReq.class);
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public PackRanking$QueryRankingReq query_ranking = new PackRanking$QueryRankingReq();
}
