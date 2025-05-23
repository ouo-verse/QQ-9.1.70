package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StUser extends MessageMicro<QZMomentMeta$StUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "nick", "icon"}, new Object[]{"", "", null}, QZMomentMeta$StUser.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430367id = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public QZMomentMeta$StIconInfo icon = new MessageMicro<QZMomentMeta$StIconInfo>() { // from class: qzonemoment.QZMomentMeta$StIconInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"iconUrl40", "iconUrl100", "iconUrl140", "iconUrl640", "iconUrl"}, new Object[]{"", "", "", "", ""}, QZMomentMeta$StIconInfo.class);
        public final PBStringField iconUrl40 = PBField.initString("");
        public final PBStringField iconUrl100 = PBField.initString("");
        public final PBStringField iconUrl140 = PBField.initString("");
        public final PBStringField iconUrl640 = PBField.initString("");
        public final PBStringField iconUrl = PBField.initString("");
    };
}
