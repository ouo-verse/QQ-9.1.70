package trpc.qq_av.av_appsvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QavAppSvr$PopupsWarning extends MessageMicro<QavAppSvr$PopupsWarning> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56}, new String[]{"title", "text", "highlight", "url", "cancel_button", "continue_button", "stay_sec"}, new Object[]{"", "", "", "", "", "", 0}, QavAppSvr$PopupsWarning.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField highlight = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField cancel_button = PBField.initString("");
    public final PBStringField continue_button = PBField.initString("");
    public final PBUInt32Field stay_sec = PBField.initUInt32(0);
}
