package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$LyricInfo extends MessageMicro<QQCircleSmartMatchMusic$LyricInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uiSongId", "strSongMid", "strFormat", "strLyric", "strMatchLyric"}, new Object[]{0L, "", "", "", ""}, QQCircleSmartMatchMusic$LyricInfo.class);
    public final PBInt64Field uiSongId = PBField.initInt64(0);
    public final PBStringField strSongMid = PBField.initString("");
    public final PBStringField strFormat = PBField.initString("");
    public final PBStringField strLyric = PBField.initString("");
    public final PBStringField strMatchLyric = PBField.initString("");
}
