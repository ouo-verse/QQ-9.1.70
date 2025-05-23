package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$AlbumInfo extends MessageMicro<QQCircleSmartMatchMusic$AlbumInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"iD", "mID", "name", "picURL"}, new Object[]{0L, "", "", ""}, QQCircleSmartMatchMusic$AlbumInfo.class);
    public final PBInt64Field iD = PBField.initInt64(0);
    public final PBStringField mID = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField picURL = PBField.initString("");
}
