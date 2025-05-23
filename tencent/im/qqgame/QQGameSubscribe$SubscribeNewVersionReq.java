package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$SubscribeNewVersionReq extends MessageMicro<QQGameSubscribe$SubscribeNewVersionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"source", "channel_id", "version"}, new Object[]{"", "", null}, QQGameSubscribe$SubscribeNewVersionReq.class);
    public final PBStringField source = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public QQGameSubscribe$GameVersion version = new QQGameSubscribe$GameVersion();
}
