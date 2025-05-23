package qqcircle;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleYuhengActivity$PrizeDetail extends MessageMicro<QQCircleYuhengActivity$PrizeDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 64, 72, 80}, new String[]{"prize_id", "prize_type", "prize_name", "material_id", "detail", "creator", AlbumCacheData.CREATE_TIME, "start_time", "end_time"}, new Object[]{0L, 0, "", "", null, "", 0L, 0L, 0L}, QQCircleYuhengActivity$PrizeDetail.class);
    public final PBInt64Field prize_id = PBField.initInt64(0);
    public final PBEnumField prize_type = PBField.initEnum(0);
    public final PBStringField prize_name = PBField.initString("");
    public final PBStringField material_id = PBField.initString("");
    public QQCircleYuhengActivity$PrizeInfo detail = new QQCircleYuhengActivity$PrizeInfo();
    public final PBStringField creator = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field start_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
}
