package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCreatorAdvSvr$AdvJobDetail extends MessageMicro<QQCircleCreatorAdvSvr$AdvJobDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"title", "summary", "picUrl", "corporationName"}, new Object[]{"", "", "", ""}, QQCircleCreatorAdvSvr$AdvJobDetail.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField picUrl = PBField.initString("");
    public final PBStringField corporationName = PBField.initString("");
}
