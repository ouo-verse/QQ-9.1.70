package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetMusicCollectionReq extends MessageMicro<QQCircleSmartMatchMusic$GetMusicCollectionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"collectionID", "attachInfo"}, new Object[]{"", ""}, QQCircleSmartMatchMusic$GetMusicCollectionReq.class);
    public final PBStringField collectionID = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
}
