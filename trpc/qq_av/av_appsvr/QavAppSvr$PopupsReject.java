package trpc.qq_av.av_appsvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QavAppSvr$PopupsReject extends MessageMicro<QavAppSvr$PopupsReject> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "confirm_button"}, new Object[]{"", ""}, QavAppSvr$PopupsReject.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField confirm_button = PBField.initString("");
}
