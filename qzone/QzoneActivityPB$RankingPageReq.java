package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$RankingPageReq extends MessageMicro<QzoneActivityPB$RankingPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 34}, new String[]{"count", "cookie"}, new Object[]{0, ""}, QzoneActivityPB$RankingPageReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField cookie = PBField.initString("");
}
