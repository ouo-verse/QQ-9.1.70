package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$ModMusicCollectionReq extends MessageMicro<QQCircleSmartMatchMusic$ModMusicCollectionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"collectionID", "mid", "modCmd"}, new Object[]{"", "", 0}, QQCircleSmartMatchMusic$ModMusicCollectionReq.class);
    public final PBStringField collectionID = PBField.initString("");
    public final PBStringField mid = PBField.initString("");
    public final PBEnumField modCmd = PBField.initEnum(0);
}
