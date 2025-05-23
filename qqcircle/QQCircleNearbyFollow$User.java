package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleNearbyFollow$User extends MessageMicro<QQCircleNearbyFollow$User> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 40, 48, 56, 64, 72, 80}, new String[]{"uid", "nick", "portrait", "feeds_count", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT, "follow_state", "relation_state", "frd_state", "black_state"}, new Object[]{"", "", "", 0L, 0L, 0, 0, 0, 0}, QQCircleNearbyFollow$User.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField portrait = PBField.initString("");
    public final PBUInt64Field feeds_count = PBField.initUInt64(0);
    public final PBUInt64Field fans_count = PBField.initUInt64(0);
    public final PBUInt32Field follow_state = PBField.initUInt32(0);
    public final PBUInt32Field relation_state = PBField.initUInt32(0);
    public final PBUInt32Field frd_state = PBField.initUInt32(0);
    public final PBUInt32Field black_state = PBField.initUInt32(0);
}
