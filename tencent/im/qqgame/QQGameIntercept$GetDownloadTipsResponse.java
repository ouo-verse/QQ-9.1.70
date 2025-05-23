package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GetDownloadTipsResponse extends MessageMicro<QQGameIntercept$GetDownloadTipsResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"icon", "download_source", "safety_reminder", "download_reminder", "download_button", "continue_button", "cancel_button", "download_url"}, new Object[]{"", "", "", "", "", "", "", ""}, QQGameIntercept$GetDownloadTipsResponse.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField download_source = PBField.initString("");
    public final PBStringField safety_reminder = PBField.initString("");
    public final PBStringField download_reminder = PBField.initString("");
    public final PBStringField download_button = PBField.initString("");
    public final PBStringField continue_button = PBField.initString("");
    public final PBStringField cancel_button = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
}
