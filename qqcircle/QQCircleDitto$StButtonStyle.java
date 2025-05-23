package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StButtonStyle extends MessageMicro<QQCircleDitto$StButtonStyle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56, 64, 74}, new String[]{"cornerSize", "textSize", "bgColorPre", "bgColorPost", "textPre", "textPost", "textColorPre", "textColorPost", "button_diaplay_url"}, new Object[]{0, 0, 0, 0, "", "", 0, 0, ""}, QQCircleDitto$StButtonStyle.class);
    public final PBUInt32Field cornerSize = PBField.initUInt32(0);
    public final PBUInt32Field textSize = PBField.initUInt32(0);
    public final PBUInt32Field bgColorPre = PBField.initUInt32(0);
    public final PBUInt32Field bgColorPost = PBField.initUInt32(0);
    public final PBStringField textPre = PBField.initString("");
    public final PBStringField textPost = PBField.initString("");
    public final PBUInt32Field textColorPre = PBField.initUInt32(0);
    public final PBUInt32Field textColorPost = PBField.initUInt32(0);
    public final PBStringField button_diaplay_url = PBField.initString("");
}
