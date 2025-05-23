package tencent.im.qqgame;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQGameAutoDownloadTask$GetPreCircleRequest extends MessageMicro<QQGameAutoDownloadTask$GetPreCircleRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{AppConstants.Preferences.QQ_VERSION}, new Object[]{""}, QQGameAutoDownloadTask$GetPreCircleRequest.class);
    public final PBStringField qq_version = PBField.initString("");
}
