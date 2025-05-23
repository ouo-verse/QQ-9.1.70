package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameCheckDownload$DownloadRemind extends MessageMicro<QQGameCheckDownload$DownloadRemind> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "exp_key"}, new Object[]{"", ""}, QQGameCheckDownload$DownloadRemind.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField exp_key = PBField.initString("");
}
