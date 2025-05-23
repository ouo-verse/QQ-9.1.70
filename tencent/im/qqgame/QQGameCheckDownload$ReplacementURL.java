package tencent.im.qqgame;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameCheckDownload$ReplacementURL extends MessageMicro<QQGameCheckDownload$ReplacementURL> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72}, new String[]{"legal_url", "appid", "pkg_name", "channel_id", "version_code", "app_name", "sign_code", MiniConst.WxMiniAppInfoConst.EXTRA_ICON, "is_test_version"}, new Object[]{"", "", "", "", "", "", "", "", Boolean.FALSE}, QQGameCheckDownload$ReplacementURL.class);
    public final PBStringField legal_url = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField version_code = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField sign_code = PBField.initString("");
    public final PBStringField app_icon = PBField.initString("");
    public final PBBoolField is_test_version = PBField.initBool(false);
}
