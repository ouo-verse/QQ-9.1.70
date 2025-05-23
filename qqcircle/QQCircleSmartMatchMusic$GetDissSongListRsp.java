package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetDissSongListRsp extends MessageMicro<QQCircleSmartMatchMusic$GetDissSongListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"songList", "attachInfo", "isEnd"}, new Object[]{null, "", Boolean.FALSE}, QQCircleSmartMatchMusic$GetDissSongListRsp.class);
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> songList = PBField.initRepeatMessage(QQCircleSmartMatchMusic$MusicInfo.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBoolField isEnd = PBField.initBool(false);
}
