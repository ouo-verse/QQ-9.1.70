package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp extends MessageMicro<QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"categoryInfo"}, new Object[]{null}, QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp.class);
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$MusicCategoryInfo> categoryInfo = PBField.initRepeatMessage(QQCircleSmartMatchMusic$MusicCategoryInfo.class);
}
