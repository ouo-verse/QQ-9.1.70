package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class QsmDataOuterClass$QSMIDIPPlayerPerSeasonInfo extends MessageMicro<QsmDataOuterClass$QSMIDIPPlayerPerSeasonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58}, new String[]{"ladder_season_id", "ladder_season_start_time", "ladder_season_end_time", "ladder_rank_index", "ladder_rank_score", "ladder_rank_index_name", "area_rank"}, new Object[]{0, 0L, 0L, 0, 0, "", null}, QsmDataOuterClass$QSMIDIPPlayerPerSeasonInfo.class);
    public final PBUInt32Field ladder_season_id = PBField.initUInt32(0);
    public final PBUInt64Field ladder_season_start_time = PBField.initUInt64(0);
    public final PBUInt64Field ladder_season_end_time = PBField.initUInt64(0);
    public final PBUInt32Field ladder_rank_index = PBField.initUInt32(0);
    public final PBUInt32Field ladder_rank_score = PBField.initUInt32(0);
    public final PBStringField ladder_rank_index_name = PBField.initString("");
    public QsmDataOuterClass$QSMIDIPPlayerAreaRank area_rank = new QsmDataOuterClass$QSMIDIPPlayerAreaRank();
}
