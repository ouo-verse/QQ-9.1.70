package tencent.im.qqgame;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameCheckDownload$CheckURLRequest extends MessageMicro<QQGameCheckDownload$CheckURLRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 80}, new String[]{"channel_id", "appid", "download_url", AppConstants.Key.SHARE_SOURCE_URL, "ad_tag", "refer", "version_code", "client_version", "tbs_version", "mie_act_id"}, new Object[]{"", "", "", "", "", "", "", "", 0, 0L}, QQGameCheckDownload$CheckURLRequest.class);
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField source_url = PBField.initString("");
    public final PBStringField ad_tag = PBField.initString("");
    public final PBStringField refer = PBField.initString("");
    public final PBStringField version_code = PBField.initString("");
    public final PBStringField client_version = PBField.initString("");
    public final PBInt32Field tbs_version = PBField.initInt32(0);
    public final PBInt64Field mie_act_id = PBField.initInt64(0);
}
