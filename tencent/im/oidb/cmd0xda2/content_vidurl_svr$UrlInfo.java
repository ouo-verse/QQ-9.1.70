package tencent.im.oidb.cmd0xda2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class content_vidurl_svr$UrlInfo extends MessageMicro<content_vidurl_svr$UrlInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"vid", "status", "url"}, new Object[]{"", 0, ""}, content_vidurl_svr$UrlInfo.class);
    public final PBStringField vid = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
}
