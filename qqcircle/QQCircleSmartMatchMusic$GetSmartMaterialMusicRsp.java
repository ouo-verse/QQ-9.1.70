package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp extends MessageMicro<QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"musics"}, new Object[]{null}, QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp.class);
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> musics = PBField.initRepeatMessage(QQCircleSmartMatchMusic$MusicInfo.class);
}
