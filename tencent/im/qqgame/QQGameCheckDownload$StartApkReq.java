package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameCheckDownload$StartApkReq extends MessageMicro<QQGameCheckDownload$StartApkReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"app_id", "pkg_name"}, new Object[]{"", ""}, QQGameCheckDownload$StartApkReq.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
}
