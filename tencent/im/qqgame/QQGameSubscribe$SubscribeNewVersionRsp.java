package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$SubscribeNewVersionRsp extends MessageMicro<QQGameSubscribe$SubscribeNewVersionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", "message"}, new Object[]{0, ""}, QQGameSubscribe$SubscribeNewVersionRsp.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
}
