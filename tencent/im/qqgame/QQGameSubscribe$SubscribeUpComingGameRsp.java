package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$SubscribeUpComingGameRsp extends MessageMicro<QQGameSubscribe$SubscribeUpComingGameRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 64, 72, 82}, new String[]{"result", "message", "tribeID", "yybPreDownloadId", "jumpText", "tribeURL", "shareSource", "appType", "noticeID"}, new Object[]{0, "", "", "", "", "", 0, 0, ""}, QQGameSubscribe$SubscribeUpComingGameRsp.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
    public final PBStringField tribeID = PBField.initString("");
    public final PBStringField yybPreDownloadId = PBField.initString("");
    public final PBStringField jumpText = PBField.initString("");
    public final PBStringField tribeURL = PBField.initString("");
    public final PBInt32Field shareSource = PBField.initInt32(0);
    public final PBInt32Field appType = PBField.initInt32(0);
    public final PBStringField noticeID = PBField.initString("");
}
