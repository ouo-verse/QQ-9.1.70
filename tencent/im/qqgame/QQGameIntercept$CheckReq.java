package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$CheckReq extends MessageMicro<QQGameIntercept$CheckReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"download_url", "package_name", "version_code", "md5"}, new Object[]{"", "", "", ""}, QQGameIntercept$CheckReq.class);
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField package_name = PBField.initString("");
    public final PBStringField version_code = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
}
