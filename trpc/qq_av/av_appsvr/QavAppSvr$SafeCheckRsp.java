package trpc.qq_av.av_appsvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QavAppSvr$SafeCheckRsp extends MessageMicro<QavAppSvr$SafeCheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"alert_type", "hover_tips_text", "hover_tips_sec", "popups_waring", "popups_reject"}, new Object[]{0, "", 0, null, null}, QavAppSvr$SafeCheckRsp.class);
    public final PBEnumField alert_type = PBField.initEnum(0);
    public final PBStringField hover_tips_text = PBField.initString("");
    public final PBUInt32Field hover_tips_sec = PBField.initUInt32(0);
    public QavAppSvr$PopupsWarning popups_waring = new QavAppSvr$PopupsWarning();
    public QavAppSvr$PopupsReject popups_reject = new QavAppSvr$PopupsReject();
}
