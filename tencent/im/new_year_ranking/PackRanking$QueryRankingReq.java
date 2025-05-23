package tencent.im.new_year_ranking;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PackRanking$QueryRankingReq extends MessageMicro<PackRanking$QueryRankingReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"flag", WidgetCacheConstellationData.NUM}, new Object[]{3, 100}, PackRanking$QueryRankingReq.class);
    public final PBEnumField flag = PBField.initEnum(3);
    public final PBUInt32Field num = PBField.initUInt32(100);
}
