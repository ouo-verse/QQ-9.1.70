package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedAlbum$GetUserAlbumsReq extends MessageMicro<QQCircleFeedAlbum$GetUserAlbumsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"user_id", "count", "attach_info", "skip"}, new Object[]{"", 0, "", 0L}, QQCircleFeedAlbum$GetUserAlbumsReq.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt64Field skip = PBField.initInt64(0);
}
