package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQGameCheckDownload$SsoCheckCustomAPKReq extends MessageMicro<QQGameCheckDownload$SsoCheckCustomAPKReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"channel_id", "appid", "download_url"}, new Object[]{"", "", ""}, QQGameCheckDownload$SsoCheckCustomAPKReq.class);
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
}
