package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp extends MessageMicro<QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"musicInfoList", "attachInfo"}, new Object[]{null, ""}, QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp.class);
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> musicInfoList = PBField.initRepeatMessage(QQCircleSmartMatchMusic$MusicInfo.class);
    public final PBStringField attachInfo = PBField.initString("");
}
