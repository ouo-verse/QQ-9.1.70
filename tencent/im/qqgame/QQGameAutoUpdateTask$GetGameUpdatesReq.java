package tencent.im.qqgame;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameAutoUpdateTask$GetGameUpdatesReq extends MessageMicro<QQGameAutoUpdateTask$GetGameUpdatesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{AppConstants.Preferences.QQ_VERSION}, new Object[]{""}, QQGameAutoUpdateTask$GetGameUpdatesReq.class);
    public final PBStringField qq_version = PBField.initString("");
}
