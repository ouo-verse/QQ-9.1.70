package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQGameCheckDownload$SsoCheckCustomAPKRsp extends MessageMicro<QQGameCheckDownload$SsoCheckCustomAPKRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "msg"}, new Object[]{0, ""}, QQGameCheckDownload$SsoCheckCustomAPKRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436033msg = PBField.initString("");
}
