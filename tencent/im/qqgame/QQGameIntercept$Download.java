package tencent.im.qqgame;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$Download extends MessageMicro<QQGameIntercept$Download> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 66}, new String[]{"download_url", "appid", "pkg_name", "channel_id", "version_code", "app_name", MiniConst.WxMiniAppInfoConst.EXTRA_ICON}, new Object[]{"", "", "", "", "", "", ""}, QQGameIntercept$Download.class);
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField version_code = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField app_icon = PBField.initString("");
}
