package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$SubscribeUpComingGameReq extends MessageMicro<QQGameSubscribe$SubscribeUpComingGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 64, 72, 82}, new String[]{"appID", "source", "subscribeType", "needArk", "channelID", "scheduleID", "oasisActID", "sendWarehouseType", "need_gift", "businessInfo"}, new Object[]{"", "", 0, 0, "", "", "", 0, 0, ""}, QQGameSubscribe$SubscribeUpComingGameReq.class);
    public final PBStringField appID = PBField.initString("");
    public final PBStringField source = PBField.initString("");
    public final PBInt32Field subscribeType = PBField.initInt32(0);
    public final PBInt32Field needArk = PBField.initInt32(0);
    public final PBStringField channelID = PBField.initString("");
    public final PBStringField scheduleID = PBField.initString("");
    public final PBStringField oasisActID = PBField.initString("");
    public final PBInt32Field sendWarehouseType = PBField.initInt32(0);
    public final PBInt32Field need_gift = PBField.initInt32(0);
    public final PBStringField businessInfo = PBField.initString("");
}
