package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$GameVersion extends MessageMicro<QQGameSubscribe$GameVersion> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 34}, new String[]{"appid", "version_code", "version_name"}, new Object[]{"", "", ""}, QQGameSubscribe$GameVersion.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField version_code = PBField.initString("");
    public final PBStringField version_name = PBField.initString("");
}
