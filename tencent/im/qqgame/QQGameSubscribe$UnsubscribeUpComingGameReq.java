package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$UnsubscribeUpComingGameReq extends MessageMicro<QQGameSubscribe$UnsubscribeUpComingGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", "source"}, new Object[]{"", ""}, QQGameSubscribe$UnsubscribeUpComingGameReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField source = PBField.initString("");
}
