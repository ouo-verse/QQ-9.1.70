package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GameInfo extends MessageMicro<QQGameIntercept$GameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"appid", "app_name", "pkg_name", "download_url", "version_code", "jump_type"}, new Object[]{"", "", "", "", 0, 0}, QQGameIntercept$GameInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public final PBInt32Field version_code = PBField.initInt32(0);
    public final PBInt32Field jump_type = PBField.initInt32(0);
}
