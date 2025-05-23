package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$SubscribeArkGiftItem extends MessageMicro<QQGameSubscribe$SubscribeArkGiftItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "pic"}, new Object[]{"", ""}, QQGameSubscribe$SubscribeArkGiftItem.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField pic = PBField.initString("");
}
