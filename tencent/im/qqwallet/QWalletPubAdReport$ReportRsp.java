package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QWalletPubAdReport$ReportRsp extends MessageMicro<QWalletPubAdReport$ReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret", "msg", "uin"}, new Object[]{0, "", ""}, QWalletPubAdReport$ReportRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436045msg = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
}
